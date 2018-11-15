package erros;

public class SexoInvalidoException extends Exception {
    public SexoInvalidoException(){ super("Informação inválida, favor informar 'masculino', 'feminino' ou 'outro'");}
}
