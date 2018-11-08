package erros;

public class RotaNaoEncontradaException extends Exception {
    public RotaNaoEncontradaException() {
        super("Rota nao encontrada");
    }
}
