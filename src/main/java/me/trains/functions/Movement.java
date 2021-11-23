package me.trains.functions;

import me.trains.Formats;
import me.trains.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Movement {

    public static void start(Player player, Location desLoc, String destName, String fromName) {

        // temp train cords -344.5 87 -152.5
        // temp dest cords -305.5 78 -90.5
        // temp stat cords -248.5 79 -89.5

        // Server2 Train cords 486.5 79 246.5

        player.sendMessage(Formats.success() + "Moving you on the to train headed for " + destName + " from " + fromName);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> train(player, desLoc, destName), 2 * 20L);
    }

    private static void train(Player player, Location destLoc, String destName) {
        Location trainLoc = new Location(Bukkit.getWorld("world"), 486.5, 79, 246.5);
        player.teleport(trainLoc);
        player.sendMessage(Component.text("Something random to say here"));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> dest(player, destLoc, destName), 10 * 20L);
    }

    private static void dest(Player player, Location destLoc, String destName) {
        player.teleport(destLoc);
        player.sendMessage(Component.text(Formats.success() + "Welcome to " + destName + " please enjoy your stay"));
    }
}
