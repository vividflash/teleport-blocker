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
 * Canoe destinations in map order, River Lum first, each paired with its
 * packed component id and the toggle that blocks it. Canoes have no master
 * toggle, so every destination is blocked only by its own. The station tree,
 * the canoe shape picker and the expert's own options are left alone.
 */
public enum CanoeDestination
{
    LUMBRIDGE("Lumbridge", InterfaceID.CanoeMapLum.CANOEING_LUMBRIDGE, TeleportBlockerConfig::canoeLumbridge),
    CHAMPIONS_GUILD("Champions' Guild", InterfaceID.CanoeMapLum.CANOEING_CHAMPIONSGUILD, TeleportBlockerConfig::canoeChampionsGuild),
    BARBARIAN_VILLAGE("Barbarian Village", InterfaceID.CanoeMapLum.CANOEING_BARBARIAN, TeleportBlockerConfig::canoeBarbarianVillage),
    EDGEVILLE("Edgeville", InterfaceID.CanoeMapLum.CANOEING_EDGEVILLE, TeleportBlockerConfig::canoeEdgeville),
    FEROX_ENCLAVE("Ferox Enclave", InterfaceID.CanoeMapLum.CANOEING_FEROXENCLAVE, TeleportBlockerConfig::canoeFeroxEnclave),
    WILDERNESS_POND("Wilderness Pond", InterfaceID.CanoeMapLum.CANOEING_WILDY, TeleportBlockerConfig::canoeWildernessPond),
    CASTLE_WARS("Castle Wars", InterfaceID.CanoeMapDougne.CANOEING_CASTLE_WARS, TeleportBlockerConfig::canoeCastleWars),
    TREE_GNOME_VILLAGE("Tree Gnome Village", InterfaceID.CanoeMapDougne.CANOEING_VILLIAGE, TeleportBlockerConfig::canoeTreeGnomeVillage),
    CLOCKTOWER("Clocktower", InterfaceID.CanoeMapDougne.CANOEING_CLOCKTOWER, TeleportBlockerConfig::canoeClocktower),
    CHAOS_DRUID_TOWER("Chaos Druid Tower", InterfaceID.CanoeMapDougne.CANOEING_CHAOSTOWER, TeleportBlockerConfig::canoeChaosDruidTower),
    TREE_GNOME_STRONGHOLD("Tree Gnome Stronghold", InterfaceID.CanoeMapDougne.CANOEING_STRONGHOLD, TeleportBlockerConfig::canoeTreeGnomeStronghold);

    private final String destinationName;
    private final int componentId;
    private final Predicate<TeleportBlockerConfig> blocked;

    CanoeDestination(String destinationName, int componentId, Predicate<TeleportBlockerConfig> blocked)
    {
        this.destinationName = destinationName;
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
        return destinationName;
    }
}
