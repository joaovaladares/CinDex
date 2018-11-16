package Pessoa;

import erros.*;
import Local.*;

public class Cliente extends PessoaAbstrato {
    private Local local;
    //construtor sem local
    public Cliente (String nome, long identificador, String sexo, String dataNascimento)
            throws CpfInvalidoException, SexoInvalidoException{
        super(nome,sexo, dataNascimento);
        //verifica se o identificador informado é válido
        String teste = "" + identificador;
        if (teste.length()==11) {
            this.identificador = identificador;
        } else {
            CpfInvalidoException e;
            e = new CpfInvalidoException();
            throw e;
        }
        local = null;
    }
    //construtor com local
    public Cliente (String nome, long cpf, String sexo, String dataNascimento, Local local)
            throws CpfInvalidoException, SexoInvalidoException{
        super(nome, sexo, dataNascimento);
        //verifica se o identificador informado é válido
        String teste = "" + cpf;
        if (teste.length()==11) {
            this.identificador = cpf;
        } else {
            CpfInvalidoException e;
            e = new CpfInvalidoException();
            throw e;
        }
        this.local = local;
    }

    public Local getLocal() throws LocalNaoCadastradoException{
        if(this.local!=null) {
            return this.local;
        }
        else{
            LocalNaoCadastradoException e;
            e = new LocalNaoCadastradoException();
            throw e;
        }
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getIdentificador() {String cpf = ""; cpf+=this.identificador; return cpf; }

    public void setIdentificador(long identificador) throws CpfInvalidoException{
        String teste = "" + identificador;
        if(teste.length()==11){
            this.identificador = identificador;
        } else{
            CpfInvalidoException e;
            e= new CpfInvalidoException();
            throw e;
        }
    }
}


