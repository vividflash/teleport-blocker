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
        position = 10
    )
    default CheckedMeans checkedMeans()
    {
        return CheckedMeans.ALLOW;
    }

    @ConfigSection(
        name = "Teleports",
        description = "",
        position = 20,
        closedByDefault = true
    )
    String teleportsSection = "teleportsSection";

    @ConfigItem(
        keyName = "homeTeleport",
        name = "Home Teleport",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
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
        position = 130,
        section = teleportsSection
    )
    default boolean minigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Minigames",
        description = "",
        position = 30,
        closedByDefault = true
    )
    String minigamesSection = "minigamesSection";

    @ConfigItem(
        keyName = "barbarianAssault",
        name = "Barbarian Assault",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
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
        position = 130,
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
        position = 140,
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
        position = 150,
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
        position = 160,
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
        position = 170,
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
        position = 180,
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
        position = 190,
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
        position = 200,
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
        position = 210,
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
        position = 220,
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
        position = 230,
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
        position = 240,
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
        position = 250,
        section = minigamesSection
    )
    default boolean tzhaarFightPit()
    {
        return false;
    }

    @ConfigSection(
        name = "Ancient Spellbook",
        description = "",
        position = 40,
        closedByDefault = true
    )
    String ancientSection = "ancientSection";

    @ConfigItem(
        keyName = "ancientHomeTeleport",
        name = "Home Teleport",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
        section = ancientSection
    )
    default boolean ancientMinigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Lunar Spellbook",
        description = "",
        position = 50,
        closedByDefault = true
    )
    String lunarSection = "lunarSection";

    @ConfigItem(
        keyName = "lunarHomeTeleport",
        name = "Home Teleport",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
        section = lunarSection
    )
    default boolean lunarMinigameTeleport()
    {
        return false;
    }

    @ConfigSection(
        name = "Canoes",
        description = "",
        position = 60,
        closedByDefault = true
    )
    String canoeSection = "canoeSection";

    @ConfigItem(
        keyName = "canoeLumbridge",
        name = "Lumbridge",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
        section = canoeSection
    )
    default boolean canoeTreeGnomeStronghold()
    {
        return false;
    }

    @ConfigSection(
        name = "Ring of Dueling",
        description = "",
        position = 70,
        closedByDefault = true
    )
    String duelingSection = "duelingSection";

    @ConfigItem(
        keyName = "duelingEmirsArena",
        name = "Emir's Arena",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
        section = gamesNecklaceSection
    )
    default boolean gamesWintertodtCamp()
    {
        return false;
    }

    @ConfigSection(
        name = "Amulet of Glory",
        description = "",
        position = 90,
        closedByDefault = true
    )
    String glorySection = "glorySection";

    @ConfigItem(
        keyName = "gloryEdgeville",
        name = "Edgeville",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
        section = glorySection
    )
    default boolean gloryAlKharid()
    {
        return false;
    }

    @ConfigSection(
        name = "Ring of Wealth",
        description = "",
        position = 100,
        closedByDefault = true
    )
    String wealthSection = "wealthSection";

    @ConfigItem(
        keyName = "wealthMiscellania",
        name = "Miscellania",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
        section = wealthSection
    )
    default boolean wealthDondakan()
    {
        return false;
    }

    @ConfigSection(
        name = "Necklace of Passage",
        description = "",
        position = 110,
        closedByDefault = true
    )
    String passageSection = "passageSection";

    @ConfigItem(
        keyName = "passageWizardsTower",
        name = "Wizards' Tower",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
        section = passageSection
    )
    default boolean passageWyrmscraig()
    {
        return false;
    }

    @ConfigSection(
        name = "Combat Bracelet",
        description = "",
        position = 120,
        closedByDefault = true
    )
    String combatBraceletSection = "combatBraceletSection";

    @ConfigItem(
        keyName = "combatWarriorsGuild",
        name = "Warriors' Guild",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
        section = combatBraceletSection
    )
    default boolean combatRangingGuild()
    {
        return false;
    }

    @ConfigSection(
        name = "Skills Necklace",
        description = "",
        position = 130,
        closedByDefault = true
    )
    String skillsNecklaceSection = "skillsNecklaceSection";

    @ConfigItem(
        keyName = "skillsFishingGuild",
        name = "Fishing Guild",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
        section = skillsNecklaceSection
    )
    default boolean skillsFarmingGuild()
    {
        return false;
    }

    @ConfigSection(
        name = "Slayer Ring",
        description = "",
        position = 140,
        closedByDefault = true
    )
    String slayerRingSection = "slayerRingSection";

    @ConfigItem(
        keyName = "slayerStrongholdSlayerCave",
        name = "Stronghold Slayer Cave",
        description = "Listed as Gnome Stronghold Caves.",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
        section = slayerRingSection
    )
    default boolean slayerWyrmscraigCavern()
    {
        return false;
    }

    @ConfigSection(
        name = "Digsite Pendant",
        description = "",
        position = 150,
        closedByDefault = true
    )
    String digsitePendantSection = "digsitePendantSection";

    @ConfigItem(
        keyName = "digsiteDigsite",
        name = "Digsite",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
        section = digsitePendantSection
    )
    default boolean digsiteLithkren()
    {
        return false;
    }

    @ConfigSection(
        name = "Burning Amulet",
        description = "",
        position = 160,
        closedByDefault = true
    )
    String burningAmuletSection = "burningAmuletSection";

    @ConfigItem(
        keyName = "burningChaosTemple",
        name = "Chaos Temple",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
        section = burningAmuletSection
    )
    default boolean burningLavaMaze()
    {
        return false;
    }

    @ConfigSection(
        name = "Soul Wars Portal and Edgeville Lever",
        description = "",
        position = 170,
        closedByDefault = true
    )
    String soulWarsPortalSection = "soulWarsPortalSection";

    @ConfigItem(
        keyName = "soulWarsPortalEdgeville",
        name = "Soul Wars to Edgeville",
        description = "",
        position = 50,
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
        position = 60,
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
        position = 30,
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
        position = 40,
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
        position = 20,
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
        position = 10,
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
        position = 80,
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
        position = 70,
        section = soulWarsPortalSection
    )
    default boolean wildernessLeverToArdougne()
    {
        return false;
    }

    @ConfigSection(
        name = "Spirit Trees",
        description = "",
        position = 180,
        closedByDefault = true
    )
    String spiritTreeSection = "spiritTreeSection";

    @ConfigItem(
        keyName = "spiritTreeGnomeVillage",
        name = "Tree Gnome Village",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
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
        position = 130,
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
        position = 140,
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
        position = 150,
        section = spiritTreeSection
    )
    default boolean spiritTreePrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Gnome Gliders",
        description = "",
        position = 190,
        closedByDefault = true
    )
    String gnomeGliderSection = "gnomeGliderSection";

    @ConfigItem(
        keyName = "gnomeGliderGrandTree",
        name = "Grand Tree",
        description = "",
        position = 50,
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
        position = 60,
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
        position = 10,
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
        position = 70,
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
        position = 30,
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
        position = 40,
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
        position = 20,
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
        position = 80,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Quetzal Transport",
        description = "",
        position = 200,
        closedByDefault = true
    )
    String quetzalSection = "quetzalSection";

    @ConfigItem(
        keyName = "quetzalVarrockToCivitas",
        name = "Varrock to Civitas",
        description = "",
        position = 160,
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
        position = 50,
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
        position = 170,
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
        position = 40,
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
        position = 150,
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
        position = 130,
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
        position = 80,
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
        position = 30,
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
        position = 60,
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
        position = 100,
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
        position = 70,
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
        position = 10,
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
        position = 110,
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
        position = 120,
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
        position = 140,
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
        position = 20,
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
        position = 90,
        section = quetzalSection
    )
    default boolean quetzalKastori()
    {
        return false;
    }

    @ConfigSection(
        name = "Lovakengj Minecarts",
        description = "",
        position = 210,
        closedByDefault = true
    )
    String minecartSection = "minecartSection";

    @ConfigItem(
        keyName = "minecartArceuus",
        name = "Arceuus",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
        section = minecartSection
    )
    default boolean minecartShayzienWest()
    {
        return false;
    }

    @ConfigSection(
        name = "Charter Ships",
        description = "Each port also removes Charter-to that port.",
        position = 220,
        closedByDefault = true
    )
    String charterSection = "charterSection";

    @ConfigItem(
        keyName = "charterPortSarim",
        name = "Port Sarim",
        description = "",
        position = 150,
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
        position = 20,
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
        position = 30,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
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
        position = 70,
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
        position = 160,
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
        position = 50,
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
        position = 170,
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
        position = 130,
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
        position = 80,
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
        position = 40,
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
        position = 10,
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
        position = 190,
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
        position = 200,
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
        position = 210,
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
        position = 180,
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
        position = 60,
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
        position = 140,
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
        position = 220,
        section = charterSection
    )
    default boolean charterPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Other Ships",
        description = "",
        position = 230,
        closedByDefault = true
    )
    String shipSection = "shipSection";

    @ConfigItem(
        keyName = "shipBarnabyArdougne",
        name = "Barnaby - Ardougne",
        description = "",
        position = 10,
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
        position = 20,
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
        position = 30,
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
        position = 200,
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
        position = 280,
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
        position = 170,
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
        position = 90,
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
        position = 190,
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
        position = 270,
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
        position = 100,
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
        position = 260,
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
        position = 150,
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
        position = 40,
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
        position = 180,
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
        position = 140,
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
        position = 160,
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
        position = 70,
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
        position = 130,
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
        position = 60,
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
        position = 250,
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
        position = 290,
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
        position = 120,
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
        position = 210,
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
        position = 50,
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
        position = 230,
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
        position = 110,
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
        position = 220,
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
        position = 80,
        section = shipSection
    )
    default boolean shipMiscellaniaRellekka()
    {
        return false;
    }

    @ConfigSection(
        name = "Boats",
        description = "",
        position = 240,
        closedByDefault = true
    )
    String boatSection = "boatSection";

    @ConfigItem(
        keyName = "boatBoatyMolchIsland",
        name = "Boaty - Molch Island",
        description = "",
        position = 60,
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
        position = 50,
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
        position = 40,
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
        position = 70,
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
        position = 110,
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
        position = 130,
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
        position = 120,
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
        position = 140,
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
        position = 160,
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
        position = 150,
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
        position = 170,
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
        position = 30,
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
        position = 10,
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
        position = 20,
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
        position = 100,
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
        position = 90,
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
        position = 80,
        section = boatSection
    )
    default boolean boatConchEastCoast()
    {
        return false;
    }

    @ConfigSection(
        name = "Fossil Island",
        description = "",
        position = 250,
        closedByDefault = true
    )
    String fossilIslandSection = "fossilIslandSection";

    @ConfigItem(
        keyName = "fossilIslandMuseumCamp",
        name = "Museum Camp",
        description = "",
        position = 50,
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
        position = 60,
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
        position = 10,
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
        position = 20,
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
        position = 40,
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
        position = 30,
        section = fossilIslandSection
    )
    default boolean fossilIslandFossilIsland()
    {
        return false;
    }

    @ConfigSection(
        name = "Other",
        description = "",
        position = 270,
        closedByDefault = true
    )
    String otherSection = "otherSection";

    @ConfigItem(
        keyName = "mountainGuideShayzienOutpost",
        name = "M. Guide - Shayzien Outpost",
        description = "",
        position = 40,
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
        position = 10,
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
        position = 50,
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
        position = 30,
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
        position = 20,
        section = otherSection
    )
    default boolean mountainGuideNemusRetreat()
    {
        return false;
    }

    @ConfigSection(
        name = "Fairy Rings",
        description = "",
        position = 260,
        closedByDefault = true
    )
    String fairyRingSection = "fairyRingSection";

    @ConfigItem(
        keyName = "fairyRingAIP",
        name = "AIP",
        description = "",
        position = 20,
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
        position = 30,
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
        position = 40,
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
        position = 50,
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
        position = 60,
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
        position = 70,
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
        position = 80,
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
        position = 90,
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
        position = 100,
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
        position = 110,
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
        position = 120,
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
        position = 130,
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
        position = 140,
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
        position = 150,
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
        position = 160,
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
        position = 170,
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
        position = 180,
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
        position = 190,
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
        position = 200,
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
        position = 210,
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
        position = 220,
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
        position = 230,
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
        position = 240,
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
        position = 250,
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
        position = 260,
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
        position = 270,
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
        position = 280,
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
        position = 290,
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
        position = 300,
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
        position = 310,
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
        position = 320,
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
        position = 330,
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
        position = 340,
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
        position = 350,
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
        position = 360,
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
        position = 370,
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
        position = 380,
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
        position = 390,
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
        position = 400,
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
        position = 410,
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
        position = 420,
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
        position = 430,
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
        position = 440,
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
        position = 450,
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
        position = 460,
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
        position = 470,
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
        position = 480,
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
        position = 490,
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
        position = 500,
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
        position = 510,
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
        position = 520,
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
        position = 530,
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
        position = 540,
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
        position = 550,
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
        position = 560,
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
        position = 570,
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
        position = 580,
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
        position = 590,
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
        position = 600,
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
        position = 610,
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
        position = 620,
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
        position = 630,
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
        position = 640,
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
        position = 650,
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
        position = 10,
        section = fairyRingSection
    )
    default boolean fairyRingPrevious()
    {
        return false;
    }
}
