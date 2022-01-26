package org.zone.nlp.command;

import net.dv8tion.jda.api.entities.Message;

import java.util.Collection;
import java.util.List;

public interface NLPCommand {

    Collection<List<WordKey>> getRequiredQuestion();

    Message getResponse(String originalMessage);

    String getCommand();

}
