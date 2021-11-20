package me.trains;

import co.aikar.commands.PaperCommandManager;
import me.trains.commands.Trains;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    private PaperCommandManager commandManager;
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        setupACF();
        loadModules();
    }

    private void setupACF() {
        commandManager = new PaperCommandManager(this);
    }

    private void loadModules() {
        // TODO: add this you fucking idiot if you don't im gonna be mad
    }

    public static Main getInstance() {
        return instance;
    }

    public PaperCommandManager getCommandManager() {
        return commandManager;
    }
}
