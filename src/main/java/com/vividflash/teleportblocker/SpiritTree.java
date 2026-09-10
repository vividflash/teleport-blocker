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

/**
 * The spirit tree network. Every tree opens the same destination list, drawn
 * by a generic list script that takes its title and lines from the game, so
 * the list is recognised by its title.
 */
public final class SpiritTree
{
    /** The title printed above the destination list. */
    public static final String TITLE = "Spirit Tree Locations";

    /** The tree option that travels straight to the last destination used. */
    public static final String PREVIOUS_OPTION = "Last-destination";

    /** The name the spirit tree objects carry. */
    public static final String OBJECT_NAME = "Spirit tree";

    private SpiritTree()
    {
    }

    /**
     * The destinations of the list in list order, each paired with the name its
     * line prints and the toggle that blocks it. Spirit trees have no master
     * toggle. The Last-destination option has a toggle of its own, since its
     * menu entry does not name the place it travels to.
     */
    public enum Destination
    {
        TREE_GNOME_VILLAGE("Tree Gnome Village", TeleportBlockerConfig::spiritTreeGnomeVillage),
        GNOME_STRONGHOLD("Gnome Stronghold", TeleportBlockerConfig::spiritTreeGnomeStronghold),
        BATTLEFIELD_OF_KHAZARD("Battlefield of Khazard", TeleportBlockerConfig::spiritTreeBattlefieldOfKhazard),
        GRAND_EXCHANGE("Grand Exchange", TeleportBlockerConfig::spiritTreeGrandExchange),
        FELDIP_HILLS("Feldip Hills", TeleportBlockerConfig::spiritTreeFeldipHills),
        PRIFDDINAS("Prifddinas", TeleportBlockerConfig::spiritTreePrifddinas),
        PORT_SARIM("Port Sarim", TeleportBlockerConfig::spiritTreePortSarim),
        ETCETERIA("Etceteria", TeleportBlockerConfig::spiritTreeEtceteria),
        BRIMHAVEN("Brimhaven", TeleportBlockerConfig::spiritTreeBrimhaven),
        HOSIDIUS("Hosidius", TeleportBlockerConfig::spiritTreeHosidius),
        FARMING_GUILD("Farming Guild", TeleportBlockerConfig::spiritTreeFarmingGuild),
        HOUSE("Your house", TeleportBlockerConfig::spiritTreeHouse),
        POISON_WASTE("Poison Waste", TeleportBlockerConfig::spiritTreePoisonWaste),
        LAGUNA_AURORAE("Laguna Aurorae", TeleportBlockerConfig::spiritTreeLagunaAurorae);

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

        /**
         * True when the text after a line's shortcut names this destination.
         * The house line can carry the house's location in brackets, which is
         * cut before comparing.
         */
        public boolean matchesLine(String destination)
        {
            int bracket = destination.indexOf(" (");
            String place = bracket > 0 ? destination.substring(0, bracket) : destination;
            return StripAndLowercase.of(destinationName).equals(StripAndLowercase.of(place));
        }

        @Override
        public String toString()
        {
            return destinationName;
        }
    }
}
