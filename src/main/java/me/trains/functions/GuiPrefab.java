package me.trains.functions;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
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
        ItemStack passItem = ItemMaker.noLore("Day Passes", Material.CLOCK);
        GuiItem passGui = ItemBuilder.from(passItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Day passes"));
        });

        // Admin Gui
        ItemStack adminItem = ItemMaker.noLore("Admin Gui", Material.BARRIER);
        GuiItem adminGui = ItemBuilder.from(adminItem).asGuiItem(event -> {
           event.setCancelled(true);
           player.sendMessage(Component.text("Admin Gui"));
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
        });

        // Land Gui Item
        ItemStack landItem = ItemMaker.noLore("Land Kingdom", Material.GRASS_BLOCK);
        GuiItem landGui = ItemBuilder.from(landItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Land Kingdom"));
        });

        // Sea Gui Item
        ItemStack seaItem = ItemMaker.noLore("Sea Kingdom", Material.NAUTILUS_SHELL);
        GuiItem seaGui = ItemBuilder.from(seaItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("Sea Kingdom"));
        });

        // East Wind Gui Item
        ItemStack eastItem = ItemMaker.noLore("East Wind Demons", Material.AMETHYST_SHARD);
        GuiItem eastGui = ItemBuilder.from(eastItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("East Wind Demons"));
        });

        // West Wind Gui Item
        ItemStack westItem = ItemMaker.noLore("West Wind Demons", Material.BLAZE_POWDER);
        GuiItem westGui = ItemBuilder.from(westItem).asGuiItem(event -> {
            event.setCancelled(true);
            player.sendMessage(Component.text("West Wind Demons "));
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
        });

        // Previous Item
        ItemStack prevItem = ItemMaker.noLore("Previous Page", Material.REDSTONE);
        GuiItem prevGui = ItemBuilder.from(prevItem).asGuiItem(event -> {
            event.setCancelled(true);
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
    public void pageOne(Player player) {

    }

}
