package Pessoa;
import erros.*;
public class RepositorioFuncionarioLista implements RepositorioFuncionario{
    private Funcionario funcionario;
    private RepositorioFuncionarioLista proximo;

    // Construtor da lista
    public RepositorioFuncionarioLista() {
        this.funcionario = null;
        this.proximo = null;
    }

    // Insere novo funcionario na lista
    public void inserir(Funcionario funcionario) {
        if (this.funcionario == null) {
            this.funcionario = funcionario;
            this.proximo = new RepositorioFuncionarioLista();
        } else {
            this.proximo.inserir(funcionario);
        }
    }

    // Remove um funcionario da lista, caso o mesmo exista
    public void remover(String cpf)
            throws FuncionarioNaoEncontradoException {
        Funcionario funcionarioEncontrado = this.procurar(cpf);
        if (this.funcionario != null) {
            if (this.funcionario.equals(funcionarioEncontrado)) {
                this.funcionario = this.proximo.funcionario;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            FuncionarioNaoEncontradoException e;
            e = new FuncionarioNaoEncontradoException();
            throw e;
        }
    }

    // Procura por um funcioanrio na lista, caso o mesmo exista, retorna o funcionario
    public Funcionario procurar(String cpf)
            throws FuncionarioNaoEncontradoException {
        Funcionario retorno;
        retorno = null;
        if (this.funcionario != null) {
            if (this.funcionario.getIdentificador().equals(cpf)) {
                retorno = this.funcionario;
            } else {
                this.proximo.procurar(cpf);
            }
        } else {
            FuncionarioNaoEncontradoException e;
            e = new FuncionarioNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    // Atualiza um funcionario na lista, caso o mesmo exista
    public void atualizar(Funcionario funcionario)
            throws FuncionarioNaoEncontradoException {
        Funcionario funcionarioAntigo = procurar(funcionario.getIdentificador());
        this.remover(funcionarioAntigo.getIdentificador());
        this.inserir(funcionario);
    }

    // Verifica se existe um funcionario, dado um identificador
    public boolean existe(String cpf) {
        if (this.funcionario != null) {
            if (this.funcionario.getIdentificador().equals(cpf)) {
                return true;
            } else {
                return this.proximo.existe(cpf);
            }
        } else {
            return false;
        }
    }
}
