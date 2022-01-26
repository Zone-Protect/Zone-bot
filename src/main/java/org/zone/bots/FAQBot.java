package org.zone.bots;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.zone.ZoneBot;

public class FAQBot extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        String text = message.getContentDisplay();
        String textOnly = "";
        for (int i = 0; i < text.length(); i++) {
            char at = text.charAt(i);
            if ((Character.isLetterOrDigit(at) || at==' ')) {
                textOnly = textOnly + at;
            }
        }
        ZoneBot.getInstance().getNaturalLanguageCommandManager().call(textOnly,
                (text1, cmd) -> message.reply(cmd.getResponse(text1)).queue());
    }
}
