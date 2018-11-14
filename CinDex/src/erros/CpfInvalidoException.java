package erros;

public class CpfInvalidoException extends Exception {
    public CpfInvalidoException() {
        super("CPF invalido, favor informar CPF válido.(11 dígitos numéricos)");
    }
}
