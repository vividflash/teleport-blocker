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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import net.runelite.api.gameval.InterfaceID;

// The gnome glider network. Every pilot opens the same map, which carries one button per
// destination, so a click is recognised by the button it lands on.
public final class GnomeGlider
{
    // The pilot option that flies straight to the last destination used, "Glider-to <place>".
    // It shows only once the pilot has a last destination. The bare "Glider" option opens the map.
    public static final String PREVIOUS_PREFIX = "Glider-to ";

    // The six glider pilots, by the name their menu entries show.
    private static final Set<String> PILOT_NAMES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        StripAndLowercase.of("Captain Errdo"),
        StripAndLowercase.of("Captain Klemfoodle"),
        StripAndLowercase.of("Captain Dalbur"),
        StripAndLowercase.of("Captain Bleemadge"),
        StripAndLowercase.of("Gnormadium Avlafrim"),
        StripAndLowercase.of("Captain Shoracks"))));

    private GnomeGlider()
    {
    }

    public static boolean isPilot(String name)
    {
        return PILOT_NAMES.contains(StripAndLowercase.of(name));
    }

    // The destinations of the glider map, each paired with its map button and the toggle that
    // blocks it. The Feldip Hills and Ape Atoll buttons stay hidden until their quest progress is
    // met. Each also carries the gnome name the pilots' Glider-to option uses. That option has a
    // toggle of its own, which also covers it whatever place it names.
    public enum Destination
    {
        GRAND_TREE(InterfaceID.Glidermap.GRANDTREE_BUTTON, "Ta Quir Priw", TeleportBlockerConfig::gnomeGliderGrandTree),
        KARAMJA(InterfaceID.Glidermap.KARAMJA_BUTTON, "Gandius", TeleportBlockerConfig::gnomeGliderKaramja),
        AL_KHARID(InterfaceID.Glidermap.ALKHARID_BUTTON, "Kar-Hewo", TeleportBlockerConfig::gnomeGliderAlKharid),
        WHITE_WOLF_MOUNTAIN(InterfaceID.Glidermap.WHITEWOLFMOUNTAIN_BUTTON, "Sindarpos", TeleportBlockerConfig::gnomeGliderWhiteWolfMountain),
        DIGSITE(InterfaceID.Glidermap.VARROCK_BUTTON, "Lemanto Andra", TeleportBlockerConfig::gnomeGliderDigsite),
        FELDIP_HILLS(InterfaceID.Glidermap.OGREAREA_BUTTON, "Lemantolly Undri", TeleportBlockerConfig::gnomeGliderFeldipHills),
        APE_ATOLL(InterfaceID.Glidermap.APEATOLL_BUTTON, "Ookookolly Undri", TeleportBlockerConfig::gnomeGliderApeAtoll);

        private static final Map<String, Destination> BY_KEY = new HashMap<>();

        static
        {
            for (Destination destination : values())
            {
                BY_KEY.put(StripAndLowercase.of(destination.gnomeName), destination);
            }
        }

        private final int componentId;
        private final String gnomeName;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(int componentId, String gnomeName, Predicate<TeleportBlockerConfig> blocked)
        {
            this.componentId = componentId;
            this.gnomeName = gnomeName;
            this.blocked = blocked;
        }

        // The destination a Glider-to option names, or null when it names none.
        public static Destination forPlace(String place)
        {
            return BY_KEY.get(StripAndLowercase.of(place));
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
