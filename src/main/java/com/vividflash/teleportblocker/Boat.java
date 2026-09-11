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
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

/**
 * The boats: Boaty on Lake Molch, Larry's boat, the Morytania rowboat,
 * Achilka's boats and the Great Conch rowboats. Some
 * offer their destinations as click options, the others open a picker whose
 * lines are not known word for word, so a picker line is read by the place
 * names it contains, and only while the picker of the boat just used is open.
 */
public final class Boat
{
    private Boat()
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

    /**
     * The boats, each paired with the objects whose option opens its picker and
     * the NPCs whose chat can pick one of its destinations. A boat with neither
     * is only ever used through click options.
     */
    public enum Network
    {
        BOATY(ids(ObjectID.AERIAL_FISHING_BOAT), "Board", ids()),
        LARRY(ids(), null, ids(NpcID.PENG_LARRY_RELL)),
        MORYTANIA_ROWBOAT(ids(ObjectID.MYQ5_BOAT_VIS, ObjectID.MYQ5_SLEPE_BOAT), "Board", ids()),
        ACHILKA(ids(), null, ids()),
        CONCH_ROWBOAT(ids(ObjectID.CONCH_ROWBOAT_NORTH, ObjectID.CONCH_ROWBOAT_EAST, ObjectID.CONCH_ROWBOAT_SOUTH), "Travel", ids());

        private final Set<Integer> pickerObjectIds;
        private final String pickerOption;
        private final Set<Integer> talkNpcIds;

        Network(Set<Integer> pickerObjectIds, String pickerOption, Set<Integer> talkNpcIds)
        {
            this.pickerObjectIds = pickerObjectIds;
            this.pickerOption = pickerOption;
            this.talkNpcIds = talkNpcIds;
        }

        public boolean hasPicker()
        {
            return pickerOption != null;
        }

        /** True when the option on the object opens this boat's picker. */
        public boolean opensPicker(int objectId, String option)
        {
            return hasPicker() && pickerObjectIds.contains(objectId)
                && StripAndLowercase.of(pickerOption).equals(StripAndLowercase.of(option));
        }

        public boolean isTalkNpc(int npcId)
        {
            return talkNpcIds.contains(npcId);
        }
    }

    /**
     * The destinations in the order of the config, each paired with its boat,
     * the lines that pick it, the click option that travels there straight
     * away with the objects or NPCs that carry it, and the toggle that blocks
     * it. On a boat with a picker the lines are the place words a picker line
     * naming it contains, and on a boat reached through chat they are the
     * chat lines themselves.
     */
    public enum Destination
    {
        BOATY_MOLCH_ISLAND(Network.BOATY, texts("molch island"), TeleportBlockerConfig::boatBoatyMolchIsland),
        BOATY_MOLCH(Network.BOATY, texts("molch"), TeleportBlockerConfig::boatBoatyMolch),
        BOATY_BATTLEFRONT(Network.BOATY, texts("battlefront"), TeleportBlockerConfig::boatBoatyBattlefront),
        BOATY_SHAYZIEN(Network.BOATY, texts("shayzien"), TeleportBlockerConfig::boatBoatyShayzien),
        LARRY_ICEBERG(Network.LARRY, texts("I'd like to travel to the iceberg."), "Iceberg",
            ids(ObjectID.PENG_BOAT_RELL, ObjectID.PENG_BOAT_3OPS), ids(),
            TeleportBlockerConfig::boatLarryIceberg),
        LARRY_WEISS(Network.LARRY, texts(), "Weiss",
            ids(ObjectID.PENG_BOAT_RELL, ObjectID.PENG_BOAT_3OPS), ids(),
            TeleportBlockerConfig::boatLarryWeiss),
        LARRY_RELLEKKA(Network.LARRY, texts(), "Travel",
            ids(ObjectID.PENG_ROW_BOAT_CLICKZONE, ObjectID.PENG_BOAT_ICE), ids(),
            TeleportBlockerConfig::boatLarryRellekka),
        MORYTANIA_BURGH_DE_ROTT(Network.MORYTANIA_ROWBOAT, texts("burgh de rott", "burgh"), TeleportBlockerConfig::boatMorytaniaBurghDeRott),
        MORYTANIA_MEIYERDITCH(Network.MORYTANIA_ROWBOAT, texts("meiyerditch"), TeleportBlockerConfig::boatMorytaniaMeiyerditch),
        MORYTANIA_ICYENE_GRAVEYARD(Network.MORYTANIA_ROWBOAT, texts("icyene graveyard", "icyene", "graveyard"), TeleportBlockerConfig::boatMorytaniaIcyeneGraveyard),
        MORYTANIA_SLEPE(Network.MORYTANIA_ROWBOAT, texts("slepe"), TeleportBlockerConfig::boatMorytaniaSlepe),
        ACHILKA_TAL_TEKLAN(Network.ACHILKA, texts(), "Tal Teklan",
            ids(), ids(NpcID.TLATI_RIVERBOAT_OWNER_SOUTH, NpcID.TLATI_RIVERBOAT_OWNER_NORTH),
            TeleportBlockerConfig::boatAchilkaTalTeklan),
        ACHILKA_GLOOMTHORN_TRAIL(Network.ACHILKA, texts(), "Gloomthorn Trail",
            ids(), ids(NpcID.TLATI_RIVERBOAT_OWNER_SOUTH, NpcID.TLATI_RIVERBOAT_OWNER_WEST),
            TeleportBlockerConfig::boatAchilkaGloomthornTrail),
        ACHILKA_KASTORI(Network.ACHILKA, texts(), "Kastori",
            ids(), ids(NpcID.TLATI_RIVERBOAT_OWNER_WEST, NpcID.TLATI_RIVERBOAT_OWNER_NORTH),
            TeleportBlockerConfig::boatAchilkaKastori),
        CONCH_SUMMER_SHORE(Network.CONCH_ROWBOAT, texts("summer shore", "south"), TeleportBlockerConfig::boatConchSummerShore),
        CONCH_NORTH_COAST(Network.CONCH_ROWBOAT, texts("north"), TeleportBlockerConfig::boatConchNorthCoast),
        CONCH_EAST_COAST(Network.CONCH_ROWBOAT, texts("east"), TeleportBlockerConfig::boatConchEastCoast);

        private final Network network;
        private final List<String> lines;
        private final String option;
        private final Set<Integer> objectIds;
        private final Set<Integer> npcIds;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(Network network, List<String> lines, Predicate<TeleportBlockerConfig> blocked)
        {
            this(network, lines, null, ids(), ids(), blocked);
        }

        Destination(Network network, List<String> lines, String option, Set<Integer> objectIds, Set<Integer> npcIds,
            Predicate<TeleportBlockerConfig> blocked)
        {
            this.network = network;
            this.lines = lines;
            this.option = option;
            this.objectIds = objectIds;
            this.npcIds = npcIds;
            this.blocked = blocked;
        }

        public Network getNetwork()
        {
            return network;
        }

        public boolean matchesOption(String text)
        {
            return option != null && StripAndLowercase.of(option).equals(StripAndLowercase.of(text));
        }

        public boolean isOptionObject(int objectId)
        {
            return objectIds.contains(objectId);
        }

        public boolean isOptionNpc(int npcId)
        {
            return npcIds.contains(npcId);
        }

        /** True when the text is a chat line that picks this destination, on a boat reached through chat. */
        public boolean matchesTalkLine(String text)
        {
            if (network.hasPicker())
            {
                return false;
            }

            String key = StripAndLowercase.of(text);
            for (String line : lines)
            {
                if (!key.isEmpty() && StripAndLowercase.of(line).equals(key))
                {
                    return true;
                }
            }
            return false;
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }

        /**
         * The destination of the boat's picker that a picker line names, or null
         * when it names none. A line can contain the words of more than one
         * destination, as Molch Island contains Molch, so the destination with
         * the longest matching words wins.
         */
        public static Destination forPickerLine(Network network, String text)
        {
            if (!network.hasPicker())
            {
                return null;
            }

            String line = StripAndLowercase.words(text);
            Destination best = null;
            int longest = 0;
            for (Destination destination : values())
            {
                if (destination.network != network)
                {
                    continue;
                }
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
