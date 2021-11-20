package me.trains;

import org.bukkit.ChatColor;

public class Formats {

    public static String success() {
        return ChatColor.translateAlternateColorCodes('&', "&d&l Trains &7&l- &r");
    }

    public static String error() {
        return ChatColor.translateAlternateColorCodes('&', "&d&l Trains &7&l- &c");
    }
}
