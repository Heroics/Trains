package me.trains.functions;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiPrefab {

    /**
     * Default Menu Gui
     * @param player the in-game player executing the command
     */
    public static void menu(Player player) {
        // Set up gui
        Gui gui = Gui.gui()
                .title(Component.text("Trains - Menu"))
                .rows(3)
                .create();

        // Blank Item
        ItemStack blank = ItemMaker.noLore(" ", Material.GRAY_STAINED_GLASS_PANE);
        GuiItem blankGui = ItemBuilder.from(blank).asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Bookings
        ItemStack bookingItem = ItemMaker.noLore("Bookings", Material.NAME_TAG);
        GuiItem bookingGui = ItemBuilder.from(bookingItem).asGuiItem(event -> {
            event.setCancelled(true);
            kingdoms(player);
        });

        // Day Passes
        ItemStack passItem = ItemMaker.noLore(ChatColor.translateAlternateColorCodes('&', "Day Passes &c&oComing Soon"), Material.CLOCK);
        GuiItem passGui = ItemBuilder.from(passItem).asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Admin Gui
        ItemStack adminItem = ItemMaker.noLore(ChatColor.translateAlternateColorCodes('&', "Admin Gui &c&oComing Soon"), Material.BARRIER);
        GuiItem adminGui = ItemBuilder.from(adminItem).asGuiItem(event -> {
           event.setCancelled(true);
        });

        // Cancel
        ItemStack cancelItem = ItemMaker.noLore(ChatColor.RED + "Cancel", Material.RED_STAINED_GLASS_PANE);
        GuiItem cancelGui = ItemBuilder.from(cancelItem).asGuiItem(event -> {
            event.setCancelled(true);
            gui.close(player);
        });

        // Populating Gui with Blanks
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(1, in, blankGui);
        }
        gui.setItem(2, 1, blankGui);
        gui.setItem(2, 3, blankGui);
        gui.setItem(2, 5, blankGui);
        gui.setItem(2, 7, blankGui);
        gui.setItem(2, 9, blankGui);
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(3, in, blankGui);
        }

        // Populating Gui with Menu Items
        gui.setItem(2, 2, bookingGui);
        gui.setItem(2, 4, passGui);
        gui.setItem(2, 6, adminGui);
        gui.setItem(2, 8, cancelGui);

        // Send gui to player
        gui.open(player);
    }

    /**
     * Kingdom Gui
     * @param player the in-game player executing the command
     */
    public static void kingdoms(Player player) {
        Gui gui = Gui.gui()
                .title(Component.text("Trains - Kingdoms"))
                .rows(3)
                .create();

        // Sky Gui Item
        ItemStack skyItem = ItemMaker.noLore("Sky Kingdom", Material.ELYTRA);
        GuiItem skyGui = ItemBuilder.from(skyItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Sky Kingdom"));

            Location location = new Location(Bukkit.getWorld("world"), -307.5, 180.5, 3152.5);
            Movement.start(player, location, "Sky Kingdom");
        });

        // Land Gui Item
        ItemStack landItem = ItemMaker.noLore("Land Kingdom", Material.GRASS_BLOCK);
        GuiItem landGui = ItemBuilder.from(landItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Land Kingdom"));

            Location location = new Location(Bukkit.getWorld("world"), 185.5, 71.5, 2232.5);
            Movement.start(player, location, "Land Kingdom");
        });

        // Sea Gui Item
        ItemStack seaItem = ItemMaker.noLore("Sea Kingdom", Material.NAUTILUS_SHELL);
        GuiItem seaGui = ItemBuilder.from(seaItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Sea Kingdom"));

            Location location = new Location(Bukkit.getWorld("world"), -1047.5, 64.5, 1884.5);
            Movement.start(player, location, "Sea Kingdom");
        });

        // East Wind Gui Item
        ItemStack eastItem = ItemMaker.noLore("East Wind Demons", Material.AMETHYST_SHARD);
        GuiItem eastGui = ItemBuilder.from(eastItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("East Wind Demons"));

            Location location = new Location(Bukkit.getWorld("world_nether"), 44.5, 129.5, 453.5);
            Movement.start(player, location, "East Wind Demons");
        });

        // West Wind Gui Item
        ItemStack westItem = ItemMaker.noLore("West Wind Demons", Material.BLAZE_POWDER);
        GuiItem westGui = ItemBuilder.from(westItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("West Wind Demons"));

            Location location = new Location(Bukkit.getWorld("world_nether"), -1466.5, 63.5, 1676.5);
            Movement.start(player, location, "West Wind Demons");
        });

        // Blank Item
        ItemStack blank = ItemMaker.noLore(" ", Material.GRAY_STAINED_GLASS_PANE);
        GuiItem blankGui = ItemBuilder.from(blank).asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Next Item
        ItemStack nextItem = ItemMaker.noLore("Next Page", Material.PAPER);
        GuiItem nextGui = ItemBuilder.from(nextItem).asGuiItem(event -> {
            event.setCancelled(true);
            pageOne(player);
        });

        // Populating Gui with default items
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(1, in, blankGui);
        }
        gui.setItem(2, 1, blankGui);
        gui.setItem(2, 9, blankGui);
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(3, in, blankGui);
        }
        gui.setItem(3, 9, nextGui);

        // Populating Gui with Menu Items
        gui.setItem(2, 3, skyGui);
        gui.setItem(2, 4, landGui);
        gui.setItem(2, 5, seaGui);
        gui.setItem(2, 6, eastGui);
        gui.setItem(2, 7, westGui);

        // Sends Gui to player
        gui.open(player);
    }

    /**
     * Page one Gui
     * @param player the in-game player executing the command
     */
    public static void pageOne(Player player) {
        Gui gui = Gui.gui()
                .title(Component.text("Trains - Page One"))
                .rows(3)
                .create();

        // Spawn Gui Item
        ItemStack spawnItem = ItemMaker.noLore("Spawn", Material.TOTEM_OF_UNDYING);
        GuiItem spawnGui = ItemBuilder.from(spawnItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Spawn"));

            Location location = new Location(Bukkit.getWorld("world"), -433.5, 67.5, 2199.5);
            Movement.start(player, location, "Spawn");
        });

        // Server Market Gui Item
        ItemStack marketItem = ItemMaker.noLore("Server Market", Material.ENDER_CHEST);
        GuiItem marketGui = ItemBuilder.from(marketItem).asGuiItem(event -> {
            event.setCancelled(true);

            Location location = new Location(Bukkit.getWorld("world"), 2212.5, 63.5, 2611.5);
            Movement.start(player, location, "The Server Market");
        });

        // Leafy Island Gui Item
        ItemStack leafyItem = ItemMaker.noLore("Leafy Island", Material.FLOWERING_AZALEA);
        GuiItem leafyGui = ItemBuilder.from(leafyItem).asGuiItem(event -> {
            event.setCancelled(true);

            Location location = new Location(Bukkit.getWorld("world"), -1370.5, 63.5, 2169.5);
            Movement.start(player, location, "Leafy Island");
        });

        // AOL Gui Item
        ItemStack aolItem = ItemMaker.noLore("Association Of Leaders", Material.LECTERN);
        GuiItem aolGui = ItemBuilder.from(aolItem).asGuiItem(event -> {
            event.setCancelled(true);

            Location location = new Location(Bukkit.getWorld("world"), 538.5, 64.5, 2720.5);
            Movement.start(player, location, "The Association Of Leaders");
        });

        // Library Gui Item
        ItemStack libraryItem = ItemMaker.noLore("Library", Material.BOOKSHELF);
        GuiItem libraryGui = ItemBuilder.from(libraryItem).asGuiItem(event -> {
            event.setCancelled(true);

            Location location = new Location(Bukkit.getWorld("world"), 48.5, 75.5, 4443.5);
            Movement.start(player, location, "The Library");
        });

        // Dungeon Gui Item
        ItemStack dunItem = ItemMaker.noLore(ChatColor.translateAlternateColorCodes('&', "Dungeons &c&oComing Soon"), Material.IRON_BARS);
        GuiItem dunGui = ItemBuilder.from(dunItem).asGuiItem(event -> {
            event.setCancelled(true);
        });

        // RedSky Gui Item
        ItemStack redsItem = ItemMaker.noLore("RedSky", Material.FLINT);
        GuiItem redsGui = ItemBuilder.from(redsItem).asGuiItem(event -> {
            event.setCancelled(true);

            Location location = new Location(Bukkit.getWorld("world"), -783.5, 75.5, 1614.5);
            Movement.start(player, location, "RedSky");
        });

        // Blank Item
        ItemStack blank = ItemMaker.noLore(" ", Material.GRAY_STAINED_GLASS_PANE);
        GuiItem blankGui = ItemBuilder.from(blank).asGuiItem(event -> {
            event.setCancelled(true);
        });

        // Next Item
        /* ? Not in use until new page is needed
        ItemStack nextItem = ItemMaker.noLore("Next Page", Material.PAPER);
        GuiItem nextGui = ItemBuilder.from(nextItem).asGuiItem(event -> {
            event.setCancelled(true);
        });
        */

        // Previous Item
        ItemStack prevItem = ItemMaker.noLore("Previous Page", Material.REDSTONE);
        GuiItem prevGui = ItemBuilder.from(prevItem).asGuiItem(event -> {
            event.setCancelled(true);
            kingdoms(player);
        });

        // Populating Gui with default items
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(1, in, blankGui);
        }
        gui.setItem(2, 1, blankGui);
        gui.setItem(2, 9, blankGui);
        for (int i = 0; i < 9; i++) {
            int in = i + 1;
            gui.setItem(3, in, blankGui);
        }
        gui.setItem(3, 1, prevGui);
        // ? Not in use until new page is needed
        // gui.setItem(3, 9, nextGui);

        // Populating Gui with Menu Items
        gui.setItem(2, 2, spawnGui);
        gui.setItem(2, 3, marketGui);
        gui.setItem(2, 4, leafyGui);
        gui.setItem(2, 5, aolGui);
        gui.setItem(2, 6, libraryGui);
        gui.setItem(2, 7, redsGui);
        gui.setItem(2, 8, dunGui);

        // Sends Gui to player
        gui.open(player);
    }

}
