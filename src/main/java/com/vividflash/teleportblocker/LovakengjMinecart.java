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
 * The Lovakengj minecart network. Every conductor and minecart opens the same
 * station list, drawn by the generic list script that also draws the spirit
 * tree list, so the list is recognised by its title. The title goes on to name
 * the fare, which depends on quest progress.
 */
public final class LovakengjMinecart
{
    /** The start of the title printed above the station list, ahead of the fare. */
    public static final String TITLE = "Minecart rides";

    private LovakengjMinecart()
    {
    }

    /** True when a list title belongs to the station list, whatever fare it names. */
    public static boolean isTitle(String title)
    {
        return StripAndLowercase.of(title).startsWith(StripAndLowercase.of(TITLE));
    }

    /**
     * The stations of the list in list order, each paired with the name its
     * line prints and the toggle that blocks it.
     */
    public enum Station
    {
        ARCEUUS("Arceuus", TeleportBlockerConfig::minecartArceuus),
        FARMING_GUILD("Farming Guild", TeleportBlockerConfig::minecartFarmingGuild),
        HOSIDIUS_SOUTH("Hosidius South", TeleportBlockerConfig::minecartHosidiusSouth),
        HOSIDIUS_WEST("Hosidius West", TeleportBlockerConfig::minecartHosidiusWest),
        KINGSTOWN("Kingstown", TeleportBlockerConfig::minecartKingstown),
        KOUREND_WOODLAND("Kourend Woodland", TeleportBlockerConfig::minecartKourendWoodland),
        LOVAKENGJ("Lovakengj", TeleportBlockerConfig::minecartLovakengj),
        MOUNT_QUIDAMORTEM("Mount Quidamortem", TeleportBlockerConfig::minecartMountQuidamortem),
        NORTHERN_TUNDRAS("Northern Tundras", TeleportBlockerConfig::minecartNorthernTundras),
        PORT_PISCARILIUS("Port Piscarilius", TeleportBlockerConfig::minecartPortPiscarilius),
        SHAYZIEN_EAST("Shayzien East", TeleportBlockerConfig::minecartShayzienEast),
        SHAYZIEN_WEST("Shayzien West", TeleportBlockerConfig::minecartShayzienWest);

        private final String stationName;
        private final Predicate<TeleportBlockerConfig> blocked;

        Station(String stationName, Predicate<TeleportBlockerConfig> blocked)
        {
            this.stationName = stationName;
            this.blocked = blocked;
        }

        public String getStationName()
        {
            return stationName;
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }

        @Override
        public String toString()
        {
            return stationName;
        }
    }
}
