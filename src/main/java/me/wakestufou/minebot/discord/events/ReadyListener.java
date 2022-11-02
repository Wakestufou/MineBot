package me.wakestufou.minebot.discord.events;


import me.wakestufou.minebot.MineBot;
import me.wakestufou.minebot.discord.utils.Message;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class ReadyListener implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if(event instanceof ReadyEvent) {
            MineBot.getPlugin(MineBot.class).getLogger().info("Bot is ready");
            Message.sendOpen();
        }
    }
}
