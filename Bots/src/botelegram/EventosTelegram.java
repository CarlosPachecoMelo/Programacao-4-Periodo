package botelegram;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import spark.Request;
import spark.Response;
import spark.Route;


public class EventosTelegram implements Route{
    
    private final String COMANDO = "/";
    private final TelegramBot bot;
    private final String token;
    long lastChatID;
    
    public EventosTelegram(String token) {
        this.bot = new TelegramBot(token);
        this.token = token;
    }
    
    @Override
    public Object handle(Request request, Response response) throws Exception {
        Update update = BotUtils.parseUpdate(request.body());
        Message message = update.message();
        
        if(isStartMessage(message) && onStart(message)){
            return "ok";
        }else{
            onWebhookUpdate(update);
        }
        
        return "ok";
        
    }

    private boolean isStartMessage(Message message) {
        return message != null && message.text() != null && message.text().startsWith("/start");
    }

    protected boolean onStart(Message message) {
        return false;
    }
    
    void onWebhookUpdate(Update update){
        lastChatID = update.message().chat().id();
       
        if(update.message().text().startsWith(COMANDO + "hello")){
            bot.execute(new SendMessage(update.message().chat().id(), "Hello World!"));
        }else{
            bot.execute(new SendMessage(update.message().chat().id(), "Comando inválido!"));
        }
    }
    
    String getToken(){
        return token;
    }
    
    TelegramBot getBot(){
        return bot;
    }
    
}
