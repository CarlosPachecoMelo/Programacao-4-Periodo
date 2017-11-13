package botelegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import interacaobot.Bot;
import static spark.Spark.post;
import static spark.Spark.port;
import com.pengrad.telegrambot.request.SetWebhook;
import static spark.Spark.*;
        
public class BotTelegram implements Bot{
    
    TelegramBot bot;
    EventosTelegram eventosTelegram;
    
    @Override
    public boolean entrar(String token) {
        eventosTelegram = new EventosTelegram(token);

        this.bot = eventosTelegram.getBot();
        
        ipAddress("149.154.167.50");
        port(443);
        
        get("/hello", (req, res) -> "Hello World");

        eventosTelegram = new EventosTelegram(token);
        post("/" + eventosTelegram.getToken(), eventosTelegram);

        String appSite = System.getenv("OPENSHIFT_APP_DNS");
        eventosTelegram.getBot().execute(new SetWebhook().url(appSite + "/" + eventosTelegram.getToken()));
        
        if(bot != null){
            return true;
        }
        return false;
   
    }

    
    @Override
    public void enviaMensagem(String mensagem) {
        bot.execute(new SendMessage(eventosTelegram.lastChatID, mensagem));
    }

    @Override
    public void sair() {
        System.out.println("Função não suportada pela API!");
    }
    
}
