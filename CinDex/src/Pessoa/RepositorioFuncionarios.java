package Pessoa;
import erros.*;
public interface RepositorioFuncionarios {
    void inserir(Funcionario funcionario)
            throws LimiteAtingidoException;
    void atualizar(Funcionario funcionario)
            throws FuncionarioNaoEncontradoException;
    void remover(String cpf)
            throws FuncionarioNaoEncontradoException;
    Funcionario procurar(String cpf)
            throws FuncionarioNaoEncontradoException;
    boolean existe(String cpf);
}
