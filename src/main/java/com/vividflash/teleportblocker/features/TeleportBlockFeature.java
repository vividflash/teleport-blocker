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
package com.vividflash.teleportblocker.features;

import com.vividflash.teleportblocker.AncientTeleportSpell;
import com.vividflash.teleportblocker.CanoeDestination;
import com.vividflash.teleportblocker.Jewellery;
import com.vividflash.teleportblocker.JewelleryTeleport;
import com.vividflash.teleportblocker.LunarTeleportSpell;
import com.vividflash.teleportblocker.Minigame;
import com.vividflash.teleportblocker.RatPit;
import com.vividflash.teleportblocker.TeleportBlockerConfig;
import com.vividflash.teleportblocker.TeleportSpell;
import com.vividflash.teleportblocker.TeleportText;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.util.Text;

/**
 * Removes the menu entries pointing at blocked spellbook teleports, at
 * blocked rows of the Minigames window, at blocked canoe map destinations and
 * at blocked destinations on worn teleport jewellery, and consumes clicks and
 * number-key presses on blocked options of the rat pit and jewellery
 * dialogues. The spell icons themselves are only touched through the minigame
 * master toggle.
 */
@Singleton
public class TeleportBlockFeature implements KeyListener
{
    private static final String SELECT_OPTION = "Select";

    /** Line breaks are dropped by removeTags, so they are converted first. */
    private static final Pattern BREAK_TAG = Pattern.compile("(?i)<br\\s*/?>");

    private static final Set<Integer> MINIGAME_ROWS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        InterfaceID.Minigames.MINIGAME_1,
        InterfaceID.Minigames.MINIGAME_2,
        InterfaceID.Minigames.MINIGAME_3,
        InterfaceID.Minigames.MINIGAME_4,
        InterfaceID.Minigames.MINIGAME_5,
        InterfaceID.Minigames.MINIGAME_6,
        InterfaceID.Minigames.MINIGAME_7,
        InterfaceID.Minigames.MINIGAME_8,
        InterfaceID.Minigames.MINIGAME_9,
        InterfaceID.Minigames.MINIGAME_10,
        InterfaceID.Minigames.MINIGAME_11,
        InterfaceID.Minigames.MINIGAME_12,
        InterfaceID.Minigames.MINIGAME_13,
        InterfaceID.Minigames.MINIGAME_14,
        InterfaceID.Minigames.MINIGAME_15,
        InterfaceID.Minigames.MINIGAME_16,
        InterfaceID.Minigames.MINIGAME_17,
        InterfaceID.Minigames.MINIGAME_18,
        InterfaceID.Minigames.MINIGAME_19,
        InterfaceID.Minigames.MINIGAME_20,
        InterfaceID.Minigames.MINIGAME_21)));

    @Inject
    private Client client;

    @Inject
    private TeleportBlockerConfig config;

    @Inject
    private EventBus eventBus;

    @Inject
    private KeyManager keyManager;

    private final Set<Integer> blockedComponents = new HashSet<>();
    private final Set<Minigame> blockedMinigames = EnumSet.noneOf(Minigame.class);
    private final Set<RatPit> blockedRatPits = EnumSet.noneOf(RatPit.class);
    private final Set<JewelleryTeleport> blockedJewellery = EnumSet.noneOf(JewelleryTeleport.class);

    public void startUp()
    {
        rebuildBlocked();
        eventBus.register(this);
        keyManager.registerKeyListener(this);
    }

    public void shutDown()
    {
        keyManager.unregisterKeyListener(this);
        eventBus.unregister(this);
        blockedComponents.clear();
        blockedMinigames.clear();
        blockedRatPits.clear();
        blockedJewellery.clear();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if ("teleportblocker".equals(event.getGroup()))
        {
            rebuildBlocked();
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event)
    {
        if (blockedComponents.isEmpty() && blockedMinigames.isEmpty() && blockedJewellery.isEmpty())
        {
            return;
        }

        Menu menu = client.getMenu();
        MenuEntry[] entries = menu.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(entries)
            .filter(entry -> !isBlockedSpell(entry) && !isBlockedMinigame(entry) && !isBlockedJewellery(entry))
            .toArray(MenuEntry[]::new);

        if (filtered.length != entries.length)
        {
            menu.setMenuEntries(filtered);
        }

        if (!blockedJewellery.isEmpty())
        {
            for (MenuEntry entry : entries)
            {
                filterSubMenu(entry);
            }
        }
    }

    // Rub carries its destinations on a submenu rather than in the top level
    // array, so it is walked separately. Rub itself is never a destination and
    // is left alone even if every destination beneath it is blocked.
    // A submenu line carries only its destination text, the item name sits on
    // the parent, so the item is resolved there and the lines are matched by
    // option alone. Rub and the other parent options never match a destination.
    private void filterSubMenu(MenuEntry entry)
    {
        Menu sub = entry.getSubMenu();
        if (sub == null)
        {
            return;
        }

        String target = entry.getTarget();
        Jewellery parent = target == null ? null : itemOf(Text.removeTags(target).trim());

        MenuEntry[] subEntries = sub.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(subEntries)
            .filter(subEntry -> !isBlockedSubMenuLine(parent, subEntry) && !isBlockedJewellery(subEntry))
            .toArray(MenuEntry[]::new);

        if (filtered.length != subEntries.length)
        {
            sub.setMenuEntries(filtered);
        }
    }

    private static Jewellery itemOf(String target)
    {
        for (Jewellery item : Jewellery.values())
        {
            if (item.matchesTarget(target))
            {
                return item;
            }
        }
        return null;
    }

    private boolean isBlockedSubMenuLine(Jewellery parent, MenuEntry subEntry)
    {
        if (parent == null)
        {
            return false;
        }

        String option = subEntry.getOption();
        if (option == null)
        {
            return false;
        }

        String line = Text.removeTags(option).trim();
        for (JewelleryTeleport teleport : blockedJewellery)
        {
            if (teleport.getItem() == parent && teleport.matchesOption(line))
            {
                return true;
            }
        }
        return false;
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        if ((!blockedRatPits.isEmpty() || !blockedJewellery.isEmpty()) && isBlockedDialogueClick(event))
        {
            event.consume();
        }
    }

    // The number keys pick a dialogue line without going through
    // MenuOptionClicked. The pressed key and the typed key arrive as separate
    // events, so consuming one does not suppress the other and both are taken.
    @Override
    public void keyPressed(KeyEvent e)
    {
        consumeIfBlockedDialogueDigit(e);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        consumeIfBlockedDialogueDigit(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    private void consumeIfBlockedDialogueDigit(KeyEvent e)
    {
        if (blockedRatPits.isEmpty() && blockedJewellery.isEmpty())
        {
            return;
        }

        int digit = digitOf(e);
        if (digit > 0 && isBlockedDialogueDigit(digit))
        {
            e.consume();
        }
    }

    private static int digitOf(KeyEvent e)
    {
        char ch = e.getKeyChar();
        if (ch >= '1' && ch <= '9')
        {
            return ch - '0';
        }

        int code = e.getKeyCode();
        if (code >= KeyEvent.VK_1 && code <= KeyEvent.VK_9)
        {
            return code - KeyEvent.VK_0;
        }
        if (code >= KeyEvent.VK_NUMPAD1 && code <= KeyEvent.VK_NUMPAD9)
        {
            return code - KeyEvent.VK_NUMPAD0;
        }
        return -1;
    }

    /**
     * True when the given 1-based digit currently selects a blocked line of the
     * rat pit or jewellery dialogue. The dialogue title takes a child slot of
     * its own, so the offset comes from locating the first child whose text
     * matches a known destination line rather than from a fixed index.
     */
    private boolean isBlockedDialogueDigit(int digit)
    {
        Widget options = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
        if (options == null)
        {
            return false;
        }

        Widget[] lines = options.getDynamicChildren();
        if (lines == null || lines.length == 0)
        {
            return false;
        }

        int firstOptionIndex = -1;
        for (int i = 0; i < lines.length; i++)
        {
            if (lines[i] != null && matchesAnyDialogueLine(lines[i].getText()))
            {
                firstOptionIndex = i;
                break;
            }
        }
        if (firstOptionIndex < 0)
        {
            return false;
        }

        int index = firstOptionIndex + digit - 1;
        if (index < 0 || index >= lines.length || lines[index] == null)
        {
            return false;
        }

        return isBlockedDialogueLine(lines[index].getText());
    }

    private static boolean matchesAnyDialogueLine(String text)
    {
        if (text == null)
        {
            return false;
        }

        String line = Text.removeTags(text).trim();
        for (RatPit pit : RatPit.values())
        {
            if (TeleportText.key(pit.getOptionLine()).equals(TeleportText.key(line)))
            {
                return true;
            }
        }
        return JewelleryTeleport.matchesAnyDialogueLine(line);
    }

    /** True when the text is a blocked rat pit or jewellery destination. */
    private boolean isBlockedDialogueLine(String text)
    {
        if (text == null)
        {
            return false;
        }

        String line = Text.removeTags(text).trim();
        for (RatPit pit : blockedRatPits)
        {
            if (TeleportText.key(pit.getOptionLine()).equals(TeleportText.key(line)))
            {
                return true;
            }
        }
        for (JewelleryTeleport teleport : blockedJewellery)
        {
            if (teleport.getItem().hasRubDialogue() && teleport.matchesOption(line))
            {
                return true;
            }
        }
        return false;
    }

    // CC_OP_LOW_PRIORITY carries op index 6 and above, where the alternate
    // destinations sit (Varrock Configure, house Group entries, Camelot
    // Toggle-location), so matching CC_OP alone would leave them clickable.
    private boolean isBlockedSpell(MenuEntry entry)
    {
        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }
        return blockedComponents.contains(entry.getParam1());
    }

    private boolean isBlockedMinigame(MenuEntry entry)
    {
        if (blockedMinigames.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }

        int component = entry.getParam1();
        if (!MINIGAME_ROWS.contains(component))
        {
            return false;
        }

        String option = entry.getOption();
        if (option == null || !SELECT_OPTION.equalsIgnoreCase(Text.removeTags(option).trim()))
        {
            return false;
        }

        Minigame minigame = Minigame.forName(rowName(client.getWidget(component)));
        return minigame != null && blockedMinigames.contains(minigame);
    }

    /**
     * The name a row prints, which is its first line. The location sits either
     * below the name in the same widget or on a child of it, so both are tried.
     * A row whose name cannot be read returns null and is left alone.
     */
    private static String rowName(Widget row)
    {
        if (row == null)
        {
            return null;
        }

        String name = firstLine(row.getText());
        if (name != null)
        {
            return name;
        }

        Widget[][] childArrays = {row.getStaticChildren(), row.getDynamicChildren(), row.getNestedChildren()};
        for (Widget[] children : childArrays)
        {
            if (children == null)
            {
                continue;
            }
            for (Widget child : children)
            {
                if (child == null)
                {
                    continue;
                }
                name = firstLine(child.getText());
                if (name != null)
                {
                    return name;
                }
            }
        }
        return null;
    }

    private static String firstLine(String text)
    {
        if (text == null)
        {
            return null;
        }

        String plain = Text.removeTags(BREAK_TAG.matcher(text).replaceAll("\n")).replace('\r', '\n');
        int end = plain.indexOf('\n');
        if (end >= 0)
        {
            plain = plain.substring(0, end);
        }
        plain = plain.trim();
        return plain.isEmpty() ? null : plain;
    }

    // Every destination of one item shares its equipment slot component, so the
    // option text tells them apart, and the target carries the item name so a
    // destination word cannot be read off an unrelated widget. Charge variants
    // print the same option text, so no item ids are needed. The item's default
    // op in the inventory carries no target at all, so that one entry is
    // matched on its option text alone.
    private boolean isBlockedJewellery(MenuEntry entry)
    {
        if (blockedJewellery.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }

        String option = entry.getOption();
        if (option == null)
        {
            return false;
        }

        String target = entry.getTarget();
        String itemName = target == null ? "" : Text.removeTags(target).trim();
        int component = entry.getParam1();
        boolean bareOnInventory = itemName.isEmpty() && WidgetUtil.componentToInterface(component) == InterfaceID.INVENTORY;

        String line = Text.removeTags(option).trim();
        for (JewelleryTeleport teleport : blockedJewellery)
        {
            Jewellery item = teleport.getItem();
            if (!teleport.matchesOption(line))
            {
                continue;
            }
            if (bareOnInventory || (onItemMenu(item, component) && item.matchesTarget(itemName)))
            {
                return true;
            }
        }
        return false;
    }

    // The destinations sit on the equipment slot while the item is worn and on
    // the inventory interface while it is not, so both are matched. The target
    // check keeps the option words off any other item in the bag.
    private static boolean onItemMenu(Jewellery item, int component)
    {
        return component == item.getWornComponentId()
            || WidgetUtil.componentToInterface(component) == InterfaceID.INVENTORY;
    }

    /** True when the click landed on a blocked line of a destination dialogue. */
    private boolean isBlockedDialogueClick(MenuOptionClicked event)
    {
        if (event.getParam1() != InterfaceID.Chatmenu.OPTIONS)
        {
            return false;
        }

        Widget options = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
        if (options == null)
        {
            return false;
        }

        Widget[] lines = options.getDynamicChildren();
        int index = event.getParam0();
        if (lines == null || index < 0 || index >= lines.length || lines[index] == null)
        {
            return false;
        }

        return isBlockedDialogueLine(lines[index].getText());
    }

    private void rebuildBlocked()
    {
        blockedComponents.clear();
        for (TeleportSpell spell : TeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedComponents.add(spell.getComponentId());
            }
        }
        for (AncientTeleportSpell spell : AncientTeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedComponents.add(spell.getComponentId());
            }
        }
        for (LunarTeleportSpell spell : LunarTeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedComponents.add(spell.getComponentId());
            }
        }
        for (CanoeDestination destination : CanoeDestination.values())
        {
            if (destination.isBlocked(config))
            {
                blockedComponents.add(destination.getComponentId());
            }
        }

        blockedMinigames.clear();
        if (!config.blockAllMinigames())
        {
            for (Minigame minigame : Minigame.values())
            {
                if (minigame.isBlocked(config))
                {
                    blockedMinigames.add(minigame);
                }
            }
        }

        blockedRatPits.clear();
        if (!config.blockAllMinigames() && !blockedMinigames.contains(Minigame.RAT_PITS))
        {
            for (RatPit pit : RatPit.values())
            {
                if (pit.isBlocked(config))
                {
                    blockedRatPits.add(pit);
                }
            }
        }

        blockedJewellery.clear();
        for (JewelleryTeleport teleport : JewelleryTeleport.values())
        {
            if (teleport.isBlocked(config))
            {
                blockedJewellery.add(teleport);
            }
        }
    }
}
