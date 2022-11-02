package me.wakestufou.minebot.plugin.events;

import me.wakestufou.minebot.discord.utils.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerDeath implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Message.sendEmbedDeath(e.getPlayer().getName(), e.getDeathMessage(), "https://crafatar.com/avatars/" + e.getPlayer().getUniqueId().toString() + "?overlay=1");
    }
}
