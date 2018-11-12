package erros;

public class EnderecoNaoEncontradoException extends Exception {
    public EnderecoNaoEncontradoException () {
        super("Endereco nao encontrado, favor informar um ja cadastrado");
    }
}
