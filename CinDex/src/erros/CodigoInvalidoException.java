package erros;

public class CodigoInvalidoException extends Exception {
    public CodigoInvalidoException() {
        super("Codigo invalido, favor adicionar um codigo com 5 numeros");
    }
}
