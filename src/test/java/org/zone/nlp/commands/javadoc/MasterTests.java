package org.zone.nlp.commands.javadoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zone.nlp.command.NLPCommandManager;
import org.zone.nlp.command.NLPWhereAreJavadocs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MasterTests {

    public static final Collection<String> SUCCESS_SENTENCES = List.of("Where are the javadocs located?",
            "url for the jd");
    public static final Collection<String> FAIL_SENTENCES = List.of("random unrelated text",
            "javadocs where?",
            "javadocs");

    @Test
    public void test_pass_sentences() {
        SUCCESS_SENTENCES.forEach(sentence -> {
            Collection<Integer> list = new ArrayList<>(1);
            NLPCommandManager manager = new NLPCommandManager();
            manager.register((s, nlpCommand) -> list.add(1));

            manager.call("Where are the javadocs located?", new NLPWhereAreJavadocs());

            Assertions.assertEquals(1, list.size(), "The line of '" + sentence + "' failed");
        });
    }

    @Test
    public void test_fail_sentences() {
        FAIL_SENTENCES.forEach(sentence -> {
            Collection<Integer> list = new ArrayList<>(1);
            NLPCommandManager manager = new NLPCommandManager();
            manager.register((s, nlpCommand) -> list.add(1));

            manager.call(sentence, new NLPWhereAreJavadocs());

            Assertions.assertEquals(0, list.size(), "The line of '" + sentence + "' passed");
        });
    }
}
