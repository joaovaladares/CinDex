package Pessoa;
import erros.*;
public interface RepositorioClientes {
    void inserir(Cliente cliente)
            throws LimiteAtingidoException;
    void atualizar(Cliente cliente)
            throws ClienteNaoEncontradoException;
    void remover(String cpf)
            throws ClienteNaoEncontradoException;
    Cliente procurar(String cpf)
            throws ClienteNaoEncontradoException;
    boolean existe(String cpf);
}
