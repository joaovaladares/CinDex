package Pessoa;
import erros.*;
public class RepositorioClienteLista implements RepositorioCliente{
    private Cliente cliente;
    private RepositorioClienteLista proximo;

    // Construtor da lista
    public RepositorioClienteLista() {
        this.cliente = null;
        this.proximo = null;
    }

    // Insere novo cliente na lista
    public void inserir(Cliente cliente) {
        if (this.cliente == null) {
            this.cliente = cliente;
            this.proximo = new RepositorioClienteLista();
        } else {
            this.proximo.inserir(cliente);
        }
    }

    // Remove um cliente da lista, caso o mesmo exista
    public void remover(String cpf)
            throws ClienteNaoEncontradoException {
        Cliente clienteEncontrado = this.procurar(cpf);
        if (this.cliente != null) {
            if (this.cliente.equals(clienteEncontrado)) {
                this.cliente = this.proximo.cliente;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }
    }

    // Procura por um cliente na lista, caso o mesmo exista, retorna o cliente
    public Cliente procurar(String cpf)
            throws ClienteNaoEncontradoException {
        Cliente retorno;
        retorno = null;
        if (this.cliente != null) {
            if (this.cliente.getIdentificador().equals(cpf)) {
                retorno = this.cliente;
            } else {
                this.proximo.procurar(cpf);
            }
        } else {
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    // Atualiza um cliente na lista, caso o mesmo exista
    public void atualizar(Cliente cliente)
            throws ClienteNaoEncontradoException {
        Cliente clienteAntigo = procurar(cliente.getIdentificador());
        this.remover(clienteAntigo.getIdentificador());
        this.inserir(cliente);
    }

    // Verifica se existe um cliente, dado um identificador
    public boolean existe(String cpf) {
        if (this.cliente != null) {
            if (this.cliente.getIdentificador().equals(cpf)) {
                return true;
            } else {
                return this.proximo.existe(cpf);
            }
        } else {
            return false;
        }
    }

}
