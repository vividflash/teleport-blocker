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
import java.util.function.Predicate;
import net.runelite.api.gameval.InterfaceID;

/**
 * Destinations offered by teleport jewellery and achievement diary reward
 * items, each paired with its item, the option text the game prints and the
 * toggle that blocks it. A few destinations are worded one way on the worn
 * menu and another in the rub dialogue or the inventory menu, so those carry
 * a second accepted line. Cancel, Rub, Wear, Wield, Drop and the Ring of
 * wealth Features, Boss Log and Coin Collection options are not listed and are
 * never touched.
 */
public enum ItemTeleport
{
    DUELING_EMIRS_ARENA(Item.RING_OF_DUELING, "Emir's Arena", TeleportBlockerConfig::duelingEmirsArena),
    DUELING_CASTLE_WARS(Item.RING_OF_DUELING, "Castle Wars", TeleportBlockerConfig::duelingCastleWars),
    DUELING_FEROX_ENCLAVE(Item.RING_OF_DUELING, "Ferox Enclave", TeleportBlockerConfig::duelingFeroxEnclave),
    DUELING_FORTIS_COLOSSEUM(Item.RING_OF_DUELING, "Fortis Colosseum", TeleportBlockerConfig::duelingFortisColosseum),

    GAMES_BURTHORPE(Item.GAMES_NECKLACE, "Burthorpe", TeleportBlockerConfig::gamesBurthorpe),
    GAMES_BARBARIAN_OUTPOST(Item.GAMES_NECKLACE, "Barbarian Outpost", TeleportBlockerConfig::gamesBarbarianOutpost),
    GAMES_CORPOREAL_BEAST(Item.GAMES_NECKLACE, "Corporeal Beast", TeleportBlockerConfig::gamesCorporealBeast),
    GAMES_TEARS_OF_GUTHIX(Item.GAMES_NECKLACE, "Tears of Guthix", TeleportBlockerConfig::gamesTearsOfGuthix),
    GAMES_WINTERTODT_CAMP(Item.GAMES_NECKLACE, "Wintertodt Camp", TeleportBlockerConfig::gamesWintertodtCamp),

    GLORY_EDGEVILLE(Item.AMULET_OF_GLORY, "Edgeville", TeleportBlockerConfig::gloryEdgeville),
    GLORY_KARAMJA(Item.AMULET_OF_GLORY, "Karamja", TeleportBlockerConfig::gloryKaramja),
    GLORY_DRAYNOR_VILLAGE(Item.AMULET_OF_GLORY, "Draynor Village", TeleportBlockerConfig::gloryDraynorVillage),
    GLORY_AL_KHARID(Item.AMULET_OF_GLORY, "Al Kharid", TeleportBlockerConfig::gloryAlKharid),

    WEALTH_MISCELLANIA(Item.RING_OF_WEALTH, "Miscellania", TeleportBlockerConfig::wealthMiscellania),
    WEALTH_GRAND_EXCHANGE(Item.RING_OF_WEALTH, "Grand Exchange", TeleportBlockerConfig::wealthGrandExchange),
    WEALTH_FALADOR_PARK(Item.RING_OF_WEALTH, "Falador Park", "Falador", TeleportBlockerConfig::wealthFaladorPark),
    WEALTH_DONDAKAN(Item.RING_OF_WEALTH, "Dondakan", "Dondakan's Rock", TeleportBlockerConfig::wealthDondakan),

    PASSAGE_WIZARDS_TOWER(Item.NECKLACE_OF_PASSAGE, "Wizards' Tower", TeleportBlockerConfig::passageWizardsTower),
    PASSAGE_THE_OUTPOST(Item.NECKLACE_OF_PASSAGE, "The Outpost", TeleportBlockerConfig::passageTheOutpost),
    PASSAGE_EAGLES_EYRIE(Item.NECKLACE_OF_PASSAGE, "Eagles' Eyrie", TeleportBlockerConfig::passageEaglesEyrie),
    PASSAGE_WYRMSCRAIG(Item.NECKLACE_OF_PASSAGE, "Wyrmscraig", TeleportBlockerConfig::passageWyrmscraig),

    COMBAT_WARRIORS_GUILD(Item.COMBAT_BRACELET, "Warriors' Guild", TeleportBlockerConfig::combatWarriorsGuild),
    COMBAT_CHAMPIONS_GUILD(Item.COMBAT_BRACELET, "Champions' Guild", TeleportBlockerConfig::combatChampionsGuild),
    COMBAT_MONASTERY(Item.COMBAT_BRACELET, "Monastery", "Edgeville Monastery", TeleportBlockerConfig::combatMonastery),
    COMBAT_RANGING_GUILD(Item.COMBAT_BRACELET, "Ranging Guild", TeleportBlockerConfig::combatRangingGuild),

    SKILLS_FISHING_GUILD(Item.SKILLS_NECKLACE, "Fishing Guild", TeleportBlockerConfig::skillsFishingGuild),
    SKILLS_MINING_GUILD(Item.SKILLS_NECKLACE, "Mining Guild", TeleportBlockerConfig::skillsMiningGuild),
    SKILLS_CRAFTING_GUILD(Item.SKILLS_NECKLACE, "Crafting Guild", TeleportBlockerConfig::skillsCraftingGuild),
    SKILLS_COOKING_GUILD(Item.SKILLS_NECKLACE, "Cooking Guild", "Cooks' Guild", TeleportBlockerConfig::skillsCookingGuild),
    SKILLS_WOODCUTTING_GUILD(Item.SKILLS_NECKLACE, "Woodcutting Guild", TeleportBlockerConfig::skillsWoodcuttingGuild),
    SKILLS_FARMING_GUILD(Item.SKILLS_NECKLACE, "Farming Guild", TeleportBlockerConfig::skillsFarmingGuild),

    SLAYER_STRONGHOLD_SLAYER_CAVE(Item.SLAYER_RING, "Stronghold Slayer Cave", "Gnome Stronghold Caves", TeleportBlockerConfig::slayerStrongholdSlayerCave),
    SLAYER_SLAYER_TOWER(Item.SLAYER_RING, "Slayer Tower", TeleportBlockerConfig::slayerSlayerTower),
    SLAYER_FREMENNIK_SLAYER_DUNGEON(Item.SLAYER_RING, "Fremennik Slayer Dungeon", "Rellekka Caves", TeleportBlockerConfig::slayerFremennikSlayerDungeon),
    SLAYER_TARNS_LAIR(Item.SLAYER_RING, "Tarn's Lair", "Haunted Mine", TeleportBlockerConfig::slayerTarnsLair),
    SLAYER_DARK_BEASTS(Item.SLAYER_RING, "Dark Beasts", "ME2 Caves", TeleportBlockerConfig::slayerDarkBeasts),
    SLAYER_WYRMSCRAIG_CAVERN(Item.SLAYER_RING, "Teleport to the Wyrmscraig Cavern", "Wyrmscraig Cavern", TeleportBlockerConfig::slayerWyrmscraigCavern),

    DIGSITE_DIGSITE(Item.DIGSITE_PENDANT, "Digsite", TeleportBlockerConfig::digsiteDigsite),
    DIGSITE_FOSSIL_ISLAND(Item.DIGSITE_PENDANT, "Fossil Island", TeleportBlockerConfig::digsiteFossilIsland),
    DIGSITE_LITHKREN(Item.DIGSITE_PENDANT, "Lithkren Dungeon", "Lithkren", TeleportBlockerConfig::digsiteLithkren),

    BURNING_CHAOS_TEMPLE(Item.BURNING_AMULET, "Chaos Temple", TeleportBlockerConfig::burningChaosTemple),
    BURNING_BANDIT_CAMP(Item.BURNING_AMULET, "Bandit Camp", TeleportBlockerConfig::burningBanditCamp),
    BURNING_LAVA_MAZE(Item.BURNING_AMULET, "Lava Maze", TeleportBlockerConfig::burningLavaMaze),

    ARDOUGNE_KANDARIN_MONASTERY(Item.ARDOUGNE_CLOAK, "Monastery Teleport", "Kandarin Monastery", TeleportBlockerConfig::ardougneKandarinMonastery),
    ARDOUGNE_ARDOUGNE_FARM(Item.ARDOUGNE_CLOAK, "Farm Teleport", "Ardougne Farm", TeleportBlockerConfig::ardougneArdougneFarm),

    DESERT_NARDAH(Item.DESERT_AMULET, "Teleport", "Nardah", TeleportBlockerConfig::desertNardah),
    DESERT_KALPHITE_CAVE(Item.DESERT_AMULET, "Kalphite Cave", TeleportBlockerConfig::desertKalphiteCave),

    EXPLORERS_CABBAGE_PATCH(Item.EXPLORERS_RING, "Teleport", TeleportBlockerConfig::explorersCabbagePatch),

    FREMENNIK_RELLEKKA(Item.FREMENNIK_SEA_BOOTS, "Teleport", TeleportBlockerConfig::fremennikRellekka),

    KANDARIN_SHERLOCK(Item.KANDARIN_HEADGEAR, "Teleport", TeleportBlockerConfig::kandarinSherlock),

    KARAMJA_GEM_MINE(Item.KARAMJA_GLOVES, "Gem Mine", TeleportBlockerConfig::karamjaGemMine),
    KARAMJA_SLAYER_MASTER(Item.KARAMJA_GLOVES, "Slayer Master", "Duradel", TeleportBlockerConfig::karamjaSlayerMaster),

    MORYTANIA_ECTOFUNTUS(Item.MORYTANIA_LEGS, "Ecto Teleport", "Ectofuntus Pit", TeleportBlockerConfig::morytaniaEctofuntus),
    MORYTANIA_BURGH_DE_ROTT(Item.MORYTANIA_LEGS, "Burgh Teleport", "Burgh de Rott", TeleportBlockerConfig::morytaniaBurghDeRott),

    RADAS_KOUREND_WOODLAND(Item.RADAS_BLESSING, "Kourend Woodland", TeleportBlockerConfig::radasKourendWoodland),
    RADAS_MT_KARUULM(Item.RADAS_BLESSING, "Mount Karuulm", TeleportBlockerConfig::radasMtKaruulm),

    WESTERN_PISCATORIS(Item.WESTERN_BANNER, "Teleport", TeleportBlockerConfig::westernPiscatoris),

    WILDERNESS_FOUNTAIN_OF_RUNE(Item.WILDERNESS_SWORD, "Teleport", TeleportBlockerConfig::wildernessFountainOfRune);


    private final Item item;
    private final String optionLine;
    private final String altOptionLine;
    private final String optionKey;
    private final String altOptionKey;
    private final Predicate<TeleportBlockerConfig> blocked;

    ItemTeleport(Item item, String optionLine, Predicate<TeleportBlockerConfig> blocked)
    {
        this(item, optionLine, null, blocked);
    }

    ItemTeleport(Item item, String optionLine, String altOptionLine, Predicate<TeleportBlockerConfig> blocked)
    {
        this.item = item;
        this.optionLine = optionLine;
        this.altOptionLine = altOptionLine;
        this.optionKey = StripAndLowercase.of(optionLine);
        this.altOptionKey = altOptionLine == null ? null : StripAndLowercase.of(altOptionLine);
        this.blocked = blocked;
    }

    public Item getItem()
    {
        return item;
    }

    // The rub dialogue and the item menu punctuate the same place differently,
    // for example Eagles' Eyrie against Eagle's Eyrie, so both sides are
    // compared with punctuation and case removed. Names that differ by a whole
    // word, such as Dondakan against Dondakan's Rock, still need the alternate.
    public boolean matchesOption(String line)
    {
        String key = StripAndLowercase.of(line);
        return !key.isEmpty()
            && (key.equals(optionKey)
                || (altOptionKey != null && key.equals(altOptionKey)));
    }

    /** True when the line is a known destination of the given item. */
    public static boolean matchesDialogueLine(Item item, String line)
    {
        for (ItemTeleport teleport : values())
        {
            if (teleport.item == item && teleport.matchesOption(line))
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

    /**
     * Teleport items, each paired with the equipment slot its worn menu sits
     * on and a lower case fragment of the item name. Every charge variant and tier carries
     * that fragment, so the fragment stands in for a list of item ids. The
     * fragment is matched against the menu target, which keeps a destination word
     * from being read off some unrelated widget. The diary items have no rub
     * dialogue, and several share the plain Teleport option, so their options
     * are only matched with the item name on the target.
     */
    public enum Item
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
        BURNING_AMULET("Burning amulet", "burning amulet", InterfaceID.Wornitems.SLOT2),

        ARDOUGNE_CLOAK("Ardougne cloak", "ardougne cloak", InterfaceID.Wornitems.SLOT1, false),
        DESERT_AMULET("Desert amulet", "desert amulet", InterfaceID.Wornitems.SLOT2, false),
        EXPLORERS_RING("Explorer's ring", "explorer's ring", InterfaceID.Wornitems.SLOT12, false),
        FREMENNIK_SEA_BOOTS("Fremennik sea boots", "fremennik sea boots", InterfaceID.Wornitems.SLOT10, false),
        KANDARIN_HEADGEAR("Kandarin headgear", "kandarin headgear", InterfaceID.Wornitems.SLOT0, false),
        KARAMJA_GLOVES("Karamja gloves", "karamja gloves", InterfaceID.Wornitems.SLOT9, false),
        MORYTANIA_LEGS("Morytania legs", "morytania legs", InterfaceID.Wornitems.SLOT7, false),
        RADAS_BLESSING("Rada's blessing", "rada's blessing", InterfaceID.Wornitems.SLOT13, false),
        WESTERN_BANNER("Western banner", "western banner", InterfaceID.Wornitems.SLOT3, false),
        WILDERNESS_SWORD("Wilderness sword", "wilderness sword", InterfaceID.Wornitems.SLOT3, false);

        private final String itemName;
        private final String targetKeyword;
        private final int wornComponentId;
        private final boolean rubDialogue;

        Item(String itemName, String targetKeyword, int wornComponentId)
        {
            this(itemName, targetKeyword, wornComponentId, true);
        }

        Item(String itemName, String targetKeyword, int wornComponentId, boolean rubDialogue)
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

        /**
         * True when the destinations of this item can appear in a chat dialogue
         * or as bare submenu lines.
         */
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
}
