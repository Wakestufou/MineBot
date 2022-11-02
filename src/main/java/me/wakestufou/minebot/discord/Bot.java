package me.wakestufou.minebot.discord;

import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.events.MessageListener;
import me.wakestufou.minebot.discord.events.ReadyListener;
import me.wakestufou.minebot.utils.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.configuration.ConfigurationSection;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class Bot {
    private JDA _bot;

    public Bot() {
        MineBot.getPlugin(MineBot.class).getLogger().info("Bot starting...");
        ConfigurationSection cs = Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord");
        if (cs != null && cs.get("token") != null) {

                this._bot = JDABuilder
                        .createDefault(
                            Objects.requireNonNull(cs.get("token")).toString(),
                                GatewayIntent.GUILD_MESSAGES,
                                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                                GatewayIntent.GUILD_MEMBERS,
                                GatewayIntent.GUILD_VOICE_STATES,
                                GatewayIntent.GUILD_INVITES,
                                GatewayIntent.SCHEDULED_EVENTS,
                                GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                                GatewayIntent.MESSAGE_CONTENT
                        )
                        .setActivity(Activity.listening("Minecraft"))
                        .addEventListeners(new ReadyListener())
                        .addEventListeners(new MessageListener())
                        .build();
        }
    }

    public JDA getJda() {
        return this._bot;
    }

    public void stop() {
        MineBot.getPlugin(MineBot.class).getLogger().info("Bot stopping...");
        this._bot.shutdown();
        MineBot.getPlugin(MineBot.class).getLogger().info("Bot stopped.");
    }
}
