package erros;

public class PacoteJaCadastradoException extends Exception {
    public PacoteJaCadastradoException(){
        super("Pacote já cadastrado!");
    }
}
