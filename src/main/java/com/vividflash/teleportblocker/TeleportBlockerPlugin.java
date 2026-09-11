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

import com.google.inject.Provides;
import com.vividflash.teleportblocker.features.TeleportBlockFeature;
import java.awt.Color;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
    name = "Teleport Blocker",
    description = "Teleport Removal Options for most things",
    tags = {"teleport", "block", "chunk", "locked", "transport", "ship", "spell", "boat", "misclick"}
)
public class TeleportBlockerPlugin extends Plugin
{
    private static final String CONFIG_GROUP = "teleportblocker";

    /** Marks the release a profile has already been told about. */
    private static final String LAST_SEEN_VERSION_KEY = "lastSeenVersion";

    /** The release the notice below belongs to, not the packaged version. */
    private static final String VERSION = "1.4";
    private static final String UPDATE_MESSAGE =
        "Teleport Blocker v1.4: Added most transport systems.";

    /** Dark red, for legibility against the opaque chatbox background. */
    private static final Color NOTICE_COLOR = new Color(0x480000);

    @Inject
    private TeleportBlockFeature teleportBlockFeature;

    @Inject
    private ConfigManager configManager;

    @Inject
    private ChatMessageManager chatMessageManager;

    private boolean updateChecked;

    @Override
    protected void startUp()
    {
        updateChecked = false;
        teleportBlockFeature.startUp();
    }

    @Override
    protected void shutDown()
    {
        teleportBlockFeature.shutDown();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGGED_IN)
        {
            maybeAnnounceUpdate();
        }
    }

    /**
     * One-time post-update notice on first login. A profile that carries no
     * version yet is told as well, which covers the installs that predate this
     * mechanism and means a fresh install reads the current notice once.
     */
    private void maybeAnnounceUpdate()
    {
        if (updateChecked)
        {
            return;
        }
        updateChecked = true;

        String lastSeen = configManager.getConfiguration(CONFIG_GROUP, LAST_SEEN_VERSION_KEY);
        if (VERSION.equals(lastSeen))
        {
            return;
        }

        configManager.setConfiguration(CONFIG_GROUP, LAST_SEEN_VERSION_KEY, VERSION);
        chatMessageManager.queue(QueuedMessage.builder()
            .type(ChatMessageType.CONSOLE)
            .runeLiteFormattedMessage(new ChatMessageBuilder()
                .append(NOTICE_COLOR, UPDATE_MESSAGE)
                .build())
            .build());
    }

    @Provides
    TeleportBlockerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TeleportBlockerConfig.class);
    }
}
