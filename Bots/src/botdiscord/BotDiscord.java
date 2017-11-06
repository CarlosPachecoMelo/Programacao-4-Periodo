package botdiscord;

import interacaobot.Bot;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class BotDiscord implements Bot{
    
    IDiscordClient cliente;
    private IChannel canal;
    static String COMANDO = "/";
    
    @Override
    public boolean entrar(String token) {
        
        cliente= new ClientBuilder().withToken(token).build();
        cliente.getDispatcher().registerListener(new EventosDiscord(this));
        cliente.login();
        
        if(cliente != null){
            return true;
        }
        return false;
        
    }

    @Override
    public void sair() {
        enviaMensagem("Estou offline =(");
        cliente.logout();
    }

    @Override
    public void enviaMensagem(String mensagem) {
        
        RequestBuffer.request(() -> {
            try{
                canal.sendMessage(mensagem);
            } catch (DiscordException e){
                System.out.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });
        
    }

        public void enviaMensagem(IChannel canal, String mensagem) {
        
        RequestBuffer.request(() -> {
            try{
                canal.sendMessage(mensagem);
            } catch (DiscordException e){
                System.out.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });
        
    }
    
    public boolean join(IChannel channel){
        canal = channel;
        if(canal != null){
            return true;
        }
        return false;
    }
    
}
