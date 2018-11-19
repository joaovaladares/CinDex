package Pessoa;

import erros.IdentificadorFuncionarioInvalidoException;
import erros.SexoInvalidoException;

public class Funcionario extends PessoaAbstrato {
    private double salario;

    Funcionario(String nome, long identificador, String sexo, String dataNascimento, double salario) {
        super(nome, sexo, dataNascimento);
        this.identificador = identificador;
        this.salario = salario;
    }

    public double getSalario() { return salario; }
    public String getIdentificador() {
        String identificador = "";
        identificador+=this.identificador;
        return identificador; }
    public void setSalario(double salario){ this.salario = salario; }
    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}
