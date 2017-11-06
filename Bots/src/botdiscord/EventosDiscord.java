package botdiscord;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class EventosDiscord {

    BotDiscord bot;

    public EventosDiscord(BotDiscord bot) {
        this.bot = bot;
    }
    
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        
        if(event.getMessage().getContent().startsWith(bot.COMANDO + "join")){
            bot.enviaMensagem(event.getChannel(), event.getAuthor() + " me chamou para conversar!");
            bot.join(event.getChannel());
        }
        
        if(event.getMessage().getContent().startsWith(bot.COMANDO + "hello")){
            bot.enviaMensagem(event.getChannel(), "Hello World!");
        }
        
        if(event.getMessage().getContent().startsWith(bot.COMANDO + "fuckyou")){
            bot.enviaMensagem(event.getChannel(), event.getAuthor() + " fuck you!");
        }
        
    }
    
}