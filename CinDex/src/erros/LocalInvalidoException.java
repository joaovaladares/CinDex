package erros;

public class LocalInvalidoException extends Exception{
    public LocalInvalidoException() {
        super("Local invalido, favor informe um local existente");
    }
}
