package Pessoa;
import erros.*;
public class RepositorioFuncionarioArray implements RepositorioFuncionarios {
    private Funcionario[] arrayFuncionarios;
    private int indice;

    public RepositorioFuncionarioArray(){
        this.arrayFuncionarios = new Funcionario[200];
        this.indice = 0;
    }

    // Insere novo funcionario no array

    public void inserir(Funcionario funcionario)
            throws LimiteAtingidoException {

        // Verifica se ainda há espaço no array
        if(this.indice < this.arrayFuncionarios.length) {
            this.arrayFuncionarios[indice] = funcionario;
            indice = indice + 1;
        }else{
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    // Remove um funcionario do array, e reorganiza o array

    public void remover(String cpf)
            throws FuncionarioNaoEncontradoException {
        int index = this.getIndice(cpf);
        // Reorganiza os funcionarios no array
        if (this.arrayFuncionarios.length - 1 - index >= 0) {
            System.arraycopy(arrayFuncionarios, index + 1, this.arrayFuncionarios, index, this.arrayFuncionarios.length - 1 - index);
        }
        this.arrayFuncionarios[this.arrayFuncionarios.length - 1] = null;
        this.indice = this.indice - 1;
    }

    // Procura um funcionario no array, caso exista, retorna o funcionario
    public Funcionario procurar(String cpf)
            throws FuncionarioNaoEncontradoException{
        Funcionario retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayFuncionarios[i].getIdentificador().equals(cpf)) {
                retorno = this.arrayFuncionarios[i];
                achou = true;
            }
        }
        if(achou) {
            return retorno;
        }else{
            FuncionarioNaoEncontradoException e;
            e = new FuncionarioNaoEncontradoException();
            throw e;
        }
    }

    // Atualiza um funcionario no array, caso o mesmo exista
    public void atualizar(Funcionario funcionario)
            throws FuncionarioNaoEncontradoException{
        int index = this.getIndice(funcionario.getIdentificador());
        arrayFuncionarios[index] = funcionario;
    }

    // Verifica se existe um funcionario no array
    public boolean existe(String cpf){
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayFuncionarios[i].getIdentificador().equals(cpf)) {
                achou = true;
            }
        }
        return achou;
    }

    // Retorna o indice de um determinado funcionario no array
    private int getIndice(String cpf)
            throws FuncionarioNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayFuncionarios[i].getIdentificador().equals(cpf)) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            FuncionarioNaoEncontradoException e;
            e = new FuncionarioNaoEncontradoException();
            throw e;
        }
    }
}
