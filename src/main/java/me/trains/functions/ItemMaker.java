package me.trains.functions;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemMaker {

    public static ItemStack noLore(String name, Material material) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(ChatColor.WHITE + name));
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack withLore(Material material, String name, List<Component> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(ChatColor.WHITE + name));
        itemMeta.lore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
