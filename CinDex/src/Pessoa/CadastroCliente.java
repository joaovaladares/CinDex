package Pessoa;

import erros.*;

public class CadastroCliente {

    private RepositorioCliente repositorio;
    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroCliente(boolean tipo) {
        if (tipo) {
            this.repositorio = new RepositorioClienteLista();
        } else {
            this.repositorio = new RepositorioClienteArray();
        }
    }

    public void cadastrar(Cliente cliente)
        throws ClienteJaCadastradoException, LimiteAtingidoException{
            if(!this.repositorio.existe(cliente.getCpf())){
                this.repositorio.inserir(cliente);
            }
            else{
                ClienteJaCadastradoException e;
                e = new ClienteJaCadastradoException();
                throw e;
            }
        }

    // Recebe um cliente a ser atualizado no repositório
    public void atualizar(Cliente cliente)
            throws ClienteNaoEncontradoException {
        this.repositorio.atualizar(cliente);
    }

    // Remove um cliente com um determinado identificador
    public void remover(String cpf)
            throws ClienteNaoEncontradoException {
        this.repositorio.remover(cpf);
    }

    // Procura um cliente com um determinado identificador, e retorna o cliente caso exista
    public Cliente procurar(String cpf)
            throws ClienteNaoEncontradoException {
        return this.repositorio.procurar(cpf);
    }

    // Verifica se um dado cliente existe
    public boolean existe(String cpf) {
        return this.repositorio.existe(cpf);
    }

}





