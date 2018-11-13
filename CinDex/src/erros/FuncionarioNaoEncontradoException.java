package erros;

public class FuncionarioNaoEncontradoException extends Exception{
    public FuncionarioNaoEncontradoException(){
        super("Funcionario não encontrado!");
    }
}
