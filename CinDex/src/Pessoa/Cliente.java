package Pessoa;

import erros.*;
import Local.*;

public class Cliente extends PessoaAbstrato {
    private Local local;

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

    public String getIdentificador() {
        String cpf = "";
        cpf += this.identificador;
        return cpf;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}


