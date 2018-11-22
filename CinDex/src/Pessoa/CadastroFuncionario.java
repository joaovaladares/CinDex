package Pessoa;
import erros.*;
public class CadastroFuncionario {
    private RepositorioFuncionarios repositorio;
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
    public void cadastrar(Funcionario funcionario) throws FuncionarioJaCadastradoException, LimiteAtingidoException, SexoInvalidoException, DataNascimentoInvalidaException, IdentificadorFuncionarioInvalidoException{
        if(!this.repositorio.existe(funcionario.getIdentificador())){
            if(!(funcionario.getSexo().equalsIgnoreCase("masculino") || funcionario.getSexo().equalsIgnoreCase("feminino") || funcionario.getSexo().equalsIgnoreCase("outro"))){
                SexoInvalidoException e;
                e = new SexoInvalidoException();
                throw e;
            }
            if(funcionario.getDataNascimento().length()!=8){
                DataNascimentoInvalidaException e;
                e = new DataNascimentoInvalidaException();
                throw e;
            }
            if(funcionario.getIdentificador().length()!=11){
                IdentificadorFuncionarioInvalidoException e;
                e= new IdentificadorFuncionarioInvalidoException();
                throw e;
            }
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
