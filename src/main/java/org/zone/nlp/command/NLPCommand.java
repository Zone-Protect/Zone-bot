package org.zone.nlp.command;

import org.zone.nlp.group.Word;

import java.util.Collection;
import java.util.List;

public interface NLPCommand {

    Collection<List<Word>> getRequiredQuestion();

}
