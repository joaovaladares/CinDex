package erros;

public class ClienteJaCadastradoException extends Exception {
    public ClienteJaCadastradoException(){ super("Cliente já cadastrado!");}
}
