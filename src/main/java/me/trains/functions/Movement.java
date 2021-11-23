package me.trains.functions;

import me.trains.Formats;
import me.trains.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Movement {

    public static void start(Player player, Location desLoc, String destName) {
        player.sendMessage(Formats.success() + "Moving you on the train headed for " + destName);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> train(player, desLoc, destName), 2 * 20L);
    }

    private static void train(Player player, Location destLoc, String destName) {
        Location trainLoc = new Location(Bukkit.getWorld("world"), -407.5, 33.5, 2214.5);
        player.teleport(trainLoc);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> dest(player, destLoc, destName), 10 * 20L);
    }

    private static void dest(Player player, Location destLoc, String destName) {
        player.teleport(destLoc);
        player.sendMessage(Component.text(Formats.success() + "Welcome to " + destName + ". Please enjoy your stay"));
    }
}
