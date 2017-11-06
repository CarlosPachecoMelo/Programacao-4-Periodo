package interacaobot;

import botdiscord.BotDiscord;
import botelegram.BotTelegram;
import botfacebook.BotFacebook;

public class BotFactory {
    
    public static Bot createBot(String chat){
        switch (chat){
            case "Discord":
                return new BotDiscord();
            case "Telegram":
                return new BotTelegram();
            case "Facebook":
                return new BotFacebook();
        }
        return null;
    }
    
}
