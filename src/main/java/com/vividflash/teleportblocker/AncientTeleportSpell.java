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
package com.vividflash.teleportblocker;

import java.util.function.Predicate;
import net.runelite.api.gameval.InterfaceID;

/**
 * Ancient spellbook teleports in spellbook order, each paired with its packed
 * component id and the toggle that blocks it. The book has no master toggle,
 * so every spell is blocked only by its own.
 */
public enum AncientTeleportSpell
{
    HOME("Home Teleport", InterfaceID.MagicSpellbook.TELEPORT_HOME_ZAROS, TeleportBlockerConfig::ancientHomeTeleport),
    MINIGAME("Minigame Teleport", InterfaceID.MagicSpellbook.TELEPORT_MINIGAME_ANCIENT, TeleportBlockerConfig::blockAllMinigames),
    PADDEWWA("Paddewwa Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT1, TeleportBlockerConfig::ancientPaddewwa),
    SENNTISTEN("Senntisten Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT2, TeleportBlockerConfig::ancientSenntisten),
    KHARYRLL("Kharyrll Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT3, TeleportBlockerConfig::ancientKharyrll),
    LASSAR("Lassar Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT4, TeleportBlockerConfig::ancientLassar),
    DAREEYAK("Dareeyak Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT5, TeleportBlockerConfig::ancientDareeyak),
    CARRALLANGER("Carrallanger Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT6, TeleportBlockerConfig::ancientCarrallanger),
    ANNAKARL("Annakarl Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT7, TeleportBlockerConfig::ancientAnnakarl),
    GHORROCK("Ghorrock Teleport", InterfaceID.MagicSpellbook.ZAROSTELEPORT8, TeleportBlockerConfig::ancientGhorrock);

    private final String spellName;
    private final int componentId;
    private final Predicate<TeleportBlockerConfig> blocked;

    AncientTeleportSpell(String spellName, int componentId, Predicate<TeleportBlockerConfig> blocked)
    {
        this.spellName = spellName;
        this.componentId = componentId;
        this.blocked = blocked;
    }

    public int getComponentId()
    {
        return componentId;
    }

    public boolean isBlocked(TeleportBlockerConfig config)
    {
        return blocked.test(config);
    }

    @Override
    public String toString()
    {
        return spellName;
    }
}
