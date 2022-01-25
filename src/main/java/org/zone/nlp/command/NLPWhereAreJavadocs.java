package org.zone.nlp.command;

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
}
