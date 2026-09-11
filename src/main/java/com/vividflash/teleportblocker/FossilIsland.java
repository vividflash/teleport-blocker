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
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.runelite.api.gameval.ObjectID;

/**
 * The Fossil Island rowboats. The rowboats on the island open a picker whose
 * lines are not known word for word, so a picker line is read by the place
 * words it contains, and only while the picker of a rowboat just used is open.
 * The rowboats to Lithkren and back travel straight from Travel. The Dive
 * option is not a trip and is never touched.
 */
public final class FossilIsland
{
    private static final String TRAVEL_OPTION = "Travel";

    /** The rowboats on the island, whose Travel option opens the picker. */
    private static final Set<Integer> PICKER_OBJECT_IDS = ids(
        ObjectID.FOSSIL_ROWBOAT_CAMP, ObjectID.FOSSIL_ROWBOAT_NORTH, ObjectID.FOSSIL_ROWBOAT_DIVING);

    private FossilIsland()
    {
    }

    private static Set<Integer> ids(Integer... ids)
    {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(ids)));
    }

    private static List<String> texts(String... texts)
    {
        return Collections.unmodifiableList(Arrays.asList(texts));
    }

    private static boolean isTravel(String option)
    {
        return StripAndLowercase.of(TRAVEL_OPTION).equals(StripAndLowercase.of(option));
    }

    /** True when the option on the object opens the rowboat picker. */
    public static boolean opensPicker(int objectId, String option)
    {
        return PICKER_OBJECT_IDS.contains(objectId) && isTravel(option);
    }

    /**
     * The destinations in the order of the config, each paired with the place
     * words a picker line naming it contains, the rowboats whose Travel goes
     * there straight away, and the toggle that blocks it.
     */
    public enum Destination
    {
        MUSEUM_CAMP(texts("camp"), ids(), TeleportBlockerConfig::fossilIslandMuseumCamp),
        NORTH(texts("north"), ids(), TeleportBlockerConfig::fossilIslandNorth),
        BANK_ISLAND(texts("sea", "bank"), ids(), TeleportBlockerConfig::fossilIslandBankIsland),
        DIGSITE(texts("digsite", "dig site", "barge"), ids(), TeleportBlockerConfig::fossilIslandDigsite),
        LITHKREN(texts("lithkren"), ids(ObjectID.FOSSIL_ROWBOAT_LITHKREN, ObjectID.FOSSIL_ROWBOAT_LITHKREN_BUILT),
            TeleportBlockerConfig::fossilIslandLithkren),
        FOSSIL_ISLAND(texts(), ids(ObjectID.LITHKREN_ROWBOAT), TeleportBlockerConfig::fossilIslandFossilIsland);

        private final List<String> lines;
        private final Set<Integer> travelObjectIds;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(List<String> lines, Set<Integer> travelObjectIds, Predicate<TeleportBlockerConfig> blocked)
        {
            this.lines = lines;
            this.travelObjectIds = travelObjectIds;
            this.blocked = blocked;
        }

        /** True when the option on the object travels straight to this destination. */
        public boolean travelsFrom(int objectId, String option)
        {
            return travelObjectIds.contains(objectId) && isTravel(option);
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }

        /**
         * The destination a picker line names, or null when it names none. The
         * destination with the longest matching words wins.
         */
        public static Destination forPickerLine(String text)
        {
            String line = StripAndLowercase.words(text);
            Destination best = null;
            int longest = 0;
            for (Destination destination : values())
            {
                for (String word : destination.lines)
                {
                    if (word.length() > longest && line.contains(StripAndLowercase.words(word)))
                    {
                        best = destination;
                        longest = word.length();
                    }
                }
            }
            return best;
        }
    }
}
