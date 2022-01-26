package org.zone.nlp.command;

import net.dv8tion.jda.api.entities.Message;
import org.zone.nlp.group.Word;

import java.util.Collection;
import java.util.List;

public interface NLPCommand {

    Collection<List<Word>> getRequiredQuestion();

    Message getResponse(String originalMessage);

}
