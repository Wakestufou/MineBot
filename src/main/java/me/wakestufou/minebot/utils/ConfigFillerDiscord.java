package me.wakestufou.minebot.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFillerDiscord implements ConfigFiller{

    @Override
    public void fill(FileConfiguration fileConfiguration) {
        ConfigurationSection cfgSection = fileConfiguration.createSection("discord");

        cfgSection.set("token", "");
        cfgSection.set("prefix", "/");
        cfgSection.set("invit", "invitDiscord");
        cfgSection.set("guildid", "933711800678121492");
        cfgSection.set("channelid", "944591738411036672");
        cfgSection.set("name", "MineBot");
    }
}
