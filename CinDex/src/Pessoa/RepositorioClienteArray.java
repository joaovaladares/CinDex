package Pessoa;
import erros.*;
public class RepositorioClienteArray implements RepositorioCliente {
    private Cliente[] arrayClientes;
    private int indice;

    public RepositorioClienteArray(){
        this.arrayClientes = new Cliente[200];
        this.indice = 0;
    }

    // Insere novo cliente no array

    public void inserir(Cliente cliente)
            throws LimiteAtingidoException {

        // Verifica se ainda há espaço no array
        if(this.indice < this.arrayClientes.length) {
            this.arrayClientes[indice] = cliente;
            indice = indice + 1;
        }else{
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    // Remove um cliente do array, e reorganiza o array

    public void remover(String cpf)
            throws ClienteNaoEncontradoException {
        int index = this.getIndice(cpf);
        // Reorganiza os clientes no array
        if (this.arrayClientes.length - 1 - index >= 0) {
            System.arraycopy(arrayClientes, index + 1, this.arrayClientes, index, this.arrayClientes.length - 1 - index);
        }
        this.arrayClientes[this.arrayClientes.length - 1] = null;
        this.indice = this.indice - 1;
    }

    // Procura um cliente no array, caso exista, retorna o cliente
    public Cliente procurar(String cpf)
            throws ClienteNaoEncontradoException{
        Cliente retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayClientes[i].getCpf().equals(cpf)) {
                retorno = this.arrayClientes[i];
                achou = true;
            }
        }
        if(achou) {
            return retorno;
        }else{
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }
    }

    // Atualiza um cliente no array, caso o mesmo exista
    public void atualizar(Cliente cliente)
            throws ClienteNaoEncontradoException{
        int index = this.getIndice(cliente.getCpf());
        arrayClientes[index] = cliente;
    }

    // Verifica se existe um cliente no array
    public boolean existe(String cpf){
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayClientes[i].getCpf().equals(cpf)) {
                achou = true;
            }
        }
        return achou;
    }

    // Retorna o indice de um determinado cliente no array
    private int getIndice(String identificador)
            throws ClienteNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayClientes[i].getCpf().equals(identificador)) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }
    }

}
