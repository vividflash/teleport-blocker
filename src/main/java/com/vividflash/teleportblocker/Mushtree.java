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
import net.runelite.api.gameval.InterfaceID;

// The magic mushtrees on Fossil Island. Using a tree opens a picker with one button per tree, each
// with a text label beside it and a number key, 1 to 4. Which button carries which tree is not
// known yet, so a button is matched by the place its label names.
public final class Mushtree
{
    // The components of each picker line, by line: the line's layer, its button and its label.
    private static final int[][] LINES = {
        {InterfaceID.FossilMushtrees.TREE_LAYER_1, InterfaceID.FossilMushtrees.BUTTON1, InterfaceID.FossilMushtrees.TREE1},
        {InterfaceID.FossilMushtrees.TREE_LAYER_2, InterfaceID.FossilMushtrees.BUTTON2, InterfaceID.FossilMushtrees.TREE2},
        {InterfaceID.FossilMushtrees.TREE_LAYER_3, InterfaceID.FossilMushtrees.BUTTON3, InterfaceID.FossilMushtrees.TREE3},
        {InterfaceID.FossilMushtrees.TREE_LAYER_4, InterfaceID.FossilMushtrees.BUTTON4, InterfaceID.FossilMushtrees.TREE4}};

    private Mushtree()
    {
    }

    public static int lineCount()
    {
        return LINES.length;
    }

    // The 0-based picker line a component belongs to, or -1 when it is on no line.
    public static int lineOf(int componentId)
    {
        for (int line = 0; line < LINES.length; line++)
        {
            for (int component : LINES[line])
            {
                if (component == componentId)
                {
                    return line;
                }
            }
        }
        return -1;
    }

    // The label component of a 0-based picker line.
    public static int labelOf(int line)
    {
        return LINES[line][2];
    }

    // The trees in the order of the config, each with the place its label names and the toggle that
    // blocks it.
    public enum Destination
    {
        HOUSE_ON_THE_HILL("House on the Hill", TeleportBlockerConfig::fossilIslandMushtreeHouseOnTheHill),
        VERDANT_VALLEY("Verdant Valley", TeleportBlockerConfig::fossilIslandMushtreeVerdantValley),
        STICKY_SWAMP("Sticky Swamp", TeleportBlockerConfig::fossilIslandMushtreeStickySwamp),
        MUSHROOM_MEADOW("Mushroom Meadow", TeleportBlockerConfig::fossilIslandMushtreeMushroomMeadow);

        private final String placeKey;
        private final Predicate<TeleportBlockerConfig> blocked;

        Destination(String place, Predicate<TeleportBlockerConfig> blocked)
        {
            this.placeKey = StripAndLowercase.of(place);
            this.blocked = blocked;
        }

        // True when the label names this tree.
        public boolean isNamedBy(String label)
        {
            return StripAndLowercase.of(label).contains(placeKey);
        }

        public boolean isBlocked(TeleportBlockerConfig config)
        {
            return blocked.test(config);
        }
    }
}
