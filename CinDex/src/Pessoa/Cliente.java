package Pessoa;

import Local.*;

public class Cliente extends PessoaAbstrata {

    private Local local;

    private long cpf;

    //construtor sem local

    public Cliente(String nome, String identificador, String sexo, String dataNascimento) {
        super(nome, sexo, dataNascimento);
        this.identificador = identificador;
        local = null;
    }

    //construtor com local
    public Cliente(String nome, String identificador, String sexo, String dataNascimento, Local local) {
        super(nome, sexo, dataNascimento);
        this.identificador = identificador;
        this.local = local;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getCodigo() {
        return this.getIdentificador();
    }
}


