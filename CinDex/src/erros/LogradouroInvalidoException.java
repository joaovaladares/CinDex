package erros;

public class LogradouroInvalidoException extends Exception {
	public LogradouroInvalidoException() {
        super("Logradouro invalida, digite um logradouro valido.");
    }
}
