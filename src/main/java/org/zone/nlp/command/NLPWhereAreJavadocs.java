package org.zone.nlp.command;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import org.zone.nlp.group.Word;
import org.zone.nlp.group.Words;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NLPWhereAreJavadocs implements NLPCommand {

    @Override
    public Collection<List<Word>> getRequiredQuestion() {
        return Arrays.asList(List.of(Words.LINK, Words.JAVA_DOCS), List.of(Words.WHERE, Words.JAVA_DOCS));
    }

    @Override
    public Message getResponse(String originalMessage) {
        return new MessageBuilder().setContent("Looking for the Javadocs?\nhttps://zone-protect.github.io/Zone-protect/").build();
    }
}
