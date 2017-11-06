package botfacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import interacaobot.Bot;

public class BotFacebook implements Bot{

    @Override
    public boolean entrar(String token) {
        
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(token, token);
        facebook.setOAuthPermissions(token);
        facebook.setOAuthAccessToken(new AccessToken(token, null));
        
        try{
            facebook.postStatusMessage("Hello World!");
            ResponseList<Post> feed = facebook.getHome();
            
            for (Post post : feed) {
                
                facebook.likePost(post.getId());
            }
        }catch(FacebookException fe){
            fe.printStackTrace();
        }
        
        
        return false;
    }

    @Override
    public void enviaMensagem(String mensagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sair() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
