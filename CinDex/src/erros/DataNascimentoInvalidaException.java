package erros;

public class DataNascimentoInvalidaException extends Exception {
    public DataNascimentoInvalidaException() { super("Data de nascimento inválida favor informar data com 8 caracteres(DDMMAAAA)");}
}
