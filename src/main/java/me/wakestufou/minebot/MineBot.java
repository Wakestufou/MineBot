package me.wakestufou.minebot;

import me.wakestufou.minebot.discord.Bot;
import me.wakestufou.minebot.discord.utils.Message;
import me.wakestufou.minebot.plugin.commands.CommandBroadcast;
import me.wakestufou.minebot.plugin.events.*;
import me.wakestufou.minebot.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MineBot extends JavaPlugin {
    private Bot _bot;
    private static MineBot _instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        _instance = this;
        getLogger().info("Plugin start...");
        Config.getInstance().setPlugin(this).load();
        this._bot = new Bot();
        loadEvent();
        loadCommand();
    }

    public static MineBot getInstance() {
        return _instance;
    }

    public Bot getBot() {
        return this._bot;
    }

    private void loadCommand() {
        Objects.requireNonNull(getCommand("bc")).setExecutor(new CommandBroadcast());
    }

    private void loadEvent() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new OnAsyncPlayerChat(), this);
        pluginManager.registerEvents(new OnPlayerJoin(), this);
        pluginManager.registerEvents(new OnPlayerQuit(), this);
        pluginManager.registerEvents(new OnPlayerDeath(), this);
        pluginManager.registerEvents(new OnPlayerAdvancementDone(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
                                    .get("guildid")
                        )
                        .toString()
                    )
            )
            .getTextChannelById(
                Objects.requireNonNull(Objects.requireNonNull(Config.getInstance().getConfigurationFile("config.yml").getConfigurationSection("discord")).get("channelid")).toString())
        ).getManager().setTopic("Server Closed !").queue();
        Message.sendClose();
        this._bot.stop();
    }
}
