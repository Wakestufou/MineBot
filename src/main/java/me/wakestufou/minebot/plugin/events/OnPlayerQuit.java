package me.wakestufou.minebot.plugin.events;

import me.wakestufou.minebot.discord.utils.Message;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerQuit implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Message.sendEmbedQuit(e.getPlayer().getName(), "https://crafatar.com/avatars/" + e.getPlayer().getUniqueId().toString() + "?overlay=1");
    }
}
