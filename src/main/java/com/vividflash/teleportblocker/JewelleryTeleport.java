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
 * Destinations offered by teleport jewellery, each paired with its item, the
 * option text the game prints and the toggle that blocks it. A few
 * destinations are worded one way on the worn menu and another in the rub
 * dialogue, so those carry a second accepted line. Cancel, Rub, Wear, Wield,
 * Drop and the Ring of wealth Features, Boss Log and Coin Collection options
 * are not listed and are never touched.
 */
public enum JewelleryTeleport
{
    DUELING_EMIRS_ARENA(Jewellery.RING_OF_DUELING, "Emir's Arena", TeleportBlockerConfig::duelingEmirsArena),
    DUELING_CASTLE_WARS(Jewellery.RING_OF_DUELING, "Castle Wars", TeleportBlockerConfig::duelingCastleWars),
    DUELING_FEROX_ENCLAVE(Jewellery.RING_OF_DUELING, "Ferox Enclave", TeleportBlockerConfig::duelingFeroxEnclave),
    DUELING_FORTIS_COLOSSEUM(Jewellery.RING_OF_DUELING, "Fortis Colosseum", TeleportBlockerConfig::duelingFortisColosseum),

    GAMES_BURTHORPE(Jewellery.GAMES_NECKLACE, "Burthorpe", TeleportBlockerConfig::gamesBurthorpe),
    GAMES_BARBARIAN_OUTPOST(Jewellery.GAMES_NECKLACE, "Barbarian Outpost", TeleportBlockerConfig::gamesBarbarianOutpost),
    GAMES_CORPOREAL_BEAST(Jewellery.GAMES_NECKLACE, "Corporeal Beast", TeleportBlockerConfig::gamesCorporealBeast),
    GAMES_TEARS_OF_GUTHIX(Jewellery.GAMES_NECKLACE, "Tears of Guthix", TeleportBlockerConfig::gamesTearsOfGuthix),
    GAMES_WINTERTODT_CAMP(Jewellery.GAMES_NECKLACE, "Wintertodt Camp", TeleportBlockerConfig::gamesWintertodtCamp),

    GLORY_EDGEVILLE(Jewellery.AMULET_OF_GLORY, "Edgeville", TeleportBlockerConfig::gloryEdgeville),
    GLORY_KARAMJA(Jewellery.AMULET_OF_GLORY, "Karamja", TeleportBlockerConfig::gloryKaramja),
    GLORY_DRAYNOR_VILLAGE(Jewellery.AMULET_OF_GLORY, "Draynor Village", TeleportBlockerConfig::gloryDraynorVillage),
    GLORY_AL_KHARID(Jewellery.AMULET_OF_GLORY, "Al Kharid", TeleportBlockerConfig::gloryAlKharid),

    WEALTH_MISCELLANIA(Jewellery.RING_OF_WEALTH, "Miscellania", TeleportBlockerConfig::wealthMiscellania),
    WEALTH_GRAND_EXCHANGE(Jewellery.RING_OF_WEALTH, "Grand Exchange", TeleportBlockerConfig::wealthGrandExchange),
    WEALTH_FALADOR_PARK(Jewellery.RING_OF_WEALTH, "Falador Park", "Falador", TeleportBlockerConfig::wealthFaladorPark),
    WEALTH_DONDAKAN(Jewellery.RING_OF_WEALTH, "Dondakan", "Dondakan's Rock", TeleportBlockerConfig::wealthDondakan),

    PASSAGE_WIZARDS_TOWER(Jewellery.NECKLACE_OF_PASSAGE, "Wizards' Tower", TeleportBlockerConfig::passageWizardsTower),
    PASSAGE_THE_OUTPOST(Jewellery.NECKLACE_OF_PASSAGE, "The Outpost", TeleportBlockerConfig::passageTheOutpost),
    PASSAGE_EAGLES_EYRIE(Jewellery.NECKLACE_OF_PASSAGE, "Eagles' Eyrie", TeleportBlockerConfig::passageEaglesEyrie),
    PASSAGE_WYRMSCRAIG(Jewellery.NECKLACE_OF_PASSAGE, "Wyrmscraig", TeleportBlockerConfig::passageWyrmscraig),

    COMBAT_WARRIORS_GUILD(Jewellery.COMBAT_BRACELET, "Warriors' Guild", TeleportBlockerConfig::combatWarriorsGuild),
    COMBAT_CHAMPIONS_GUILD(Jewellery.COMBAT_BRACELET, "Champions' Guild", TeleportBlockerConfig::combatChampionsGuild),
    COMBAT_MONASTERY(Jewellery.COMBAT_BRACELET, "Monastery", "Edgeville Monastery", TeleportBlockerConfig::combatMonastery),
    COMBAT_RANGING_GUILD(Jewellery.COMBAT_BRACELET, "Ranging Guild", TeleportBlockerConfig::combatRangingGuild),

    SKILLS_FISHING_GUILD(Jewellery.SKILLS_NECKLACE, "Fishing Guild", TeleportBlockerConfig::skillsFishingGuild),
    SKILLS_MINING_GUILD(Jewellery.SKILLS_NECKLACE, "Mining Guild", TeleportBlockerConfig::skillsMiningGuild),
    SKILLS_CRAFTING_GUILD(Jewellery.SKILLS_NECKLACE, "Crafting Guild", TeleportBlockerConfig::skillsCraftingGuild),
    SKILLS_COOKING_GUILD(Jewellery.SKILLS_NECKLACE, "Cooking Guild", "Cooks' Guild", TeleportBlockerConfig::skillsCookingGuild),
    SKILLS_WOODCUTTING_GUILD(Jewellery.SKILLS_NECKLACE, "Woodcutting Guild", TeleportBlockerConfig::skillsWoodcuttingGuild),
    SKILLS_FARMING_GUILD(Jewellery.SKILLS_NECKLACE, "Farming Guild", TeleportBlockerConfig::skillsFarmingGuild),

    SLAYER_STRONGHOLD_SLAYER_CAVE(Jewellery.SLAYER_RING, "Stronghold Slayer Cave", "Gnome Stronghold Caves", TeleportBlockerConfig::slayerStrongholdSlayerCave),
    SLAYER_SLAYER_TOWER(Jewellery.SLAYER_RING, "Slayer Tower", TeleportBlockerConfig::slayerSlayerTower),
    SLAYER_FREMENNIK_SLAYER_DUNGEON(Jewellery.SLAYER_RING, "Fremennik Slayer Dungeon", "Rellekka Caves", TeleportBlockerConfig::slayerFremennikSlayerDungeon),
    SLAYER_TARNS_LAIR(Jewellery.SLAYER_RING, "Tarn's Lair", "Haunted Mine", TeleportBlockerConfig::slayerTarnsLair),
    SLAYER_DARK_BEASTS(Jewellery.SLAYER_RING, "Dark Beasts", "ME2 Caves", TeleportBlockerConfig::slayerDarkBeasts),
    SLAYER_WYRMSCRAIG_CAVERN(Jewellery.SLAYER_RING, "Teleport to the Wyrmscraig Cavern", "Wyrmscraig Cavern", TeleportBlockerConfig::slayerWyrmscraigCavern),

    DIGSITE_DIGSITE(Jewellery.DIGSITE_PENDANT, "Digsite", TeleportBlockerConfig::digsiteDigsite),
    DIGSITE_FOSSIL_ISLAND(Jewellery.DIGSITE_PENDANT, "Fossil Island", TeleportBlockerConfig::digsiteFossilIsland),
    DIGSITE_LITHKREN(Jewellery.DIGSITE_PENDANT, "Lithkren Dungeon", "Lithkren", TeleportBlockerConfig::digsiteLithkren),

    BURNING_CHAOS_TEMPLE(Jewellery.BURNING_AMULET, "Chaos Temple", TeleportBlockerConfig::burningChaosTemple),
    BURNING_BANDIT_CAMP(Jewellery.BURNING_AMULET, "Bandit Camp", TeleportBlockerConfig::burningBanditCamp),
    BURNING_LAVA_MAZE(Jewellery.BURNING_AMULET, "Lava Maze", TeleportBlockerConfig::burningLavaMaze);


    private final Jewellery item;
    private final String optionLine;
    private final String altOptionLine;
    private final Predicate<TeleportBlockerConfig> blocked;

    JewelleryTeleport(Jewellery item, String optionLine, Predicate<TeleportBlockerConfig> blocked)
    {
        this(item, optionLine, null, blocked);
    }

    JewelleryTeleport(Jewellery item, String optionLine, String altOptionLine, Predicate<TeleportBlockerConfig> blocked)
    {
        this.item = item;
        this.optionLine = optionLine;
        this.altOptionLine = altOptionLine;
        this.blocked = blocked;
    }

    public Jewellery getItem()
    {
        return item;
    }

    // The rub dialogue and the item menu punctuate the same place differently,
    // for example Eagles' Eyrie against Eagle's Eyrie, so both sides are
    // compared with punctuation and case removed. Names that differ by a whole
    // word, such as Dondakan against Dondakan's Rock, still need the alternate.
    public boolean matchesOption(String line)
    {
        String key = TeleportText.key(line);
        return !key.isEmpty()
            && (key.equals(TeleportText.key(optionLine))
                || (altOptionLine != null && key.equals(TeleportText.key(altOptionLine))));
    }

    /** True when the line is a known destination of any item that has a rub dialogue. */
    public static boolean matchesAnyDialogueLine(String line)
    {
        for (JewelleryTeleport teleport : values())
        {
            if (teleport.item.hasRubDialogue() && teleport.matchesOption(line))
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

    @Override
    public String toString()
    {
        return optionLine;
    }
}
