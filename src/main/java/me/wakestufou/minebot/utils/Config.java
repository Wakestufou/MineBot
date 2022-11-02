package me.wakestufou.minebot.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Config {
    private static Config _instance;
    private Plugin _plugin;
    private Map<String, FileConfiguration> _filesMap;

    private Config() {
        this._filesMap = new HashMap<>();
    }

    public void load() {
        setDataFolder();
        setFiles();
    }

    private void setFiles() {
        File file = new File(_plugin.getDataFolder(), "config.yml");
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                if (!file.createNewFile())
                    this._plugin.getLogger().severe("Config File can't be created.");
                else
                    this._plugin.getLogger().info("Config File has been created. " + ChatColor.GREEN + "Please stop the server and complete the config file !");

                (new ConfigFillerDiscord()).fill(fileConfiguration);
                fileConfiguration.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this._filesMap.put("config.yml", fileConfiguration);
    }

    private void setDataFolder() {
        if (!this._plugin.getDataFolder().exists()) {
            if (this._plugin.getDataFolder().mkdir())
                this._plugin.getLogger().info("DataFolder has been created.");
            else
                this._plugin.getLogger().severe("DataFolder can't be created.");
        }
    }

    public Config setPlugin(Plugin plugin) {
        this._plugin = plugin;
        return _instance;
    }

    public static Config getInstance() {
        if (_instance == null)
            _instance = new Config();
        return _instance;
    }

    public FileConfiguration getConfigurationFile(String s) {
        AtomicReference<FileConfiguration> file = new AtomicReference<>(null);
        this._filesMap.forEach((name, fileConfiguration) -> {
            if (name.equalsIgnoreCase(s))
                file.set(fileConfiguration);
        });

        return file.get();
    }
}
