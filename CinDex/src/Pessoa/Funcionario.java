package Pessoa;

import erros.IdentificadorFuncionarioInvalidoException;
import erros.SexoInvalidoException;

public class Funcionario extends PessoaAbstrato {
    private double salario;

    Funcionario(String nome, long identificador, String sexo, String dataNascimento, double salario)
            throws IdentificadorFuncionarioInvalidoException, SexoInvalidoException {
        super(nome, sexo, dataNascimento);
        //verifica se o identificador informado é válido
        String teste = "" + identificador;
        if (teste.length()==11 || teste.length()==14) {
            this.identificador = identificador;
        } else {
            IdentificadorFuncionarioInvalidoException e;
            e = new IdentificadorFuncionarioInvalidoException();
            throw e;
        }
        this.salario = salario;
    }

    public double getSalario() { return salario; }
    public String getIdentificador() {
        String identificador = "";
        identificador+=this.identificador;
        return identificador; }
    public void setSalario(double salario){ this.salario = salario; }
    public void setIdentificador(long identificador) throws IdentificadorFuncionarioInvalidoException{
        String teste = "" + identificador;
        if(teste.length()==11 || teste.length()==14){
            this.identificador = identificador;
        } else{
            IdentificadorFuncionarioInvalidoException e;
            e= new IdentificadorFuncionarioInvalidoException();
            throw e;
        }
    }
}
