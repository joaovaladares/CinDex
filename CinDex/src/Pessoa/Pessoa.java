package Pessoa;

import erros.CpfInvalidoException;

import java.util.InputMismatchException;

public abstract class Pessoa {
    protected String nome;
    protected long cpf;

    public String getNome() { return nome; }
    public String getCpf() {String cpf = ""; cpf+=this.cpf; return cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(long cpf) throws CpfInvalidoException{
        String teste = "" + cpf;
        if(teste.length()==11){
            this.cpf = cpf;

        } else{
            CpfInvalidoException e;
            e= new CpfInvalidoException();
            throw e;
        }
    }
}
