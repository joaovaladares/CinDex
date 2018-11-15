package Pessoa;
import erros.*;
public class CadastroFuncionario {
    private RepositorioFuncionario repositorio;
    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroFuncionario(boolean tipo){
        if(tipo){
            repositorio = new RepositorioFuncionarioLista();
        }
        else{
            repositorio = new RepositorioFuncionarioArray();
        }
    }
    //cadastra um funcionario no repositorio, caso ainda nao tenha sido cadastrado
    public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException, LimiteAtingidoException{
        if(!this.repositorio.existe(funcionario.getIdentificador())){
            this.repositorio.inserir(funcionario);
        }
        else{
            FuncionarioJaCadastradoException e;
            e = new FuncionarioJaCadastradoException();
            throw e;
        }
    }

    // Recebe um funcionario a ser atualizado no repositório
    public void atualizar(Funcionario funcionario)
            throws FuncionarioNaoEncontradoException {
        this.repositorio.atualizar(funcionario);
    }

    // Remove um funcionario com um determinado identificador
    public void remover(String cpf)
            throws FuncionarioNaoEncontradoException {
        this.repositorio.remover(cpf);
    }

    // Procura um funcinario com um determinado identificador, e retorna o funcioanrio caso exista
    public Funcionario procurar(String cpf)
            throws FuncionarioNaoEncontradoException {
        return this.repositorio.procurar(cpf);
    }

    // Verifica se um dado funcionario existe
    public boolean existe(String cpf) {

        return this.repositorio.existe(cpf);
    }

}
