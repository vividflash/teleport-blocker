/*
 * Copyright (c) 2026, vividflash
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.vividflash.teleportblocker.features;

import com.vividflash.teleportblocker.TeleportBlockerConfig;
import com.vividflash.teleportblocker.TeleportSpell;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;

/**
 * Removes the menu entries pointing at blocked spellbook teleports. The spell
 * icons themselves are never touched.
 */
@Singleton
public class TeleportBlockFeature
{
    @Inject
    private Client client;

    @Inject
    private TeleportBlockerConfig config;

    @Inject
    private EventBus eventBus;

    private final Set<Integer> blockedComponents = new HashSet<>();

    public void startUp()
    {
        rebuildBlockedComponents();
        eventBus.register(this);
    }

    public void shutDown()
    {
        eventBus.unregister(this);
        blockedComponents.clear();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if ("teleportblocker".equals(event.getGroup()))
        {
            rebuildBlockedComponents();
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event)
    {
        if (blockedComponents.isEmpty())
        {
            return;
        }

        Menu menu = client.getMenu();
        MenuEntry[] entries = menu.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(entries)
            .filter(entry -> !isBlockedSpell(entry))
            .toArray(MenuEntry[]::new);

        if (filtered.length != entries.length)
        {
            menu.setMenuEntries(filtered);
        }
    }

    // CC_OP_LOW_PRIORITY carries op index 6 and above, where the alternate
    // destinations sit (Varrock Configure, house Group entries, Camelot
    // Toggle-location), so matching CC_OP alone would leave them clickable.
    private boolean isBlockedSpell(MenuEntry entry)
    {
        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }
        return blockedComponents.contains(entry.getParam1());
    }

    private void rebuildBlockedComponents()
    {
        blockedComponents.clear();
        for (TeleportSpell spell : TeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedComponents.add(spell.getComponentId());
            }
        }
    }
}
