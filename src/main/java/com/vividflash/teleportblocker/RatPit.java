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
 * The four destinations the rat pit dialogue offers, each paired with its
 * option line and the toggle that blocks it. Cancel is not listed and is never
 * touched.
 */
public enum RatPit
{
    ARDOUGNE("Ardougne (kittens)", TeleportBlockerConfig::ratPitsArdougne),
    VARROCK("Varrock (grown cats)", TeleportBlockerConfig::ratPitsVarrock),
    KELDAGRIM("Keldagrim (overgrown cats)", TeleportBlockerConfig::ratPitsKeldagrim),
    PORT_SARIM("Port Sarim (wily cats)", TeleportBlockerConfig::ratPitsPortSarim);

    private final String optionLine;
    private final Predicate<TeleportBlockerConfig> blocked;

    RatPit(String optionLine, Predicate<TeleportBlockerConfig> blocked)
    {
        this.optionLine = optionLine;
        this.blocked = blocked;
    }

    public String getOptionLine()
    {
        return optionLine;
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
