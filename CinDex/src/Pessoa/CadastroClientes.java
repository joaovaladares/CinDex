package Pessoa;

import erros.*;

public class CadastroClientes {

    private RepositorioClientes repositorio;
    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroClientes(boolean tipo) {
        if (tipo) {
            this.repositorio = new RepositorioClientesLista();
        } else {
            this.repositorio = new RepositorioClientesArray();
        }
    }

    public void cadastrar(Cliente cliente)
        throws ClienteJaCadastradoException, LimiteAtingidoException, CpfInvalidoException, SexoInvalidoException, DataNascimentoInvalidaException{
            if(!this.repositorio.existe(cliente.getIdentificador())){
                if(!(cliente.getSexo().equalsIgnoreCase("masculino") || cliente.getSexo().equalsIgnoreCase("feminino") || cliente.getSexo().equalsIgnoreCase("outro"))){
                    SexoInvalidoException e;
                    e = new SexoInvalidoException();
                    throw e;
                }
                if(cliente.getDataNascimento().length()!=8){
                    DataNascimentoInvalidaException e;
                    e = new DataNascimentoInvalidaException();
                    throw e;
                }
                if(cliente.getIdentificador().length()!=11){
                    CpfInvalidoException e;
                    e= new CpfInvalidoException();
                    throw e;
                }
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





