package Pessoa;

import erros.CepInvalidoException;
import erros.CpfInvalidoException;
import erros.SexoInvalidoException;

import java.util.InputMismatchException;

public class Cliente extends Pessoa{
    private String sexo;
    private String dataNascimento;
    private String cidade;
    private String cep;
    private String logradouro;
    Cliente (String nome, long cpf, String sexo, String dataNascimento, String cidade, String cep, String logradouro)
            throws CpfInvalidoException, SexoInvalidoException, CepInvalidoException {
        String teste = "" + cpf;
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
        //verifica se o sexo informado é válido
        if(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("outro")){
            this.sexo = sexo;
        } else{
            SexoInvalidoException e;
            e = new SexoInvalidoException();
            throw e;
        }
        //verifica se o cep informado é válido
        if (cep.length() == 8) {
            this.cep = cep;
        } else{
            CepInvalidoException e;
            e = new CepInvalidoException();
            throw e;
        }
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.logradouro = logradouro;
    }

    public String getSexo() { return sexo; }

    public String getDataNascimento() { return dataNascimento; }

    public String getCidade() { return cidade; }

    public String getCep() { return cep; }

    public String getLogradouro() { return logradouro; }

    public void setSexo(String sexo) { this.sexo = sexo; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public void setCep(String cep) { this.cep = cep; }

    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
}


