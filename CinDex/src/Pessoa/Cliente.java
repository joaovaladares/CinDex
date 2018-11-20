package Pessoa;

import erros.*;
import Local.*;

public class Cliente extends PessoaAbstrato {

    private Local local;

    private long cpf;

    //construtor sem local

    public Cliente(String nome, long identificador, String sexo, String dataNascimento) {
        super(nome, sexo, dataNascimento);
        this.identificador = identificador;
        local = null;
    }

    //construtor com local
    public Cliente(String nome, long identificador, String sexo, String dataNascimento, Local local) {
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

    public void setIdentificador(long identificador) {
        this.cpf = identificador;
    }
}


