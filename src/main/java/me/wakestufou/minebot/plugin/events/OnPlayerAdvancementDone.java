package me.wakestufou.minebot.plugin.events;

import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.utils.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class OnPlayerAdvancementDone implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void OnPlayerAdvancementDone(PlayerAdvancementDoneEvent e) {
        if (e.getAdvancement().getKey().getKey().startsWith("recipes") || e.message() == null) {
            return;
        }

        Message.sendEmbedAdvancement(PlainTextComponentSerializer.plainText().serialize((Component) Objects.requireNonNull(e.message())),
                "https://crafatar.com/avatars/" + e.getPlayer().getUniqueId().toString() + "?overlay=1");
    }
}
