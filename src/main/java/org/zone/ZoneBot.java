package org.zone;

import net.dv8tion.jda.api.JDABuilder;
import org.apache.log4j.BasicConfigurator;
import org.zone.bots.FAQBot;
import org.zone.nlp.command.NLPCommandManager;
import org.zone.nlp.command.NLPWhereAreJavadocs;

import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public final class ZoneBot {

    private final NLPCommandManager nlpCommandManager = new NLPCommandManager();

    private static Logger logger;
    private static ZoneBot bot;

    private ZoneBot() {

    }

    public NLPCommandManager getNaturalLanguageCommandManager() {
        return this.nlpCommandManager;
    }

    public static ZoneBot getInstance() {
        return bot;
    }

    public static void initBot() {
        bot = new ZoneBot();
        bot.nlpCommandManager.register(new NLPWhereAreJavadocs());
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger = Logger.getLogger("zone-bot");
        if (args.length!=1) {
            logger.warning("Token was not specified");
            return;
        }
        logger.info("Booting");
        initBot();
        try {
            JDABuilder.createDefault(args[0]).addEventListeners(new FAQBot()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
