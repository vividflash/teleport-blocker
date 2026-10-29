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

// Arceuus spellbook teleports in spellbook order, each paired with its packed component id and the
// toggle that blocks it.
public enum ArceuusTeleportSpell
{
    HOME("Home Teleport", InterfaceID.MagicSpellbook.TELEPORT_HOME_ARCEUUS, TeleportBlockerConfig::arceuusHomeTeleport),
    MINIGAME("Minigame Teleport", InterfaceID.MagicSpellbook.TELEPORT_MINIGAME_ARCEUUS, TeleportBlockerConfig::arceuusMinigameTeleport),
    LIBRARY("Arceuus Library Teleport", InterfaceID.MagicSpellbook.TELEPORT_ARCEUUS_LIBRARY, TeleportBlockerConfig::arceuusLibrary),
    DRAYNOR_MANOR("Draynor Manor Teleport", InterfaceID.MagicSpellbook.TELEPORT_DRAYNOR_MANOR, TeleportBlockerConfig::arceuusDraynorManor),
    BATTLEFRONT("Battlefront Teleport", InterfaceID.MagicSpellbook.TELEPORT_BATTLEFRONT, TeleportBlockerConfig::arceuusBattlefront),
    MIND_ALTAR("Mind Altar Teleport", InterfaceID.MagicSpellbook.TELEPORT_MIND_ALTAR, TeleportBlockerConfig::arceuusMindAltar),
    RESPAWN("Respawn Teleport", InterfaceID.MagicSpellbook.TELEPORT_RESPAWN, TeleportBlockerConfig::arceuusRespawn),
    SALVE_GRAVEYARD("Salve Graveyard Teleport", InterfaceID.MagicSpellbook.TELEPORT_SALVE_GRAVEYARD, TeleportBlockerConfig::arceuusSalveGraveyard),
    FENKENSTRAIN_CASTLE("Fenkenstrain's Castle Teleport", InterfaceID.MagicSpellbook.TELEPORT_FENKENSTRAIN_CASTLE, TeleportBlockerConfig::arceuusFenkenstrainsCastle),
    WEST_ARDOUGNE("West Ardougne Teleport", InterfaceID.MagicSpellbook.TELEPORT_WEST_ARDOUGNE, TeleportBlockerConfig::arceuusWestArdougne),
    HARMONY_ISLAND("Harmony Island Teleport", InterfaceID.MagicSpellbook.TELEPORT_HARMONY_ISLAND, TeleportBlockerConfig::arceuusHarmonyIsland),
    CEMETERY("Cemetery Teleport", InterfaceID.MagicSpellbook.TELEPORT_CEMETERY, TeleportBlockerConfig::arceuusCemetery),
    BARROWS("Barrows Teleport", InterfaceID.MagicSpellbook.TELEPORT_BARROWS, TeleportBlockerConfig::arceuusBarrows),
    APE_ATOLL("Ape Atoll Teleport", InterfaceID.MagicSpellbook.TELEPORT_APE_ATOLL_DUNGEON, TeleportBlockerConfig::arceuusApeAtoll);

    private final String spellName;
    private final int componentId;
    private final Predicate<TeleportBlockerConfig> blocked;

    ArceuusTeleportSpell(String spellName, int componentId, Predicate<TeleportBlockerConfig> blocked)
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
