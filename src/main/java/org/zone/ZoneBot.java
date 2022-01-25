package org.zone;

import net.dv8tion.jda.api.JDABuilder;
import org.apache.log4j.BasicConfigurator;
import org.zone.bots.FAQBot;

import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public class ZoneBot {

    private static Logger logger;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger = Logger.getLogger("zone-bot");
        if (args.length!=1) {
            logger.warning("Token was not specified");
            return;
        }
        logger.info("Booting");
        try {
            JDABuilder.createDefault(args[0]).addEventListeners(new FAQBot()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
