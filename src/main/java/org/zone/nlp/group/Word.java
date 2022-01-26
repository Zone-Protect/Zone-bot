package org.zone.nlp.group;

import java.util.stream.Stream;

public interface Word {

    String getCorrectSpelling();

    String[] getCommonSpelling();

    default boolean match(String string) {
        if (string.endsWith("s") && !string.endsWith("ss")) {
            return this.match(string.substring(0, string.length() - 1));
        }
        if (string.equalsIgnoreCase(this.getCorrectSpelling())) {
            return true;
        }
        return Stream.of(this.getCommonSpelling()).anyMatch(common -> common.equalsIgnoreCase(string));
    }
}
