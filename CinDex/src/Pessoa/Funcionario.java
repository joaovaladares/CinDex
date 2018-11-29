package Pessoa;

public class Funcionario extends PessoaAbstrata {

    private double salario;

    private String matricula;

    Funcionario(String nome, long identificador, String sexo, String dataNascimento, double salario, String matricula) {
        super(nome, sexo, dataNascimento);
        this.identificador = identificador;
        this.salario = salario;
        this.matricula = matricula;
    }


    public double getSalario() { return salario; }

    public void setSalario(double salario){ this.salario = salario; }

    public String getCodigo() {
        return this.matricula;
    }
}
