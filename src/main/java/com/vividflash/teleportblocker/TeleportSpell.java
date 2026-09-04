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
 * Standard spellbook teleports in spellbook order, each paired with its packed
 * component id and the toggle that blocks it. Minigame Teleport takes its
 * toggle from the minigame master instead, so the teleport master leaves it
 * alone.
 */
public enum TeleportSpell
{
    HOME("Home Teleport", InterfaceID.MagicSpellbook.TELEPORT_HOME_STANDARD, TeleportBlockerConfig::homeTeleport),
    MINIGAME("Minigame Teleport", InterfaceID.MagicSpellbook.TELEPORT_MINIGAME_STANDARD, TeleportBlockerConfig::blockAllMinigames, false),
    VARROCK("Varrock Teleport", InterfaceID.MagicSpellbook.VARROCK_TELEPORT, TeleportBlockerConfig::varrockTeleport),
    LUMBRIDGE("Lumbridge Teleport", InterfaceID.MagicSpellbook.LUMBRIDGE_TELEPORT, TeleportBlockerConfig::lumbridgeTeleport),
    FALADOR("Falador Teleport", InterfaceID.MagicSpellbook.FALADOR_TELEPORT, TeleportBlockerConfig::faladorTeleport),
    HOUSE("Teleport to House", InterfaceID.MagicSpellbook.TELEPORT_TO_YOUR_HOUSE, TeleportBlockerConfig::houseTeleport),
    CAMELOT("Camelot Teleport", InterfaceID.MagicSpellbook.CAMELOT_TELEPORT, TeleportBlockerConfig::camelotTeleport),
    KOUREND("Kourend Castle Teleport", InterfaceID.MagicSpellbook.KOUREND_TELEPORT, TeleportBlockerConfig::kourendTeleport),
    ARDOUGNE("Ardougne Teleport", InterfaceID.MagicSpellbook.ARDOUGNE_TELEPORT, TeleportBlockerConfig::ardougneTeleport),
    FORTIS("Civitas illa Fortis Teleport", InterfaceID.MagicSpellbook.FORTIS_TELEPORT, TeleportBlockerConfig::fortisTeleport),
    WATCHTOWER("Watchtower Teleport", InterfaceID.MagicSpellbook.WATCHTOWER_TELEPORT, TeleportBlockerConfig::watchtowerTeleport),
    TROLLHEIM("Trollheim Teleport", InterfaceID.MagicSpellbook.TROLLHEIM_TELEPORT, TeleportBlockerConfig::trollheimTeleport),
    APE_ATOLL("Ape Atoll Teleport", InterfaceID.MagicSpellbook.APE_TELEPORT, TeleportBlockerConfig::apeAtollTeleport);

    private final String spellName;
    private final int componentId;
    private final Predicate<TeleportBlockerConfig> blocked;
    private final boolean coveredByBlockAll;

    TeleportSpell(String spellName, int componentId, Predicate<TeleportBlockerConfig> blocked)
    {
        this(spellName, componentId, blocked, true);
    }

    TeleportSpell(String spellName, int componentId, Predicate<TeleportBlockerConfig> blocked, boolean coveredByBlockAll)
    {
        this.spellName = spellName;
        this.componentId = componentId;
        this.blocked = blocked;
        this.coveredByBlockAll = coveredByBlockAll;
    }

    public int getComponentId()
    {
        return componentId;
    }

    public boolean isBlocked(TeleportBlockerConfig config)
    {
        return (coveredByBlockAll && config.blockAllTeleports()) || blocked.test(config);
    }

    @Override
    public String toString()
    {
        return spellName;
    }
}
