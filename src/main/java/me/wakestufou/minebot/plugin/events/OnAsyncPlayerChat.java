package me.wakestufou.minebot.plugin.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.utils.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnAsyncPlayerChat implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onAsyncPlayerChat(AsyncChatEvent e){
        TextComponent textComponent = (TextComponent) e.message();
        Message.SendEmdedChat(e.getPlayer().getName(), textComponent.content(), "https://crafatar.com/avatars/" + e.getPlayer().getUniqueId().toString() + "?overlay=1");
    }
}
