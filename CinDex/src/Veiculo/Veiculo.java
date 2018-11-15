package Veiculo;

import erros.*;

public class Veiculo {

    //Atributos exclusivos dos veículos
    private String nome;
    private String tipo;
    private int capacidade;

    public Veiculo(String nome, String tipo, int capacidade)
            throws TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida{
        this.nome = nome;

        //Trata de verificar se a capacidade nao e negativa.
        if(capacidade < 0){
            VeiculoCapacidadeInvalida e;
            e = new VeiculoCapacidadeInvalida();
            throw e;
        }
        else {
            this.capacidade = capacidade;
        }

        //Trata de verificar se o foram inseridos tipos de veículos aceitáveis.
        if (tipo.equals("Carro") || tipo.equals("carro") ||
                tipo.equals("Avião") || tipo.equals("avião") ||
                tipo.equals("Navio") || tipo.equals("navio")) {
            this.tipo = tipo;
        }
        else {
            TipoVeiculoInvalidoException e;
            e = new TipoVeiculoInvalidoException();
            throw e;
        }
    }

    public String getTipoVeiculo(){
        return this.tipo;
    }
    public void setTipoVeiculo(String tipo){
        this.tipo = tipo;
    }

    public String getNomeVeiculo(){
        return this.nome;
    }
    public void setNomeVeiculo(String nome){
        this.nome = nome;
    }

    public int getCapacidadeVeiculo(){
        return this.capacidade;
    }
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
}

