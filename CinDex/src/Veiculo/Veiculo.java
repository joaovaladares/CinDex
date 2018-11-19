package Veiculo;

import erros.*;

public class Veiculo {

    //Atributos exclusivos dos veículos
    private String nome;
    private String tipo;
    private int capacidade;

    public Veiculo(String nome, String tipo, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public String getTipoVeiculo() {
        return this.tipo;
    }

    public void setTipoVeiculo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeVeiculo() {
        return this.nome;
    }

    public void setNomeVeiculo(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeVeiculo() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}

