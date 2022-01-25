package org.zone.nlp.command;

import org.zone.nlp.group.Word;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.function.BiConsumer;

public class NLPCommandManager {

    private final Collection<NLPCommand> commands = new LinkedHashSet<>();
    private final Collection<BiConsumer<String, NLPCommand>> events = new LinkedHashSet<>();

    public Collection<NLPCommand> getCommands() {
        return Collections.unmodifiableCollection(this.commands);
    }

    public synchronized void register(BiConsumer<String, NLPCommand> consumer) {
        this.events.add(consumer);
    }

    public void call(String message, NLPCommand command) {
        boolean check = command.getRequiredQuestion().stream().anyMatch(keyWords -> {
            String[] words = message.split(" ");
            int pointer = 0;
            for (Word keyWord : keyWords) {
                boolean passed = false;
                for (int i = pointer; i < words.length; i++) {
                    String targetWord = words[i];
                    if (keyWord.match(targetWord)) {
                        pointer = i;
                        passed = true;
                        break;
                    }
                }
                if (passed) {
                    continue;
                }
                return false;
            }
            return true;
        });
        if (check) {
            this.events.parallelStream().forEach(action -> action.accept(message, command));
        }
    }

}
