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
    @ConfigItem(
        keyName = "blockAllTeleports",
        name = "Block all standard tp",
        description = "Blocks every teleport in the section below, whatever its own toggle says.",
        position = 0
    )
    default boolean blockAllTeleports()
    {
        return true;
    }

    @ConfigSection(
        name = "Teleports",
        description = "One toggle per standard spellbook teleport.",
        position = 1,
        closedByDefault = true
    )
    String teleportsSection = "teleportsSection";

    @ConfigItem(
        keyName = "homeTeleport",
        name = "Home Teleport",
        description = "Removes the click options from Home Teleport.",
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
        description = "Removes the click options from Varrock Teleport, including the Configure option for the Grand Exchange destination.",
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
        description = "Removes the click options from Lumbridge Teleport.",
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
        description = "Removes the click options from Falador Teleport.",
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
        description = "Removes the click options from Teleport to House, including Outside, Inside and the Group entries.",
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
        description = "Removes the click options from Camelot Teleport, including the Toggle-location option for the Seers' Village destination.",
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
        description = "Removes the click options from Kourend Castle Teleport.",
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
        description = "Removes the click options from Ardougne Teleport.",
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
        description = "Removes the click options from Civitas illa Fortis Teleport.",
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
        description = "Removes the click options from Watchtower Teleport, including the toggle for the Yanille destination.",
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
        description = "Removes the click options from Trollheim Teleport.",
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
        description = "Removes the click options from Ape Atoll Teleport.",
        position = 13,
        section = teleportsSection
    )
    default boolean apeAtollTeleport()
    {
        return false;
    }

    @ConfigItem(
        keyName = "blockAllMinigames",
        name = "Block all minigames",
        description = "Removes the click options from Minigame Teleport, so the Minigames window never opens. Untick to keep the spell and pick destinations below.",
        position = 14
    )
    default boolean blockAllMinigames()
    {
        return true;
    }

    @ConfigSection(
        name = "Minigames",
        description = "One toggle per row of the Minigames window, used when the spell itself is not blocked.",
        position = 15,
        closedByDefault = true
    )
    String minigamesSection = "minigamesSection";

    @ConfigItem(
        keyName = "barbarianAssault",
        name = "Barbarian Assault",
        description = "Removes the Select option from Barbarian Assault.",
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
        description = "Removes the Select option from Blast Furnace.",
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
        description = "Removes the Select option from Bounty Hunter.",
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
        description = "Removes the Select option from Burthorpe Games Room.",
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
        description = "Removes the Select option from Castle Wars.",
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
        description = "Removes the Select option from Clan Wars.",
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
        description = "Removes the Select option from Fishing Trawler.",
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
        description = "Removes the Select option from Giants' Foundry.",
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
        description = "Removes the Select option from Guardians of the Rift.",
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
        description = "Removes the Select option from Last Man Standing.",
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
        description = "Removes the Select option from Mage Training Arena.",
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
        description = "Removes the Select option from Mastering Mixology.",
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
        description = "Removes the Select option from Nightmare Zone.",
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
        description = "Removes the Select option from Pest Control.",
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
        description = "Removes the Select option from Rat Pits, so the destination dialogue never opens.",
        position = 30,
        section = minigamesSection
    )
    default boolean ratPits()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsArdougne",
        name = "Rat Pits: Ardougne (kittens)",
        description = "Blocks the Ardougne option in the rat pit dialogue.",
        position = 31,
        section = minigamesSection
    )
    default boolean ratPitsArdougne()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsVarrock",
        name = "Rat Pits: Varrock (grown cats)",
        description = "Blocks the Varrock option in the rat pit dialogue.",
        position = 32,
        section = minigamesSection
    )
    default boolean ratPitsVarrock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsKeldagrim",
        name = "Rat Pits: Keldagrim (overgrown cats)",
        description = "Blocks the Keldagrim option in the rat pit dialogue.",
        position = 33,
        section = minigamesSection
    )
    default boolean ratPitsKeldagrim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ratPitsPortSarim",
        name = "Rat Pits: Port Sarim (wily cats)",
        description = "Blocks the Port Sarim option in the rat pit dialogue.",
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
        description = "Removes the Select option from Shades of Mort'ton.",
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
        description = "Removes the Select option from Sorceress's Garden.",
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
        description = "Removes the Select option from Soul Wars.",
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
        description = "Removes the Select option from Tithe Farm.",
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
        description = "Removes the Select option from Trouble Brewing.",
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
        description = "Removes the Select option from TzHaar Fight Pit.",
        position = 40,
        section = minigamesSection
    )
    default boolean tzhaarFightPit()
    {
        return false;
    }

    @ConfigSection(
        name = "Ancient spellbook",
        description = "One toggle per ancient spellbook teleport. Every one starts unblocked.",
        position = 41,
        closedByDefault = true
    )
    String ancientSection = "ancientSection";

    @ConfigItem(
        keyName = "ancientHomeTeleport",
        name = "Home Teleport",
        description = "Removes the click options from the ancient Home Teleport.",
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
        description = "Removes the click options from Paddewwa Teleport.",
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
        description = "Removes the click options from Senntisten Teleport.",
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
        description = "Removes the click options from Kharyrll Teleport.",
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
        description = "Removes the click options from Lassar Teleport.",
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
        description = "Removes the click options from Dareeyak Teleport.",
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
        description = "Removes the click options from Carrallanger Teleport.",
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
        description = "Removes the click options from Annakarl Teleport.",
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
        description = "Removes the click options from Ghorrock Teleport.",
        position = 51,
        section = ancientSection
    )
    default boolean ancientGhorrock()
    {
        return false;
    }

    @ConfigSection(
        name = "Lunar spellbook",
        description = "One toggle per lunar spellbook teleport, Tele Group aside. Every one starts unblocked.",
        position = 52,
        closedByDefault = true
    )
    String lunarSection = "lunarSection";

    @ConfigItem(
        keyName = "lunarHomeTeleport",
        name = "Home Teleport",
        description = "Removes the click options from the lunar Home Teleport.",
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
        description = "Removes the click options from Moonclan Teleport.",
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
        description = "Removes the click options from Ourania Teleport.",
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
        description = "Removes the click options from Waterbirth Teleport.",
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
        description = "Removes the click options from Barbarian Teleport.",
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
        description = "Removes the click options from Khazard Teleport.",
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
        description = "Removes the click options from Fishing Guild Teleport.",
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
        description = "Removes the click options from Catherby Teleport.",
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
        description = "Removes the click options from Ice Plateau Teleport.",
        position = 62,
        section = lunarSection
    )
    default boolean lunarIcePlateau()
    {
        return false;
    }

    @ConfigSection(
        name = "Canoes",
        description = "One toggle per canoe destination, River Lum first. Every one starts unblocked.",
        position = 63,
        closedByDefault = true
    )
    String canoeSection = "canoeSection";

    @ConfigItem(
        keyName = "canoeLumbridge",
        name = "Lumbridge",
        description = "Blocks the Lumbridge destination on the canoe map.",
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
        description = "Blocks the Champions' Guild destination on the canoe map.",
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
        description = "Blocks the Barbarian Village destination on the canoe map.",
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
        description = "Blocks the Edgeville destination on the canoe map.",
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
        description = "Blocks the Ferox Enclave destination on the canoe map.",
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
        description = "Blocks the Wilderness Pond destination on the canoe map.",
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
        description = "Blocks the Castle Wars destination on the canoe map.",
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
        description = "Blocks the Tree Gnome Village destination on the canoe map.",
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
        description = "Blocks the Clocktower destination on the canoe map.",
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
        description = "Blocks the Chaos Druid Tower destination on the canoe map.",
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
        description = "Blocks the Tree Gnome Stronghold destination on the canoe map.",
        position = 74,
        section = canoeSection
    )
    default boolean canoeTreeGnomeStronghold()
    {
        return false;
    }

    @ConfigSection(
        name = "Ring of dueling",
        description = "One toggle per Ring of dueling destination, on the worn menu and in the rub dialogue.",
        position = 75,
        closedByDefault = true
    )
    String duelingSection = "duelingSection";

    @ConfigItem(
        keyName = "duelingEmirsArena",
        name = "Emir's Arena",
        description = "Blocks the Emir's Arena option on the Ring of dueling.",
        position = 76,
        section = duelingSection
    )
    default boolean duelingEmirsArena()
    {
        return true;
    }

    @ConfigItem(
        keyName = "duelingCastleWars",
        name = "Castle Wars",
        description = "Blocks the Castle Wars option on the Ring of dueling.",
        position = 77,
        section = duelingSection
    )
    default boolean duelingCastleWars()
    {
        return true;
    }

    @ConfigItem(
        keyName = "duelingFeroxEnclave",
        name = "Ferox Enclave",
        description = "Blocks the Ferox Enclave option on the Ring of dueling.",
        position = 78,
        section = duelingSection
    )
    default boolean duelingFeroxEnclave()
    {
        return true;
    }

    @ConfigItem(
        keyName = "duelingFortisColosseum",
        name = "Fortis Colosseum",
        description = "Blocks the Fortis Colosseum option on the Ring of dueling.",
        position = 79,
        section = duelingSection
    )
    default boolean duelingFortisColosseum()
    {
        return true;
    }

    @ConfigSection(
        name = "Games necklace",
        description = "One toggle per Games necklace destination, on the worn menu and in the rub dialogue.",
        position = 80,
        closedByDefault = true
    )
    String gamesNecklaceSection = "gamesNecklaceSection";

    @ConfigItem(
        keyName = "gamesBurthorpe",
        name = "Burthorpe",
        description = "Blocks the Burthorpe option on the Games necklace.",
        position = 81,
        section = gamesNecklaceSection
    )
    default boolean gamesBurthorpe()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gamesBarbarianOutpost",
        name = "Barbarian Outpost",
        description = "Blocks the Barbarian Outpost option on the Games necklace.",
        position = 82,
        section = gamesNecklaceSection
    )
    default boolean gamesBarbarianOutpost()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gamesCorporealBeast",
        name = "Corporeal Beast",
        description = "Blocks the Corporeal Beast option on the Games necklace.",
        position = 83,
        section = gamesNecklaceSection
    )
    default boolean gamesCorporealBeast()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gamesTearsOfGuthix",
        name = "Tears of Guthix",
        description = "Blocks the Tears of Guthix option on the Games necklace.",
        position = 84,
        section = gamesNecklaceSection
    )
    default boolean gamesTearsOfGuthix()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gamesWintertodtCamp",
        name = "Wintertodt Camp",
        description = "Blocks the Wintertodt Camp option on the Games necklace.",
        position = 85,
        section = gamesNecklaceSection
    )
    default boolean gamesWintertodtCamp()
    {
        return true;
    }

    @ConfigSection(
        name = "Amulet of glory",
        description = "One toggle per Amulet of glory destination, on the worn menu and in the rub dialogue.",
        position = 86,
        closedByDefault = true
    )
    String glorySection = "glorySection";

    @ConfigItem(
        keyName = "gloryEdgeville",
        name = "Edgeville",
        description = "Blocks the Edgeville option on the Amulet of glory.",
        position = 87,
        section = glorySection
    )
    default boolean gloryEdgeville()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gloryKaramja",
        name = "Karamja",
        description = "Blocks the Karamja option on the Amulet of glory.",
        position = 88,
        section = glorySection
    )
    default boolean gloryKaramja()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gloryDraynorVillage",
        name = "Draynor Village",
        description = "Blocks the Draynor Village option on the Amulet of glory.",
        position = 89,
        section = glorySection
    )
    default boolean gloryDraynorVillage()
    {
        return true;
    }

    @ConfigItem(
        keyName = "gloryAlKharid",
        name = "Al Kharid",
        description = "Blocks the Al Kharid option on the Amulet of glory.",
        position = 90,
        section = glorySection
    )
    default boolean gloryAlKharid()
    {
        return true;
    }

    @ConfigSection(
        name = "Ring of wealth",
        description = "One toggle per Ring of wealth destination, on the worn menu and in the rub dialogue.",
        position = 91,
        closedByDefault = true
    )
    String wealthSection = "wealthSection";

    @ConfigItem(
        keyName = "wealthMiscellania",
        name = "Miscellania",
        description = "Blocks the Miscellania option on the Ring of wealth.",
        position = 92,
        section = wealthSection
    )
    default boolean wealthMiscellania()
    {
        return true;
    }

    @ConfigItem(
        keyName = "wealthGrandExchange",
        name = "Grand Exchange",
        description = "Blocks the Grand Exchange option on the Ring of wealth.",
        position = 93,
        section = wealthSection
    )
    default boolean wealthGrandExchange()
    {
        return true;
    }

    @ConfigItem(
        keyName = "wealthFaladorPark",
        name = "Falador Park",
        description = "Blocks the Falador Park option on the Ring of wealth.",
        position = 94,
        section = wealthSection
    )
    default boolean wealthFaladorPark()
    {
        return true;
    }

    @ConfigItem(
        keyName = "wealthDondakan",
        name = "Dondakan",
        description = "Blocks the Dondakan option on the Ring of wealth.",
        position = 95,
        section = wealthSection
    )
    default boolean wealthDondakan()
    {
        return true;
    }

    @ConfigSection(
        name = "Necklace of passage",
        description = "One toggle per Necklace of passage destination, on the worn menu and in the rub dialogue.",
        position = 96,
        closedByDefault = true
    )
    String passageSection = "passageSection";

    @ConfigItem(
        keyName = "passageWizardsTower",
        name = "Wizards' Tower",
        description = "Blocks the Wizards' Tower option on the Necklace of passage.",
        position = 97,
        section = passageSection
    )
    default boolean passageWizardsTower()
    {
        return true;
    }

    @ConfigItem(
        keyName = "passageTheOutpost",
        name = "The Outpost",
        description = "Blocks the The Outpost option on the Necklace of passage.",
        position = 98,
        section = passageSection
    )
    default boolean passageTheOutpost()
    {
        return true;
    }

    @ConfigItem(
        keyName = "passageEaglesEyrie",
        name = "Eagles' Eyrie",
        description = "Blocks the Eagles' Eyrie option on the Necklace of passage.",
        position = 99,
        section = passageSection
    )
    default boolean passageEaglesEyrie()
    {
        return true;
    }

    @ConfigItem(
        keyName = "passageWyrmscraig",
        name = "Wyrmscraig",
        description = "Blocks the Wyrmscraig option on the Necklace of passage.",
        position = 100,
        section = passageSection
    )
    default boolean passageWyrmscraig()
    {
        return true;
    }

    @ConfigSection(
        name = "Combat bracelet",
        description = "One toggle per Combat bracelet destination, on the worn menu and in the rub dialogue.",
        position = 101,
        closedByDefault = true
    )
    String combatBraceletSection = "combatBraceletSection";

    @ConfigItem(
        keyName = "combatWarriorsGuild",
        name = "Warriors' Guild",
        description = "Blocks the Warriors' Guild option on the Combat bracelet.",
        position = 102,
        section = combatBraceletSection
    )
    default boolean combatWarriorsGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "combatChampionsGuild",
        name = "Champions' Guild",
        description = "Blocks the Champions' Guild option on the Combat bracelet.",
        position = 103,
        section = combatBraceletSection
    )
    default boolean combatChampionsGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "combatMonastery",
        name = "Monastery",
        description = "Blocks the Monastery option on the Combat bracelet.",
        position = 104,
        section = combatBraceletSection
    )
    default boolean combatMonastery()
    {
        return true;
    }

    @ConfigItem(
        keyName = "combatRangingGuild",
        name = "Ranging Guild",
        description = "Blocks the Ranging Guild option on the Combat bracelet.",
        position = 105,
        section = combatBraceletSection
    )
    default boolean combatRangingGuild()
    {
        return true;
    }

    @ConfigSection(
        name = "Skills necklace",
        description = "One toggle per Skills necklace destination, on the worn menu and in the rub dialogue.",
        position = 106,
        closedByDefault = true
    )
    String skillsNecklaceSection = "skillsNecklaceSection";

    @ConfigItem(
        keyName = "skillsFishingGuild",
        name = "Fishing Guild",
        description = "Blocks the Fishing Guild option on the Skills necklace.",
        position = 107,
        section = skillsNecklaceSection
    )
    default boolean skillsFishingGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "skillsMiningGuild",
        name = "Mining Guild",
        description = "Blocks the Mining Guild option on the Skills necklace.",
        position = 108,
        section = skillsNecklaceSection
    )
    default boolean skillsMiningGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "skillsCraftingGuild",
        name = "Crafting Guild",
        description = "Blocks the Crafting Guild option on the Skills necklace.",
        position = 109,
        section = skillsNecklaceSection
    )
    default boolean skillsCraftingGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "skillsCookingGuild",
        name = "Cooking Guild",
        description = "Blocks the Cooking Guild option on the Skills necklace.",
        position = 110,
        section = skillsNecklaceSection
    )
    default boolean skillsCookingGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "skillsWoodcuttingGuild",
        name = "Woodcutting Guild",
        description = "Blocks the Woodcutting Guild option on the Skills necklace.",
        position = 111,
        section = skillsNecklaceSection
    )
    default boolean skillsWoodcuttingGuild()
    {
        return true;
    }

    @ConfigItem(
        keyName = "skillsFarmingGuild",
        name = "Farming Guild",
        description = "Blocks the Farming Guild option on the Skills necklace.",
        position = 112,
        section = skillsNecklaceSection
    )
    default boolean skillsFarmingGuild()
    {
        return true;
    }

    @ConfigSection(
        name = "Slayer ring",
        description = "One toggle per Slayer ring destination, listed in the teleport dialogue the ring opens.",
        position = 113,
        closedByDefault = true
    )
    String slayerRingSection = "slayerRingSection";

    @ConfigItem(
        keyName = "slayerStrongholdSlayerCave",
        name = "Stronghold Slayer Cave",
        description = "Blocks the Gnome Stronghold Caves option on the Slayer ring.",
        position = 114,
        section = slayerRingSection
    )
    default boolean slayerStrongholdSlayerCave()
    {
        return true;
    }

    @ConfigItem(
        keyName = "slayerSlayerTower",
        name = "Slayer Tower",
        description = "Blocks the Slayer Tower option on the Slayer ring.",
        position = 115,
        section = slayerRingSection
    )
    default boolean slayerSlayerTower()
    {
        return true;
    }

    @ConfigItem(
        keyName = "slayerFremennikSlayerDungeon",
        name = "Fremennik Slayer Dungeon",
        description = "Blocks the Rellekka Caves option on the Slayer ring.",
        position = 116,
        section = slayerRingSection
    )
    default boolean slayerFremennikSlayerDungeon()
    {
        return true;
    }

    @ConfigItem(
        keyName = "slayerTarnsLair",
        name = "Tarn's Lair",
        description = "Blocks the Haunted Mine option on the Slayer ring.",
        position = 117,
        section = slayerRingSection
    )
    default boolean slayerTarnsLair()
    {
        return true;
    }

    @ConfigItem(
        keyName = "slayerDarkBeasts",
        name = "Dark Beasts",
        description = "Blocks the ME2 Caves option on the Slayer ring.",
        position = 118,
        section = slayerRingSection
    )
    default boolean slayerDarkBeasts()
    {
        return true;
    }

    @ConfigItem(
        keyName = "slayerWyrmscraigCavern",
        name = "Wyrmscraig Cavern",
        description = "Blocks the Wyrmscraig Cavern option on the Slayer ring.",
        position = 119,
        section = slayerRingSection
    )
    default boolean slayerWyrmscraigCavern()
    {
        return true;
    }

    @ConfigSection(
        name = "Digsite pendant",
        description = "One toggle per Digsite pendant destination, on the worn menu and in the rub dialogue.",
        position = 120,
        closedByDefault = true
    )
    String digsitePendantSection = "digsitePendantSection";

    @ConfigItem(
        keyName = "digsiteDigsite",
        name = "Digsite",
        description = "Blocks the Digsite option on the Digsite pendant.",
        position = 121,
        section = digsitePendantSection
    )
    default boolean digsiteDigsite()
    {
        return true;
    }

    @ConfigItem(
        keyName = "digsiteFossilIsland",
        name = "Fossil Island",
        description = "Blocks the Fossil Island option on the Digsite pendant.",
        position = 122,
        section = digsitePendantSection
    )
    default boolean digsiteFossilIsland()
    {
        return true;
    }

    @ConfigItem(
        keyName = "digsiteLithkren",
        name = "Lithkren Dungeon",
        description = "Blocks the Lithkren Dungeon option on the Digsite pendant.",
        position = 123,
        section = digsitePendantSection
    )
    default boolean digsiteLithkren()
    {
        return true;
    }

    @ConfigSection(
        name = "Burning amulet",
        description = "One toggle per Burning amulet destination, on the worn menu and in the rub dialogue.",
        position = 124,
        closedByDefault = true
    )
    String burningAmuletSection = "burningAmuletSection";

    @ConfigItem(
        keyName = "burningChaosTemple",
        name = "Chaos Temple",
        description = "Blocks the Chaos Temple option on the Burning amulet.",
        position = 125,
        section = burningAmuletSection
    )
    default boolean burningChaosTemple()
    {
        return true;
    }

    @ConfigItem(
        keyName = "burningBanditCamp",
        name = "Bandit Camp",
        description = "Blocks the Bandit Camp option on the Burning amulet.",
        position = 126,
        section = burningAmuletSection
    )
    default boolean burningBanditCamp()
    {
        return true;
    }

    @ConfigItem(
        keyName = "burningLavaMaze",
        name = "Lava Maze",
        description = "Blocks the Lava Maze option on the Burning amulet.",
        position = 127,
        section = burningAmuletSection
    )
    default boolean burningLavaMaze()
    {
        return true;
    }

}
