package org.zone.nlp.command;

import org.zone.nlp.group.Word;

public class WordKey {

    private final Word word;
    private final boolean shouldFailIfFound;

    public WordKey(Word word) {
        this(word, false);
    }

    public WordKey(Word word, boolean shouldFailIfFound) {
        this.word = word;
        this.shouldFailIfFound = shouldFailIfFound;
    }

    public Word getWord() {
        return this.word;
    }

    public boolean isFailingWord() {
        return this.shouldFailIfFound;
    }
}
