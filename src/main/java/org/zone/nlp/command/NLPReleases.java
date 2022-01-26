package org.zone.nlp.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import org.zone.nlp.group.Words;

import java.util.Collection;
import java.util.List;

public class NLPReleases implements NLPCommand {
    @Override
    public Collection<List<WordKey>> getRequiredQuestion() {
        return List.of(
                List.of(new WordKey(Words.WHERE), new WordKey(Words.DOWNLOAD)),
                List.of(new WordKey(Words.DOWNLOAD), new WordKey(Words.LINK)));
    }

    @Override
    public Message getResponse(String originalMessage) {
        return new MessageBuilder()
                .setEmbeds(new EmbedBuilder()
                        .setTitle("Betas")
                        .setAuthor("github", "https://github.com/Zone-Protect/Zone-protect/releases")
                        .build())
                .setContent("Looking for the downloads?")
                .build();
    }

    @Override
    public String getCommand() {
        return "download";
    }
}
