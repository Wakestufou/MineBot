package me.wakestufou.minebot.plugin.events;

import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.utils.Message;
import me.wakestufou.minebot.utils.Config;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class OnPlayerQuit implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Message.sendEmbedQuit(e.getPlayer().getName(), "https://crafatar.com/avatars/" + e.getPlayer().getUniqueId().toString() + "?overlay=1");
        Objects.requireNonNull(MineBot.getInstance().getBot().getJda().getGuildById(
                        Objects.requireNonNull(Objects.requireNonNull(Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord")).get("guildid")).toString()
                ))
                .getSelfMember()
                .modifyNickname(
                        Objects.requireNonNull(Objects.requireNonNull(Config
                                        .getInstance()
                                        .getConfigurationFile("config.yml")
                                        .getConfigurationSection("discord"))
                                .get("name")) +
                                " / Connected Player : " +
                                (MineBot.getInstance().getServer().getOnlinePlayers().size() - 1)
                ).queue();
    }
}
