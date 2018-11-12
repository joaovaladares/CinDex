package Pessoa;

import erros.CpfInvalidoException;

import java.util.InputMismatchException;

public class Funcionario extends Pessoa{
    private double salario;

    Funcionario(String nome, long cpf, double salario) throws CpfInvalidoException{
        String teste = ""+cpf;
        this.nome = nome;
        //verifica se o cpf informado é válido

        if (teste.length()==11) {
            try {
                this.cpf = cpf;
            }
            catch (InputMismatchException f){
                CpfInvalidoException e;
                e = new CpfInvalidoException();
                throw e;
            }
        } else {
            CpfInvalidoException e;
            e = new CpfInvalidoException();
            throw e;
        }
        this.salario = salario;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario){ this.salario = salario; }
}
