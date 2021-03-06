package Pessoa;

import erros.*;

public abstract class PessoaAbstrata {
    private String nome;
    private String sexo;
    private String dataNascimento;
    protected String identificador;

    public PessoaAbstrata(String nome, String sexo, String dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador ( String identificador ){
        this.identificador = identificador;
    }

    public abstract String getCodigo();

}
