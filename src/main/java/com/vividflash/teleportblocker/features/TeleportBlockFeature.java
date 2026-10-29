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
import com.vividflash.teleportblocker.ArceuusTeleportSpell;
import com.vividflash.teleportblocker.Boat;
import com.vividflash.teleportblocker.CanoeDestination;
import com.vividflash.teleportblocker.CharterShip;
import com.vividflash.teleportblocker.FairyRing;
import com.vividflash.teleportblocker.FossilIsland;
import com.vividflash.teleportblocker.GnomeGlider;
import com.vividflash.teleportblocker.ItemTeleport;
import com.vividflash.teleportblocker.ItemTeleport.Item;
import com.vividflash.teleportblocker.LovakengjMinecart;
import com.vividflash.teleportblocker.LunarTeleportSpell;
import com.vividflash.teleportblocker.Minigame;
import com.vividflash.teleportblocker.MountainGuide;
import com.vividflash.teleportblocker.Mushtree;
import com.vividflash.teleportblocker.QuetzalTransport;
import com.vividflash.teleportblocker.Ship;
import com.vividflash.teleportblocker.SoulWarsPortal;
import com.vividflash.teleportblocker.SpiritTree;
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
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ObjectComposition;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetClosed;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.util.Text;

// Removes the menu entries pointing at blocked spellbook teleports, at blocked rows of the
// Minigames window, at blocked canoe map destinations, at blocked portals into Soul Wars, at
// blocked destinations on worn teleport jewellery, at blocked options of the Wilderness levers, at
// blocked lines of the spirit tree list and at the trees' Last-destination option, at blocked
// glider map destinations and at the pilots' Glider option, at blocked quetzal map landing sites
// and legs of the Varrock quetzal route, at the quetzals' and whistles' Last-destination option and
// at a whistle's Signal set to fly to a blocked Hunter Guild, at blocked lines of the Lovakengj
// minecart station list, at blocked charter ports and the crews' Charter-to option, at the options
// of blocked ship legs, boat trips and Mountain Guide trips, at the fairy ring dials' Confirm for a
// blocked code and the rings' Zanaris, Last and Favourites options, and at blocked lines of a boat
// picker, and consumes clicks and number-key presses on blocked options of the rat pit, jewellery
// and Soul Wars portal dialogues, of the charter confirm dialogue, of ship and Mountain Guide chats
// and of boat pickers, as well as shortcut key presses on blocked spirit tree, minecart, charter
// and boat picker lines. The spell icons themselves are only touched through the Minigame Teleport
// toggles.
@Slf4j
@Singleton
public class TeleportBlockFeature implements KeyListener
{
    private static final String SELECT_OPTION = "Select";
    // The option of a destination button that a map drawn over a list by another plugin adds.
    private static final String TRAVEL_OPTION = "Travel";

    private static final String SPIRIT_TREE_TITLE_KEY = StripAndLowercase.of(SpiritTree.TITLE);
    private static final String SPIRIT_TREE_PREVIOUS_KEY = StripAndLowercase.of(SpiritTree.PREVIOUS_OPTION);
    private static final String SPIRIT_TREE_OBJECT_KEY = StripAndLowercase.of(SpiritTree.OBJECT_NAME);
    private static final String QUETZAL_PREVIOUS_KEY = StripAndLowercase.of(QuetzalTransport.PREVIOUS_OPTION);
    private static final String QUETZAL_SIGNAL_KEY = StripAndLowercase.of(QuetzalTransport.SIGNAL_OPTION);
    private static final String SHIP_TALK_KEY = StripAndLowercase.of(Ship.TALK_OPTION);
    private static final String CHARTER_CONFIRM_KEY = StripAndLowercase.of(CharterShip.CONFIRM_OPTION);

    private static final int CANOE_MAP_LUM = WidgetUtil.componentToInterface(InterfaceID.CanoeMapLum.UNIVERSE);
    private static final int CANOE_MAP_DOUGNE = WidgetUtil.componentToInterface(InterfaceID.CanoeMapDougne.UNIVERSE);

    // Line breaks are dropped by removeTags, so they are converted first.
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

    // Every click option on a scene object, which leaves Examine out.
    private static final Set<MenuAction> OBJECT_OPTIONS = EnumSet.of(
        MenuAction.GAME_OBJECT_FIRST_OPTION,
        MenuAction.GAME_OBJECT_SECOND_OPTION,
        MenuAction.GAME_OBJECT_THIRD_OPTION,
        MenuAction.GAME_OBJECT_FOURTH_OPTION,
        MenuAction.GAME_OBJECT_FIFTH_OPTION);

    // The fairy ring objects whose menu carries Zanaris, Last and Favourites.
    private static final Set<Integer> FAIRY_RING_OBJECTS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        ObjectID.FAIRYRING_MINORHUB,
        ObjectID.FAIRYRING_HOMEHUB)));

    // The objects that show a checked object as a variant, so only their definition is read.
    private static final Set<Integer> VARIANT_BASE_OBJECTS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
        WildernessLever.Destination.VARIANT_BASE_OBJECT_ID,
        Boat.VARIANT_BASE_OBJECT_ID,
        FossilIsland.VARIANT_BASE_OBJECT_ID)));
    private static final Pattern FAIRY_RING_CODE = Pattern.compile("(?<![A-Za-z])\\(?([A-D][IJKL][PQRS])\\)?$");
    private static final String FAIRY_RING_ZANARIS = "Zanaris";
    private static final String FAIRY_RING_LAST = "Last: ";
    private static final String FAIRY_RING_FAVOURITES = "Favourites";

    // Every click option on an NPC, which leaves Examine out.
    private static final Set<MenuAction> NPC_OPTIONS = EnumSet.of(
        MenuAction.NPC_FIRST_OPTION,
        MenuAction.NPC_SECOND_OPTION,
        MenuAction.NPC_THIRD_OPTION,
        MenuAction.NPC_FOURTH_OPTION,
        MenuAction.NPC_FIFTH_OPTION);

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
    private final Set<ItemTeleport> blockedItemTeleports = EnumSet.noneOf(ItemTeleport.class);
    private final Set<SoulWarsPortal> blockedPortals = EnumSet.noneOf(SoulWarsPortal.class);
    private final Set<CanoeDestination> blockedCanoes = EnumSet.noneOf(CanoeDestination.class);
    private final Set<SoulWarsPortal.Entry> blockedEntryPortals = EnumSet.noneOf(SoulWarsPortal.Entry.class);
    private final Set<WildernessLever.Entry> blockedLeverEntries = EnumSet.noneOf(WildernessLever.Entry.class);
    private final Set<WildernessLever.Destination> blockedLeverDestinations = EnumSet.noneOf(WildernessLever.Destination.class);
    private final Set<SpiritTree.Destination> blockedSpiritTrees = EnumSet.noneOf(SpiritTree.Destination.class);
    private boolean blockSpiritTreePrevious;
    private final Set<GnomeGlider.Destination> blockedGliders = EnumSet.noneOf(GnomeGlider.Destination.class);
    private boolean blockGliderPrevious;
    private final Set<QuetzalTransport.Destination> blockedQuetzalDestinations = EnumSet.noneOf(QuetzalTransport.Destination.class);
    private final Set<QuetzalTransport.Route> blockedQuetzalRoutes = EnumSet.noneOf(QuetzalTransport.Route.class);
    private boolean blockQuetzalPrevious;
    private final Set<LovakengjMinecart.Station> blockedMinecartStations = EnumSet.noneOf(LovakengjMinecart.Station.class);
    private final Set<CharterShip.Port> blockedCharterPorts = EnumSet.noneOf(CharterShip.Port.class);
    private boolean blockCharterPrevious;
    private final Set<Ship.Leg> blockedShipLegs = EnumSet.noneOf(Ship.Leg.class);
    private final Set<Boat.Destination> blockedBoats = EnumSet.noneOf(Boat.Destination.class);
    private final Set<FossilIsland.Destination> blockedFossilIsland = EnumSet.noneOf(FossilIsland.Destination.class);
    private final Set<Mushtree.Destination> blockedMushtrees = EnumSet.noneOf(Mushtree.Destination.class);
    private final Set<MountainGuide.Destination> blockedMountainGuides = EnumSet.noneOf(MountainGuide.Destination.class);
    private final Set<FairyRing> blockedFairyRings = EnumSet.noneOf(FairyRing.class);
    private boolean blockFairyRingPrevious;

    // The legs of the ship NPC clicked last, whose chat lines are read until the next click outside
    // a dialogue.
    private final Set<Ship.Leg> talkLegs = EnumSet.noneOf(Ship.Leg.class);
    // The boat whose picker or chat was opened last, or null.
    private Boat.Network pickerNetwork;
    // True when a Fossil Island rowboat's picker was opened last.
    private boolean fossilPicker;
    // True once the remembered boat's picker has opened, so its closing forgets the boat.
    private boolean pickerOpened;
    // True when a Mountain Guide around Mount Quidamortem was clicked last, whose chat lines are
    // read until the next click outside a dialogue.
    private boolean mountainGuideChat;

    // The variant id of the entry being checked, computed at most once per entry.
    private boolean variantKnown;
    private int entryVariantId;
    // True while the chartering menu is loaded, so its widget is only read then.
    private boolean charterMenuLoaded;
    // The list and group logged as recognised last, so each is logged once per opening.
    private String loggedList;
    private int loggedListGroup;
    // The map button logged as removed last.
    private String loggedMapButton;

    public void startUp()
    {
        log.debug("[state] startUp");
        rebuildBlocked();
        eventBus.register(this);
        keyManager.registerKeyListener(this);
    }

    public void shutDown()
    {
        log.debug("[state] shutDown");
        keyManager.unregisterKeyListener(this);
        eventBus.unregister(this);
        blockedSpellComponents.clear();
        blockedMinigames.clear();
        blockedRatPits.clear();
        blockedItemTeleports.clear();
        blockedPortals.clear();
        blockedCanoes.clear();
        blockedEntryPortals.clear();
        blockedLeverEntries.clear();
        blockedLeverDestinations.clear();
        blockedSpiritTrees.clear();
        blockSpiritTreePrevious = false;
        blockedGliders.clear();
        blockGliderPrevious = false;
        blockedQuetzalDestinations.clear();
        blockedQuetzalRoutes.clear();
        blockQuetzalPrevious = false;
        blockedMinecartStations.clear();
        blockedCharterPorts.clear();
        blockCharterPrevious = false;
        blockedShipLegs.clear();
        blockedBoats.clear();
        blockedFossilIsland.clear();
        blockedMushtrees.clear();
        blockedMountainGuides.clear();
        blockedFairyRings.clear();
        blockFairyRingPrevious = false;
        talkLegs.clear();
        pickerNetwork = null;
        fossilPicker = false;
        pickerOpened = false;
        mountainGuideChat = false;
        charterMenuLoaded = false;
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
        if (!isFiltering())
        {
            return;
        }

        MenuEntry entry = event.getMenuEntry();
        if (isBlocked(entry))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[menu] removed option={} target={} type={}", entry.getOption(), entry.getTarget(), entry.getType());
            }
            client.getMenu().removeMenuEntry(entry);
        }
    }

    // An opened menu is filtered again, for a ring's Last option and
    // Favourites rows.
    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {
        filterMenu();
    }

    private boolean isFiltering()
    {
        return !(blockedSpellComponents.isEmpty() && blockedMinigames.isEmpty() && blockedItemTeleports.isEmpty()
            && blockedCanoes.isEmpty() && blockedEntryPortals.isEmpty() && blockedLeverEntries.isEmpty()
            && blockedLeverDestinations.isEmpty() && blockedSpiritTrees.isEmpty() && !blockSpiritTreePrevious
            && blockedGliders.isEmpty() && !blockGliderPrevious && blockedQuetzalDestinations.isEmpty()
            && blockedQuetzalRoutes.isEmpty() && !blockQuetzalPrevious && blockedMinecartStations.isEmpty()
            && blockedCharterPorts.isEmpty() && !blockCharterPrevious && blockedShipLegs.isEmpty() && blockedBoats.isEmpty()
            && blockedFossilIsland.isEmpty() && blockedMushtrees.isEmpty() && blockedMountainGuides.isEmpty()
            && blockedFairyRings.isEmpty() && !blockFairyRingPrevious);
    }

    // Submenus are walked on this full pass only, which runs before the menu
    // shows.
    private void filterMenu()
    {
        if (!isFiltering())
        {
            return;
        }

        Menu menu = client.getMenu();
        MenuEntry[] entries = menu.getMenuEntries();

        Set<MenuEntry> emptiedFavourites = null;
        if (!blockedItemTeleports.isEmpty() || !blockedFairyRings.isEmpty())
        {
            for (MenuEntry entry : entries)
            {
                if (!blockedItemTeleports.isEmpty())
                {
                    filterSubMenu(entry);
                }
                if (filterFairyRingFavourites(entry))
                {
                    if (emptiedFavourites == null)
                    {
                        emptiedFavourites = new HashSet<>();
                    }
                    emptiedFavourites.add(entry);
                }
            }
        }

        MenuEntry[] filtered = null;
        int kept = 0;
        for (int i = 0; i < entries.length; i++)
        {
            MenuEntry entry = entries[i];
            if (isBlocked(entry) || (emptiedFavourites != null && emptiedFavourites.contains(entry)))
            {
                if (filtered == null)
                {
                    filtered = new MenuEntry[entries.length - 1];
                    System.arraycopy(entries, 0, filtered, 0, i);
                    kept = i;
                }
            }
            else if (filtered != null)
            {
                filtered[kept++] = entry;
            }
        }

        if (filtered != null)
        {
            if (log.isDebugEnabled())
            {
                log.debug("[menu] opened menu filtered, {} of {} entries kept", kept, entries.length);
            }
            menu.setMenuEntries(kept == filtered.length ? filtered : Arrays.copyOf(filtered, kept));
        }
    }

    private boolean isBlocked(MenuEntry entry)
    {
        variantKnown = false;
        return isBlockedSpell(entry) || isBlockedMinigame(entry) || isBlockedItemTeleport(entry)
            || isBlockedCanoe(entry) || isBlockedEntryPortal(entry) || isBlockedLeverEntry(entry)
            || isBlockedLeverDestination(entry) || isBlockedSpiritTree(entry)
            || isBlockedSpiritTreePrevious(entry) || isBlockedGlider(entry) || isBlockedGliderPrevious(entry)
            || isBlockedQuetzalMap(entry) || isBlockedQuetzalRoute(entry) || isBlockedQuetzalPrevious(entry)
            || isBlockedWhistleSignal(entry) || isBlockedMinecart(entry) || isBlockedCharter(entry)
            || isBlockedCharterPrevious(entry) || isBlockedShip(entry) || isBlockedBoat(entry)
            || isBlockedBoatList(entry) || isBlockedFossilIsland(entry) || isBlockedMushtree(entry) || isBlockedMountainGuide(entry)
            || isBlockedFairyRingConfirm(entry) || isBlockedFairyRingOption(entry);
    }

    private int entryVariantId(MenuEntry entry)
    {
        if (!variantKnown)
        {
            entryVariantId = variantId(entry.getIdentifier());
            variantKnown = true;
        }
        return entryVariantId;
    }

    // The Favourites rows sit on a submenu of the ring's Favourites option.
    // Returns true when every row was removed, so the parent goes with them.
    private boolean filterFairyRingFavourites(MenuEntry entry)
    {
        Menu sub = entry.getSubMenu();
        if (sub == null || blockedFairyRings.isEmpty() || !isFairyRingObject(entry)
            || !FAIRY_RING_FAVOURITES.equals(plainText(entry.getOption())))
        {
            return false;
        }

        MenuEntry[] subEntries = sub.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(subEntries)
            .filter(subEntry -> !isBlockedFairyRingOption(subEntry))
            .toArray(MenuEntry[]::new);

        if (filtered.length == subEntries.length)
        {
            return false;
        }
        if (log.isDebugEnabled())
        {
            log.debug("[menu] favourites submenu filtered, {} of {} rows kept", filtered.length, subEntries.length);
        }
        sub.setMenuEntries(filtered);
        return filtered.length == 0;
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
        Item parent = target == null ? null : itemOf(Text.removeTags(target).trim());

        MenuEntry[] subEntries = sub.getMenuEntries();
        MenuEntry[] filtered = Arrays.stream(subEntries)
            .filter(subEntry -> !isBlockedSubMenuLine(parent, subEntry) && !isBlockedItemTeleport(subEntry))
            .toArray(MenuEntry[]::new);

        if (filtered.length != subEntries.length)
        {
            if (log.isDebugEnabled())
            {
                log.debug("[menu] submenu of {} filtered, {} of {} lines kept", target, filtered.length, subEntries.length);
            }
            sub.setMenuEntries(filtered);
        }
    }

    private static Item itemOf(String target)
    {
        for (Item item : Item.values())
        {
            if (item.matchesTarget(target))
            {
                return item;
            }
        }
        return null;
    }

    private boolean isBlockedSubMenuLine(Item parent, MenuEntry subEntry)
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
        for (ItemTeleport teleport : blockedItemTeleports)
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
        if (log.isDebugEnabled())
        {
            int clickedGroup = WidgetUtil.componentToInterface(event.getMenuEntry().getParam1());
            if (clickedGroup == InterfaceID.MENU || clickedGroup == InterfaceID.MENU_NEW)
            {
                logListClick(event.getMenuEntry());
            }
        }
        if (isDialogueBlocking() && isBlockedDialogueClick(event))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[click] consumed dialogue click option={} target={}", event.getMenuOption(), event.getMenuTarget());
            }
            event.consume();
        }
        if (isBlockedFairyRingConfirm(event.getMenuEntry()) || isBlockedFairyRingOption(event.getMenuEntry()))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[click] consumed fairy ring click option={} target={}", event.getMenuOption(), event.getMenuTarget());
            }
            event.consume();
        }
        rememberTransport(event.getMenuEntry());
    }

    // The chat of a ship NPC and the picker of a boat do not say who opened
    // them, so the NPC or boat clicked last is remembered until the next click
    // outside a dialogue, and a boat also until its picker closes.
    private void rememberTransport(MenuEntry entry)
    {
        if (isDialogueAction(entry))
        {
            return;
        }

        talkLegs.clear();
        pickerNetwork = null;
        fossilPicker = false;
        pickerOpened = false;
        mountainGuideChat = false;

        MenuAction action = entry.getType();
        if (NPC_OPTIONS.contains(action))
        {
            if (!blockedShipLegs.isEmpty())
            {
                for (Ship.Leg leg : Ship.Leg.values())
                {
                    if (npcMatches(entry, leg::isLegNpc))
                    {
                        if (log.isDebugEnabled())
                        {
                            log.debug("[transport] ship npc clicked, remembered leg={}", leg);
                        }
                        talkLegs.add(leg);
                    }
                }
            }
            if (!blockedBoats.isEmpty())
            {
                for (Boat.Network network : Boat.Network.values())
                {
                    if (npcMatches(entry, network::isTalkNpc))
                    {
                        if (log.isDebugEnabled())
                        {
                            log.debug("[transport] boat npc clicked, remembered network={}", network);
                        }
                        pickerNetwork = network;
                    }
                }
            }
            mountainGuideChat = !blockedMountainGuides.isEmpty() && npcMatches(entry, MountainGuide::isQuidamortemGuide);
            if (mountainGuideChat)
            {
                if (log.isDebugEnabled())
                {
                    log.debug("[transport] mountain guide clicked, chat lines watched");
                }
            }
        }
        else if (OBJECT_OPTIONS.contains(action) && (!blockedBoats.isEmpty() || !blockedFossilIsland.isEmpty()))
        {
            int objectId = entry.getIdentifier();
            int variantId = variantId(objectId);
            String option = plainText(entry.getOption());
            for (Boat.Network network : Boat.Network.values())
            {
                if (network.opensPicker(objectId, option) || network.opensPicker(variantId, option))
                {
                    if (log.isDebugEnabled())
                    {
                        log.debug("[transport] boat object clicked, remembered network={} option={}", network, option);
                    }
                    pickerNetwork = network;
                }
            }
            fossilPicker = FossilIsland.opensPicker(objectId, option) || FossilIsland.opensPicker(variantId, option);
            if (fossilPicker)
            {
                if (log.isDebugEnabled())
                {
                    log.debug("[transport] fossil island rowboat clicked, option={}", option);
                }
            }
        }
    }

    private static boolean isDialogueAction(MenuEntry entry)
    {
        return entry.getType() == MenuAction.WIDGET_CONTINUE
            || entry.getParam1() == InterfaceID.Chatmenu.OPTIONS
            || entry.getParam1() == InterfaceID.Menu.LJ_LAYER1;
    }

    // A click on the boat can close an older dialogue before the picker opens,
    // so only a close that follows the picker's opening forgets the boat.
    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event)
    {
        if (event.getGroupId() == InterfaceID.CHARTERING_MENU_SIDE)
        {
            if (log.isDebugEnabled())
            {
                log.debug("[charter] chartering menu loaded");
            }
            charterMenuLoaded = true;
        }
        if (remembersPicker() && isPickerGroup(event.getGroupId()))
        {
            pickerOpened = true;
        }
    }

    @Subscribe
    public void onWidgetClosed(WidgetClosed event)
    {
        if (event.getGroupId() == InterfaceID.CHARTERING_MENU_SIDE)
        {
            charterMenuLoaded = false;
        }
        if (event.getGroupId() == InterfaceID.MENU || event.getGroupId() == InterfaceID.MENU_NEW
            || event.getGroupId() == InterfaceID.FOSSIL_MUSHTREES)
        {
            loggedList = null;
            loggedMapButton = null;
        }
        if (pickerOpened && isPickerGroup(event.getGroupId()))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[picker] closed, remembered boat forgotten");
            }
            pickerNetwork = null;
            fossilPicker = false;
            pickerOpened = false;
        }
    }

    // True when the boat clicked last opens a picker, which may be on the shared list interface.
    private boolean remembersPicker()
    {
        Boat.Network network = pickerNetwork;
        return fossilPicker || (network != null && network.hasPicker());
    }

    private static boolean isPickerGroup(int groupId)
    {
        return groupId == InterfaceID.CHATMENU || groupId == InterfaceID.MENU;
    }

    // The number keys pick a dialogue line, and the number and letter keys a
    // spirit tree, minecart, charter, boat or mushtree picker line, without going through
    // MenuOptionClicked. The pressed key and the typed key arrive as separate
    // events, so consuming one does not suppress the other and both are taken.
    @Override
    public void keyPressed(KeyEvent e)
    {
        consumeIfBlockedDialogueDigit(e);
        consumeIfBlockedSpiritTreeKey(e);
        consumeIfBlockedMinecartKey(e);
        consumeIfBlockedCharterKey(e);
        consumeIfBlockedBoatKey(e);
        consumeIfBlockedMushtreeKey(e);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        consumeIfBlockedDialogueDigit(e);
        consumeIfBlockedSpiritTreeKey(e);
        consumeIfBlockedMinecartKey(e);
        consumeIfBlockedCharterKey(e);
        consumeIfBlockedBoatKey(e);
        consumeIfBlockedMushtreeKey(e);
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
        if (digit > 0 && (isBlockedDialogueDigit(digit) || isBlockedTransportDigit(digit)))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[key] consumed dialogue digit {}", digit);
            }
            e.consume();
        }
    }

    private boolean isDialogueBlocking()
    {
        return !blockedRatPits.isEmpty() || !blockedItemTeleports.isEmpty() || !blockedPortals.isEmpty()
            || !blockedCharterPorts.isEmpty() || !blockedShipLegs.isEmpty() || !blockedBoats.isEmpty()
            || !blockedFossilIsland.isEmpty() || !blockedMountainGuides.isEmpty();
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

    // True when the given 1-based digit currently selects a blocked line of the rat pit or
    // jewellery dialogue. The dialogue title takes a child slot of its own, so the offset comes
    // from locating the first child whose text matches a known destination line rather than from a
    // fixed index.
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

        Item item = dialogueItem(lines);
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

    // The item whose rub dialogue the lines belong to, or null when they belong to none. The
    // dialogue carries no marker of the item that opened it, and a portal or an NPC can offer a
    // place a piece of jewellery also travels to, so the lines are read as a rub dialogue only when
    // one item accounts for more of them than any other item and for more than one of them. Every
    // item offers at least two destinations, while a dialogue that only shares a place name offers
    // one.
    private static Item dialogueItem(Widget[] lines)
    {
        Item item = null;
        int most = 0;
        boolean tied = false;

        for (Item candidate : Item.values())
        {
            if (!candidate.hasRubDialogue())
            {
                continue;
            }

            int count = 0;
            for (Widget line : lines)
            {
                if (line != null && ItemTeleport.matchesDialogueLine(candidate, plainText(line.getText())))
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

    // True when the lines are the Soul Wars portal dialogue. That dialogue carries no marker of its
    // own either, and one of the two places it offers is a jewellery destination as well, so it is
    // only recognised when both of them are present.
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

    private static boolean matchesAnyDialogueLine(Item item, boolean portal, String text)
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
        return item != null && ItemTeleport.matchesDialogueLine(item, line);
    }

    // True when the text is a blocked line of the dialogue it was read from.
    private boolean isBlockedDialogueLine(Item item, boolean portal, String text)
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
        for (ItemTeleport teleport : blockedItemTeleports)
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

    private static boolean matchesKey(String key, String line)
    {
        return !line.isEmpty() && key.equals(StripAndLowercase.of(line));
    }

    private static String plainText(String text)
    {
        return text == null ? "" : Text.removeTags(text).trim();
    }

    private boolean isBlockedFairyRingConfirm(MenuEntry entry)
    {
        if (blockedFairyRings.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }
        if (entry.getParam1() != InterfaceID.Fairyrings.CONFIRM)
        {
            return false;
        }

        FairyRing ring = FairyRing.fromDials(
            client.getVarbitValue(VarbitID.FAIRYRING_1),
            client.getVarbitValue(VarbitID.FAIRYRING_2),
            client.getVarbitValue(VarbitID.FAIRYRING_3));
        return ring != null && blockedFairyRings.contains(ring);
    }

    private static boolean isFairyRingObject(MenuEntry entry)
    {
        return OBJECT_OPTIONS.contains(entry.getType())
            && FAIRY_RING_OBJECTS.contains(entry.getIdentifier() & 0xFFFF);
    }

    // The text before the code is a name the player chose, so only the
    // trailing code is read, bracketed or bare.
    private static FairyRing fairyRingOf(String option)
    {
        Matcher matcher = FAIRY_RING_CODE.matcher(option);
        return matcher.find() ? FairyRing.valueOf(matcher.group(1)) : null;
    }

    // The ring object's Zanaris, Last and Favourites rows. A submenu row
    // carries the object id in its low 16 bits.
    private boolean isBlockedFairyRingOption(MenuEntry entry)
    {
        if (!isFairyRingObject(entry))
        {
            return false;
        }

        String option = plainText(entry.getOption());
        if (FAIRY_RING_ZANARIS.equals(option))
        {
            return blockedFairyRings.contains(FairyRing.BKS);
        }

        FairyRing ring = fairyRingOf(option);
        // Only the ring's own Last option, not a favourite labelled that way.
        if (blockFairyRingPrevious && option.startsWith(FAIRY_RING_LAST)
            && entry.getIdentifier() <= 0xFFFF)
        {
            return true;
        }
        return ring != null && blockedFairyRings.contains(ring);
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

    // Every spirit tree opens the same destination list on an interface that
    // other lists share, so the title is checked before a line is read. The
    // lines are made by script, so the destination is read from the line the
    // entry sits on rather than from a fixed position. A map button another
    // plugin draws over the list names its destination in the entry's target.
    private boolean isBlockedSpiritTree(MenuEntry entry)
    {
        if (blockedSpiritTrees.isEmpty())
        {
            return false;
        }

        if (isListLineEntry(entry))
        {
            String line = entryLine(entry, spiritTreeLines());
            return line != null && isBlockedSpiritTreeLine(line);
        }
        return isMapButtonEntry(entry) && spiritTreeLines() != null && isBlockedMapButton(entry, this::isBlockedSpiritTreeLine);
    }

    // Every conductor and minecart opens the same station list, drawn on the
    // interface the spirit tree list uses, so it is read the same way under a
    // title of its own.
    private boolean isBlockedMinecart(MenuEntry entry)
    {
        if (blockedMinecartStations.isEmpty())
        {
            return false;
        }

        if (isListLineEntry(entry))
        {
            String line = entryLine(entry, minecartLines());
            return line != null && isBlockedMinecartLine(line);
        }
        return isMapButtonEntry(entry) && minecartLines() != null && isBlockedMapButton(entry, this::isBlockedMinecartLine);
    }

    // True when an entry sits on a line of the classic or the modern list.
    private static boolean isListLineEntry(MenuEntry entry)
    {
        return entry.getParam1() == InterfaceID.Menu.LJ_LAYER1 || entry.getParam1() == InterfaceID.MenuNew.TEXT;
    }

    // True when an entry is the Travel option of a button that a map drawn over the classic or the
    // modern list adds to the list's root layer.
    private static boolean isMapButtonEntry(MenuEntry entry)
    {
        return (entry.getParam1() == InterfaceID.Menu.LJ_LAYER2 || entry.getParam1() == InterfaceID.MenuNew.INFINITE)
            && TRAVEL_OPTION.equals(entry.getOption());
    }

    // A map button's target is the destination's name.
    private boolean isBlockedMapButton(MenuEntry entry, Predicate<String> blocked)
    {
        String destination = plainText(entry.getTarget());
        if (!blocked.test(destination))
        {
            return false;
        }
        logMapButton(destination, WidgetUtil.componentToInterface(entry.getParam1()));
        return true;
    }

    // The menu is rebuilt while the mouse rests on a button, so a removal is logged once per button.
    private void logMapButton(String destination, int group)
    {
        if (log.isDebugEnabled() && !destination.equals(loggedMapButton))
        {
            loggedMapButton = destination;
            if (log.isDebugEnabled())
            {
                log.debug("[teleportmaps] removed map button {} on group {}", destination, group);
            }
        }
    }

    // The text of the list line an entry sits on, or null when it sits on none.
    private static String entryLine(MenuEntry entry, Widget[] lines)
    {
        int index = entry.getParam0();
        if (lines == null || index < 0 || index >= lines.length || lines[index] == null)
        {
            return null;
        }
        return plainText(lines[index].getText());
    }

    // Each line prints its own shortcut, 1 to 9 and then letters, so the
    // pressed key is compared with the shortcut the line prints. A list opened
    // without shortcuts prints none and no key is taken.
    private void consumeIfBlockedSpiritTreeKey(KeyEvent e)
    {
        if (!blockedSpiritTrees.isEmpty())
        {
            consumeIfBlockedListKey(e, this::spiritTreeLines, this::isBlockedSpiritTreeLine);
        }
    }

    private void consumeIfBlockedMinecartKey(KeyEvent e)
    {
        if (!blockedMinecartStations.isEmpty())
        {
            consumeIfBlockedListKey(e, this::minecartLines, this::isBlockedMinecartLine);
        }
    }

    private static void consumeIfBlockedListKey(KeyEvent e, Supplier<Widget[]> openLines, Predicate<String> blocked)
    {
        String key = keyLabel(e);
        Widget[] lines = key == null ? null : openLines.get();
        if (lines == null)
        {
            return;
        }

        for (Widget line : lines)
        {
            if (line == null)
            {
                continue;
            }

            String text = plainText(line.getText());
            if (key.equalsIgnoreCase(listLabel(text)) && blocked.test(text))
            {
                if (log.isDebugEnabled())
                {
                    log.debug("[key] consumed list key {} on line {}", key, text);
                }
                e.consume();
                return;
            }
        }
    }

    // The letter or digit a key press stands for, or null when it stands for none.
    private static String keyLabel(KeyEvent e)
    {
        char ch = e.getKeyChar();
        if (Character.isLetterOrDigit(ch))
        {
            return String.valueOf(ch);
        }

        int digit = digitOf(e);
        return digit > 0 ? String.valueOf(digit) : null;
    }

    // The lines of the spirit tree list, or null when that list is not open.
    private Widget[] spiritTreeLines()
    {
        return listLines("spirit tree", title -> matchesKey(SPIRIT_TREE_TITLE_KEY, title));
    }

    // The lines of the minecart station list, or null when that list is not open.
    private Widget[] minecartLines()
    {
        return listLines("minecart", LovakengjMinecart::isTitle);
    }

    // The lines of the shared list interface, classic (187) or modern (947), or null when no list
    // with a matching title is open. A map drawn over the list by another plugin hides the lines
    // and the title but keeps their text, so only the list's root is checked for being shown.
    private Widget[] listLines(String name, Predicate<String> isTitle)
    {
        int group;
        Widget list;
        Widget frame = client.getWidget(InterfaceID.Menu.LJ_LAYER2);
        if (frame != null && !frame.isHidden())
        {
            group = InterfaceID.MENU;
            list = hasTitle(frame, isTitle) ? client.getWidget(InterfaceID.Menu.LJ_LAYER1) : null;
        }
        else
        {
            Widget universe = client.getWidget(InterfaceID.MenuNew.UNIVERSE);
            group = InterfaceID.MENU_NEW;
            list = universe != null && !universe.isHidden() && hasTitle(client.getWidget(InterfaceID.MenuNew.TITLE), isTitle)
                ? client.getWidget(InterfaceID.MenuNew.TEXT) : null;
        }
        if (list == null)
        {
            return null;
        }

        if (log.isDebugEnabled() && (!name.equals(loggedList) || group != loggedListGroup))
        {
            loggedList = name;
            loggedListGroup = group;
            if (log.isDebugEnabled())
            {
                log.debug("[list] {} list recognised on group {}, lines hidden={}", name, group, list.isHidden());
            }
        }
        return list.getDynamicChildren();
    }

    // True when a title widget's own text or one of its dynamic children's matches.
    private static boolean hasTitle(Widget frame, Predicate<String> isTitle)
    {
        if (frame == null)
        {
            return false;
        }
        if (isTitle.test(plainText(frame.getText())))
        {
            return true;
        }

        Widget[] titles = frame.getDynamicChildren();
        if (titles == null)
        {
            return false;
        }

        for (Widget title : titles)
        {
            if (title != null && isTitle.test(plainText(title.getText())))
            {
                return true;
            }
        }
        return false;
    }

    // Logs what a click on the shared list interface landed on, so a list the
    // plugin does not recognise shows its title and line in the log.
    private void logListClick(MenuEntry entry)
    {
        boolean modern = WidgetUtil.componentToInterface(entry.getParam1()) == InterfaceID.MENU_NEW;
        Widget frame = client.getWidget(modern ? InterfaceID.MenuNew.TITLE : InterfaceID.Menu.LJ_LAYER2);
        Widget[] titles = frame == null ? null : frame.getDynamicChildren();
        StringBuilder titleText = new StringBuilder();
        if (frame != null && !plainText(frame.getText()).isEmpty())
        {
            titleText.append('[').append(plainText(frame.getText())).append(']');
        }
        if (titles != null)
        {
            for (Widget title : titles)
            {
                if (title != null && !plainText(title.getText()).isEmpty())
                {
                    titleText.append('[').append(plainText(title.getText())).append(']');
                }
            }
        }
        Widget list = client.getWidget(modern ? InterfaceID.MenuNew.TEXT : InterfaceID.Menu.LJ_LAYER1);
        Widget[] lines = list == null || !isListLineEntry(entry) ? null : list.getDynamicChildren();
        log.debug("[list] click group={} option={} target={} type={} param0={} param1={} line={} titles={} "
                + "mapButton={} spiritTreeList={} minecartList={}",
            modern ? InterfaceID.MENU_NEW : InterfaceID.MENU, entry.getOption(), entry.getTarget(), entry.getType(),
            entry.getParam0(), entry.getParam1(), entryLine(entry, lines), titleText, isMapButtonEntry(entry),
            spiritTreeLines() != null, minecartLines() != null);
    }

    // The shortcut a list line prints before its text, or null when it prints none.
    private static String listLabel(String line)
    {
        int colon = line.indexOf(": ");
        return colon > 0 ? line.substring(0, colon).trim() : null;
    }

    // The text a list line prints after its shortcut.
    private static String listText(String line)
    {
        int colon = line.indexOf(": ");
        return colon > 0 ? line.substring(colon + 2) : line;
    }

    private boolean isBlockedSpiritTreeLine(String line)
    {
        String destination = listText(line);
        for (SpiritTree.Destination tree : blockedSpiritTrees)
        {
            if (tree.matchesLine(destination))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isBlockedMinecartLine(String line)
    {
        String station = listText(line);
        for (LovakengjMinecart.Station blocked : blockedMinecartStations)
        {
            if (matchesLine(blocked.getStationName(), station))
            {
                return true;
            }
        }
        return false;
    }

    // Last-destination travels straight to the tree used last. Its entry reads
    // either Last-destination or the name of that tree. Previous Destination
    // removes it whatever it points at; a named tree is also removed by that
    // tree's own toggle.
    // The object's name is checked so the same option elsewhere is left alone.
    private boolean isBlockedSpiritTreePrevious(MenuEntry entry)
    {
        if ((!blockSpiritTreePrevious && blockedSpiritTrees.isEmpty()) || !OBJECT_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        String option = plainText(entry.getOption());
        boolean blocked;
        if (matchesKey(SPIRIT_TREE_PREVIOUS_KEY, option))
        {
            blocked = blockSpiritTreePrevious;
        }
        else
        {
            SpiritTree.Destination named = SpiritTree.Destination.forOption(option);
            blocked = named != null && (blockSpiritTreePrevious || blockedSpiritTrees.contains(named));
        }
        if (!blocked)
        {
            return false;
        }

        ObjectComposition composition = client.getObjectDefinition(entry.getIdentifier());
        if (composition != null && composition.getImpostorIds() != null)
        {
            composition = composition.getImpostor();
        }
        return composition != null && matchesKey(SPIRIT_TREE_OBJECT_KEY, plainText(composition.getName()));
    }

    // An object whose look depends on the player's progress reaches the menu
    // under its base id, so the id of the variant on screen is checked too.
    // Only the known base ids are looked up.
    private int variantId(int objectId)
    {
        if (!VARIANT_BASE_OBJECTS.contains(objectId))
        {
            return objectId;
        }

        ObjectComposition composition = client.getObjectDefinition(objectId);
        if (composition == null || composition.getImpostorIds() == null)
        {
            return objectId;
        }
        ObjectComposition variant = composition.getImpostor();
        return variant == null ? objectId : variant.getId();
    }

    // Every pilot opens the same map, which carries one button per
    // destination, so the button the entry sits on names the place. The
    // button ids belong to the glider map alone, so the entry type is not
    // checked.
    private boolean isBlockedGlider(MenuEntry entry)
    {
        if (blockedGliders.isEmpty())
        {
            return false;
        }

        int component = entry.getParam1();
        for (GnomeGlider.Destination destination : blockedGliders)
        {
            if (destination.getComponentId() == component)
            {
                return true;
            }
        }
        return false;
    }

    // "Glider-to <place>" flies straight to the pilot's last destination.
    // Previous Destination removes it whatever it points at; a named place is
    // also removed by that place's own toggle. The bare Glider option opens
    // the map and stays. The pilot's name is checked so the same option
    // elsewhere is left alone.
    private boolean isBlockedGliderPrevious(MenuEntry entry)
    {
        if ((!blockGliderPrevious && blockedGliders.isEmpty()) || !NPC_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        String option = plainText(entry.getOption());
        if (!option.startsWith(GnomeGlider.PREVIOUS_PREFIX))
        {
            return false;
        }

        GnomeGlider.Destination named = GnomeGlider.Destination.forPlace(option.substring(GnomeGlider.PREVIOUS_PREFIX.length()));
        boolean blocked = blockGliderPrevious || (named != null && blockedGliders.contains(named));
        return blocked && GnomeGlider.isPilot(plainText(entry.getTarget()));
    }

    // A quetzal map icon carries one option, whose text is the name of its
    // landing site, and one click on it flies. The quetzals' map and the
    // whistle's map build their icons the same way, and the icon component
    // belongs to those maps alone, so the entry type is not checked.
    private boolean isBlockedQuetzalMap(MenuEntry entry)
    {
        if (blockedQuetzalDestinations.isEmpty() || !QuetzalTransport.isMapIcon(entry.getParam1()))
        {
            return false;
        }

        String option = plainText(entry.getOption());
        for (QuetzalTransport.Destination destination : blockedQuetzalDestinations)
        {
            if (matchesLine(destination.getDestinationName(), option))
            {
                return true;
            }
        }
        return false;
    }

    // The Varrock quetzal flies one fixed leg from each end, from the quetzal
    // and from its keeper, whose chat leads to the same flight, so every
    // option on them at a blocked end is removed, which leaves Examine.
    private boolean isBlockedQuetzalRoute(MenuEntry entry)
    {
        if (blockedQuetzalRoutes.isEmpty() || !NPC_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        for (QuetzalTransport.Route route : blockedQuetzalRoutes)
        {
            if (npcMatches(entry, route::isRouteNpc))
            {
                return true;
            }
        }
        return false;
    }

    // Last-destination flies straight to the landing site used last, from a
    // network quetzal and from a whistle. Its entry reads either
    // Last-destination or the name of that site. Previous Destination removes
    // it whatever it points at; a named site is also removed by that site's
    // own toggle.
    private boolean isBlockedQuetzalPrevious(MenuEntry entry)
    {
        if (!blockQuetzalPrevious && blockedQuetzalDestinations.isEmpty())
        {
            return false;
        }

        String option = plainText(entry.getOption());
        boolean blocked;
        if (matchesKey(QUETZAL_PREVIOUS_KEY, option))
        {
            blocked = blockQuetzalPrevious;
        }
        else
        {
            QuetzalTransport.Destination named = QuetzalTransport.Destination.forOption(option);
            blocked = named != null && (blockQuetzalPrevious || blockedQuetzalDestinations.contains(named));
        }
        if (!blocked)
        {
            return false;
        }

        if (NPC_OPTIONS.contains(entry.getType()))
        {
            return npcMatches(entry, QuetzalTransport::isNetworkQuetzal);
        }
        return isWhistleOption(entry);
    }

    // A whistle set to fly straight to the Hunter Guild does so from Signal
    // without opening the map, so Signal is removed while that site is
    // blocked and the whistle is set that way.
    private boolean isBlockedWhistleSignal(MenuEntry entry)
    {
        if (!blockedQuetzalDestinations.contains(QuetzalTransport.Destination.HUNTER_GUILD)
            || !isWhistleOption(entry)
            || !matchesKey(QUETZAL_SIGNAL_KEY, plainText(entry.getOption())))
        {
            return false;
        }

        return client.getVarbitValue(VarbitID.SETTINGS_QUETZALWHISTLE_DEFAULT_TP) != 0;
    }

    private static boolean isWhistleOption(MenuEntry entry)
    {
        MenuAction action = entry.getType();
        return (action == MenuAction.CC_OP || action == MenuAction.CC_OP_LOW_PRIORITY)
            && QuetzalTransport.isWhistle(entry.getItemId());
    }

    // An NPC whose look depends on the player's progress reaches the menu
    // under its base id, so the id of the variant on screen is checked too.
    private static boolean npcMatches(MenuEntry entry, IntPredicate ids)
    {
        NPC npc = entry.getNpc();
        if (npc == null)
        {
            return false;
        }

        NPCComposition variant = npc.getTransformedComposition();
        return ids.test(npc.getId()) || (variant != null && ids.test(variant.getId()));
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
        for (SoulWarsPortal.Entry portal : blockedEntryPortals)
        {
            if (portal.getObjectId() == objectId || portal.getObjectId() == entryVariantId(entry))
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
        for (WildernessLever.Entry lever : blockedLeverEntries)
        {
            if (lever.getObjectId() == objectId || lever.getObjectId() == entryVariantId(entry))
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
        if (objectId == WildernessLever.Destination.PRE_DIARY_OBJECT_ID
            || entryVariantId(entry) == WildernessLever.Destination.PRE_DIARY_OBJECT_ID)
        {
            return blockedLeverDestinations.contains(WildernessLever.Destination.ARDOUGNE);
        }
        if (!WildernessLever.Destination.isLeverObject(objectId) && !WildernessLever.Destination.isLeverObject(entryVariantId(entry)))
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

    // The name a row prints, which is its first line. The location sits either below the name in
    // the same widget or on a child of it, so both are tried. A row whose name cannot be read
    // returns null and is left alone.
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
    private boolean isBlockedItemTeleport(MenuEntry entry)
    {
        if (blockedItemTeleports.isEmpty())
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

        int component = entry.getParam1();
        boolean onInventory = WidgetUtil.componentToInterface(component) == InterfaceID.INVENTORY;
        if (!onInventory && !isBlockedWornComponent(component))
        {
            return false;
        }

        String target = entry.getTarget();
        String itemName = target == null ? "" : Text.removeTags(target).trim();
        boolean bareOnInventory = itemName.isEmpty() && onInventory;

        String line = Text.removeTags(option).trim();
        for (ItemTeleport teleport : blockedItemTeleports)
        {
            Item item = teleport.getItem();
            if (!teleport.matchesOption(line))
            {
                continue;
            }
            if ((bareOnInventory && item.hasRubDialogue()) || (onItemMenu(item, component) && item.matchesTarget(itemName)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isBlockedWornComponent(int component)
    {
        for (ItemTeleport teleport : blockedItemTeleports)
        {
            if (teleport.getItem().getWornComponentId() == component)
            {
                return true;
            }
        }
        return false;
    }

    // The destinations sit on the equipment slot while the item is worn and on
    // the inventory interface while it is not, so both are matched. The target
    // check keeps the option words off any other item in the bag.
    private static boolean onItemMenu(Item item, int component)
    {
        return component == item.getWornComponentId()
            || WidgetUtil.componentToInterface(component) == InterfaceID.INVENTORY;
    }

    // True when the click landed on a blocked line of a destination dialogue.
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

        return isBlockedDialogueLine(dialogueItem(lines), isPortalDialogue(lines), lines[index].getText())
            || isBlockedTransportLine(lines, lines[index].getText());
    }

    // The chartering menu carries one pin per port on its map and one line
    // per port in its list, each with one option named after the port, so the
    // option text names the place. The pins are made by script when the menu
    // opens, so an option is also read as the menu's while the menu is open.
    private boolean isBlockedCharter(MenuEntry entry)
    {
        if (blockedCharterPorts.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        if (action != MenuAction.CC_OP && action != MenuAction.CC_OP_LOW_PRIORITY)
        {
            return false;
        }

        if (WidgetUtil.componentToInterface(entry.getParam1()) != InterfaceID.CHARTERING_MENU_SIDE && !isCharterMenuOpen())
        {
            return false;
        }
        return isBlockedCharterPort(plainText(entry.getOption()));
    }

    private boolean isCharterMenuOpen()
    {
        if (!charterMenuLoaded)
        {
            return false;
        }
        Widget menu = client.getWidget(InterfaceID.CharteringMenuSide.UNIVERSE);
        return menu != null && !menu.isHidden();
    }

    private boolean isBlockedCharterPort(String name)
    {
        for (CharterShip.Port port : blockedCharterPorts)
        {
            if (port.matchesName(name))
            {
                return true;
            }
        }
        return false;
    }

    // Charter-to sails straight to the last port chartered to and names that
    // port after the option, so it is removed while that port is blocked, and
    // whatever it names while the previous destination is blocked. The crews'
    // ids are checked so the same option elsewhere is left alone.
    private boolean isBlockedCharterPrevious(MenuEntry entry)
    {
        if ((blockedCharterPorts.isEmpty() && !blockCharterPrevious) || !NPC_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        String port = CharterShip.previousPort(plainText(entry.getOption()));
        if (port == null || !npcMatches(entry, CharterShip::isCrew))
        {
            return false;
        }
        return blockCharterPrevious || isBlockedCharterPort(port);
    }

    // The chartering list prints each line's shortcut the way the spirit tree
    // list does, with a space before the colon, so its keys are read the same
    // way.
    private void consumeIfBlockedCharterKey(KeyEvent e)
    {
        if (!blockedCharterPorts.isEmpty())
        {
            consumeIfBlockedListKey(e, this::charterLines, line -> isBlockedCharterPort(listText(line)));
        }
    }

    // The lines of the chartering list, or null when the chartering menu is not open.
    private Widget[] charterLines()
    {
        Widget list = client.getWidget(InterfaceID.CharteringMenuSide.LIST_CONTENT);
        return list == null || list.isHidden() ? null : list.getDynamicChildren();
    }

    // A ship NPC sails a leg from a click option named after the destination
    // or from Travel, so the option is removed from the NPCs at the leg's
    // start. A ferryman whose chat reaches its one leg only through a line any
    // dialogue could carry loses Talk-to there as well.
    private boolean isBlockedShip(MenuEntry entry)
    {
        if (blockedShipLegs.isEmpty() || !NPC_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        NPC npc = entry.getNpc();
        if (npc == null)
        {
            return false;
        }

        // The NPC is matched first, so the option text is only read on a ship NPC.
        int npcId = npc.getId();
        NPCComposition variant = npc.getTransformedComposition();
        int variantId = variant == null ? npcId : variant.getId();
        String option = null;
        boolean talk = false;
        for (Ship.Leg leg : blockedShipLegs)
        {
            boolean legNpc = leg.isLegNpc(npcId) || leg.isLegNpc(variantId);
            boolean talkNpc = leg.removesTalk(npcId) || leg.removesTalk(variantId);
            if (!legNpc && !talkNpc)
            {
                continue;
            }

            if (option == null)
            {
                option = plainText(entry.getOption());
                talk = matchesKey(SHIP_TALK_KEY, option);
            }
            if ((legNpc && leg.matchesOption(option)) || (talkNpc && talk))
            {
                return true;
            }
        }
        return false;
    }

    // Larry's boat, the Slepe rowboat and Achilka offer each destination as a
    // click option of its own, so the option is removed from the boats and NPCs that carry it.
    private boolean isBlockedBoat(MenuEntry entry)
    {
        if (blockedBoats.isEmpty())
        {
            return false;
        }

        MenuAction action = entry.getType();
        boolean onObject = OBJECT_OPTIONS.contains(action);
        if (!onObject && !NPC_OPTIONS.contains(action))
        {
            return false;
        }

        String key = StripAndLowercase.of(plainText(entry.getOption()));
        for (Boat.Destination destination : blockedBoats)
        {
            if (!destination.matchesOptionKey(key))
            {
                continue;
            }

            if (onObject)
            {
                int objectId = entry.getIdentifier();
                if (destination.isOptionObject(objectId) || destination.isOptionObject(entryVariantId(entry)))
                {
                    return true;
                }
            }
            else if (npcMatches(entry, destination::isOptionNpc))
            {
                return true;
            }
        }
        return false;
    }

    // A boat picker drawn on the shared list interface is read like the
    // spirit tree list, but only while the picker of the boat just used may
    // be open, since its title is not known.
    private boolean isBlockedBoatList(MenuEntry entry)
    {
        if (!remembersPicker() || entry.getParam1() != InterfaceID.Menu.LJ_LAYER1)
        {
            return false;
        }

        String line = entryLine(entry, boatPickerLines());
        return line != null && isBlockedBoatLine(listText(line));
    }

    private void consumeIfBlockedBoatKey(KeyEvent e)
    {
        if (remembersPicker())
        {
            consumeIfBlockedListKey(e, this::boatPickerLines, line -> isBlockedBoatLine(listText(line)));
        }
    }

    // The lines of the shared list interface while the remembered boat's picker may be on it, or
    // null.
    private Widget[] boatPickerLines()
    {
        return remembersPicker() ? listLines("boat", title -> true) : null;
    }

    // The rowboats to Lithkren and back travel straight from Travel, so the
    // option is removed from the rowboat that carries it.
    private boolean isBlockedFossilIsland(MenuEntry entry)
    {
        if (blockedFossilIsland.isEmpty() || !OBJECT_OPTIONS.contains(entry.getType()))
        {
            return false;
        }

        int objectId = entry.getIdentifier();
        for (FossilIsland.Destination destination : blockedFossilIsland)
        {
            if (destination.travelsFrom(objectId) || destination.travelsFrom(entryVariantId(entry)))
            {
                return FossilIsland.isTravel(plainText(entry.getOption()));
            }
        }
        return false;
    }

    // The mushtree picker has one button per tree, with the tree's name on a
    // label beside it. Which button carries which tree is not known yet, so
    // the label is read, and logged so a dev run shows the order.
    private boolean isBlockedMushtree(MenuEntry entry)
    {
        if (blockedMushtrees.isEmpty())
        {
            return false;
        }

        int line = Mushtree.lineOf(entry.getParam1());
        if (line < 0)
        {
            return entry.getParam1() == InterfaceID.FossilMushtrees.UNIVERSE && TRAVEL_OPTION.equals(entry.getOption())
                && isBlockedMushtreeButton(entry);
        }

        String label = mushtreeLabel(line);
        if (log.isDebugEnabled())
        {
            log.debug("[mushtree] line {} label {} option {} type {}", line + 1, label, entry.getOption(), entry.getType());
        }
        return isBlockedMushtreeLabel(label);
    }

    // A map drawn over the picker by another plugin adds a button per tree to the picker's root,
    // named after the tree.
    private boolean isBlockedMushtreeButton(MenuEntry entry)
    {
        String label = plainText(entry.getTarget());
        if (!isBlockedMushtreeLabel(label))
        {
            return false;
        }
        logMapButton(label, InterfaceID.FOSSIL_MUSHTREES);
        return true;
    }

    // The picker takes 1 to 4 for its four lines, top to bottom.
    private void consumeIfBlockedMushtreeKey(KeyEvent e)
    {
        if (blockedMushtrees.isEmpty())
        {
            return;
        }

        int digit = digitOf(e);
        Widget picker = digit > 0 && digit <= Mushtree.lineCount()
            ? client.getWidget(InterfaceID.FossilMushtrees.UNIVERSE) : null;
        if (picker == null || picker.isHidden())
        {
            return;
        }

        String label = mushtreeLabel(digit - 1);
        if (isBlockedMushtreeLabel(label))
        {
            if (log.isDebugEnabled())
            {
                log.debug("[key] consumed mushtree key {} on label {}", digit, label);
            }
            e.consume();
        }
    }

    // The text of a 0-based mushtree picker line's label, or null when it is not loaded.
    private String mushtreeLabel(int line)
    {
        Widget label = client.getWidget(Mushtree.labelOf(line));
        return label == null ? null : plainText(label.getText());
    }

    private boolean isBlockedMushtreeLabel(String label)
    {
        if (label == null)
        {
            return false;
        }

        for (Mushtree.Destination destination : blockedMushtrees)
        {
            if (destination.isNamedBy(label))
            {
                return true;
            }
        }
        return false;
    }

    // True when the given 1-based digit currently picks a blocked line of the charter confirm
    // dialogue, of a ship NPC's chat or of a boat picker. The option lines are the children that
    // carry a click option, which leaves the title out.
    private boolean isBlockedTransportDigit(int digit)
    {
        Widget options = client.getWidget(InterfaceID.Chatmenu.OPTIONS);
        if (options == null)
        {
            return false;
        }

        Widget[] lines = options.getDynamicChildren();
        if (lines == null)
        {
            return false;
        }

        int count = 0;
        for (Widget line : lines)
        {
            if (line != null && hasOption(line) && ++count == digit)
            {
                return isBlockedTransportLine(lines, line.getText());
            }
        }
        return false;
    }

    private static boolean hasOption(Widget widget)
    {
        String[] actions = widget.getActions();
        if (actions == null)
        {
            return false;
        }

        for (String action : actions)
        {
            if (action != null && !action.isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    // True when the text is a blocked line of the charter confirm dialogue, of a ship NPC's chat,
    // of a boat picker or of a Mountain Guide's chat.
    private boolean isBlockedTransportLine(Widget[] lines, String text)
    {
        String line = plainText(text);
        if (line.isEmpty())
        {
            return false;
        }
        return isBlockedCharterConfirm(lines, line) || isBlockedShipLine(line) || isBlockedBoatLine(line)
            || isBlockedMountainGuideLine(line);
    }

    // The confirm dialogue names the port in its title, so Okay is blocked
    // while that port is blocked. It catches a port the menu let through.
    private boolean isBlockedCharterConfirm(Widget[] lines, String line)
    {
        if (blockedCharterPorts.isEmpty() || !matchesKey(CHARTER_CONFIRM_KEY, line))
        {
            return false;
        }

        for (Widget title : lines)
        {
            String port = title == null ? null : CharterShip.confirmPort(plainText(title.getText()));
            if (port != null)
            {
                return isBlockedCharterPort(port);
            }
        }
        return false;
    }

    // A Mountain Guide's picker line is only read while the chat belongs to a
    // guide around Mount Quidamortem, so the same words from anyone else are left alone.
    private boolean isBlockedMountainGuideLine(String line)
    {
        if (!mountainGuideChat)
        {
            return false;
        }

        for (MountainGuide.Destination destination : blockedMountainGuides)
        {
            if (destination.matchesLine(line))
            {
                return true;
            }
        }
        return false;
    }

    // The Varlamore guide travels straight from Follow, so Follow is removed
    // at the end whose trip leads to a blocked destination.
    private boolean isBlockedMountainGuide(MenuEntry entry)
    {
        if (blockedMountainGuides.isEmpty() || !NPC_OPTIONS.contains(entry.getType())
            || !npcMatches(entry, MountainGuide::isVarlamoreGuide) || !MountainGuide.isFollow(plainText(entry.getOption())))
        {
            return false;
        }

        int x = entry.getNpc().getWorldLocation().getX();
        for (MountainGuide.Destination destination : blockedMountainGuides)
        {
            if (destination.followsFrom(x))
            {
                return true;
            }
        }
        return false;
    }

    // A chat line that picks a leg is only read while the chat belongs to one
    // of that leg's NPCs, so the same words from anyone else are left alone.
    private boolean isBlockedShipLine(String line)
    {
        for (Ship.Leg leg : talkLegs)
        {
            if (blockedShipLegs.contains(leg) && leg.matchesLine(line))
            {
                return true;
            }
        }
        return false;
    }

    // A picker line is read by the place words it contains, and a chat line
    // of Larry's by its exact text, both only for the boat used last.
    private boolean isBlockedBoatLine(String line)
    {
        if (fossilPicker)
        {
            FossilIsland.Destination picked = FossilIsland.Destination.forPickerLine(line);
            return picked != null && blockedFossilIsland.contains(picked);
        }

        Boat.Network network = pickerNetwork;
        if (network == null)
        {
            return false;
        }

        Boat.Destination picked = Boat.Destination.forPickerLine(network, line);
        if (picked != null)
        {
            return blockedBoats.contains(picked);
        }
        for (Boat.Destination destination : blockedBoats)
        {
            if (destination.getNetwork() == network && destination.matchesTalkLine(line))
            {
                return true;
            }
        }
        return false;
    }

    private void rebuildBlocked()
    {
        // With "Checked Means: Allow" every toggle allows instead of blocks.
        boolean invert = config.checkedMeans() == TeleportBlockerConfig.CheckedMeans.ALLOW;

        blockedSpellComponents.clear();
        for (TeleportSpell spell : TeleportSpell.values())
        {
            if (spell.isBlocked(config) != invert)
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        for (AncientTeleportSpell spell : AncientTeleportSpell.values())
        {
            if (spell.isBlocked(config) != invert)
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        for (ArceuusTeleportSpell spell : ArceuusTeleportSpell.values())
        {
            if (spell.isBlocked(config) != invert)
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        for (LunarTeleportSpell spell : LunarTeleportSpell.values())
        {
            if (spell.isBlocked(config) != invert)
            {
                blockedSpellComponents.add(spell.getComponentId());
            }
        }
        blockedMinigames.clear();
        for (Minigame minigame : Minigame.values())
        {
            if (minigame.isBlocked(config) != invert)
            {
                blockedMinigames.add(minigame);
            }
        }

        blockedRatPits.clear();
        if (!blockedMinigames.contains(Minigame.RAT_PITS))
        {
            for (Minigame.RatPit pit : Minigame.RatPit.values())
            {
                if (pit.isBlocked(config) != invert)
                {
                    blockedRatPits.add(pit);
                }
            }
        }

        blockedItemTeleports.clear();
        for (ItemTeleport teleport : ItemTeleport.values())
        {
            if (teleport.isBlocked(config) != invert)
            {
                blockedItemTeleports.add(teleport);
            }
        }

        blockedPortals.clear();
        for (SoulWarsPortal destination : SoulWarsPortal.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedPortals.add(destination);
            }
        }

        blockedCanoes.clear();
        for (CanoeDestination destination : CanoeDestination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedCanoes.add(destination);
            }
        }

        blockedEntryPortals.clear();
        for (SoulWarsPortal.Entry portal : SoulWarsPortal.Entry.values())
        {
            if (portal.isBlocked(config) != invert)
            {
                blockedEntryPortals.add(portal);
            }
        }

        blockedLeverEntries.clear();
        for (WildernessLever.Entry lever : WildernessLever.Entry.values())
        {
            if (lever.isBlocked(config) != invert)
            {
                blockedLeverEntries.add(lever);
            }
        }

        blockedLeverDestinations.clear();
        for (WildernessLever.Destination destination : WildernessLever.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedLeverDestinations.add(destination);
            }
        }

        blockedSpiritTrees.clear();
        for (SpiritTree.Destination tree : SpiritTree.Destination.values())
        {
            if (tree.isBlocked(config) != invert)
            {
                blockedSpiritTrees.add(tree);
            }
        }
        blockSpiritTreePrevious = config.spiritTreePrevious() != invert;

        blockedGliders.clear();
        for (GnomeGlider.Destination destination : GnomeGlider.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedGliders.add(destination);
            }
        }
        blockGliderPrevious = config.gnomeGliderPrevious() != invert;

        blockedQuetzalDestinations.clear();
        for (QuetzalTransport.Destination destination : QuetzalTransport.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedQuetzalDestinations.add(destination);
            }
        }

        blockedQuetzalRoutes.clear();
        for (QuetzalTransport.Route route : QuetzalTransport.Route.values())
        {
            if (route.isBlocked(config) != invert)
            {
                blockedQuetzalRoutes.add(route);
            }
        }
        blockQuetzalPrevious = config.quetzalPrevious() != invert;

        blockedMinecartStations.clear();
        for (LovakengjMinecart.Station station : LovakengjMinecart.Station.values())
        {
            if (station.isBlocked(config) != invert)
            {
                blockedMinecartStations.add(station);
            }
        }

        blockedCharterPorts.clear();
        for (CharterShip.Port port : CharterShip.Port.values())
        {
            if (port.isBlocked(config) != invert)
            {
                blockedCharterPorts.add(port);
            }
        }
        blockCharterPrevious = config.charterPrevious() != invert;

        blockedShipLegs.clear();
        for (Ship.Leg leg : Ship.Leg.values())
        {
            if (leg.isBlocked(config) != invert)
            {
                blockedShipLegs.add(leg);
            }
        }

        blockedBoats.clear();
        for (Boat.Destination destination : Boat.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedBoats.add(destination);
            }
        }

        blockedFossilIsland.clear();
        for (FossilIsland.Destination destination : FossilIsland.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedFossilIsland.add(destination);
            }
        }

        blockedMountainGuides.clear();
        for (MountainGuide.Destination destination : MountainGuide.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedMountainGuides.add(destination);
            }
        }

        blockedFairyRings.clear();
        for (FairyRing ring : FairyRing.values())
        {
            if (ring.isBlocked(config) != invert)
            {
                blockedFairyRings.add(ring);
            }
        }
        blockFairyRingPrevious = config.fairyRingPrevious() != invert;

        blockedMushtrees.clear();
        for (Mushtree.Destination destination : Mushtree.Destination.values())
        {
            if (destination.isBlocked(config) != invert)
            {
                blockedMushtrees.add(destination);
            }
        }

        if (log.isDebugEnabled())
        {
            log.debug("[config] invert={} spells={} minigames={} ratPits={} itemTeleports={} portals={} canoes={} "
                    + "entryPortals={} leverEntries={} leverDestinations={} spiritTrees={} spiritTreePrev={} gliders={} gliderPrev={} "
                    + "quetzalDestinations={} quetzalRoutes={} quetzalPrev={} minecarts={} charterPorts={} charterPrev={} "
                    + "shipLegs={} boats={} fossilIsland={} mushtrees={} mountainGuides={} fairyRings={} fairyRingPrev={}",
                invert, blockedSpellComponents.size(), blockedMinigames.size(), blockedRatPits.size(),
                blockedItemTeleports.size(), blockedPortals.size(), blockedCanoes.size(), blockedEntryPortals.size(),
                blockedLeverEntries.size(), blockedLeverDestinations.size(), blockedSpiritTrees.size(), blockSpiritTreePrevious,
                blockedGliders.size(), blockGliderPrevious, blockedQuetzalDestinations.size(), blockedQuetzalRoutes.size(),
                blockQuetzalPrevious, blockedMinecartStations.size(), blockedCharterPorts.size(), blockCharterPrevious,
                blockedShipLegs.size(), blockedBoats.size(), blockedFossilIsland.size(), blockedMushtrees.size(), blockedMountainGuides.size(),
                blockedFairyRings.size(), blockFairyRingPrevious);
        }
    }
}
