package me.wakestufou.minebot.discord.events;

import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.utils.Config;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot() && event.getChannel().getId().equalsIgnoreCase(Objects.requireNonNull(Objects.requireNonNull(Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord")).get("channelid")).toString())) {
            MineBot.getInstance().getServer().sendMessage(Component.text(ChatColor.AQUA + "[DISCORD]" + ChatColor.RESET + "<" + event.getAuthor().getName() + "> " + event.getMessage().getContentRaw()));
        }
    }
}
