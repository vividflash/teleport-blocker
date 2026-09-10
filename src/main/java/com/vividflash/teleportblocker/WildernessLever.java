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
import net.runelite.api.gameval.ObjectID;

/**
 * The Wilderness levers: the Edgeville and Ardougne levers that pull a player
 * into the Deserted Keep, and the Deserted Keep lever that pulls back out.
 */
public final class WildernessLever
{
    private WildernessLever()
    {
    }

    /**
     * The two levers that pull into the Wilderness, each paired with its
     * object id and the toggle that blocks it. Both offer only Pull.
     */
    public enum Entry
    {
        EDGEVILLE(ObjectID.EDGEVILLE_WILDY_LEVER, TeleportBlockerConfig::edgevilleLeverToWilderness),
        ARDOUGNE(ObjectID.WILDINLEVER, TeleportBlockerConfig::ardougneLeverToWilderness);

        private final int objectId;
        private final Predicate<TeleportBlockerConfig> blocked;

        Entry(int objectId, Predicate<TeleportBlockerConfig> blocked)
        {
            this.objectId = objectId;
            this.blocked = blocked;
        }

        public int getObjectId()
        {
            return objectId;
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }
    }

    /**
     * The two return destinations of the Deserted Keep lever, each paired with
     * its option line and the toggle that blocks it. Once the Wilderness Easy
     * Diary is done the lever offers both as options, in either order, so the
     * option text tells them apart. Before that diary it offers only Pull,
     * which always goes to Ardougne. Swap-options is never touched.
     */
    public enum Destination
    {
        EDGEVILLE("Edgeville", TeleportBlockerConfig::wildernessLeverToEdgeville),
        ARDOUGNE("Ardougne", TeleportBlockerConfig::wildernessLeverToArdougne);

        public static final int PRE_DIARY_OBJECT_ID = ObjectID.WILDOUTLEVER_DEFAULT;

        private static final Set<Integer> OBJECT_IDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            ObjectID.WILDOUTLEVER_DIARY,
            ObjectID.WILDOUTLEVER_DIARY_SWAPPED)));

        private final String optionLine;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(String optionLine, Predicate<TeleportBlockerConfig> blocked)
        {
            this.optionLine = optionLine;
            this.blocked = blocked;
        }

        public String getOptionLine()
        {
            return optionLine;
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }

        public static boolean isLeverObject(int objectId)
        {
            return OBJECT_IDS.contains(objectId);
        }

        @Override
        public String toString()
        {
            return optionLine;
        }
    }
}
