package interacaobot;

public interface Bot {

    boolean entrar(String token);
    void sair();
    void enviaMensagem(String mensagem);
    
}
