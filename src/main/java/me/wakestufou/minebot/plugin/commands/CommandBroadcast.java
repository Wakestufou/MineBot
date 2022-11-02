package me.wakestufou.minebot.plugin.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandBroadcast implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length <= 0) {
                player.sendMessage("La commande est : /bc <message>");
            }
            else {
                StringBuilder bc = new StringBuilder();
                for (String arg :
                     args) {
                    bc.append(arg).append(" ");
                }

                Bukkit.broadcast(Component.text(bc.toString()));
            }
            return true;
        }
        return false;
    }
}
