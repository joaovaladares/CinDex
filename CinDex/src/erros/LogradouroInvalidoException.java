package erros;

public class LogradouroInvalidoException extends Exception {
	public LogradouroInvalidoException() {
        super("Logradouro invalido, digite um logradouro valido.");
    }
}
