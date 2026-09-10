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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.NpcID;

/**
 * The gnome glider network. Every pilot opens the same map, which carries one
 * button per destination, so a click is recognised by the button it lands on.
 */
public final class GnomeGlider
{
    /** The pilot option that flies straight to the last destination used. */
    public static final String PREVIOUS_OPTION = "Glider";

    /**
     * The glider pilots, including every form a pilot takes as the player's
     * progress and last destination change.
     */
    private static final Set<Integer> PILOT_IDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        NpcID.PILOT_GRAND_TREE,
        NpcID.PILOT_GRAND_TREE_BASE,
        NpcID.PILOT_GRAND_TREE_KARAMJA,
        NpcID.PILOT_GRAND_TREE_AL_KHARID,
        NpcID.PILOT_GRAND_TREE_VARROCK,
        NpcID.PILOT_GRAND_TREE_WHITEWOLF,
        NpcID.PILOT_GRAND_TREE_OGRE,
        NpcID.PILOT_GRAND_TREE_APE,
        NpcID.PILOT_KARAMJA,
        NpcID.PILOT_KARAMJA_BASE,
        NpcID.PILOT_KARAMJA_GRANDTREE,
        NpcID.PILOT_KARAMJA_AL_KHARID,
        NpcID.PILOT_KARAMJA_VARROCK,
        NpcID.PILOT_KARAMJA_WHITEWOLF,
        NpcID.PILOT_KARAMJA_OGRE,
        NpcID.PILOT_KARAMJA_APE,
        NpcID.PILOT_AL_KHARID,
        NpcID.PILOT_AL_KHARID_BASE,
        NpcID.PILOT_AL_KHARID_GRANDTREE,
        NpcID.PILOT_AL_KHARID_KARAMJA,
        NpcID.PILOT_AL_KHARID_VARROCK,
        NpcID.PILOT_AL_KHARID_WHITEWOLF,
        NpcID.PILOT_AL_KHARID_OGRE,
        NpcID.PILOT_AL_KHARID_APE,
        NpcID.PILOT_WHITE_WOLF,
        NpcID.PILOT_WHITE_WOLF_BASE,
        NpcID.PILOT_WHITE_WOLF_GRANDTREE,
        NpcID.PILOT_WHITE_WOLF_KARAMJA,
        NpcID.PILOT_WHITE_WOLF_AL_KHARID,
        NpcID.PILOT_WHITE_WOLF_VARROCK,
        NpcID.PILOT_WHITE_WOLF_OGRE,
        NpcID.PILOT_WHITE_WOLF_APE,
        NpcID.PILOT_DIGSITE,
        NpcID.GNORMADIUM_AVLAFRIM,
        NpcID.GNORMADIUM_AVLAFRIM_TALK,
        NpcID.GNORMADIUM_AVLAFRIM_GLIDER,
        NpcID.GNORMADIUM_AVLAFRIM_GRANDTREE,
        NpcID.GNORMADIUM_AVLAFRIM_KARAMJA,
        NpcID.GNORMADIUM_AVLAFRIM_AL_KHARID,
        NpcID.GNORMADIUM_AVLAFRIM_VARROCK,
        NpcID.GNORMADIUM_AVLAFRIM_WHITEWOLF,
        NpcID.GNORMADIUM_AVLAFRIM_APE,
        NpcID.PILOT_APEATOLL,
        NpcID.PILOT_APEATOLL_MODEL,
        NpcID.PILOT_APEATOLL_GRANDTREE,
        NpcID.PILOT_APEATOLL_KARAMJA,
        NpcID.PILOT_APEATOLL_AL_KHARID,
        NpcID.PILOT_APEATOLL_VARROCK,
        NpcID.PILOT_APEATOLL_WHITEWOLF,
        NpcID.PILOT_APEATOLL_OGRE)));

    private GnomeGlider()
    {
    }

    public static boolean isPilot(int npcId)
    {
        return PILOT_IDS.contains(npcId);
    }

    /**
     * The destinations of the glider map, each paired with its map button and
     * the toggle that blocks it. The Feldip Hills and Ape Atoll buttons stay
     * hidden until their quest progress is met. Gliders have no master toggle.
     * The pilots' Glider option has a toggle of its own, since its menu entry
     * does not name the place it flies to.
     */
    public enum Destination
    {
        GRAND_TREE(InterfaceID.Glidermap.GRANDTREE_BUTTON, TeleportBlockerConfig::gnomeGliderGrandTree),
        KARAMJA(InterfaceID.Glidermap.KARAMJA_BUTTON, TeleportBlockerConfig::gnomeGliderKaramja),
        AL_KHARID(InterfaceID.Glidermap.ALKHARID_BUTTON, TeleportBlockerConfig::gnomeGliderAlKharid),
        WHITE_WOLF_MOUNTAIN(InterfaceID.Glidermap.WHITEWOLFMOUNTAIN_BUTTON, TeleportBlockerConfig::gnomeGliderWhiteWolfMountain),
        DIGSITE(InterfaceID.Glidermap.VARROCK_BUTTON, TeleportBlockerConfig::gnomeGliderDigsite),
        FELDIP_HILLS(InterfaceID.Glidermap.OGREAREA_BUTTON, TeleportBlockerConfig::gnomeGliderFeldipHills),
        APE_ATOLL(InterfaceID.Glidermap.APEATOLL_BUTTON, TeleportBlockerConfig::gnomeGliderApeAtoll);

        private final int componentId;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(int componentId, Predicate<TeleportBlockerConfig> blocked)
        {
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
    }
}
