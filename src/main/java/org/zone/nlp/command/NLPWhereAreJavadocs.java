package org.zone.nlp.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import org.zone.nlp.group.Words;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NLPWhereAreJavadocs implements NLPCommand {

    @Override
    public Collection<List<WordKey>> getRequiredQuestion() {
        return Arrays.asList(
                List.of(new WordKey(Words.LINK), new WordKey(Words.JAVA_DOCS)),
                List.of(new WordKey(Words.WHERE), new WordKey(Words.JAVA_DOCS)));
    }

    @Override
    public Message getResponse(String originalMessage) {
        return new MessageBuilder()
                .setContent("Looking for the Javadocs?")
                .setEmbeds(new EmbedBuilder()
                        .setAuthor("Javadoc", "https://zone-protect.github.io/Zone-protect/")
                        .build())
                .build();
    }

    @Override
    public String getCommand() {
        return "javadocs";
    }
}
