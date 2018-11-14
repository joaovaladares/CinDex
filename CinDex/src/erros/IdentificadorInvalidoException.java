package erros;

public class IdentificadorInvalidoException extends Exception {
    public IdentificadorInvalidoException() {
        super("Identificador inválido, favor informar código com 6 digitos");
    }
}
