package erros;

public class IdentificadorFuncionarioInvalidoException extends Exception {
    public IdentificadorFuncionarioInvalidoException(){ super("Identificador inválido, favor informar CPF com 11 dígitos ou CNPJ com 14 dígitos!");}
}
