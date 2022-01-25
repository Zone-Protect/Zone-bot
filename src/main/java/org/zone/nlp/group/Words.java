package org.zone.nlp.group;

public enum Words implements Word {
    WHAT("what"),
    WHERE("where"),
    LINK("link", "url", "uri"),
    JAVA_DOCS("JavaDoc", "jd", "javadocs");


    private final String correct;
    private final String[] common;

    private Words(String correct, String... common) {
        this.common = common;
        this.correct = correct;
    }

    @Override
    public String getCorrectSpelling() {
        return this.correct;
    }

    @Override
    public String[] getCommonSpelling() {
        return this.common;
    }
}
