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
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

/**
 * The quetzals: the network whose quetzals and whistles open a map of landing
 * sites, and the separate quetzal that flies between Varrock and Civitas illa
 * Fortis.
 */
public final class QuetzalTransport
{
    /** The network quetzal and whistle option that flies straight to the last landing site used. */
    public static final String PREVIOUS_OPTION = "Last-destination";

    /** The whistle option that opens the map, or flies straight to the Hunter Guild when the whistle is set to. */
    public static final String SIGNAL_OPTION = "Signal";

    /** The component that holds the landing site icons, on the quetzals' map and on the whistle's map. */
    private static final Set<Integer> MAP_ICONS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        InterfaceID.QuetzalMenu.ICONS,
        InterfaceID.QuetzalwhistleMenu.ICONS)));

    /** The network quetzals: Renu in each of her colours, and the quetzal at every landing site. */
    private static final Set<Integer> NETWORK_QUETZAL_IDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        NpcID.QUETZAL_CHILD_GREEN,
        NpcID.QUETZAL_CHILD_ORANGE,
        NpcID.QUETZAL_CHILD_BLUE,
        NpcID.QUETZAL_CHILD_CYAN,
        NpcID.QUETZAL_CHILD_GREEN_ORANGE,
        NpcID.QUETZAL_FORTIS,
        NpcID.QUETZAL_TEOMAT,
        NpcID.QUETZAL_SUNSETCOAST,
        NpcID.QUETZAL_HUNTERGUILD,
        NpcID.QUETZAL_CAMTORUM,
        NpcID.QUETZAL_COLOSSALWYRM,
        NpcID.QUETZAL_OUTERFORTIS,
        NpcID.QUETZAL_COLOSSEUM,
        NpcID.QUETZAL_ALDARIN,
        NpcID.QUETZAL_QUETZACALLIGORGE,
        NpcID.QUETZAL_SALVAGEROVERLOOK,
        NpcID.QUETZAL_TALTEKLAN,
        NpcID.QUETZAL_AUBURNVALLEY,
        NpcID.QUETZAL_KASTORI)));

    /** Every tier of the quetzal whistle. */
    private static final Set<Integer> WHISTLE_IDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        ItemID.HG_QUETZALWHISTLE_BASIC,
        ItemID.HG_QUETZALWHISTLE_ENHANCED,
        ItemID.HG_QUETZALWHISTLE_PERFECTED,
        ItemID.HG_QUETZALWHISTLE_PERFECTED_INFINITE)));

    private QuetzalTransport()
    {
    }

    public static boolean isMapIcon(int componentId)
    {
        return MAP_ICONS.contains(componentId);
    }

    public static boolean isNetworkQuetzal(int npcId)
    {
        return NETWORK_QUETZAL_IDS.contains(npcId);
    }

    public static boolean isWhistle(int itemId)
    {
        return WHISTLE_IDS.contains(itemId);
    }

    /**
     * The two legs of the Varrock quetzal route, each paired with the keeper
     * and the quetzal at its starting end and the toggle that blocks it. The
     * quetzal flies from Travel, and the keeper from Travel and from chat.
     */
    public enum Route
    {
        VARROCK_TO_CIVITAS(NpcID.VMQ2_QUETZAL_KEEPER_2OP, NpcID.VMQ2_QUETZAL_OP, TeleportBlockerConfig::quetzalVarrockToCivitas),
        CIVITAS_TO_VARROCK(NpcID.VMQ2_QUETZAL_KEEPER_FORTIS, NpcID.VMQ2_QUETZAL_FORTIS, TeleportBlockerConfig::quetzalCivitasToVarrock);

        private final int keeperId;
        private final int quetzalId;
        private final Predicate<TeleportBlockerConfig> blocked;

        Route(int keeperId, int quetzalId, Predicate<TeleportBlockerConfig> blocked)
        {
            this.keeperId = keeperId;
            this.quetzalId = quetzalId;
            this.blocked = blocked;
        }

        public boolean isRouteNpc(int npcId)
        {
            return npcId == keeperId || npcId == quetzalId;
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }
    }

    /**
     * The landing sites of the network map in the game's own order, each paired
     * with the name its icon option carries and the toggle that blocks it. Every
     * site has an icon, built or not. The Last-destination option has a toggle
     * of its own, since its menu entry does not name the site it flies to.
     */
    public enum Destination
    {
        CIVITAS("Civitas illa Fortis", TeleportBlockerConfig::quetzalCivitas),
        THE_TEOMAT("The Teomat", TeleportBlockerConfig::quetzalTheTeomat),
        SUNSET_COAST("Sunset Coast", TeleportBlockerConfig::quetzalSunsetCoast),
        HUNTER_GUILD("Hunter Guild", TeleportBlockerConfig::quetzalHunterGuild),
        CAM_TORUM_ENTRANCE("Cam Torum Entrance", TeleportBlockerConfig::quetzalCamTorumEntrance),
        COLOSSAL_WYRM_REMAINS("Colossal Wyrm Remains", TeleportBlockerConfig::quetzalColossalWyrmRemains),
        OUTER_FORTIS("Outer Fortis", TeleportBlockerConfig::quetzalOuterFortis),
        FORTIS_COLOSSEUM("Fortis Colosseum", TeleportBlockerConfig::quetzalFortisColosseum),
        ALDARIN("Aldarin", TeleportBlockerConfig::quetzalAldarin),
        QUETZACALLI_GORGE("Quetzacalli Gorge", TeleportBlockerConfig::quetzalQuetzacalliGorge),
        SALVAGER_OVERLOOK("Salvager Overlook", TeleportBlockerConfig::quetzalSalvagerOverlook),
        TAL_TEKLAN("Tal Teklan", TeleportBlockerConfig::quetzalTalTeklan),
        AUBURNVALE("Auburnvale", TeleportBlockerConfig::quetzalAuburnvale),
        KASTORI("Kastori", TeleportBlockerConfig::quetzalKastori);

        private final String destinationName;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(String destinationName, Predicate<TeleportBlockerConfig> blocked)
        {
            this.destinationName = destinationName;
            this.blocked = blocked;
        }

        public String getDestinationName()
        {
            return destinationName;
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
}
