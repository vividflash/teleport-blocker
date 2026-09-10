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
import com.vividflash.teleportblocker.JewelleryTeleport;
import com.vividflash.teleportblocker.JewelleryTeleport.Jewellery;
import com.vividflash.teleportblocker.LunarTeleportSpell;
import com.vividflash.teleportblocker.Minigame;
import com.vividflash.teleportblocker.SoulWarsPortal;
import com.vividflash.teleportblocker.StripAndLowercase;
import com.vividflash.teleportblocker.TeleportBlockerConfig;
import com.vividflash.teleportblocker.TeleportSpell;
import com.vividflash.teleportblocker.WildernessLever;
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
import net.runelite.api.ObjectComposition;
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
 * blocked rows of the Minigames window, at blocked canoe map destinations, at
 * blocked portals into Soul Wars, at blocked destinations on worn teleport
 * jewellery and at blocked options of the Wilderness levers, and consumes clicks and
 * number-key presses on blocked options of the rat pit, jewellery and Soul
 * Wars portal dialogues. The spell icons themselves are only touched through the minigame
 * master toggle.
 */
@Singleton
public class TeleportBlockFeature implements KeyListener
{
    private static final String SELECT_OPTION = "Select";

    private static final int CANOE_MAP_LUM = WidgetUtil.componentToInterface(InterfaceID.CanoeMapLum.UNIVERSE);
    private static final int CANOE_MAP_DOUGNE = WidgetUtil.componentToInterface(InterfaceID.CanoeMapDougne.UNIVERSE);

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

    /** Every click option on a scene object, which leaves Examine out. */
    private static final Set<MenuAction> OBJECT_OPTIONS = EnumSet.of(
        MenuAction.GAME_OBJECT_FIRST_OPTION,
        MenuAction.GAME_OBJECT_SECOND_OPTION,
        MenuAction.GAME_OBJECT_THIRD_OPTION,
        MenuAction.GAME_OBJECT_FOURTH_OPTION,
        MenuAction.GAME_OBJECT_FIFTH_OPTION);

    @Inject
    private Client client;

    @Inject
    private TeleportBlockerConfig config;

    @Inject
    private EventBus eventBus;

    @Inject
    private KeyManager keyManager;

    private final Set<Integer> blockedSpellComponents = new HashSet<>();
    private final Set<Minigame> blockedMinigames = EnumSet.noneOf(Minigame.class);
    private final Set<Minigame.RatPit> blockedRatPits = EnumSet.noneOf(Minigame.RatPit.class);
    private final Set<JewelleryTeleport> blockedJewellery = EnumSet.noneOf(JewelleryTeleport.class);
    private final Set<SoulWarsPortal> blockedPortals = EnumSet.noneOf(SoulWarsPortal.class);
    private final Set<CanoeDestination> blockedCanoes = EnumSet.noneOf(CanoeDestination.class);
    private final Set<SoulWarsPortal.Entry> blockedEntryPortals = EnumSet.noneOf(SoulWarsPortal.Entry.class);
    private final Set<WildernessLever.Entry> blockedLeverEntries = EnumSet.noneOf(WildernessLever.Entry.class);
    private final Set<WildernessLever.Destination> blockedLeverDestinations = EnumSet.noneOf(WildernessLever.Destination.class);

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
        blockedSpellComponents.clear();
        blockedMinigames.clear();
        blockedRatPits.clear();
        blockedJewellery.clear();
        blockedPortals.clear();
        blockedCanoes.clear();
        blockedEntryPortals.clear();
        blockedLeverEntries.clear();
        blockedLeverDestinations.clear();
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
        if (blockedSpellComponents.isEmpty() && blockedMinigames.isEmpty() && blockedJewellery.isEmpty()
            && blockedCanoes.isEmpty() && blockedEntryPortals.isEmpty() && blockedLeverEntries.isEmpty()
            && blockedLeverDestinations.isEmpty())
        {
            return;
        }

        Menu menu = client.getMenu();
        MenuEntry[] entries = menu.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(entries)
            .filter(entry -> !isBlockedSpell(entry) && !isBlockedMinigame(entry) && !isBlockedJewellery(entry)
                && !isBlockedCanoe(entry) && !isBlockedEntryPortal(entry) && !isBlockedLeverEntry(entry)
                && !isBlockedLeverDestination(entry))
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
        if (isDialogueBlocking() && isBlockedDialogueClick(event))
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
        if (!isDialogueBlocking())
        {
            return;
        }

        int digit = digitOf(e);
        if (digit > 0 && isBlockedDialogueDigit(digit))
        {
            e.consume();
        }
    }

    private boolean isDialogueBlocking()
    {
        return !blockedRatPits.isEmpty() || !blockedJewellery.isEmpty() || !blockedPortals.isEmpty();
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

        Jewellery item = dialogueItem(lines);
        boolean portal = isPortalDialogue(lines);
        int firstOptionIndex = -1;
        for (int i = 0; i < lines.length; i++)
        {
            if (lines[i] != null && matchesAnyDialogueLine(item, portal, lines[i].getText()))
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

        return isBlockedDialogueLine(item, portal, lines[index].getText());
    }

    /**
     * The item whose rub dialogue the lines belong to, or null when they belong
     * to none. The dialogue carries no marker of the item that opened it, and a
     * portal or an NPC can offer a place a piece of jewellery also travels to,
     * so the lines are read as a rub dialogue only when one item accounts for
     * more of them than any other item and for more than one of them. Every
     * item offers at least two destinations, while a dialogue that only shares
     * a place name offers one.
     */
    private static Jewellery dialogueItem(Widget[] lines)
    {
        Jewellery item = null;
        int most = 0;
        boolean tied = false;

        for (Jewellery candidate : Jewellery.values())
        {
            if (!candidate.hasRubDialogue())
            {
                continue;
            }

            int count = 0;
            for (Widget line : lines)
            {
                if (line != null && JewelleryTeleport.matchesDialogueLine(candidate, plainText(line.getText())))
                {
                    count++;
                }
            }

            if (count > most)
            {
                item = candidate;
                most = count;
                tied = false;
            }
            else if (count == most && count > 0)
            {
                tied = true;
            }
        }

        return most > 1 && !tied ? item : null;
    }

    /**
     * True when the lines are the Soul Wars portal dialogue. That dialogue
     * carries no marker of its own either, and one of the two places it offers
     * is a jewellery destination as well, so it is only recognised when both of
     * them are present.
     */
    private static boolean isPortalDialogue(Widget[] lines)
    {
        for (SoulWarsPortal destination : SoulWarsPortal.values())
        {
            boolean present = false;
            for (Widget line : lines)
            {
                if (line != null && matchesLine(destination.getOptionLine(), plainText(line.getText())))
                {
                    present = true;
                    break;
                }
            }
            if (!present)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean matchesAnyDialogueLine(Jewellery item, boolean portal, String text)
    {
        String line = plainText(text);
        if (line.isEmpty())
        {
            return false;
        }

        for (Minigame.RatPit pit : Minigame.RatPit.values())
        {
            if (matchesLine(pit.getOptionLine(), line))
            {
                return true;
            }
        }
        if (portal)
        {
            for (SoulWarsPortal destination : SoulWarsPortal.values())
            {
                if (matchesLine(destination.getOptionLine(), line))
                {
                    return true;
                }
            }
        }
        return item != null && JewelleryTeleport.matchesDialogueLine(item, line);
    }

    /** True when the text is a blocked line of the dialogue it was read from. */
    private boolean isBlockedDialogueLine(Jewellery item, boolean portal, String text)
    {
        String line = plainText(text);
        if (line.isEmpty())
        {
            return false;
        }

        for (Minigame.RatPit pit : blockedRatPits)
        {
            if (matchesLine(pit.getOptionLine(), line))
            {
                return true;
            }
        }
        if (portal)
        {
            for (SoulWarsPortal destination : blockedPortals)
            {
                if (matchesLine(destination.getOptionLine(), line))
                {
                    return true;
                }
            }
        }
        for (JewelleryTeleport teleport : blockedJewellery)
        {
            if (teleport.getItem() == item && teleport.matchesOption(line))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean matchesLine(String optionLine, String line)
    {
        return !line.isEmpty() && StripAndLowercase.of(optionLine).equals(StripAndLowercase.of(line));
    }

    private static String plainText(String text)
    {
        return text == null ? "" : Text.removeTags(text).trim();
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
        return blockedSpellComponents.contains(entry.getParam1());
    }

    // The canoe map carries its Travel to option on the destination frame
    // rather than on the map pin, and the two maps frame their destinations in
    // a different order, so the place is read from the option text. The
    // interface check keeps those words off anything outside the map.
    private boolean isBlockedCanoe(MenuEntry entry)
    {
        if (blockedCanoes.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }

        int group = WidgetUtil.componentToInterface(entry.getParam1());
        if (group != CANOE_MAP_LUM && group != CANOE_MAP_DOUGNE)
        {
            return false;
        }

        String option = StripAndLowercase.of(plainText(entry.getOption()));
        if (option.isEmpty())
        {
            return false;
        }

        for (CanoeDestination destination : blockedCanoes)
        {
            if (option.contains(StripAndLowercase.of(destination.getDestinationName())))
            {
                return true;
            }
        }
        return false;
    }

    // An object whose look depends on the player's progress reaches the menu
    // under its base id, so the id of the variant on screen is checked too.
    private int variantId(int objectId)
    {
        ObjectComposition composition = client.getObjectDefinition(objectId);
        if (composition == null || composition.getImpostorIds() == null)
        {
            return objectId;
        }
        ObjectComposition variant = composition.getImpostor();
        return variant == null ? objectId : variant.getId();
    }

    // The portals into Soul Wars travel straight from Enter with no dialogue
    // in between, so their options are removed from the menu.
    private boolean isBlockedEntryPortal(MenuEntry entry)
    {
        if (blockedEntryPortals.isEmpty() || !OBJECT_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        int objectId = entry.getIdentifier();
        int variantId = variantId(objectId);
        for (SoulWarsPortal.Entry portal : blockedEntryPortals)
        {
            if (portal.getObjectId() == objectId || portal.getObjectId() == variantId)
            {
                return true;
            }
        }
        return false;
    }

    // The Edgeville and Ardougne levers travel straight from Pull with no
    // dialogue in between, so their option is removed from the menu.
    private boolean isBlockedLeverEntry(MenuEntry entry)
    {
        if (blockedLeverEntries.isEmpty() || !OBJECT_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        int objectId = entry.getIdentifier();
        int variantId = variantId(objectId);
        for (WildernessLever.Entry lever : blockedLeverEntries)
        {
            if (lever.getObjectId() == objectId || lever.getObjectId() == variantId)
            {
                return true;
            }
        }
        return false;
    }

    // The Deserted Keep lever offers its return destinations as click options
    // rather than a chat dialogue. Before the Wilderness Easy Diary its only
    // option is Pull, which goes to Ardougne.
    private boolean isBlockedLeverDestination(MenuEntry entry)
    {
        if (blockedLeverDestinations.isEmpty() || !OBJECT_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        int objectId = entry.getIdentifier();
        int variantId = variantId(objectId);
        if (objectId == WildernessLever.Destination.PRE_DIARY_OBJECT_ID
            || variantId == WildernessLever.Destination.PRE_DIARY_OBJECT_ID)
        {
            return blockedLeverDestinations.contains(WildernessLever.Destination.ARDOUGNE);
        }
        if (!WildernessLever.Destination.isLeverObject(objectId) && !WildernessLever.Destination.isLeverObject(variantId))
        {
            return false;
        }

        String option = plainText(entry.getOption());
        for (WildernessLever.Destination destination : blockedLeverDestinations)
        {
            if (matchesLine(destination.getOptionLine(), option))
            {
                return true;
            }
        }
        return false;
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

        return isBlockedDialogueLine(dialogueItem(lines), isPortalDialogue(lines), lines[index].getText());
    }

    private void rebuildBlocked()
    {
        blockedSpellComponents.clear();
        for (TeleportSpell spell : TeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        for (AncientTeleportSpell spell : AncientTeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        for (LunarTeleportSpell spell : LunarTeleportSpell.values())
        {
            if (spell.isBlocked(config))
            {
                blockedSpellComponents.add(spell.getComponentId());
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
            for (Minigame.RatPit pit : Minigame.RatPit.values())
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

        blockedPortals.clear();
        for (SoulWarsPortal destination : SoulWarsPortal.values())
        {
            if (destination.isBlocked(config))
            {
                blockedPortals.add(destination);
            }
        }

        blockedCanoes.clear();
        for (CanoeDestination destination : CanoeDestination.values())
        {
            if (destination.isBlocked(config))
            {
                blockedCanoes.add(destination);
            }
        }

        blockedEntryPortals.clear();
        for (SoulWarsPortal.Entry portal : SoulWarsPortal.Entry.values())
        {
            if (portal.isBlocked(config))
            {
                blockedEntryPortals.add(portal);
            }
        }

        blockedLeverEntries.clear();
        for (WildernessLever.Entry lever : WildernessLever.Entry.values())
        {
            if (lever.isBlocked(config))
            {
                blockedLeverEntries.add(lever);
            }
        }

        blockedLeverDestinations.clear();
        for (WildernessLever.Destination destination : WildernessLever.Destination.values())
        {
            if (destination.isBlocked(config))
            {
                blockedLeverDestinations.add(destination);
            }
        }
    }
}
