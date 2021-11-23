package me.trains.events;

import me.trains.Main;
import me.trains.functions.GuiPrefab;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Objects;


public class PlayerInteract implements Listener {

    public PlayerInteract() {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        if (Objects.equals(event.getRightClicked().getName(), "Train Operator")) {
            GuiPrefab.menu(event.getPlayer());
        }
    }
}
