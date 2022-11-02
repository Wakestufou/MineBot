package me.wakestufou.minebot.discord.events;


import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.utils.Message;
import me.wakestufou.minebot.utils.Config;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ReadyListener implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof ReadyEvent) {
            MineBot.getPlugin(MineBot.class).getLogger().info("Bot is ready");
            Message.sendOpen();
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
                                    (MineBot.getInstance().getServer().getOnlinePlayers().size())
                    ).queue();

            Objects.requireNonNull(
                Objects.requireNonNull(
                    MineBot
                        .getInstance()
                        .getBot()
                        .getJda()
                        .getGuildById(
                            Objects.requireNonNull(
                                Objects.requireNonNull(
                                    Config
                                        .getInstance()
                                        .getConfigurationFile("config.yml")
                                        .getConfigurationSection("discord"))
                                        .get("guildid"))
                                    .toString()
                        )
                )
                .getTextChannelById(
                Objects.requireNonNull(Objects.requireNonNull(Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord")).get("channelid")).toString())
            ).getManager().setTopic("Server Open !").queue();

        }
    }
}
