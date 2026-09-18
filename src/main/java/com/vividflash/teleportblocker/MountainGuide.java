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
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import net.runelite.api.gameval.NpcID;

/**
 * The Mountain Guides. The three around Mount Quidamortem open the same chat
 * picker from Travel and from Talk-to, so a picker line is read only while the
 * chat of a guide clicked last is open. The guide between Nemus Retreat and
 * Quetzacalli Gorge travels straight from Follow to the other end, and which
 * end he stands at is told apart by his position.
 */
public final class MountainGuide
{
    private static final String FOLLOW_OPTION = "Follow";

    private static final Set<Integer> QUIDAMORTEM_GUIDE_IDS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        NpcID.RAIDS_MOUNTAINGUIDE_1OP, NpcID.RAIDS_MOUNTAINGUIDE_2OPS, NpcID.RAIDS_MOUNTAINGUIDE_TEMPLE_MULTI,
        NpcID.RAIDS_MOUNTAINGUIDE_WALL_MULTI, NpcID.RAIDS_MOUNTAINGUIDE_SOUTH_MULTI)));

    /** West of this x the Varlamore guide stands at Nemus Retreat, east of it at Quetzacalli Gorge. */
    private static final int VARLAMORE_MIDPOINT_X = 1420;

    private MountainGuide()
    {
    }

    public static boolean isQuidamortemGuide(int npcId)
    {
        return QUIDAMORTEM_GUIDE_IDS.contains(npcId);
    }

    public static boolean isVarlamoreGuide(int npcId)
    {
        return npcId == NpcID.QUETZACALLI_MOUNTAIN_GUIDE_AUBURNVALE;
    }

    public static boolean isFollow(String option)
    {
        return StripAndLowercase.of(FOLLOW_OPTION).equals(StripAndLowercase.of(option));
    }

    /**
     * The destinations in the order of the config, each paired with the picker
     * line that picks it or the side of the Varlamore guide whose Follow goes
     * there, and the toggle that blocks it.
     */
    public enum Destination
    {
        SHAYZIEN_OUTPOST("The Shayzien Outpost.", null, TeleportBlockerConfig::mountainGuideShayzienOutpost),
        MOUNT_QUIDAMORTEM("Mount Quidamortem.", null, TeleportBlockerConfig::mountainGuideMountQuidamortem),
        SOUTH_OF_QUIDAMORTEM("South of Quidamortem.", null, TeleportBlockerConfig::mountainGuideSouthOfQuidamortem),
        QUETZACALLI_GORGE(null, x -> x < VARLAMORE_MIDPOINT_X, TeleportBlockerConfig::mountainGuideQuetzacalliGorge),
        NEMUS_RETREAT(null, x -> x >= VARLAMORE_MIDPOINT_X, TeleportBlockerConfig::mountainGuideNemusRetreat);

        private final String line;
        private final IntPredicate followFromX;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(String line, IntPredicate followFromX, Predicate<TeleportBlockerConfig> blocked)
        {
            this.line = line;
            this.followFromX = followFromX;
            this.blocked = blocked;
        }

        public boolean matchesLine(String text)
        {
            String key = StripAndLowercase.of(text);
            return line != null && !key.isEmpty() && StripAndLowercase.of(line).equals(key);
        }

        /** True when Follow on the Varlamore guide standing at this x goes here. */
        public boolean followsFrom(int x)
        {
            return followFromX != null && followFromX.test(x);
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }
    }
}
