package me.trains.functions;

import me.trains.Formats;
import org.bukkit.entity.Player;

public class Movement {

    public void start(Player player, double destX, double destY, double destZ, String destName, String fromName) {

        // temp train cords -344.5 87 -152.5
        // temp dest cords -305.5 78 -90.5
        // temp stat cords -248.5 79 -89.5

        player.sendMessage(Formats.success() + "Moving you on the to train headed for " + destName + " from " + fromName);
    }
}
