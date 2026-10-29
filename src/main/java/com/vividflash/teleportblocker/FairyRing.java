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

// Fairy ring codes in alphabetical order, each paired with the toggle that blocks it.
public enum FairyRing
{
    AIP(TeleportBlockerConfig::fairyRingAIP),
    AIQ(TeleportBlockerConfig::fairyRingAIQ),
    AIR(TeleportBlockerConfig::fairyRingAIR),
    AIS(TeleportBlockerConfig::fairyRingAIS),
    AJP(TeleportBlockerConfig::fairyRingAJP),
    AJQ(TeleportBlockerConfig::fairyRingAJQ),
    AJR(TeleportBlockerConfig::fairyRingAJR),
    AJS(TeleportBlockerConfig::fairyRingAJS),
    AKP(TeleportBlockerConfig::fairyRingAKP),
    AKQ(TeleportBlockerConfig::fairyRingAKQ),
    AKR(TeleportBlockerConfig::fairyRingAKR),
    AKS(TeleportBlockerConfig::fairyRingAKS),
    ALP(TeleportBlockerConfig::fairyRingALP),
    ALQ(TeleportBlockerConfig::fairyRingALQ),
    ALR(TeleportBlockerConfig::fairyRingALR),
    ALS(TeleportBlockerConfig::fairyRingALS),
    BIP(TeleportBlockerConfig::fairyRingBIP),
    BIQ(TeleportBlockerConfig::fairyRingBIQ),
    BIR(TeleportBlockerConfig::fairyRingBIR),
    BIS(TeleportBlockerConfig::fairyRingBIS),
    BJP(TeleportBlockerConfig::fairyRingBJP),
    BJQ(TeleportBlockerConfig::fairyRingBJQ),
    BJR(TeleportBlockerConfig::fairyRingBJR),
    BJS(TeleportBlockerConfig::fairyRingBJS),
    BKP(TeleportBlockerConfig::fairyRingBKP),
    BKQ(TeleportBlockerConfig::fairyRingBKQ),
    BKR(TeleportBlockerConfig::fairyRingBKR),
    BKS(TeleportBlockerConfig::fairyRingBKS),
    BLP(TeleportBlockerConfig::fairyRingBLP),
    BLQ(TeleportBlockerConfig::fairyRingBLQ),
    BLR(TeleportBlockerConfig::fairyRingBLR),
    BLS(TeleportBlockerConfig::fairyRingBLS),
    CIP(TeleportBlockerConfig::fairyRingCIP),
    CIQ(TeleportBlockerConfig::fairyRingCIQ),
    CIR(TeleportBlockerConfig::fairyRingCIR),
    CIS(TeleportBlockerConfig::fairyRingCIS),
    CJP(TeleportBlockerConfig::fairyRingCJP),
    CJQ(TeleportBlockerConfig::fairyRingCJQ),
    CJR(TeleportBlockerConfig::fairyRingCJR),
    CJS(TeleportBlockerConfig::fairyRingCJS),
    CKP(TeleportBlockerConfig::fairyRingCKP),
    CKQ(TeleportBlockerConfig::fairyRingCKQ),
    CKR(TeleportBlockerConfig::fairyRingCKR),
    CKS(TeleportBlockerConfig::fairyRingCKS),
    CLP(TeleportBlockerConfig::fairyRingCLP),
    CLQ(TeleportBlockerConfig::fairyRingCLQ),
    CLR(TeleportBlockerConfig::fairyRingCLR),
    CLS(TeleportBlockerConfig::fairyRingCLS),
    DIP(TeleportBlockerConfig::fairyRingDIP),
    DIQ(TeleportBlockerConfig::fairyRingDIQ),
    DIR(TeleportBlockerConfig::fairyRingDIR),
    DIS(TeleportBlockerConfig::fairyRingDIS),
    DJP(TeleportBlockerConfig::fairyRingDJP),
    DJQ(TeleportBlockerConfig::fairyRingDJQ),
    DJR(TeleportBlockerConfig::fairyRingDJR),
    DJS(TeleportBlockerConfig::fairyRingDJS),
    DKP(TeleportBlockerConfig::fairyRingDKP),
    DKQ(TeleportBlockerConfig::fairyRingDKQ),
    DKR(TeleportBlockerConfig::fairyRingDKR),
    DKS(TeleportBlockerConfig::fairyRingDKS),
    DLP(TeleportBlockerConfig::fairyRingDLP),
    DLQ(TeleportBlockerConfig::fairyRingDLQ),
    DLR(TeleportBlockerConfig::fairyRingDLR),
    DLS(TeleportBlockerConfig::fairyRingDLS);

    private static final FairyRing[] CODES = values();

    private final Predicate<TeleportBlockerConfig> blocked;

    FairyRing(Predicate<TeleportBlockerConfig> blocked)
    {
        this.blocked = blocked;
    }

    public boolean isBlocked(TeleportBlockerConfig config)
    {
        return blocked.test(config);
    }

    // The ring for the three dial values, or null when a dial value is outside 0 to 3.
    public static FairyRing fromDials(int left, int middle, int right)
    {
        if (left < 0 || left > 3 || middle < 0 || middle > 3 || right < 0 || right > 3)
        {
            return null;
        }
        // A dial value counts letters backwards: 0, 1, 2, 3 is A, D, C, B.
        return CODES[(4 - left) % 4 * 16 + (4 - middle) % 4 * 4 + (4 - right) % 4];
    }
}
