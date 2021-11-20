package me.trains.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.trains.Main;
import org.bukkit.entity.Player;

@CommandAlias("trains")
public class Trains extends BaseCommand {

    public Trains() {
        Main.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public void train(Player player) {
        // TODO: add gui to this when player runs command
    }

    @Subcommand("admin")
    @CommandPermission("heroics.trains.admin")
    public void admin(Player player) {
        // TODO: add admin gui because why not
    }

    @Subcommand("version")
    public void version(Player player) {
        // TODO: add credits and current version
    }
}
