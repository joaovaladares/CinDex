package erros;

public class DimensaoInvalidaException extends Exception {
    public DimensaoInvalidaException() {
        super("Dimensão inválida, favor informar dimensão menor ou igual a 2 metros!");
    }
}
