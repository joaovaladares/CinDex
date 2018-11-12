package Veiculo;

import erros.TipoVeiculoInvalidoException;
import erros.VeiculoCapacidadeInvalida;
import erros.VeiculoCheioException;

public class Veiculo {
    private String nome;
    private String tipo;
    private int capacidade;
    private boolean disponibilidade;

    public Veiculo(String nome, String tipo, int capacidade) throws TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida{
        this.nome = nome;

        if(capacidade < 0){
            VeiculoCapacidadeInvalida e;
            e = new VeiculoCapacidadeInvalida();
            throw e;
        }
        else {
            this.capacidade = capacidade;
        }

        if (tipo.equals("Carro") || tipo.equals("carro") || tipo.equals("Avião") || tipo.equals("avião") || tipo.equals("Navio") || tipo.equals("navio")) {
            this.tipo = tipo;
        }
        else {
            //Trata de verificar se o foram inseridos tipos de veículos aceitáveis.
            TipoVeiculoInvalidoException e;
            e = new TipoVeiculoInvalidoException();
            throw e;
        }


        this.disponibilidade = true;

    }

    public void inserirVeiculo(Veiculo nomeVeiculo){

    }

    //    public Veiculo()
    //    throws TipoVeiculoInvalidoException {
    //        this.nome = null;
    //        this.tipo = null;
    //        this.capacidade = 0;
    //    }
}

