package Pessoa;

import erros.*;

public abstract class PessoaAbstrato {
    private String nome;
    private String sexo;
    private String dataNascimento;
    protected long identificador;
    public PessoaAbstrato(String nome, String sexo, String dataNascimento)
            throws SexoInvalidoException{
        this.nome = nome;
        //verifica se o sexo informado é válido
        if(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("outro")){
            this.sexo = sexo;
        } else{
            SexoInvalidoException e;
            e = new SexoInvalidoException();
            throw e;
        }
        this.dataNascimento = dataNascimento;
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public abstract String getIdentificador();
    public abstract void setIdentificador(long identificador)throws CpfInvalidoException, IdentificadorFuncionarioInvalidoException;
}
