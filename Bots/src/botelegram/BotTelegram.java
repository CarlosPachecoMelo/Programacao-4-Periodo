package botelegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import interacaobot.Bot;
import java.util.List;

public class BotTelegram implements Bot{
    
    TelegramBot bot;
    GetUpdates updates;
    
    @Override
    public boolean entrar(String token) {
        bot = new TelegramBot(token);
        
        Update update = new Update();
        updates = new GetUpdates().limit(10).offset(0).timeout(0);
        GetUpdatesResponse updatesResponse = bot.execute(updates);
        List<Update> listUpdates = updatesResponse.updates();
        
        Message message = update.message();
        
        bot.setUpdatesListener (new UpdatesListener(){
            @Override
            public int process(List<Update> updates){
                
                
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
        
        if(bot != null){
            return true;
        }
        return false;
   
    }

    
    
    
    @Override
    public void enviaMensagem(String mensagem) {
        
        bot.execute(null);
        
    }

    @Override
    public void sair() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
