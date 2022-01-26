package org.zone.bots;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.zone.ZoneBot;
import org.zone.nlp.command.NLPCommand;

import java.util.Optional;
import java.util.stream.Collectors;

public class PrefixBot extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (!(message.startsWith("zone!") || message.startsWith("zones!") || message.startsWith("z!"))) {
            return;
        }
        String[] commandSplit = message.split("! ", 2);
        if (commandSplit.length <= 1) {
            String rMessage =
                    ZoneBot.getInstance().getNaturalLanguageCommandManager().getCommands().parallelStream().map(nlpCommand -> " - " + nlpCommand.getCommand()).collect(Collectors.joining("\n"));
            event.getMessage().reply(new MessageBuilder().setContent(rMessage).build()).queue();
            return;
        }
        String command = commandSplit[1];
        Optional<NLPCommand> opCommand =
                ZoneBot.getInstance().getNaturalLanguageCommandManager().getCommands().parallelStream().filter(nlpCommand -> nlpCommand.getCommand().equalsIgnoreCase(command)).findAny();
        opCommand.ifPresent(nlpCommand -> event.getMessage().reply(nlpCommand.getResponse(message)).queue());
    }
}
