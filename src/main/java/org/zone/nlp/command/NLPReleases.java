package org.zone.nlp.command;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import org.zone.nlp.group.Word;
import org.zone.nlp.group.Words;

import java.util.Collection;
import java.util.List;

public class NLPReleases implements NLPCommand {
    @Override
    public Collection<List<Word>> getRequiredQuestion() {
        return List.of(List.of(Words.WHERE, Words.DOWNLOAD), List.of(Words.DOWNLOAD, Words.LINK));
    }

    @Override
    public Message getResponse(String originalMessage) {
        return new MessageBuilder().setContent("Looking for the downloads?\nStable - Ore: Not ready\nGithub - " +
                "Includes betas: https://github.com/Zone-Protect/Zone-protect/releases").build();
    }

    @Override
    public String getCommand() {
        return "download";
    }
}
