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

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Destinations offered by the Minigames window, each paired with the name the
 * window prints and the toggle that blocks it.
 */
public enum Minigame
{
    BARBARIAN_ASSAULT("Barbarian Assault", TeleportBlockerConfig::barbarianAssault),
    BLAST_FURNACE("Blast Furnace", TeleportBlockerConfig::blastFurnace),
    BOUNTY_HUNTER("Bounty Hunter", TeleportBlockerConfig::bountyHunter),
    BURTHORPE_GAMES_ROOM("Burthorpe Games Room", TeleportBlockerConfig::burthorpeGamesRoom),
    CASTLE_WARS("Castle Wars", TeleportBlockerConfig::castleWars),
    CLAN_WARS("Clan Wars", TeleportBlockerConfig::clanWars),
    FISHING_TRAWLER("Fishing Trawler", TeleportBlockerConfig::fishingTrawler),
    GIANTS_FOUNDRY("Giants' Foundry", TeleportBlockerConfig::giantsFoundry),
    GUARDIANS_OF_THE_RIFT("Guardians of the Rift", TeleportBlockerConfig::guardiansOfTheRift),
    LAST_MAN_STANDING("Last Man Standing", TeleportBlockerConfig::lastManStanding),
    MAGE_TRAINING_ARENA("Mage Training Arena", TeleportBlockerConfig::mageTrainingArena),
    MASTERING_MIXOLOGY("Mastering Mixology", TeleportBlockerConfig::masteringMixology),
    NIGHTMARE_ZONE("Nightmare Zone", TeleportBlockerConfig::nightmareZone),
    PEST_CONTROL("Pest Control", TeleportBlockerConfig::pestControl),
    RAT_PITS("Rat Pits", TeleportBlockerConfig::ratPits),
    SHADES_OF_MORTTON("Shades of Mort'ton", TeleportBlockerConfig::shadesOfMortton),
    SORCERESS_GARDEN("Sorceress's Garden", TeleportBlockerConfig::sorceressGarden),
    SOUL_WARS("Soul Wars", TeleportBlockerConfig::soulWars),
    TITHE_FARM("Tithe Farm", TeleportBlockerConfig::titheFarm),
    TROUBLE_BREWING("Trouble Brewing", TeleportBlockerConfig::troubleBrewing),
    TZHAAR_FIGHT_PIT("TzHaar Fight Pit", TeleportBlockerConfig::tzhaarFightPit);

    private static final Map<String, Minigame> BY_NAME = buildNameLookup();

    private final String minigameName;
    private final Predicate<TeleportBlockerConfig> blocked;

    Minigame(String minigameName, Predicate<TeleportBlockerConfig> blocked)
    {
        this.minigameName = minigameName;
        this.blocked = blocked;
    }

    private static Map<String, Minigame> buildNameLookup()
    {
        Map<String, Minigame> lookup = new HashMap<>();
        for (Minigame minigame : values())
        {
            lookup.put(TeleportText.key(minigame.minigameName), minigame);
        }
        return Collections.unmodifiableMap(lookup);
    }

    public static Minigame forName(String name)
    {
        return name == null ? null : BY_NAME.get(TeleportText.key(name));
    }

    public boolean isBlocked(TeleportBlockerConfig config)
    {
        return blocked.test(config);
    }

    @Override
    public String toString()
    {
        return minigameName;
    }
}
