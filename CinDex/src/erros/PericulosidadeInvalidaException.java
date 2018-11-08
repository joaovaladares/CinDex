package erros;

public class PericulosidadeInvalidaException extends Exception {
    public PericulosidadeInvalidaException() {
        super("Periculosidade invalida, favor informar se a 'Segura' ou 'Perigosa' ");
    }
}
