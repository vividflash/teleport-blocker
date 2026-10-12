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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("teleportblocker")
public interface TeleportBlockerConfig extends Config
{
    enum CheckedMeans
    {
        ALLOW("Allow"),
        BLOCK("Block");

        private final String label;

        CheckedMeans(String label)
        {
            this.label = label;
        }

        @Override
        public String toString()
        {
            return label;
        }
    }

    @ConfigItem(
        keyName = "checkedMeans",
        name = "Checked Means",
        description = "",
        position = 0
    )
    default CheckedMeans checkedMeans()
    {
        return CheckedMeans.ALLOW;
    }

    @ConfigSection(
        name = "Teleports",
        description = "",
        position = 1,
        closedByDefault = true
    )
    String teleportsSection = "teleportsSection";

    @ConfigItem(
        keyName = "homeTeleport",
        name = "Home Teleport",
        description = "",
        position = 2,
        section = teleportsSection
    )
    default boolean homeTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "varrockTeleport",
        name = "Varrock Teleport",
        description = "",
        position = 3,
        section = teleportsSection
    )
    default boolean varrockTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lumbridgeTeleport",
        name = "Lumbridge Teleport",
        description = "",
        position = 4,
        section = teleportsSection
    )
    default boolean lumbridgeTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "faladorTeleport",
        name = "Falador Teleport",
        description = "",
        position = 5,
        section = teleportsSection
    )
    default boolean faladorTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "houseTeleport",
        name = "Teleport to House",
        description = "",
        position = 6,
        section = teleportsSection
    )
    default boolean houseTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "camelotTeleport",
        name = "Camelot Teleport",
        description = "",
        position = 7,
        section = teleportsSection
    )
    default boolean camelotTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "kourendTeleport",
        name = "Kourend Castle Teleport",
        description = "",
        position = 8,
        section = teleportsSection
    )
    default boolean kourendTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ardougneTeleport",
        name = "Ardougne Teleport",
        description = "",
        position = 9,
        section = teleportsSection
    )
    default boolean ardougneTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fortisTeleport",
        name = "Civitas illa Fortis Teleport",
        description = "",
        position = 10,
        section = teleportsSection
    )
    default boolean fortisTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "watchtowerTeleport",
        name = "Watchtower Teleport",
        description = "",
        position = 11,
        section = teleportsSection
    )
    default boolean watchtowerTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "trollheimTeleport",
        name = "Trollheim Teleport",
        description = "",
        position = 12,
        section = teleportsSection
    )
    default boolean trollheimTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "apeAtollTeleport",
        name = "Ape Atoll Teleport",
        description = "",
        position = 13,
        section = teleportsSection
    )
    default boolean apeAtollTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minigameTeleport",
        name = "Minigame Teleport",
        description = "",
        position = 14,
        section = teleportsSection
    )
    default boolean minigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Minigames",
        description = "",
        position = 15,
        closedByDefault = true
    )
    String minigamesSection = "minigamesSection";

    @ConfigItem(
        keyName = "barbarianAssault",
        name = "Barbarian Assault",
        description = "",
        position = 16,
        section = minigamesSection
    )
    default boolean barbarianAssault()
    {
        return false;
    }

    @ConfigItem(
        keyName = "blastFurnace",
        name = "Blast Furnace",
        description = "",
        position = 17,
        section = minigamesSection
    )
    default boolean blastFurnace()
    {
        return false;
    }

    @ConfigItem(
        keyName = "bountyHunter",
        name = "Bounty Hunter",
        description = "",
        position = 18,
        section = minigamesSection
    )
    default boolean bountyHunter()
    {
        return false;
    }

    @ConfigItem(
        keyName = "burthorpeGamesRoom",
        name = "Burthorpe Games Room",
        description = "",
        position = 19,
        section = minigamesSection
    )
    default boolean burthorpeGamesRoom()
    {
        return false;
    }

    @ConfigItem(
        keyName = "castleWars",
        name = "Castle Wars",
        description = "",
        position = 20,
        section = minigamesSection
    )
    default boolean castleWars()
    {
        return false;
    }

    @ConfigItem(
        keyName = "clanWars",
        name = "Clan Wars",
        description = "",
        position = 21,
        section = minigamesSection
    )
    default boolean clanWars()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fishingTrawler",
        name = "Fishing Trawler",
        description = "",
        position = 22,
        section = minigamesSection
    )
    default boolean fishingTrawler()
    {
        return false;
    }

    @ConfigItem(
        keyName = "giantsFoundry",
        name = "Giants' Foundry",
        description = "",
        position = 23,
        section = minigamesSection
    )
    default boolean giantsFoundry()
    {
        return false;
    }

    @ConfigItem(
        keyName = "guardiansOfTheRift",
        name = "Guardians of the Rift",
        description = "",
        position = 24,
        section = minigamesSection
    )
    default boolean guardiansOfTheRift()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lastManStanding",
        name = "Last Man Standing",
        description = "",
        position = 25,
        section = minigamesSection
    )
    default boolean lastManStanding()
    {
        return false;
    }

    @ConfigItem(
        keyName = "mageTrainingArena",
        name = "Mage Training Arena",
        description = "",
        position = 26,
        section = minigamesSection
    )
    default boolean mageTrainingArena()
    {
        return false;
    }

    @ConfigItem(
        keyName = "masteringMixology",
        name = "Mastering Mixology",
        description = "",
        position = 27,
        section = minigamesSection
    )
    default boolean masteringMixology()
    {
        return false;
    }

    @ConfigItem(
        keyName = "nightmareZone",
        name = "Nightmare Zone",
        description = "",
        position = 28,
        section = minigamesSection
    )
    default boolean nightmareZone()
    {
        return false;
    }

    @ConfigItem(
        keyName = "pestControl",
        name = "Pest Control",
        description = "",
        position = 29,
        section = minigamesSection
    )
    default boolean pestControl()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPits",
        name = "Rat Pits",
        description = "",
        position = 30,
        section = minigamesSection
    )
    default boolean ratPits()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsArdougne",
        name = "Rat Pits: Ardougne (Kittens)",
        description = "",
        position = 31,
        section = minigamesSection
    )
    default boolean ratPitsArdougne()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsVarrock",
        name = "Rat Pits: Varrock (Grown Cats)",
        description = "",
        position = 32,
        section = minigamesSection
    )
    default boolean ratPitsVarrock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsKeldagrim",
        name = "Rat Pits: Keldagrim (Overgrown Cats)",
        description = "",
        position = 33,
        section = minigamesSection
    )
    default boolean ratPitsKeldagrim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsPortSarim",
        name = "Rat Pits: Port Sarim (Wily Cats)",
        description = "",
        position = 34,
        section = minigamesSection
    )
    default boolean ratPitsPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shadesOfMortton",
        name = "Shades of Mort'ton",
        description = "",
        position = 35,
        section = minigamesSection
    )
    default boolean shadesOfMortton()
    {
        return false;
    }

    @ConfigItem(
        keyName = "sorceressGarden",
        name = "Sorceress's Garden",
        description = "",
        position = 36,
        section = minigamesSection
    )
    default boolean sorceressGarden()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWars",
        name = "Soul Wars",
        description = "",
        position = 37,
        section = minigamesSection
    )
    default boolean soulWars()
    {
        return false;
    }

    @ConfigItem(
        keyName = "titheFarm",
        name = "Tithe Farm",
        description = "",
        position = 38,
        section = minigamesSection
    )
    default boolean titheFarm()
    {
        return false;
    }

    @ConfigItem(
        keyName = "troubleBrewing",
        name = "Trouble Brewing",
        description = "",
        position = 39,
        section = minigamesSection
    )
    default boolean troubleBrewing()
    {
        return false;
    }

    @ConfigItem(
        keyName = "tzhaarFightPit",
        name = "TzHaar Fight Pit",
        description = "",
        position = 40,
        section = minigamesSection
    )
    default boolean tzhaarFightPit()
    {
        return false;
    }

    @ConfigSection(
        name = "Ancient Spellbook",
        description = "",
        position = 41,
        closedByDefault = true
    )
    String ancientSection = "ancientSection";

    @ConfigItem(
        keyName = "ancientHomeTeleport",
        name = "Home Teleport",
        description = "",
        position = 42,
        section = ancientSection
    )
    default boolean ancientHomeTeleport()
    {
        return false;
    }


    @ConfigItem(
        keyName = "ancientPaddewwa",
        name = "Paddewwa Teleport",
        description = "",
        position = 44,
        section = ancientSection
    )
    default boolean ancientPaddewwa()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientSenntisten",
        name = "Senntisten Teleport",
        description = "",
        position = 45,
        section = ancientSection
    )
    default boolean ancientSenntisten()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientKharyrll",
        name = "Kharyrll Teleport",
        description = "",
        position = 46,
        section = ancientSection
    )
    default boolean ancientKharyrll()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientLassar",
        name = "Lassar Teleport",
        description = "",
        position = 47,
        section = ancientSection
    )
    default boolean ancientLassar()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientDareeyak",
        name = "Dareeyak Teleport",
        description = "",
        position = 48,
        section = ancientSection
    )
    default boolean ancientDareeyak()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientCarrallanger",
        name = "Carrallanger Teleport",
        description = "",
        position = 49,
        section = ancientSection
    )
    default boolean ancientCarrallanger()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientAnnakarl",
        name = "Annakarl Teleport",
        description = "",
        position = 50,
        section = ancientSection
    )
    default boolean ancientAnnakarl()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientGhorrock",
        name = "Ghorrock Teleport",
        description = "",
        position = 51,
        section = ancientSection
    )
    default boolean ancientGhorrock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ancientMinigameTeleport",
        name = "Minigame Teleport",
        description = "",
        position = 52,
        section = ancientSection
    )
    default boolean ancientMinigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Lunar Spellbook",
        description = "",
        position = 52,
        closedByDefault = true
    )
    String lunarSection = "lunarSection";

    @ConfigItem(
        keyName = "lunarHomeTeleport",
        name = "Home Teleport",
        description = "",
        position = 53,
        section = lunarSection
    )
    default boolean lunarHomeTeleport()
    {
        return false;
    }


    @ConfigItem(
        keyName = "lunarMoonclan",
        name = "Moonclan Teleport",
        description = "",
        position = 55,
        section = lunarSection
    )
    default boolean lunarMoonclan()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarOurania",
        name = "Ourania Teleport",
        description = "",
        position = 56,
        section = lunarSection
    )
    default boolean lunarOurania()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarWaterbirth",
        name = "Waterbirth Teleport",
        description = "",
        position = 57,
        section = lunarSection
    )
    default boolean lunarWaterbirth()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarBarbarian",
        name = "Barbarian Teleport",
        description = "",
        position = 58,
        section = lunarSection
    )
    default boolean lunarBarbarian()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarKhazard",
        name = "Khazard Teleport",
        description = "",
        position = 59,
        section = lunarSection
    )
    default boolean lunarKhazard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarFishingGuild",
        name = "Fishing Guild Teleport",
        description = "",
        position = 60,
        section = lunarSection
    )
    default boolean lunarFishingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarCatherby",
        name = "Catherby Teleport",
        description = "",
        position = 61,
        section = lunarSection
    )
    default boolean lunarCatherby()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarIcePlateau",
        name = "Ice Plateau Teleport",
        description = "",
        position = 62,
        section = lunarSection
    )
    default boolean lunarIcePlateau()
    {
        return false;
    }

    @ConfigItem(
        keyName = "lunarMinigameTeleport",
        name = "Minigame Teleport",
        description = "",
        position = 63,
        section = lunarSection
    )
    default boolean lunarMinigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Canoes",
        description = "",
        position = 63,
        closedByDefault = true
    )
    String canoeSection = "canoeSection";

    @ConfigItem(
        keyName = "canoeLumbridge",
        name = "Lumbridge",
        description = "",
        position = 64,
        section = canoeSection
    )
    default boolean canoeLumbridge()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeChampionsGuild",
        name = "Champions' Guild",
        description = "",
        position = 65,
        section = canoeSection
    )
    default boolean canoeChampionsGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeBarbarianVillage",
        name = "Barbarian Village",
        description = "",
        position = 66,
        section = canoeSection
    )
    default boolean canoeBarbarianVillage()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeEdgeville",
        name = "Edgeville",
        description = "",
        position = 67,
        section = canoeSection
    )
    default boolean canoeEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeFeroxEnclave",
        name = "Ferox Enclave",
        description = "",
        position = 68,
        section = canoeSection
    )
    default boolean canoeFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeWildernessPond",
        name = "Wilderness Pond",
        description = "",
        position = 69,
        section = canoeSection
    )
    default boolean canoeWildernessPond()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeCastleWars",
        name = "Castle Wars",
        description = "",
        position = 70,
        section = canoeSection
    )
    default boolean canoeCastleWars()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeTreeGnomeVillage",
        name = "Tree Gnome Village",
        description = "",
        position = 71,
        section = canoeSection
    )
    default boolean canoeTreeGnomeVillage()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeClocktower",
        name = "Clocktower",
        description = "",
        position = 72,
        section = canoeSection
    )
    default boolean canoeClocktower()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeChaosDruidTower",
        name = "Chaos Druid Tower",
        description = "",
        position = 73,
        section = canoeSection
    )
    default boolean canoeChaosDruidTower()
    {
        return false;
    }

    @ConfigItem(
        keyName = "canoeTreeGnomeStronghold",
        name = "Tree Gnome Stronghold",
        description = "",
        position = 74,
        section = canoeSection
    )
    default boolean canoeTreeGnomeStronghold()
    {
        return false;
    }

    @ConfigSection(
        name = "Ring of Dueling",
        description = "",
        position = 75,
        closedByDefault = true
    )
    String duelingSection = "duelingSection";

    @ConfigItem(
        keyName = "duelingEmirsArena",
        name = "Emir's Arena",
        description = "",
        position = 76,
        section = duelingSection
    )
    default boolean duelingEmirsArena()
    {
        return false;
    }

    @ConfigItem(
        keyName = "duelingCastleWars",
        name = "Castle Wars",
        description = "",
        position = 77,
        section = duelingSection
    )
    default boolean duelingCastleWars()
    {
        return false;
    }

    @ConfigItem(
        keyName = "duelingFeroxEnclave",
        name = "Ferox Enclave",
        description = "",
        position = 78,
        section = duelingSection
    )
    default boolean duelingFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "duelingFortisColosseum",
        name = "Fortis Colosseum",
        description = "",
        position = 79,
        section = duelingSection
    )
    default boolean duelingFortisColosseum()
    {
        return false;
    }

    @ConfigSection(
        name = "Games Necklace",
        description = "",
        position = 80,
        closedByDefault = true
    )
    String gamesNecklaceSection = "gamesNecklaceSection";

    @ConfigItem(
        keyName = "gamesBurthorpe",
        name = "Burthorpe",
        description = "",
        position = 81,
        section = gamesNecklaceSection
    )
    default boolean gamesBurthorpe()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gamesBarbarianOutpost",
        name = "Barbarian Outpost",
        description = "",
        position = 82,
        section = gamesNecklaceSection
    )
    default boolean gamesBarbarianOutpost()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gamesCorporealBeast",
        name = "Corporeal Beast",
        description = "",
        position = 83,
        section = gamesNecklaceSection
    )
    default boolean gamesCorporealBeast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gamesTearsOfGuthix",
        name = "Tears of Guthix",
        description = "",
        position = 84,
        section = gamesNecklaceSection
    )
    default boolean gamesTearsOfGuthix()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gamesWintertodtCamp",
        name = "Wintertodt Camp",
        description = "",
        position = 85,
        section = gamesNecklaceSection
    )
    default boolean gamesWintertodtCamp()
    {
        return false;
    }

    @ConfigSection(
        name = "Amulet of Glory",
        description = "",
        position = 86,
        closedByDefault = true
    )
    String glorySection = "glorySection";

    @ConfigItem(
        keyName = "gloryEdgeville",
        name = "Edgeville",
        description = "",
        position = 87,
        section = glorySection
    )
    default boolean gloryEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gloryKaramja",
        name = "Karamja",
        description = "",
        position = 88,
        section = glorySection
    )
    default boolean gloryKaramja()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gloryDraynorVillage",
        name = "Draynor Village",
        description = "",
        position = 89,
        section = glorySection
    )
    default boolean gloryDraynorVillage()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gloryAlKharid",
        name = "Al Kharid",
        description = "",
        position = 90,
        section = glorySection
    )
    default boolean gloryAlKharid()
    {
        return false;
    }

    @ConfigSection(
        name = "Ring of Wealth",
        description = "",
        position = 91,
        closedByDefault = true
    )
    String wealthSection = "wealthSection";

    @ConfigItem(
        keyName = "wealthMiscellania",
        name = "Miscellania",
        description = "",
        position = 92,
        section = wealthSection
    )
    default boolean wealthMiscellania()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wealthGrandExchange",
        name = "Grand Exchange",
        description = "",
        position = 93,
        section = wealthSection
    )
    default boolean wealthGrandExchange()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wealthFaladorPark",
        name = "Falador Park",
        description = "",
        position = 94,
        section = wealthSection
    )
    default boolean wealthFaladorPark()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wealthDondakan",
        name = "Dondakan",
        description = "",
        position = 95,
        section = wealthSection
    )
    default boolean wealthDondakan()
    {
        return false;
    }

    @ConfigSection(
        name = "Necklace of Passage",
        description = "",
        position = 96,
        closedByDefault = true
    )
    String passageSection = "passageSection";

    @ConfigItem(
        keyName = "passageWizardsTower",
        name = "Wizards' Tower",
        description = "",
        position = 97,
        section = passageSection
    )
    default boolean passageWizardsTower()
    {
        return false;
    }

    @ConfigItem(
        keyName = "passageTheOutpost",
        name = "The Outpost",
        description = "",
        position = 98,
        section = passageSection
    )
    default boolean passageTheOutpost()
    {
        return false;
    }

    @ConfigItem(
        keyName = "passageEaglesEyrie",
        name = "Eagles' Eyrie",
        description = "",
        position = 99,
        section = passageSection
    )
    default boolean passageEaglesEyrie()
    {
        return false;
    }

    @ConfigItem(
        keyName = "passageWyrmscraig",
        name = "Wyrmscraig",
        description = "",
        position = 100,
        section = passageSection
    )
    default boolean passageWyrmscraig()
    {
        return false;
    }

    @ConfigSection(
        name = "Combat Bracelet",
        description = "",
        position = 101,
        closedByDefault = true
    )
    String combatBraceletSection = "combatBraceletSection";

    @ConfigItem(
        keyName = "combatWarriorsGuild",
        name = "Warriors' Guild",
        description = "",
        position = 102,
        section = combatBraceletSection
    )
    default boolean combatWarriorsGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "combatChampionsGuild",
        name = "Champions' Guild",
        description = "",
        position = 103,
        section = combatBraceletSection
    )
    default boolean combatChampionsGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "combatMonastery",
        name = "Monastery",
        description = "",
        position = 104,
        section = combatBraceletSection
    )
    default boolean combatMonastery()
    {
        return false;
    }

    @ConfigItem(
        keyName = "combatRangingGuild",
        name = "Ranging Guild",
        description = "",
        position = 105,
        section = combatBraceletSection
    )
    default boolean combatRangingGuild()
    {
        return false;
    }

    @ConfigSection(
        name = "Skills Necklace",
        description = "",
        position = 106,
        closedByDefault = true
    )
    String skillsNecklaceSection = "skillsNecklaceSection";

    @ConfigItem(
        keyName = "skillsFishingGuild",
        name = "Fishing Guild",
        description = "",
        position = 107,
        section = skillsNecklaceSection
    )
    default boolean skillsFishingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "skillsMiningGuild",
        name = "Mining Guild",
        description = "",
        position = 108,
        section = skillsNecklaceSection
    )
    default boolean skillsMiningGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "skillsCraftingGuild",
        name = "Crafting Guild",
        description = "",
        position = 109,
        section = skillsNecklaceSection
    )
    default boolean skillsCraftingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "skillsCookingGuild",
        name = "Cooking Guild",
        description = "",
        position = 110,
        section = skillsNecklaceSection
    )
    default boolean skillsCookingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "skillsWoodcuttingGuild",
        name = "Woodcutting Guild",
        description = "",
        position = 111,
        section = skillsNecklaceSection
    )
    default boolean skillsWoodcuttingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "skillsFarmingGuild",
        name = "Farming Guild",
        description = "",
        position = 112,
        section = skillsNecklaceSection
    )
    default boolean skillsFarmingGuild()
    {
        return false;
    }

    @ConfigSection(
        name = "Slayer Ring",
        description = "",
        position = 113,
        closedByDefault = true
    )
    String slayerRingSection = "slayerRingSection";

    @ConfigItem(
        keyName = "slayerStrongholdSlayerCave",
        name = "Stronghold Slayer Cave",
        description = "Listed as Gnome Stronghold Caves.",
        position = 114,
        section = slayerRingSection
    )
    default boolean slayerStrongholdSlayerCave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "slayerSlayerTower",
        name = "Slayer Tower",
        description = "",
        position = 115,
        section = slayerRingSection
    )
    default boolean slayerSlayerTower()
    {
        return false;
    }

    @ConfigItem(
        keyName = "slayerFremennikSlayerDungeon",
        name = "Fremennik Slayer Dungeon",
        description = "Listed as Rellekka Caves.",
        position = 116,
        section = slayerRingSection
    )
    default boolean slayerFremennikSlayerDungeon()
    {
        return false;
    }

    @ConfigItem(
        keyName = "slayerTarnsLair",
        name = "Tarn's Lair",
        description = "Listed as Haunted Mine.",
        position = 117,
        section = slayerRingSection
    )
    default boolean slayerTarnsLair()
    {
        return false;
    }

    @ConfigItem(
        keyName = "slayerDarkBeasts",
        name = "Dark Beasts",
        description = "Listed as ME2 Caves.",
        position = 118,
        section = slayerRingSection
    )
    default boolean slayerDarkBeasts()
    {
        return false;
    }

    @ConfigItem(
        keyName = "slayerWyrmscraigCavern",
        name = "Wyrmscraig Cavern",
        description = "",
        position = 119,
        section = slayerRingSection
    )
    default boolean slayerWyrmscraigCavern()
    {
        return false;
    }

    @ConfigSection(
        name = "Digsite Pendant",
        description = "",
        position = 120,
        closedByDefault = true
    )
    String digsitePendantSection = "digsitePendantSection";

    @ConfigItem(
        keyName = "digsiteDigsite",
        name = "Digsite",
        description = "",
        position = 121,
        section = digsitePendantSection
    )
    default boolean digsiteDigsite()
    {
        return false;
    }

    @ConfigItem(
        keyName = "digsiteFossilIsland",
        name = "Fossil Island",
        description = "",
        position = 122,
        section = digsitePendantSection
    )
    default boolean digsiteFossilIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "digsiteLithkren",
        name = "Lithkren Dungeon",
        description = "",
        position = 123,
        section = digsitePendantSection
    )
    default boolean digsiteLithkren()
    {
        return false;
    }

    @ConfigSection(
        name = "Burning Amulet",
        description = "",
        position = 124,
        closedByDefault = true
    )
    String burningAmuletSection = "burningAmuletSection";

    @ConfigItem(
        keyName = "burningChaosTemple",
        name = "Chaos Temple",
        description = "",
        position = 125,
        section = burningAmuletSection
    )
    default boolean burningChaosTemple()
    {
        return false;
    }

    @ConfigItem(
        keyName = "burningBanditCamp",
        name = "Bandit Camp",
        description = "",
        position = 126,
        section = burningAmuletSection
    )
    default boolean burningBanditCamp()
    {
        return false;
    }

    @ConfigItem(
        keyName = "burningLavaMaze",
        name = "Lava Maze",
        description = "",
        position = 127,
        section = burningAmuletSection
    )
    default boolean burningLavaMaze()
    {
        return false;
    }

    @ConfigSection(
        name = "Soul Wars Portal and Edgeville Lever",
        description = "",
        position = 128,
        closedByDefault = true
    )
    String soulWarsPortalSection = "soulWarsPortalSection";

    @ConfigItem(
        keyName = "soulWarsPortalEdgeville",
        name = "Soul Wars to Edgeville",
        description = "",
        position = 133,
        section = soulWarsPortalSection
    )
    default boolean soulWarsPortalEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWarsPortalFeroxEnclave",
        name = "Soul Wars to Ferox Enclave",
        description = "",
        position = 134,
        section = soulWarsPortalSection
    )
    default boolean soulWarsPortalFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWarsEntryEdgeville",
        name = "Edgeville to Soul Wars",
        description = "",
        position = 131,
        section = soulWarsPortalSection
    )
    default boolean soulWarsEntryEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWarsEntryFeroxEnclave",
        name = "Ferox Enclave to Soul Wars",
        description = "",
        position = 132,
        section = soulWarsPortalSection
    )
    default boolean soulWarsEntryFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "edgevilleLeverToWilderness",
        name = "Edgeville Lever to Wilderness",
        description = "",
        position = 130,
        section = soulWarsPortalSection
    )
    default boolean edgevilleLeverToWilderness()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ardougneLeverToWilderness",
        name = "Ardougne Lever to Wilderness",
        description = "",
        position = 129,
        section = soulWarsPortalSection
    )
    default boolean ardougneLeverToWilderness()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wildernessLeverToEdgeville",
        name = "Wilderness Lever to Edgeville",
        description = "",
        position = 136,
        section = soulWarsPortalSection
    )
    default boolean wildernessLeverToEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wildernessLeverToArdougne",
        name = "Wilderness Lever to Ardougne",
        description = "Also Pull before the Wilderness Easy Diary.",
        position = 135,
        section = soulWarsPortalSection
    )
    default boolean wildernessLeverToArdougne()
    {
        return false;
    }

    @ConfigSection(
        name = "Spirit Trees",
        description = "",
        position = 137,
        closedByDefault = true
    )
    String spiritTreeSection = "spiritTreeSection";

    @ConfigItem(
        keyName = "spiritTreeGnomeVillage",
        name = "Tree Gnome Village",
        description = "",
        position = 138,
        section = spiritTreeSection
    )
    default boolean spiritTreeGnomeVillage()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeGnomeStronghold",
        name = "Gnome Stronghold",
        description = "",
        position = 139,
        section = spiritTreeSection
    )
    default boolean spiritTreeGnomeStronghold()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeBattlefieldOfKhazard",
        name = "Battlefield of Khazard",
        description = "",
        position = 140,
        section = spiritTreeSection
    )
    default boolean spiritTreeBattlefieldOfKhazard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeGrandExchange",
        name = "Grand Exchange",
        description = "",
        position = 141,
        section = spiritTreeSection
    )
    default boolean spiritTreeGrandExchange()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeFeldipHills",
        name = "Feldip Hills",
        description = "",
        position = 142,
        section = spiritTreeSection
    )
    default boolean spiritTreeFeldipHills()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreePrifddinas",
        name = "Prifddinas",
        description = "",
        position = 143,
        section = spiritTreeSection
    )
    default boolean spiritTreePrifddinas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreePortSarim",
        name = "Port Sarim",
        description = "",
        position = 144,
        section = spiritTreeSection
    )
    default boolean spiritTreePortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeEtceteria",
        name = "Etceteria",
        description = "",
        position = 145,
        section = spiritTreeSection
    )
    default boolean spiritTreeEtceteria()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeBrimhaven",
        name = "Brimhaven",
        description = "",
        position = 146,
        section = spiritTreeSection
    )
    default boolean spiritTreeBrimhaven()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeHosidius",
        name = "Hosidius",
        description = "",
        position = 147,
        section = spiritTreeSection
    )
    default boolean spiritTreeHosidius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeFarmingGuild",
        name = "Farming Guild",
        description = "",
        position = 148,
        section = spiritTreeSection
    )
    default boolean spiritTreeFarmingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeHouse",
        name = "Your House",
        description = "",
        position = 149,
        section = spiritTreeSection
    )
    default boolean spiritTreeHouse()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreePoisonWaste",
        name = "Poison Waste",
        description = "",
        position = 150,
        section = spiritTreeSection
    )
    default boolean spiritTreePoisonWaste()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeLagunaAurorae",
        name = "Laguna Aurorae",
        description = "",
        position = 151,
        section = spiritTreeSection
    )
    default boolean spiritTreeLagunaAurorae()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreePrevious",
        name = "Previous Destination",
        description = "",
        position = 152,
        section = spiritTreeSection
    )
    default boolean spiritTreePrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Gnome Gliders",
        description = "",
        position = 153,
        closedByDefault = true
    )
    String gnomeGliderSection = "gnomeGliderSection";

    @ConfigItem(
        keyName = "gnomeGliderGrandTree",
        name = "Grand Tree",
        description = "",
        position = 158,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderGrandTree()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderKaramja",
        name = "Karamja",
        description = "",
        position = 159,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderKaramja()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderAlKharid",
        name = "Al Kharid",
        description = "",
        position = 154,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderAlKharid()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderWhiteWolfMountain",
        name = "White Wolf Mountain",
        description = "",
        position = 160,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderWhiteWolfMountain()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderDigsite",
        name = "Digsite",
        description = "",
        position = 156,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderDigsite()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderFeldipHills",
        name = "Feldip Hills",
        description = "",
        position = 157,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderFeldipHills()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderApeAtoll",
        name = "Ape Atoll",
        description = "",
        position = 155,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderApeAtoll()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderPrevious",
        name = "Previous Destination",
        description = "",
        position = 161,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Quetzal Transport",
        description = "",
        position = 162,
        closedByDefault = true
    )
    String quetzalSection = "quetzalSection";

    @ConfigItem(
        keyName = "quetzalVarrockToCivitas",
        name = "Varrock to Civitas",
        description = "",
        position = 178,
        section = quetzalSection
    )
    default boolean quetzalVarrockToCivitas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCivitasToVarrock",
        name = "Civitas to Varrock",
        description = "",
        position = 167,
        section = quetzalSection
    )
    default boolean quetzalCivitasToVarrock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalPrevious",
        name = "Previous Destination",
        description = "",
        position = 179,
        section = quetzalSection
    )
    default boolean quetzalPrevious()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCivitas",
        name = "Civitas",
        description = "",
        position = 166,
        section = quetzalSection
    )
    default boolean quetzalCivitas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalTheTeomat",
        name = "The Teomat",
        description = "",
        position = 177,
        section = quetzalSection
    )
    default boolean quetzalTheTeomat()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalSunsetCoast",
        name = "Sunset Coast",
        description = "",
        position = 175,
        section = quetzalSection
    )
    default boolean quetzalSunsetCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalHunterGuild",
        name = "Hunter Guild",
        description = "Also the whistle's Signal while set to it.",
        position = 170,
        section = quetzalSection
    )
    default boolean quetzalHunterGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCamTorumEntrance",
        name = "Cam Torum Entrance",
        description = "",
        position = 165,
        section = quetzalSection
    )
    default boolean quetzalCamTorumEntrance()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalColossalWyrmRemains",
        name = "Colossal Wyrm Remains",
        description = "",
        position = 168,
        section = quetzalSection
    )
    default boolean quetzalColossalWyrmRemains()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalOuterFortis",
        name = "Outer Fortis",
        description = "",
        position = 172,
        section = quetzalSection
    )
    default boolean quetzalOuterFortis()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalFortisColosseum",
        name = "Fortis Colosseum",
        description = "",
        position = 169,
        section = quetzalSection
    )
    default boolean quetzalFortisColosseum()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalAldarin",
        name = "Aldarin",
        description = "",
        position = 163,
        section = quetzalSection
    )
    default boolean quetzalAldarin()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalQuetzacalliGorge",
        name = "Quetzacalli Gorge",
        description = "",
        position = 173,
        section = quetzalSection
    )
    default boolean quetzalQuetzacalliGorge()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalSalvagerOverlook",
        name = "Salvager Overlook",
        description = "",
        position = 174,
        section = quetzalSection
    )
    default boolean quetzalSalvagerOverlook()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalTalTeklan",
        name = "Tal Teklan",
        description = "",
        position = 176,
        section = quetzalSection
    )
    default boolean quetzalTalTeklan()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalAuburnvale",
        name = "Auburnvale",
        description = "",
        position = 164,
        section = quetzalSection
    )
    default boolean quetzalAuburnvale()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalKastori",
        name = "Kastori",
        description = "",
        position = 171,
        section = quetzalSection
    )
    default boolean quetzalKastori()
    {
        return false;
    }

    @ConfigSection(
        name = "Lovakengj Minecarts",
        description = "",
        position = 180,
        closedByDefault = true
    )
    String minecartSection = "minecartSection";

    @ConfigItem(
        keyName = "minecartArceuus",
        name = "Arceuus",
        description = "",
        position = 181,
        section = minecartSection
    )
    default boolean minecartArceuus()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartFarmingGuild",
        name = "Farming Guild",
        description = "",
        position = 182,
        section = minecartSection
    )
    default boolean minecartFarmingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartHosidiusSouth",
        name = "Hosidius South",
        description = "",
        position = 183,
        section = minecartSection
    )
    default boolean minecartHosidiusSouth()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartHosidiusWest",
        name = "Hosidius West",
        description = "",
        position = 184,
        section = minecartSection
    )
    default boolean minecartHosidiusWest()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartKingstown",
        name = "Kingstown",
        description = "",
        position = 185,
        section = minecartSection
    )
    default boolean minecartKingstown()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartKourendWoodland",
        name = "Kourend Woodland",
        description = "",
        position = 186,
        section = minecartSection
    )
    default boolean minecartKourendWoodland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartLovakengj",
        name = "Lovakengj",
        description = "",
        position = 187,
        section = minecartSection
    )
    default boolean minecartLovakengj()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartMountQuidamortem",
        name = "Mt. Quidamortem",
        description = "",
        position = 188,
        section = minecartSection
    )
    default boolean minecartMountQuidamortem()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartNorthernTundras",
        name = "Northern Tundras",
        description = "",
        position = 189,
        section = minecartSection
    )
    default boolean minecartNorthernTundras()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartPortPiscarilius",
        name = "Port Piscarilius",
        description = "",
        position = 190,
        section = minecartSection
    )
    default boolean minecartPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartShayzienEast",
        name = "Shayzien East",
        description = "",
        position = 191,
        section = minecartSection
    )
    default boolean minecartShayzienEast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartShayzienWest",
        name = "Shayzien West",
        description = "",
        position = 192,
        section = minecartSection
    )
    default boolean minecartShayzienWest()
    {
        return false;
    }

    @ConfigSection(
        name = "Charter Ships",
        description = "Each port also removes Charter-to that port.",
        position = 193,
        closedByDefault = true
    )
    String charterSection = "charterSection";

    @ConfigItem(
        keyName = "charterPortSarim",
        name = "Port Sarim",
        description = "",
        position = 208,
        section = charterSection
    )
    default boolean charterPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterBrimhaven",
        name = "Brimhaven",
        description = "",
        position = 195,
        section = charterSection
    )
    default boolean charterBrimhaven()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterCatherby",
        name = "Catherby",
        description = "",
        position = 196,
        section = charterSection
    )
    default boolean charterCatherby()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterMosLeHarmless",
        name = "Mos Le'Harmless",
        description = "",
        position = 202,
        section = charterSection
    )
    default boolean charterMosLeHarmless()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterMusaPoint",
        name = "Musa Point",
        description = "",
        position = 203,
        section = charterSection
    )
    default boolean charterMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortKhazard",
        name = "Port Khazard",
        description = "",
        position = 204,
        section = charterSection
    )
    default boolean charterPortKhazard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortPhasmatys",
        name = "Port Phasmatys",
        description = "",
        position = 205,
        section = charterSection
    )
    default boolean charterPortPhasmatys()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterKaramjaShipyard",
        name = "Karamja Shipyard",
        description = "",
        position = 200,
        section = charterSection
    )
    default boolean charterKaramjaShipyard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortTyras",
        name = "Port Tyras",
        description = "",
        position = 209,
        section = charterSection
    )
    default boolean charterPortTyras()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterCorsairCove",
        name = "Corsair Cove",
        description = "",
        position = 198,
        section = charterSection
    )
    default boolean charterCorsairCove()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPrifddinas",
        name = "Prifddinas",
        description = "",
        position = 210,
        section = charterSection
    )
    default boolean charterPrifddinas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortPiscarilius",
        name = "Port Piscarilius",
        description = "",
        position = 206,
        section = charterSection
    )
    default boolean charterPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterLandsEnd",
        name = "Land's End",
        description = "",
        position = 201,
        section = charterSection
    )
    default boolean charterLandsEnd()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterCivitasIllaFortis",
        name = "Civitas illa Fortis",
        description = "",
        position = 197,
        section = charterSection
    )
    default boolean charterCivitasIllaFortis()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterAldarin",
        name = "Aldarin",
        description = "",
        position = 194,
        section = charterSection
    )
    default boolean charterAldarin()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterSunsetCoast",
        name = "Sunset Coast",
        description = "",
        position = 212,
        section = charterSection
    )
    default boolean charterSunsetCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterThePandemonium",
        name = "The Pandemonium",
        description = "",
        position = 213,
        section = charterSection
    )
    default boolean charterThePandemonium()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterTheSummerShore",
        name = "The Summer Shore",
        description = "",
        position = 214,
        section = charterSection
    )
    default boolean charterTheSummerShore()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterRedRock",
        name = "Red Rock",
        description = "",
        position = 211,
        section = charterSection
    )
    default boolean charterRedRock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterDeepfinPoint",
        name = "Deepfin Point",
        description = "",
        position = 199,
        section = charterSection
    )
    default boolean charterDeepfinPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortRoberts",
        name = "Port Roberts",
        description = "",
        position = 207,
        section = charterSection
    )
    default boolean charterPortRoberts()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPrevious",
        name = "Previous Destination",
        description = "",
        position = 215,
        section = charterSection
    )
    default boolean charterPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Other Ships",
        description = "",
        position = 216,
        closedByDefault = true
    )
    String shipSection = "shipSection";

    @ConfigItem(
        keyName = "shipBarnabyArdougne",
        name = "Barnaby - Ardougne",
        description = "",
        position = 217,
        section = shipSection
    )
    default boolean shipBarnabyArdougne()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipBarnabyBrimhaven",
        name = "Barnaby - Brimhaven",
        description = "",
        position = 218,
        section = shipSection
    )
    default boolean shipBarnabyBrimhaven()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipBarnabyRimmington",
        name = "Barnaby - Rimmington",
        description = "",
        position = 219,
        section = shipSection
    )
    default boolean shipBarnabyRimmington()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimVoidKnightsOutpost",
        name = "Port Sarim - Void Knights",
        description = "",
        position = 236,
        section = shipSection
    )
    default boolean shipPortSarimVoidKnightsOutpost()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipVoidKnightsOutpostPortSarim",
        name = "Void Knights - Port Sarim",
        description = "",
        position = 244,
        section = shipSection
    )
    default boolean shipVoidKnightsOutpostPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimMusaPoint",
        name = "Port Sarim - Musa Point",
        description = "Also the crew's Talk-to before the Pandemonium quest.",
        position = 233,
        section = shipSection
    )
    default boolean shipPortSarimMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMusaPointPortSarim",
        name = "Musa Point - Port Sarim",
        description = "Also the customs officer's Talk-to before the Pandemonium quest.",
        position = 225,
        section = shipSection
    )
    default boolean shipMusaPointPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimPandemonium",
        name = "Port Sarim - The Pandemonium",
        description = "",
        position = 235,
        section = shipSection
    )
    default boolean shipPortSarimPandemonium()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPandemoniumPortSarim",
        name = "The Pandemonium - Port Sarim",
        description = "",
        position = 243,
        section = shipSection
    )
    default boolean shipPandemoniumPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMusaPointPandemonium",
        name = "Musa Point - The Pandemonium",
        description = "",
        position = 226,
        section = shipSection
    )
    default boolean shipMusaPointPandemonium()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPandemoniumMusaPoint",
        name = "The Pandemonium - Musa Point",
        description = "",
        position = 242,
        section = shipSection
    )
    default boolean shipPandemoniumMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimEntrana",
        name = "Port Sarim - Entrana",
        description = "Also the monk's Talk-to.",
        position = 231,
        section = shipSection
    )
    default boolean shipPortSarimEntrana()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipEntranaPortSarim",
        name = "Entrana - Port Sarim",
        description = "Also the monk's Talk-to.",
        position = 220,
        section = shipSection
    )
    default boolean shipEntranaPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimPortPiscarilius",
        name = "Port Sarim - Port Piscarilius",
        description = "",
        position = 234,
        section = shipSection
    )
    default boolean shipPortSarimPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortPiscariliusPortSarim",
        name = "Port Piscarilius - Port Sarim",
        description = "",
        position = 230,
        section = shipSection
    )
    default boolean shipPortPiscariliusPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimLandsEnd",
        name = "Port Sarim - Land's End",
        description = "",
        position = 232,
        section = shipSection
    )
    default boolean shipPortSarimLandsEnd()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipLandsEndPortSarim",
        name = "Land's End - Port Sarim",
        description = "",
        position = 223,
        section = shipSection
    )
    default boolean shipLandsEndPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortPiscariliusLandsEnd",
        name = "Port Piscarilius - Land's End",
        description = "",
        position = 229,
        section = shipSection
    )
    default boolean shipPortPiscariliusLandsEnd()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipLandsEndPortPiscarilius",
        name = "Land's End - Port Piscarilius",
        description = "",
        position = 222,
        section = shipSection
    )
    default boolean shipLandsEndPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaWaterbirthIsland",
        name = "Rellekka - Waterbirth",
        description = "Also Jarvald's Talk-to in Rellekka.",
        position = 241,
        section = shipSection
    )
    default boolean shipRellekkaWaterbirthIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipWaterbirthIslandRellekka",
        name = "Waterbirth - Rellekka",
        description = "",
        position = 245,
        section = shipSection
    )
    default boolean shipWaterbirthIslandRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaPiratesCove",
        name = "Rellekka - Pirates' Cove",
        description = "Also Lokar's Talk-to in Rellekka.",
        position = 240,
        section = shipSection
    )
    default boolean shipRellekkaPiratesCove()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPiratesCoveRellekka",
        name = "Pirates' Cove - Rellekka",
        description = "",
        position = 228,
        section = shipSection
    )
    default boolean shipPiratesCoveRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaJatizso",
        name = "Rellekka - Jatizso",
        description = "",
        position = 237,
        section = shipSection
    )
    default boolean shipRellekkaJatizso()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipJatizsoRellekka",
        name = "Jatizso - Rellekka",
        description = "",
        position = 221,
        section = shipSection
    )
    default boolean shipJatizsoRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaNeitiznot",
        name = "Rellekka - Neitiznot",
        description = "",
        position = 239,
        section = shipSection
    )
    default boolean shipRellekkaNeitiznot()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipNeitiznotRellekka",
        name = "Neitiznot - Rellekka",
        description = "",
        position = 227,
        section = shipSection
    )
    default boolean shipNeitiznotRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaMiscellania",
        name = "Rellekka - Miscellania",
        description = "Also the sailor's Talk-to.",
        position = 238,
        section = shipSection
    )
    default boolean shipRellekkaMiscellania()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMiscellaniaRellekka",
        name = "Miscellania - Rellekka",
        description = "Also the sailor's Talk-to.",
        position = 224,
        section = shipSection
    )
    default boolean shipMiscellaniaRellekka()
    {
        return false;
    }

    @ConfigSection(
        name = "Boats",
        description = "",
        position = 246,
        closedByDefault = true
    )
    String boatSection = "boatSection";

    @ConfigItem(
        keyName = "boatBoatyMolchIsland",
        name = "Boaty - Molch Island",
        description = "",
        position = 258,
        section = boatSection
    )
    default boolean boatBoatyMolchIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyMolch",
        name = "Boaty - Molch",
        description = "",
        position = 257,
        section = boatSection
    )
    default boolean boatBoatyMolch()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyBattlefront",
        name = "Boaty - Battlefront",
        description = "",
        position = 256,
        section = boatSection
    )
    default boolean boatBoatyBattlefront()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyShayzien",
        name = "Boaty - Shayzien",
        description = "",
        position = 259,
        section = boatSection
    )
    default boolean boatBoatyShayzien()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryIceberg",
        name = "Larry - Iceberg",
        description = "",
        position = 263,
        section = boatSection
    )
    default boolean boatLarryIceberg()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryWeiss",
        name = "Larry - Weiss",
        description = "",
        position = 265,
        section = boatSection
    )
    default boolean boatLarryWeiss()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryRellekka",
        name = "Larry - Rellekka",
        description = "",
        position = 264,
        section = boatSection
    )
    default boolean boatLarryRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaBurghDeRott",
        name = "Morytania - Burgh de Rott",
        description = "",
        position = 266,
        section = boatSection
    )
    default boolean boatMorytaniaBurghDeRott()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaMeiyerditch",
        name = "Morytania - Meiyerditch",
        description = "",
        position = 268,
        section = boatSection
    )
    default boolean boatMorytaniaMeiyerditch()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaIcyeneGraveyard",
        name = "Morytania - Icyene Graveyard",
        description = "",
        position = 267,
        section = boatSection
    )
    default boolean boatMorytaniaIcyeneGraveyard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaSlepe",
        name = "Morytania - Slepe",
        description = "",
        position = 269,
        section = boatSection
    )
    default boolean boatMorytaniaSlepe()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaTalTeklan",
        name = "Achilka - Tal Teklan",
        description = "",
        position = 255,
        section = boatSection
    )
    default boolean boatAchilkaTalTeklan()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaGloomthornTrail",
        name = "Achilka - Gloomthorn Trail",
        description = "",
        position = 253,
        section = boatSection
    )
    default boolean boatAchilkaGloomthornTrail()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaKastori",
        name = "Achilka - Kastori",
        description = "",
        position = 254,
        section = boatSection
    )
    default boolean boatAchilkaKastori()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchSummerShore",
        name = "Great Conch - Summer Shore",
        description = "",
        position = 262,
        section = boatSection
    )
    default boolean boatConchSummerShore()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchNorthCoast",
        name = "Great Conch - North Coast",
        description = "",
        position = 261,
        section = boatSection
    )
    default boolean boatConchNorthCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchEastCoast",
        name = "Great Conch - East Coast",
        description = "",
        position = 260,
        section = boatSection
    )
    default boolean boatConchEastCoast()
    {
        return false;
    }

    @ConfigSection(
        name = "Fossil Island",
        description = "",
        position = 270,
        closedByDefault = true
    )
    String fossilIslandSection = "fossilIslandSection";

    @ConfigItem(
        keyName = "fossilIslandMuseumCamp",
        name = "Museum Camp",
        description = "",
        position = 275,
        section = fossilIslandSection
    )
    default boolean fossilIslandMuseumCamp()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fossilIslandNorth",
        name = "North",
        description = "",
        position = 276,
        section = fossilIslandSection
    )
    default boolean fossilIslandNorth()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fossilIslandBankIsland",
        name = "Bank Island",
        description = "",
        position = 271,
        section = fossilIslandSection
    )
    default boolean fossilIslandBankIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fossilIslandDigsite",
        name = "Digsite",
        description = "",
        position = 272,
        section = fossilIslandSection
    )
    default boolean fossilIslandDigsite()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fossilIslandLithkren",
        name = "Lithkren",
        description = "",
        position = 274,
        section = fossilIslandSection
    )
    default boolean fossilIslandLithkren()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fossilIslandFossilIsland",
        name = "Fossil Island",
        description = "",
        position = 273,
        section = fossilIslandSection
    )
    default boolean fossilIslandFossilIsland()
    {
        return false;
    }

    @ConfigSection(
        name = "Other",
        description = "",
        position = 360,
        closedByDefault = true
    )
    String otherSection = "otherSection";

    @ConfigItem(
        keyName = "mountainGuideShayzienOutpost",
        name = "M. Guide - Shayzien Outpost",
        description = "",
        position = 364,
        section = otherSection
    )
    default boolean mountainGuideShayzienOutpost()
    {
        return false;
    }

    @ConfigItem(
        keyName = "mountainGuideMountQuidamortem",
        name = "M. Guide - Mt. Quidamortem",
        description = "",
        position = 361,
        section = otherSection
    )
    default boolean mountainGuideMountQuidamortem()
    {
        return false;
    }

    @ConfigItem(
        keyName = "mountainGuideSouthOfQuidamortem",
        name = "M. Guide - South of Quidamortem",
        description = "",
        position = 365,
        section = otherSection
    )
    default boolean mountainGuideSouthOfQuidamortem()
    {
        return false;
    }

    @ConfigItem(
        keyName = "mountainGuideQuetzacalliGorge",
        name = "M. Guide - Quetzacalli Gorge",
        description = "",
        position = 363,
        section = otherSection
    )
    default boolean mountainGuideQuetzacalliGorge()
    {
        return false;
    }

    @ConfigItem(
        keyName = "mountainGuideNemusRetreat",
        name = "M. Guide - Nemus Retreat",
        description = "",
        position = 362,
        section = otherSection
    )
    default boolean mountainGuideNemusRetreat()
    {
        return false;
    }

    @ConfigSection(
        name = "Fairy Rings",
        description = "",
        position = 290,
        closedByDefault = true
    )
    String fairyRingSection = "fairyRingSection";

    @ConfigItem(
        keyName = "fairyRingAIP",
        name = "AIP",
        description = "",
        position = 291,
        section = fairyRingSection
    )
    default boolean fairyRingAIP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAIQ",
        name = "AIQ (Mudskipper Point)",
        description = "",
        position = 292,
        section = fairyRingSection
    )
    default boolean fairyRingAIQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAIR",
        name = "AIR (Ardougne Island)",
        description = "",
        position = 293,
        section = fairyRingSection
    )
    default boolean fairyRingAIR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAIS",
        name = "AIS (Auburn Valley)",
        description = "",
        position = 294,
        section = fairyRingSection
    )
    default boolean fairyRingAIS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAJP",
        name = "AJP (Avium Savannah)",
        description = "",
        position = 295,
        section = fairyRingSection
    )
    default boolean fairyRingAJP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAJQ",
        name = "AJQ (Dorgesh-Kaan Cave)",
        description = "",
        position = 296,
        section = fairyRingSection
    )
    default boolean fairyRingAJQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAJR",
        name = "AJR (Slayer Cave)",
        description = "",
        position = 297,
        section = fairyRingSection
    )
    default boolean fairyRingAJR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAJS",
        name = "AJS (Penguins)",
        description = "",
        position = 298,
        section = fairyRingSection
    )
    default boolean fairyRingAJS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAKP",
        name = "AKP (Necropolis)",
        description = "",
        position = 299,
        section = fairyRingSection
    )
    default boolean fairyRingAKP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAKQ",
        name = "AKQ (Piscatoris)",
        description = "",
        position = 300,
        section = fairyRingSection
    )
    default boolean fairyRingAKQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAKR",
        name = "AKR (Hosidius Vinery)",
        description = "",
        position = 301,
        section = fairyRingSection
    )
    default boolean fairyRingAKR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingAKS",
        name = "AKS (Feldip Hills)",
        description = "",
        position = 302,
        section = fairyRingSection
    )
    default boolean fairyRingAKS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingALP",
        name = "ALP (Lighthouse)",
        description = "",
        position = 303,
        section = fairyRingSection
    )
    default boolean fairyRingALP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingALQ",
        name = "ALQ (Haunted Woods)",
        description = "",
        position = 304,
        section = fairyRingSection
    )
    default boolean fairyRingALQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingALR",
        name = "ALR (Abyssal Area)",
        description = "",
        position = 305,
        section = fairyRingSection
    )
    default boolean fairyRingALR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingALS",
        name = "ALS (McGrubor's Wood)",
        description = "",
        position = 306,
        section = fairyRingSection
    )
    default boolean fairyRingALS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBIP",
        name = "BIP (Mort Myre Island)",
        description = "",
        position = 307,
        section = fairyRingSection
    )
    default boolean fairyRingBIP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBIQ",
        name = "BIQ (Kalphite Hive)",
        description = "",
        position = 308,
        section = fairyRingSection
    )
    default boolean fairyRingBIQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBIR",
        name = "BIR",
        description = "",
        position = 309,
        section = fairyRingSection
    )
    default boolean fairyRingBIR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBIS",
        name = "BIS (Ardougne Zoo)",
        description = "",
        position = 310,
        section = fairyRingSection
    )
    default boolean fairyRingBIS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBJP",
        name = "BJP (Isle of Souls)",
        description = "",
        position = 311,
        section = fairyRingSection
    )
    default boolean fairyRingBJP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBJQ",
        name = "BJQ",
        description = "",
        position = 312,
        section = fairyRingSection
    )
    default boolean fairyRingBJQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBJR",
        name = "BJR (Fisher King)",
        description = "",
        position = 313,
        section = fairyRingSection
    )
    default boolean fairyRingBJR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBJS",
        name = "BJS (Zul-Andra)",
        description = "",
        position = 314,
        section = fairyRingSection
    )
    default boolean fairyRingBJS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBKP",
        name = "BKP (Castle Wars)",
        description = "",
        position = 315,
        section = fairyRingSection
    )
    default boolean fairyRingBKP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBKQ",
        name = "BKQ (Enchanted Valley)",
        description = "",
        position = 316,
        section = fairyRingSection
    )
    default boolean fairyRingBKQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBKR",
        name = "BKR (Mort Myre)",
        description = "",
        position = 317,
        section = fairyRingSection
    )
    default boolean fairyRingBKR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBKS",
        name = "BKS (Zanaris)",
        description = "",
        position = 318,
        section = fairyRingSection
    )
    default boolean fairyRingBKS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBLP",
        name = "BLP (TzHaar)",
        description = "",
        position = 319,
        section = fairyRingSection
    )
    default boolean fairyRingBLP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBLQ",
        name = "BLQ (Yu'biusk)",
        description = "",
        position = 320,
        section = fairyRingSection
    )
    default boolean fairyRingBLQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBLR",
        name = "BLR (Legends' Guild)",
        description = "",
        position = 321,
        section = fairyRingSection
    )
    default boolean fairyRingBLR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingBLS",
        name = "BLS (South of Quidamortem)",
        description = "",
        position = 322,
        section = fairyRingSection
    )
    default boolean fairyRingBLS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCIP",
        name = "CIP (Miscellania)",
        description = "",
        position = 323,
        section = fairyRingSection
    )
    default boolean fairyRingCIP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCIQ",
        name = "CIQ (Yanille)",
        description = "",
        position = 324,
        section = fairyRingSection
    )
    default boolean fairyRingCIQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCIR",
        name = "CIR (Farming Guild)",
        description = "",
        position = 325,
        section = fairyRingSection
    )
    default boolean fairyRingCIR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCIS",
        name = "CIS (Arceuus Library)",
        description = "",
        position = 326,
        section = fairyRingSection
    )
    default boolean fairyRingCIS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCJP",
        name = "CJP",
        description = "",
        position = 327,
        section = fairyRingSection
    )
    default boolean fairyRingCJP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCJQ",
        name = "CJQ (Great Conch)",
        description = "",
        position = 328,
        section = fairyRingSection
    )
    default boolean fairyRingCJQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCJR",
        name = "CJR (Sinclair Mansion)",
        description = "",
        position = 329,
        section = fairyRingSection
    )
    default boolean fairyRingCJR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCJS",
        name = "CJS",
        description = "",
        position = 330,
        section = fairyRingSection
    )
    default boolean fairyRingCJS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCKP",
        name = "CKP (Cosmic Plane)",
        description = "",
        position = 331,
        section = fairyRingSection
    )
    default boolean fairyRingCKP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCKQ",
        name = "CKQ (Aldarin)",
        description = "",
        position = 332,
        section = fairyRingSection
    )
    default boolean fairyRingCKQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCKR",
        name = "CKR (Tai Bwo Wannai)",
        description = "",
        position = 333,
        section = fairyRingSection
    )
    default boolean fairyRingCKR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCKS",
        name = "CKS (Canifis)",
        description = "",
        position = 334,
        section = fairyRingSection
    )
    default boolean fairyRingCKS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCLP",
        name = "CLP (Draynor Island)",
        description = "",
        position = 335,
        section = fairyRingSection
    )
    default boolean fairyRingCLP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCLQ",
        name = "CLQ",
        description = "",
        position = 336,
        section = fairyRingSection
    )
    default boolean fairyRingCLQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCLR",
        name = "CLR (Ape Atoll)",
        description = "",
        position = 337,
        section = fairyRingSection
    )
    default boolean fairyRingCLR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingCLS",
        name = "CLS (Hazelmere)",
        description = "",
        position = 338,
        section = fairyRingSection
    )
    default boolean fairyRingCLS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDIP",
        name = "DIP (Abyssal Nexus)",
        description = "",
        position = 339,
        section = fairyRingSection
    )
    default boolean fairyRingDIP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDIQ",
        name = "DIQ (Your House)",
        description = "",
        position = 340,
        section = fairyRingSection
    )
    default boolean fairyRingDIQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDIR",
        name = "DIR (Gorak's Plane)",
        description = "",
        position = 341,
        section = fairyRingSection
    )
    default boolean fairyRingDIR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDIS",
        name = "DIS (Wizards' Tower)",
        description = "",
        position = 342,
        section = fairyRingSection
    )
    default boolean fairyRingDIS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDJP",
        name = "DJP (Tower of Life)",
        description = "",
        position = 343,
        section = fairyRingSection
    )
    default boolean fairyRingDJP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDJQ",
        name = "DJQ",
        description = "",
        position = 344,
        section = fairyRingSection
    )
    default boolean fairyRingDJQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDJR",
        name = "DJR (Chasm of Fire)",
        description = "",
        position = 345,
        section = fairyRingSection
    )
    default boolean fairyRingDJR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDJS",
        name = "DJS",
        description = "",
        position = 346,
        section = fairyRingSection
    )
    default boolean fairyRingDJS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDKP",
        name = "DKP (Musa Point)",
        description = "",
        position = 347,
        section = fairyRingSection
    )
    default boolean fairyRingDKP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDKQ",
        name = "DKQ",
        description = "",
        position = 348,
        section = fairyRingSection
    )
    default boolean fairyRingDKQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDKR",
        name = "DKR (Edgeville)",
        description = "",
        position = 349,
        section = fairyRingSection
    )
    default boolean fairyRingDKR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDKS",
        name = "DKS (Polar Hunter)",
        description = "",
        position = 350,
        section = fairyRingSection
    )
    default boolean fairyRingDKS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDLP",
        name = "DLP (Grimstone Dungeon)",
        description = "",
        position = 351,
        section = fairyRingSection
    )
    default boolean fairyRingDLP()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDLQ",
        name = "DLQ (Nardah)",
        description = "",
        position = 352,
        section = fairyRingSection
    )
    default boolean fairyRingDLQ()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDLR",
        name = "DLR (Poison Waste)",
        description = "",
        position = 353,
        section = fairyRingSection
    )
    default boolean fairyRingDLR()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingDLS",
        name = "DLS (Myreque Hideout)",
        description = "",
        position = 354,
        section = fairyRingSection
    )
    default boolean fairyRingDLS()
    {
        return false;
    }

    @ConfigItem(
        keyName = "fairyRingPrevious",
        name = "Previous Destination",
        description = "",
        position = 290,
        section = fairyRingSection
    )
    default boolean fairyRingPrevious()
    {
        return false;
    }
}
