package erros;

public class CepInvalidoException extends Exception {
    public CepInvalidoException() {
        super("CEP invalido, favor informar CEP válido.(8 dígitos numéricos)");
    }
}
