package com.company;

public class Pacotes {
    private int codigo;
    private int peso;
    private int[] dimensoes;
    private Pessoas pessoa;
    private Veiculos veiculo;
    private int[] endereco;
    Pacotes(int codigo,int peso,int[] dimensoes,Pessoas pessoa,Veiculos veiculo){
        this.codigo = codigo;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.pessoa = pessoa;
        this.veiculo = veiculo;
    }

    public int[] getEndereco() {
        return endereco;
    }
}
