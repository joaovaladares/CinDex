package erros;

public class TipoInvalidoException extends Exception {
    public TipoInvalidoException() {
        super("Tipo invalido, favor informar se e 'Rural' ou 'Urbana' ");
    }
}
