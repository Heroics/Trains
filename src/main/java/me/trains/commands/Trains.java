package me.trains.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.trains.Main;
import me.trains.functions.GuiPrefab;
import org.bukkit.entity.Player;

@CommandAlias("trains")
@CommandPermission("heroics.trains.command")
public class Trains extends BaseCommand {

    public Trains() {
        Main.getInstance().getCommandManager().registerCommand(this);
    }

    @Default
    public void train(Player player) {
        GuiPrefab.menu(player);
    }

    @Subcommand("admin")
    @CommandPermission("heroics.trains.admin")
    public void admin(Player player) {

    }

    @Subcommand("version")
    public void version(Player player) {
        // TODO: add credits and current version
    }
}
