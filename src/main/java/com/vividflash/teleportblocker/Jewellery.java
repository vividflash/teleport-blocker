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

import java.util.Locale;
import net.runelite.api.gameval.InterfaceID;

/**
 * Teleport jewellery, each paired with the equipment slot its worn menu sits
 * on and a lower case fragment of the item name. Every charge variant carries
 * that fragment, so the fragment stands in for a list of item ids. The
 * fragment is matched against the menu target, which keeps a destination word
 * from being read off some unrelated widget.
 */
public enum Jewellery
{
    RING_OF_DUELING("Ring of dueling", "dueling", InterfaceID.Wornitems.SLOT12),
    GAMES_NECKLACE("Games necklace", "games necklace", InterfaceID.Wornitems.SLOT2),
    AMULET_OF_GLORY("Amulet of glory", "glory", InterfaceID.Wornitems.SLOT2),
    RING_OF_WEALTH("Ring of wealth", "wealth", InterfaceID.Wornitems.SLOT12),
    NECKLACE_OF_PASSAGE("Necklace of passage", "passage", InterfaceID.Wornitems.SLOT2),
    COMBAT_BRACELET("Combat bracelet", "combat bracelet", InterfaceID.Wornitems.SLOT9),
    SKILLS_NECKLACE("Skills necklace", "skills necklace", InterfaceID.Wornitems.SLOT2),
    SLAYER_RING("Slayer ring", "slayer ring", InterfaceID.Wornitems.SLOT12),
    DIGSITE_PENDANT("Digsite pendant", "digsite pendant", InterfaceID.Wornitems.SLOT2),
    BURNING_AMULET("Burning amulet", "burning amulet", InterfaceID.Wornitems.SLOT2);

    private final String itemName;
    private final String targetKeyword;
    private final int wornComponentId;
    private final boolean rubDialogue;

    Jewellery(String itemName, String targetKeyword, int wornComponentId)
    {
        this(itemName, targetKeyword, wornComponentId, true);
    }

    Jewellery(String itemName, String targetKeyword, int wornComponentId, boolean rubDialogue)
    {
        this.itemName = itemName;
        this.targetKeyword = targetKeyword;
        this.wornComponentId = wornComponentId;
        this.rubDialogue = rubDialogue;
    }

    public int getWornComponentId()
    {
        return wornComponentId;
    }

    /** True when the destinations of this item can appear in a chat dialogue. */
    public boolean hasRubDialogue()
    {
        return rubDialogue;
    }


    /** A target that cannot be read matches nothing, so the entry is left alone. */
    public boolean matchesTarget(String target)
    {
        return target != null && target.toLowerCase(Locale.ROOT).contains(targetKeyword);
    }

    @Override
    public String toString()
    {
        return itemName;
    }
}
