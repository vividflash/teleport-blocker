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

/**
 * The ships crewed by NPCs outside the charter network: Captain Barnaby's
 * ships, the ships out of Port Sarim and the ships out of Rellekka. Each leg
 * sails from the NPCs at its starting end, from a click option named after
 * the destination or Travel, and mostly from their chat as well.
 */
public final class Ship
{
    /** The option that opens an NPC's chat. */
    public static final String TALK_OPTION = "Talk-to";

    private Ship()
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
     * The legs in the order of the config, each paired with the NPCs that sail
     * it, the click options that sail it straight away, the chat lines that
     * pick it, the NPCs among them that lose Talk-to, and the toggle that
     * blocks it. Captain Barnaby's legs are kept by destination, so each one
     * starts at both of the other ports. An NPC that sails one leg only and
     * reaches it in chat through a line any dialogue could carry, such as YES
     * or Let's go!, loses Talk-to at the blocked end, since its chat leads
     * there too.
     */
    public enum Leg
    {
        BARNABY_ARDOUGNE(
            ids(NpcID.CAPTAIN_BARNABY_RIMMINGTON, NpcID.CAPTAIN_BARNABY_KARAMJA),
            texts("Ardougne"),
            texts("I'd like to go to Ardougne."),
            ids(),
            TeleportBlockerConfig::shipBarnabyArdougne),
        BARNABY_BRIMHAVEN(
            ids(NpcID.CAPTAIN_BARNABY_ARDOUGNE_MODEL, NpcID.CAPTAIN_BARNABY, NpcID.CAPTAIN_BARNABY_RIMMINGTON),
            texts("Brimhaven"),
            texts("I'd like to go to Brimhaven."),
            ids(),
            TeleportBlockerConfig::shipBarnabyBrimhaven),
        BARNABY_RIMMINGTON(
            ids(NpcID.CAPTAIN_BARNABY_ARDOUGNE_MODEL, NpcID.CAPTAIN_BARNABY, NpcID.CAPTAIN_BARNABY_KARAMJA),
            texts("Rimmington"),
            texts("I'd like to go to Rimmington."),
            ids(),
            TeleportBlockerConfig::shipBarnabyRimmington),
        PORT_SARIM_VOID_KNIGHTS_OUTPOST(
            ids(NpcID.PEST_SQUIRE_SHIP_PORTSARIM),
            texts("Travel"),
            texts("I'd like to go to your outpost."),
            ids(),
            TeleportBlockerConfig::shipPortSarimVoidKnightsOutpost),
        VOID_KNIGHTS_OUTPOST_PORT_SARIM(
            ids(NpcID.PEST_SQUIRE_SHIP_ISLAND),
            texts("Travel"),
            texts("I'd like to go back to Port Sarim please."),
            ids(),
            TeleportBlockerConfig::shipVoidKnightsOutpostPortSarim),
        PORT_SARIM_MUSA_POINT(
            ids(NpcID.CAPTAIN_TOBIAS_1OP, NpcID.CAPTAIN_TOBIAS_2OP, NpcID.SEAMAN_LORRIS_1OP, NpcID.SEAMAN_LORRIS_2OP,
                NpcID.SEAMAN_THRESNOR_1OP, NpcID.SEAMAN_THRESNOR_2OP, NpcID.CAPTAIN_TOBIAS, NpcID.SEAMAN_LORRIS,
                NpcID.SEAMAN_THRESNOR),
            texts("Travel", "Pay-fare", "Musa Point"),
            texts("I'd like to go to Musa Point."),
            ids(NpcID.CAPTAIN_TOBIAS_1OP, NpcID.SEAMAN_LORRIS_1OP, NpcID.SEAMAN_THRESNOR_1OP, NpcID.CAPTAIN_TOBIAS,
                NpcID.SEAMAN_LORRIS, NpcID.SEAMAN_THRESNOR),
            TeleportBlockerConfig::shipPortSarimMusaPoint),
        MUSA_POINT_PORT_SARIM(
            ids(NpcID.CUSTOMS_OFFICER_1OP, NpcID.CUSTOMS_OFFICER_2OP, NpcID.CUSTOMS_OFFICER),
            texts("Travel", "Pay-fare", "Port Sarim"),
            texts(),
            ids(NpcID.CUSTOMS_OFFICER_1OP, NpcID.CUSTOMS_OFFICER),
            TeleportBlockerConfig::shipMusaPointPortSarim),
        PORT_SARIM_PANDEMONIUM(
            ids(NpcID.CAPTAIN_TOBIAS_2OP, NpcID.SEAMAN_LORRIS_2OP, NpcID.SEAMAN_THRESNOR_2OP),
            texts("The Pandemonium"),
            texts("I'd like to go to the Pandemonium."),
            ids(),
            TeleportBlockerConfig::shipPortSarimPandemonium),
        PANDEMONIUM_PORT_SARIM(
            ids(NpcID.SEAMAN_MORRIS),
            texts("Port Sarim"),
            texts(),
            ids(),
            TeleportBlockerConfig::shipPandemoniumPortSarim),
        MUSA_POINT_PANDEMONIUM(
            ids(NpcID.CUSTOMS_OFFICER_2OP),
            texts("The Pandemonium"),
            texts(),
            ids(),
            TeleportBlockerConfig::shipMusaPointPandemonium),
        PANDEMONIUM_MUSA_POINT(
            ids(NpcID.SEAMAN_MORRIS),
            texts("Musa Point"),
            texts(),
            ids(),
            TeleportBlockerConfig::shipPandemoniumMusaPoint),
        PORT_SARIM_ENTRANA(
            ids(NpcID.SHIPMONK, NpcID.SHIPMONK1_B, NpcID.SHIPMONK1_C),
            texts("Take-boat", "Travel-boat"),
            texts(),
            ids(NpcID.SHIPMONK, NpcID.SHIPMONK1_B, NpcID.SHIPMONK1_C),
            TeleportBlockerConfig::shipPortSarimEntrana),
        ENTRANA_PORT_SARIM(
            ids(NpcID.SHIPMONK2, NpcID.SHIPMONK2_B, NpcID.SHIPMONK2_C),
            texts("Take-boat", "Travel-boat"),
            texts(),
            ids(NpcID.SHIPMONK2, NpcID.SHIPMONK2_B, NpcID.SHIPMONK2_C),
            TeleportBlockerConfig::shipEntranaPortSarim),
        PORT_SARIM_PORT_PISCARILIUS(
            ids(NpcID.VEOS_VISIBLE_TRAVEL, NpcID.VEOS_VISIBLE_TRAVEL_AMULET, NpcID.VEOS_SARIM,
                NpcID.CABIN_BOY_HERBERT_SARIM, NpcID.CABIN_BOY_HERBERT_SARIM_VIS),
            texts("Port Piscarilius"),
            texts("I'd like to travel to Port Piscarilius, please.", "Travel to Port Piscarilius"),
            ids(),
            TeleportBlockerConfig::shipPortSarimPortPiscarilius),
        PORT_PISCARILIUS_PORT_SARIM(
            ids(NpcID.VEOS_VIS, NpcID.VEOS_VIS_AMULET, NpcID.CABIN_BOY_HERBERT_PISC, NpcID.CABIN_BOY_HERBERT_PISC_VIS),
            texts("Port Sarim"),
            texts("I'd like to travel to Port Sarim, please.", "Travel to Port Sarim"),
            ids(),
            TeleportBlockerConfig::shipPortPiscariliusPortSarim),
        PORT_SARIM_LANDS_END(
            ids(NpcID.VEOS_VISIBLE_TRAVEL, NpcID.VEOS_VISIBLE_TRAVEL_AMULET, NpcID.VEOS_SARIM,
                NpcID.CABIN_BOY_HERBERT_SARIM, NpcID.CABIN_BOY_HERBERT_SARIM_VIS),
            texts("Land's End"),
            texts("I'd like to travel to Land's End, please.", "Travel to Land's End"),
            ids(),
            TeleportBlockerConfig::shipPortSarimLandsEnd),
        LANDS_END_PORT_SARIM(
            ids(NpcID.ZEAH_MAGORO),
            texts("Port Sarim"),
            texts(),
            ids(),
            TeleportBlockerConfig::shipLandsEndPortSarim),
        PORT_PISCARILIUS_LANDS_END(
            ids(NpcID.VEOS_VIS, NpcID.VEOS_VIS_AMULET, NpcID.CABIN_BOY_HERBERT_PISC, NpcID.CABIN_BOY_HERBERT_PISC_VIS),
            texts("Land's End"),
            texts("I'd like to travel to Land's End, please.", "Travel to Land's End"),
            ids(),
            TeleportBlockerConfig::shipPortPiscariliusLandsEnd),
        LANDS_END_PORT_PISCARILIUS(
            ids(NpcID.ZEAH_MAGORO),
            texts("Port Piscarilius"),
            texts(),
            ids(),
            TeleportBlockerConfig::shipLandsEndPortPiscarilius),
        RELLEKKA_WATERBIRTH_ISLAND(
            ids(NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_RELLEKKA, NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_ISLAND,
                NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_1OP),
            texts("Waterbirth Island"),
            texts(),
            ids(NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_RELLEKKA, NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_ISLAND,
                NpcID.VIKING_DAGGANOTH_CAVE_FERRYMAN_1OP),
            TeleportBlockerConfig::shipRellekkaWaterbirthIsland),
        WATERBIRTH_ISLAND_RELLEKKA(
            ids(NpcID.VIKING_DAGGANOTH_CAVE_WATERBIRTH_ISLAND),
            texts("Rellekka"),
            texts("I wish to return to Rellekka."),
            ids(),
            TeleportBlockerConfig::shipWaterbirthIslandRellekka),
        RELLEKKA_PIRATES_COVE(
            ids(NpcID.LUNAR_FREMENNIK_PIRATE_BY_PIRATESHIP, NpcID.LUNAR_FREMENNIK_PIRATE_1OP),
            texts("Pirate's Cove"),
            texts(),
            ids(NpcID.LUNAR_FREMENNIK_PIRATE_BY_PIRATESHIP, NpcID.LUNAR_FREMENNIK_PIRATE_1OP),
            TeleportBlockerConfig::shipRellekkaPiratesCove),
        PIRATES_COVE_RELLEKKA(
            ids(NpcID.LUNAR_FREMENNIK_PIRATE_PIRATECOVE),
            texts("Rellekka"),
            texts("Can you take me back to Rellekka?"),
            ids(),
            TeleportBlockerConfig::shipPiratesCoveRellekka),
        RELLEKKA_JATIZSO(
            ids(NpcID.FRIS_R_FERRYMAN_RELLEKKA),
            texts("Jatizso"),
            texts("Can you ferry me to Jatizso?"),
            ids(),
            TeleportBlockerConfig::shipRellekkaJatizso),
        JATIZSO_RELLEKKA(
            ids(NpcID.FRIS_R_FERRYMAN_IZSO),
            texts("Rellekka"),
            texts("Can you ferry me to Rellekka?"),
            ids(),
            TeleportBlockerConfig::shipJatizsoRellekka),
        RELLEKKA_NEITIZNOT(
            ids(NpcID.FRIS_R_FERRY_RELLIKKA),
            texts("Neitiznot"),
            texts("Can you ferry me to Neitiznot?"),
            ids(),
            TeleportBlockerConfig::shipRellekkaNeitiznot),
        NEITIZNOT_RELLEKKA(
            ids(NpcID.FRIS_R_FERRY_IZNOT),
            texts("Rellekka"),
            texts("Can you ferry me to Rellekka?"),
            ids(),
            TeleportBlockerConfig::shipNeitiznotRellekka),
        RELLEKKA_MISCELLANIA(
            ids(NpcID.VIKING_SAILOR),
            texts("Miscellania"),
            texts(),
            ids(NpcID.VIKING_SAILOR),
            TeleportBlockerConfig::shipRellekkaMiscellania),
        MISCELLANIA_RELLEKKA(
            ids(NpcID.MISC_SAILOR),
            texts("Rellekka"),
            texts(),
            ids(NpcID.MISC_SAILOR),
            TeleportBlockerConfig::shipMiscellaniaRellekka);

        private final Set<Integer> npcIds;
        private final List<String> options;
        private final List<String> lines;
        private final Set<Integer> talkIds;
        private final Predicate<TeleportBlockerConfig> blocked;

        Leg(Set<Integer> npcIds, List<String> options, List<String> lines, Set<Integer> talkIds,
            Predicate<TeleportBlockerConfig> blocked)
        {
            this.npcIds = npcIds;
            this.options = options;
            this.lines = lines;
            this.talkIds = talkIds;
            this.blocked = blocked;
        }

        public boolean isLegNpc(int npcId)
        {
            return npcIds.contains(npcId);
        }

        /** True when the NPC loses Talk-to while this leg is blocked. */
        public boolean removesTalk(int npcId)
        {
            return talkIds.contains(npcId);
        }

        public boolean matchesOption(String option)
        {
            return matchesAny(options, option);
        }

        public boolean matchesLine(String line)
        {
            return matchesAny(lines, line);
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }

        private static boolean matchesAny(List<String> texts, String text)
        {
            String key = StripAndLowercase.of(text);
            for (String candidate : texts)
            {
                if (!key.isEmpty() && StripAndLowercase.of(candidate).equals(key))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
