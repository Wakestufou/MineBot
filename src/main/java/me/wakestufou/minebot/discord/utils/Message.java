package me.wakestufou.minebot.discord.utils;

import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.utils.Config;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Message {
    private static final String guildId = Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord").get("guildid").toString();
    private static final String channelId = Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord").get("channelid").toString();

    public static void SendEmdedChat(String title, String message, String url) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Color.BLUE)
                .setDescription(message)
                .setAuthor(title, null, url);;

        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendOpen() {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Server Open")
                .setColor(Color.GREEN);
        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendClose() {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Server Closed")
                .setColor(Color.RED);
        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendEmbedJoin(String player, String url) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Color.GREEN)
                .setDescription("joined the game !")
                .setAuthor(player, null, url);;
        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();

    }

    public static void sendEmbedQuit(String name, String url) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Color.RED)
                .setDescription("left the game !")
                .setAuthor(name, null, url);;
        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendEmbedDeath(String name, String description, String url) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Color.BLACK)
                .setDescription(description)
                .setAuthor(name, null, url);
        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }

    public static void sendEmbedAdvancement(String name, String content) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setAuthor(name,
                        null,
                        content)
                .setColor(Color.MAGENTA);

        MineBot.getInstance().getBot().getJda().getGuildById(guildId).getTextChannelById(channelId).sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
