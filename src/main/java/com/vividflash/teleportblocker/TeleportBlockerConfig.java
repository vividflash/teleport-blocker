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

@ConfigGroup("teleportblocker")
public interface TeleportBlockerConfig extends Config
{
    @ConfigItem(
        keyName = "homeTeleport",
        name = "Home Teleport",
        description = "Removes the click options from Home Teleport.",
        position = 0
    )
    default boolean homeTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "minigameTeleport",
        name = "Minigame Teleport",
        description = "Removes the click options from Minigame Teleport.",
        position = 1
    )
    default boolean minigameTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "varrockTeleport",
        name = "Varrock Teleport",
        description = "Removes the click options from Varrock Teleport, including the Configure option for the Grand Exchange destination.",
        position = 2
    )
    default boolean varrockTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "lumbridgeTeleport",
        name = "Lumbridge Teleport",
        description = "Removes the click options from Lumbridge Teleport.",
        position = 3
    )
    default boolean lumbridgeTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "faladorTeleport",
        name = "Falador Teleport",
        description = "Removes the click options from Falador Teleport.",
        position = 4
    )
    default boolean faladorTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "houseTeleport",
        name = "Teleport to House",
        description = "Removes the click options from Teleport to House, including Outside, Inside and the Group entries.",
        position = 5
    )
    default boolean houseTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "camelotTeleport",
        name = "Camelot Teleport",
        description = "Removes the click options from Camelot Teleport, including the Toggle-location option for the Seers' Village destination.",
        position = 6
    )
    default boolean camelotTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "kourendTeleport",
        name = "Kourend Castle Teleport",
        description = "Removes the click options from Kourend Castle Teleport.",
        position = 7
    )
    default boolean kourendTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "ardougneTeleport",
        name = "Ardougne Teleport",
        description = "Removes the click options from Ardougne Teleport.",
        position = 8
    )
    default boolean ardougneTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "fortisTeleport",
        name = "Civitas illa Fortis Teleport",
        description = "Removes the click options from Civitas illa Fortis Teleport.",
        position = 9
    )
    default boolean fortisTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "watchtowerTeleport",
        name = "Watchtower Teleport",
        description = "Removes the click options from Watchtower Teleport, including the toggle for the Yanille destination.",
        position = 10
    )
    default boolean watchtowerTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "trollheimTeleport",
        name = "Trollheim Teleport",
        description = "Removes the click options from Trollheim Teleport.",
        position = 11
    )
    default boolean trollheimTeleport()
    {
        return true;
    }

    @ConfigItem(
        keyName = "apeAtollTeleport",
        name = "Ape Atoll Teleport",
        description = "Removes the click options from Ape Atoll Teleport.",
        position = 12
    )
    default boolean apeAtollTeleport()
    {
        return true;
    }





}
