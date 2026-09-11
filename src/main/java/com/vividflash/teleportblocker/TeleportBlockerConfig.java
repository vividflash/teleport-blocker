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

    @ConfigSection(
        name = "Soul Wars portal and Edgeville lever",
        description = "One toggle per Soul Wars portal route, into Soul Wars and out of it, plus the Wilderness lever routes at Edgeville, Ardougne and the Deserted Keep. Every one starts unblocked.",
        position = 128,
        closedByDefault = true
    )
    String soulWarsPortalSection = "soulWarsPortalSection";

    @ConfigItem(
        keyName = "soulWarsPortalEdgeville",
        name = "Soul Wars to Edgeville",
        description = "Blocks the Edgeville option in the Soul Wars portal dialogue.",
        position = 129,
        section = soulWarsPortalSection
    )
    default boolean soulWarsPortalEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWarsPortalFeroxEnclave",
        name = "Soul Wars to Ferox Enclave",
        description = "Blocks the Ferox Enclave option in the Soul Wars portal dialogue.",
        position = 130,
        section = soulWarsPortalSection
    )
    default boolean soulWarsPortalFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "soulWarsEntryEdgeville",
        name = "Edgeville to Soul Wars",
        description = "Removes the Enter option from the Soul Wars portal in Edgeville.",
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
        description = "Removes the Enter option from the Soul Wars portal in the Ferox Enclave dungeon.",
        position = 132,
        section = soulWarsPortalSection
    )
    default boolean soulWarsEntryFeroxEnclave()
    {
        return false;
    }

    @ConfigItem(
        keyName = "edgevilleLeverToWilderness",
        name = "Edgeville lever to Wilderness",
        description = "Removes the Pull option from the lever in Edgeville.",
        position = 133,
        section = soulWarsPortalSection
    )
    default boolean edgevilleLeverToWilderness()
    {
        return false;
    }

    @ConfigItem(
        keyName = "ardougneLeverToWilderness",
        name = "Ardougne lever to Wilderness",
        description = "Removes the Pull option from the lever in Ardougne.",
        position = 134,
        section = soulWarsPortalSection
    )
    default boolean ardougneLeverToWilderness()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wildernessLeverToEdgeville",
        name = "Wilderness lever to Edgeville",
        description = "Blocks the Edgeville option on the Deserted Keep lever.",
        position = 135,
        section = soulWarsPortalSection
    )
    default boolean wildernessLeverToEdgeville()
    {
        return false;
    }

    @ConfigItem(
        keyName = "wildernessLeverToArdougne",
        name = "Wilderness lever to Ardougne",
        description = "Blocks the Ardougne option on the Deserted Keep lever, or its Pull option before the Wilderness Easy Diary.",
        position = 136,
        section = soulWarsPortalSection
    )
    default boolean wildernessLeverToArdougne()
    {
        return false;
    }

    @ConfigSection(
        name = "Spirit trees",
        description = "One toggle per spirit tree destination, in list order. Every one starts unblocked.",
        position = 137,
        closedByDefault = true
    )
    String spiritTreeSection = "spiritTreeSection";

    @ConfigItem(
        keyName = "spiritTreeGnomeVillage",
        name = "Tree Gnome Village",
        description = "Blocks the Tree Gnome Village destination in the spirit tree list.",
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
        description = "Blocks the Gnome Stronghold destination in the spirit tree list.",
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
        description = "Blocks the Battlefield of Khazard destination in the spirit tree list.",
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
        description = "Blocks the Grand Exchange destination in the spirit tree list.",
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
        description = "Blocks the Feldip Hills destination in the spirit tree list.",
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
        description = "Blocks the Prifddinas destination in the spirit tree list.",
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
        description = "Blocks the Port Sarim destination in the spirit tree list.",
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
        description = "Blocks the Etceteria destination in the spirit tree list.",
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
        description = "Blocks the Brimhaven destination in the spirit tree list.",
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
        description = "Blocks the Hosidius destination in the spirit tree list.",
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
        description = "Blocks the Farming Guild destination in the spirit tree list.",
        position = 148,
        section = spiritTreeSection
    )
    default boolean spiritTreeFarmingGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreeHouse",
        name = "Your house",
        description = "Blocks the player-owned house destination in the spirit tree list.",
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
        description = "Blocks the Poison Waste destination in the spirit tree list.",
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
        description = "Blocks the Laguna Aurorae destination in the spirit tree list.",
        position = 151,
        section = spiritTreeSection
    )
    default boolean spiritTreeLagunaAurorae()
    {
        return false;
    }

    @ConfigItem(
        keyName = "spiritTreePrevious",
        name = "Previous destination",
        description = "Removes the Last-destination option from spirit trees.",
        position = 152,
        section = spiritTreeSection
    )
    default boolean spiritTreePrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Gnome gliders",
        description = "One toggle per glider map destination. Every one starts unblocked.",
        position = 153,
        closedByDefault = true
    )
    String gnomeGliderSection = "gnomeGliderSection";

    @ConfigItem(
        keyName = "gnomeGliderGrandTree",
        name = "Grand Tree",
        description = "Blocks the Ta Quir Priw (Grand Tree) destination on the glider map.",
        position = 154,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderGrandTree()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderKaramja",
        name = "Karamja",
        description = "Blocks the Gandius (Karamja) destination on the glider map.",
        position = 155,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderKaramja()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderAlKharid",
        name = "Al Kharid",
        description = "Blocks the Kar-Hewo (Al Kharid) destination on the glider map.",
        position = 156,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderAlKharid()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderWhiteWolfMountain",
        name = "White Wolf Mountain",
        description = "Blocks the Sindarpos (White Wolf Mountain) destination on the glider map.",
        position = 157,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderWhiteWolfMountain()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderDigsite",
        name = "Digsite",
        description = "Blocks the Lemanto Andra (Digsite) destination on the glider map.",
        position = 158,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderDigsite()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderFeldipHills",
        name = "Feldip Hills",
        description = "Blocks the Lemantolly Undri (Feldip Hills) destination on the glider map.",
        position = 159,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderFeldipHills()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderApeAtoll",
        name = "Ape Atoll",
        description = "Blocks the Ookookolly Undri (Ape Atoll) destination on the glider map.",
        position = 160,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderApeAtoll()
    {
        return false;
    }

    @ConfigItem(
        keyName = "gnomeGliderPrevious",
        name = "Previous destination",
        description = "Removes the Glider option from glider pilots.",
        position = 161,
        section = gnomeGliderSection
    )
    default boolean gnomeGliderPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Quetzal transport",
        description = "The Varrock quetzal route and one toggle per quetzal map landing site. Every one starts unblocked.",
        position = 162,
        closedByDefault = true
    )
    String quetzalSection = "quetzalSection";

    @ConfigItem(
        keyName = "quetzalVarrockToCivitas",
        name = "Varrock to Civitas",
        description = "Removes the options of the quetzal and its keeper at Varrock, which fly to Civitas.",
        position = 163,
        section = quetzalSection
    )
    default boolean quetzalVarrockToCivitas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCivitasToVarrock",
        name = "Civitas to Varrock",
        description = "Removes the options of the quetzal and its keeper at Civitas, which fly to Varrock.",
        position = 164,
        section = quetzalSection
    )
    default boolean quetzalCivitasToVarrock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalPrevious",
        name = "Previous destination",
        description = "Removes the Last-destination option from quetzals and quetzal whistles.",
        position = 165,
        section = quetzalSection
    )
    default boolean quetzalPrevious()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCivitas",
        name = "Civitas",
        description = "Blocks the Civitas landing site on the quetzal map.",
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
        description = "Blocks The Teomat landing site on the quetzal map.",
        position = 167,
        section = quetzalSection
    )
    default boolean quetzalTheTeomat()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalSunsetCoast",
        name = "Sunset Coast",
        description = "Blocks the Sunset Coast landing site on the quetzal map.",
        position = 168,
        section = quetzalSection
    )
    default boolean quetzalSunsetCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalHunterGuild",
        name = "Hunter Guild",
        description = "Blocks the Hunter Guild landing site on the quetzal map, and a whistle's Signal while it is set to fly there.",
        position = 169,
        section = quetzalSection
    )
    default boolean quetzalHunterGuild()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalCamTorumEntrance",
        name = "Cam Torum Entrance",
        description = "Blocks the Cam Torum Entrance landing site on the quetzal map.",
        position = 170,
        section = quetzalSection
    )
    default boolean quetzalCamTorumEntrance()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalColossalWyrmRemains",
        name = "Colossal Wyrm Remains",
        description = "Blocks the Colossal Wyrm Remains landing site on the quetzal map.",
        position = 171,
        section = quetzalSection
    )
    default boolean quetzalColossalWyrmRemains()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalOuterFortis",
        name = "Outer Fortis",
        description = "Blocks the Outer Fortis landing site on the quetzal map.",
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
        description = "Blocks the Fortis Colosseum landing site on the quetzal map.",
        position = 173,
        section = quetzalSection
    )
    default boolean quetzalFortisColosseum()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalAldarin",
        name = "Aldarin",
        description = "Blocks the Aldarin landing site on the quetzal map.",
        position = 174,
        section = quetzalSection
    )
    default boolean quetzalAldarin()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalQuetzacalliGorge",
        name = "Quetzacalli Gorge",
        description = "Blocks the Quetzacalli Gorge landing site on the quetzal map.",
        position = 175,
        section = quetzalSection
    )
    default boolean quetzalQuetzacalliGorge()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalSalvagerOverlook",
        name = "Salvager Overlook",
        description = "Blocks the Salvager Overlook landing site on the quetzal map.",
        position = 176,
        section = quetzalSection
    )
    default boolean quetzalSalvagerOverlook()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalTalTeklan",
        name = "Tal Teklan",
        description = "Blocks the Tal Teklan landing site on the quetzal map.",
        position = 177,
        section = quetzalSection
    )
    default boolean quetzalTalTeklan()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalAuburnvale",
        name = "Auburnvale",
        description = "Blocks the Auburnvale landing site on the quetzal map.",
        position = 178,
        section = quetzalSection
    )
    default boolean quetzalAuburnvale()
    {
        return false;
    }

    @ConfigItem(
        keyName = "quetzalKastori",
        name = "Kastori",
        description = "Blocks the Kastori landing site on the quetzal map.",
        position = 179,
        section = quetzalSection
    )
    default boolean quetzalKastori()
    {
        return false;
    }

    @ConfigSection(
        name = "Lovakengj minecarts",
        description = "One toggle per minecart station, in list order. Every one starts unblocked.",
        position = 180,
        closedByDefault = true
    )
    String minecartSection = "minecartSection";

    @ConfigItem(
        keyName = "minecartArceuus",
        name = "Arceuus",
        description = "Blocks the Arceuus station in the minecart list.",
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
        description = "Blocks the Farming Guild station in the minecart list.",
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
        description = "Blocks the Hosidius South station in the minecart list.",
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
        description = "Blocks the Hosidius West station in the minecart list.",
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
        description = "Blocks the Kingstown station in the minecart list.",
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
        description = "Blocks the Kourend Woodland station in the minecart list.",
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
        description = "Blocks the Lovakengj station in the minecart list.",
        position = 187,
        section = minecartSection
    )
    default boolean minecartLovakengj()
    {
        return false;
    }

    @ConfigItem(
        keyName = "minecartMountQuidamortem",
        name = "Mount Quidamortem",
        description = "Blocks the Mount Quidamortem station in the minecart list.",
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
        description = "Blocks the Northern Tundras station in the minecart list.",
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
        description = "Blocks the Port Piscarilius station in the minecart list.",
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
        description = "Blocks the Shayzien East station in the minecart list.",
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
        description = "Blocks the Shayzien West station in the minecart list.",
        position = 192,
        section = minecartSection
    )
    default boolean minecartShayzienWest()
    {
        return false;
    }

    @ConfigSection(
        name = "Charter ships",
        description = "One toggle per charter ship port, in list order. Every one starts unblocked.",
        position = 193,
        closedByDefault = true
    )
    String charterSection = "charterSection";

    @ConfigItem(
        keyName = "charterPortSarim",
        name = "Port Sarim",
        description = "Blocks the Port Sarim destination on the charter ship menu, and Charter-to Port Sarim.",
        position = 194,
        section = charterSection
    )
    default boolean charterPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterBrimhaven",
        name = "Brimhaven",
        description = "Blocks the Brimhaven destination on the charter ship menu, and Charter-to Brimhaven.",
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
        description = "Blocks the Catherby destination on the charter ship menu, and Charter-to Catherby.",
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
        description = "Blocks the Mos Le'Harmless destination on the charter ship menu, and Charter-to Mos Le'Harmless.",
        position = 197,
        section = charterSection
    )
    default boolean charterMosLeHarmless()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterMusaPoint",
        name = "Musa Point",
        description = "Blocks the Musa Point destination on the charter ship menu, and Charter-to Musa Point.",
        position = 198,
        section = charterSection
    )
    default boolean charterMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortKhazard",
        name = "Port Khazard",
        description = "Blocks the Port Khazard destination on the charter ship menu, and Charter-to Port Khazard.",
        position = 199,
        section = charterSection
    )
    default boolean charterPortKhazard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortPhasmatys",
        name = "Port Phasmatys",
        description = "Blocks the Port Phasmatys destination on the charter ship menu, and Charter-to Port Phasmatys.",
        position = 200,
        section = charterSection
    )
    default boolean charterPortPhasmatys()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterKaramjaShipyard",
        name = "Karamja Shipyard",
        description = "Blocks the Karamja Shipyard destination on the charter ship menu, and Charter-to Karamja Shipyard.",
        position = 201,
        section = charterSection
    )
    default boolean charterKaramjaShipyard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortTyras",
        name = "Port Tyras",
        description = "Blocks the Port Tyras destination on the charter ship menu, and Charter-to Port Tyras.",
        position = 202,
        section = charterSection
    )
    default boolean charterPortTyras()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterCorsairCove",
        name = "Corsair Cove",
        description = "Blocks the Corsair Cove destination on the charter ship menu, and Charter-to Corsair Cove.",
        position = 203,
        section = charterSection
    )
    default boolean charterCorsairCove()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPrifddinas",
        name = "Prifddinas",
        description = "Blocks the Prifddinas destination on the charter ship menu, and Charter-to Prifddinas.",
        position = 204,
        section = charterSection
    )
    default boolean charterPrifddinas()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortPiscarilius",
        name = "Port Piscarilius",
        description = "Blocks the Port Piscarilius destination on the charter ship menu, and Charter-to Port Piscarilius.",
        position = 205,
        section = charterSection
    )
    default boolean charterPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterLandsEnd",
        name = "Land's End",
        description = "Blocks the Land's End destination on the charter ship menu, and Charter-to Land's End.",
        position = 206,
        section = charterSection
    )
    default boolean charterLandsEnd()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterCivitasIllaFortis",
        name = "Civitas illa Fortis",
        description = "Blocks the Civitas illa Fortis destination on the charter ship menu, and Charter-to Civitas illa Fortis.",
        position = 207,
        section = charterSection
    )
    default boolean charterCivitasIllaFortis()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterAldarin",
        name = "Aldarin",
        description = "Blocks the Aldarin destination on the charter ship menu, and Charter-to Aldarin.",
        position = 208,
        section = charterSection
    )
    default boolean charterAldarin()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterSunsetCoast",
        name = "Sunset Coast",
        description = "Blocks the Sunset Coast destination on the charter ship menu, and Charter-to Sunset Coast.",
        position = 209,
        section = charterSection
    )
    default boolean charterSunsetCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterThePandemonium",
        name = "The Pandemonium",
        description = "Blocks The Pandemonium destination on the charter ship menu, and Charter-to The Pandemonium.",
        position = 210,
        section = charterSection
    )
    default boolean charterThePandemonium()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterTheSummerShore",
        name = "The Summer Shore",
        description = "Blocks The Summer Shore destination on the charter ship menu, and Charter-to The Summer Shore.",
        position = 211,
        section = charterSection
    )
    default boolean charterTheSummerShore()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterRedRock",
        name = "Red Rock",
        description = "Blocks the Red Rock destination on the charter ship menu, and Charter-to Red Rock.",
        position = 212,
        section = charterSection
    )
    default boolean charterRedRock()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterDeepfinPoint",
        name = "Deepfin Point",
        description = "Blocks the Deepfin Point destination on the charter ship menu, and Charter-to Deepfin Point.",
        position = 213,
        section = charterSection
    )
    default boolean charterDeepfinPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPortRoberts",
        name = "Port Roberts",
        description = "Blocks the Port Roberts destination on the charter ship menu, and Charter-to Port Roberts.",
        position = 214,
        section = charterSection
    )
    default boolean charterPortRoberts()
    {
        return false;
    }

    @ConfigItem(
        keyName = "charterPrevious",
        name = "Previous destination",
        description = "Removes the Charter-to option from charter ship crews.",
        position = 215,
        section = charterSection
    )
    default boolean charterPrevious()
    {
        return false;
    }

    @ConfigSection(
        name = "Other ships",
        description = "One toggle per ship leg outside the charter network, named by the port it sails from and to. Every one starts unblocked.",
        position = 216,
        closedByDefault = true
    )
    String shipSection = "shipSection";

    @ConfigItem(
        keyName = "shipBarnabyArdougne",
        name = "Barnaby - Ardougne",
        description = "Blocks Captain Barnaby's ship to Ardougne, from Brimhaven and from Rimmington.",
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
        description = "Blocks Captain Barnaby's ship to Brimhaven, from Ardougne and from Rimmington.",
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
        description = "Blocks Captain Barnaby's ship to Rimmington, from Ardougne and from Brimhaven.",
        position = 219,
        section = shipSection
    )
    default boolean shipBarnabyRimmington()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimVoidKnightsOutpost",
        name = "Port Sarim - Void Knights' Outpost",
        description = "Blocks the squire's ship from Port Sarim to the Void Knights' Outpost.",
        position = 220,
        section = shipSection
    )
    default boolean shipPortSarimVoidKnightsOutpost()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipVoidKnightsOutpostPortSarim",
        name = "Void Knights' Outpost - Port Sarim",
        description = "Blocks the squire's ship from the Void Knights' Outpost to Port Sarim.",
        position = 221,
        section = shipSection
    )
    default boolean shipVoidKnightsOutpostPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimMusaPoint",
        name = "Port Sarim - Musa Point",
        description = "Blocks the ship from Port Sarim to Musa Point. Before the Pandemonium quest this also removes the crew's Talk-to.",
        position = 222,
        section = shipSection
    )
    default boolean shipPortSarimMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMusaPointPortSarim",
        name = "Musa Point - Port Sarim",
        description = "Blocks the ship from Musa Point to Port Sarim. Before the Pandemonium quest this also removes the customs officer's Talk-to.",
        position = 223,
        section = shipSection
    )
    default boolean shipMusaPointPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimPandemonium",
        name = "Port Sarim - The Pandemonium",
        description = "Blocks the ship from Port Sarim to The Pandemonium.",
        position = 224,
        section = shipSection
    )
    default boolean shipPortSarimPandemonium()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPandemoniumPortSarim",
        name = "The Pandemonium - Port Sarim",
        description = "Blocks the ship from The Pandemonium to Port Sarim.",
        position = 225,
        section = shipSection
    )
    default boolean shipPandemoniumPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMusaPointPandemonium",
        name = "Musa Point - The Pandemonium",
        description = "Blocks the ship from Musa Point to The Pandemonium.",
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
        description = "Blocks the ship from The Pandemonium to Musa Point.",
        position = 227,
        section = shipSection
    )
    default boolean shipPandemoniumMusaPoint()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimEntrana",
        name = "Port Sarim - Entrana",
        description = "Blocks the ship from Port Sarim to Entrana, including the monk's Talk-to.",
        position = 228,
        section = shipSection
    )
    default boolean shipPortSarimEntrana()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipEntranaPortSarim",
        name = "Entrana - Port Sarim",
        description = "Blocks the ship from Entrana to Port Sarim, including the monk's Talk-to.",
        position = 229,
        section = shipSection
    )
    default boolean shipEntranaPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimPortPiscarilius",
        name = "Port Sarim - Port Piscarilius",
        description = "Blocks the ship from Port Sarim to Port Piscarilius.",
        position = 230,
        section = shipSection
    )
    default boolean shipPortSarimPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortPiscariliusPortSarim",
        name = "Port Piscarilius - Port Sarim",
        description = "Blocks the ship from Port Piscarilius to Port Sarim.",
        position = 231,
        section = shipSection
    )
    default boolean shipPortPiscariliusPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortSarimLandsEnd",
        name = "Port Sarim - Land's End",
        description = "Blocks the ship from Port Sarim to Land's End.",
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
        description = "Blocks the ship from Land's End to Port Sarim.",
        position = 233,
        section = shipSection
    )
    default boolean shipLandsEndPortSarim()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPortPiscariliusLandsEnd",
        name = "Port Piscarilius - Land's End",
        description = "Blocks the ship from Port Piscarilius to Land's End.",
        position = 234,
        section = shipSection
    )
    default boolean shipPortPiscariliusLandsEnd()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipLandsEndPortPiscarilius",
        name = "Land's End - Port Piscarilius",
        description = "Blocks the ship from Land's End to Port Piscarilius.",
        position = 235,
        section = shipSection
    )
    default boolean shipLandsEndPortPiscarilius()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaWaterbirthIsland",
        name = "Rellekka - Waterbirth Island",
        description = "Blocks Jarvald's ship from Rellekka to Waterbirth Island, including his Talk-to there.",
        position = 236,
        section = shipSection
    )
    default boolean shipRellekkaWaterbirthIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipWaterbirthIslandRellekka",
        name = "Waterbirth Island - Rellekka",
        description = "Blocks Jarvald's ship from Waterbirth Island to Rellekka.",
        position = 237,
        section = shipSection
    )
    default boolean shipWaterbirthIslandRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaPiratesCove",
        name = "Rellekka - Pirates' Cove",
        description = "Blocks Lokar Searunner's ship from Rellekka to Pirates' Cove, including his Talk-to there.",
        position = 238,
        section = shipSection
    )
    default boolean shipRellekkaPiratesCove()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipPiratesCoveRellekka",
        name = "Pirates' Cove - Rellekka",
        description = "Blocks Lokar Searunner's ship from Pirates' Cove to Rellekka.",
        position = 239,
        section = shipSection
    )
    default boolean shipPiratesCoveRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaJatizso",
        name = "Rellekka - Jatizso",
        description = "Blocks the ferry from Rellekka to Jatizso.",
        position = 240,
        section = shipSection
    )
    default boolean shipRellekkaJatizso()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipJatizsoRellekka",
        name = "Jatizso - Rellekka",
        description = "Blocks the ferry from Jatizso to Rellekka.",
        position = 241,
        section = shipSection
    )
    default boolean shipJatizsoRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaNeitiznot",
        name = "Rellekka - Neitiznot",
        description = "Blocks the ferry from Rellekka to Neitiznot.",
        position = 242,
        section = shipSection
    )
    default boolean shipRellekkaNeitiznot()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipNeitiznotRellekka",
        name = "Neitiznot - Rellekka",
        description = "Blocks the ferry from Neitiznot to Rellekka.",
        position = 243,
        section = shipSection
    )
    default boolean shipNeitiznotRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipRellekkaMiscellania",
        name = "Rellekka - Miscellania",
        description = "Blocks the sailor's ship from Rellekka to Miscellania, including his Talk-to there.",
        position = 244,
        section = shipSection
    )
    default boolean shipRellekkaMiscellania()
    {
        return false;
    }

    @ConfigItem(
        keyName = "shipMiscellaniaRellekka",
        name = "Miscellania - Rellekka",
        description = "Blocks the sailor's ship from Miscellania to Rellekka, including his Talk-to there.",
        position = 245,
        section = shipSection
    )
    default boolean shipMiscellaniaRellekka()
    {
        return false;
    }

    @ConfigSection(
        name = "Boats",
        description = "One toggle per boat trip, named by the boat and the place it goes to. Every one starts unblocked.",
        position = 246,
        closedByDefault = true
    )
    String boatSection = "boatSection";

    @ConfigItem(
        keyName = "boatFossilMuseumCamp",
        name = "Fossil rowboat - Museum Camp",
        description = "Blocks the Fossil Island rowboat trip to the Museum Camp.",
        position = 247,
        section = boatSection
    )
    default boolean boatFossilMuseumCamp()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatFossilNorth",
        name = "Fossil rowboat - North",
        description = "Blocks the Fossil Island rowboat trip to the north of the island.",
        position = 248,
        section = boatSection
    )
    default boolean boatFossilNorth()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatFossilBankIsland",
        name = "Fossil rowboat - Bank island",
        description = "Blocks the Fossil Island rowboat trip out to the small island with the bank.",
        position = 249,
        section = boatSection
    )
    default boolean boatFossilBankIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatFossilDigsite",
        name = "Fossil rowboat - Digsite",
        description = "Blocks the Fossil Island rowboat trip to the Digsite.",
        position = 250,
        section = boatSection
    )
    default boolean boatFossilDigsite()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatFossilLithkren",
        name = "Fossil rowboat - Lithkren",
        description = "Blocks the rowboat from Fossil Island to Lithkren.",
        position = 251,
        section = boatSection
    )
    default boolean boatFossilLithkren()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatFossilFossilIsland",
        name = "Fossil rowboat - Fossil Island",
        description = "Blocks the rowboat from Lithkren back to Fossil Island.",
        position = 252,
        section = boatSection
    )
    default boolean boatFossilFossilIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyMolchIsland",
        name = "Boaty - Molch Island",
        description = "Blocks Boaty's trip to Molch Island.",
        position = 253,
        section = boatSection
    )
    default boolean boatBoatyMolchIsland()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyMolch",
        name = "Boaty - Molch",
        description = "Blocks Boaty's trip to Molch.",
        position = 254,
        section = boatSection
    )
    default boolean boatBoatyMolch()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyBattlefront",
        name = "Boaty - Battlefront",
        description = "Blocks Boaty's trip to the Battlefront.",
        position = 255,
        section = boatSection
    )
    default boolean boatBoatyBattlefront()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatBoatyShayzien",
        name = "Boaty - Shayzien",
        description = "Blocks Boaty's trip to Shayzien.",
        position = 256,
        section = boatSection
    )
    default boolean boatBoatyShayzien()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryIceberg",
        name = "Larry - Iceberg",
        description = "Blocks the Iceberg option on Larry's boat.",
        position = 257,
        section = boatSection
    )
    default boolean boatLarryIceberg()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryWeiss",
        name = "Larry - Weiss",
        description = "Blocks the Weiss option on Larry's boat.",
        position = 258,
        section = boatSection
    )
    default boolean boatLarryWeiss()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatLarryRellekka",
        name = "Larry - Rellekka",
        description = "Blocks the Travel option on Larry's boat at the Iceberg and at Weiss, which goes back to Rellekka.",
        position = 259,
        section = boatSection
    )
    default boolean boatLarryRellekka()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaBurghDeRott",
        name = "Morytania rowboat - Burgh de Rott",
        description = "Blocks the Morytania rowboat trip to Burgh de Rott.",
        position = 260,
        section = boatSection
    )
    default boolean boatMorytaniaBurghDeRott()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaMeiyerditch",
        name = "Morytania rowboat - Meiyerditch",
        description = "Blocks the Morytania rowboat trip to Meiyerditch.",
        position = 261,
        section = boatSection
    )
    default boolean boatMorytaniaMeiyerditch()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaIcyeneGraveyard",
        name = "Morytania rowboat - Icyene Graveyard",
        description = "Blocks the Morytania rowboat trip to the Icyene Graveyard.",
        position = 262,
        section = boatSection
    )
    default boolean boatMorytaniaIcyeneGraveyard()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatMorytaniaSlepe",
        name = "Morytania rowboat - Slepe",
        description = "Blocks the Morytania rowboat trip to Slepe.",
        position = 263,
        section = boatSection
    )
    default boolean boatMorytaniaSlepe()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaTalTeklan",
        name = "Achilka - Tal Teklan",
        description = "Blocks Achilka's boat to Tal Teklan.",
        position = 264,
        section = boatSection
    )
    default boolean boatAchilkaTalTeklan()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaGloomthornTrail",
        name = "Achilka - Gloomthorn Trail",
        description = "Blocks Achilka's boat to the Gloomthorn Trail.",
        position = 265,
        section = boatSection
    )
    default boolean boatAchilkaGloomthornTrail()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatAchilkaKastori",
        name = "Achilka - Kastori",
        description = "Blocks Achilka's boat to Kastori.",
        position = 266,
        section = boatSection
    )
    default boolean boatAchilkaKastori()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchSummerShore",
        name = "Conch rowboat - Summer Shore",
        description = "Blocks the Great Conch rowboat trip to The Summer Shore.",
        position = 267,
        section = boatSection
    )
    default boolean boatConchSummerShore()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchNorthCoast",
        name = "Conch rowboat - North coast",
        description = "Blocks the Great Conch rowboat trip to the north coast.",
        position = 268,
        section = boatSection
    )
    default boolean boatConchNorthCoast()
    {
        return false;
    }

    @ConfigItem(
        keyName = "boatConchEastCoast",
        name = "Conch rowboat - East coast",
        description = "Blocks the Great Conch rowboat trip to the east coast.",
        position = 269,
        section = boatSection
    )
    default boolean boatConchEastCoast()
    {
        return false;
    }

}
