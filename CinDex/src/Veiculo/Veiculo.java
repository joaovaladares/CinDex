package Veiculo;

import erros.TipoVeiculoInvalidoException;
import erros.VeiculoCheioException;

public class Veiculo {
    private String nome;
    private String tipo;
    private int capacidade;

    public Veiculo(String nome, String tipo, int capacidade) throws TipoVeiculoInvalidoException {
        this.nome = nome;
        this.capacidade = capacidade;
        if (tipo.equals("Carro") || tipo.equals("carro") || tipo.equals("Avião") || tipo.equals("avião") || tipo.equals("Navio") || tipo.equals("navio")) {
            this.tipo = tipo;
        }
        else {
            //Trata de verificar se o foram inseridos tipos de veículos aceitáveis.
            TipoVeiculoInvalidoException e;
            e = new TipoVeiculoInvalidoException();
                throw e;
        }

    }

    public void NovoVeiculo(String nome, String tipo, int capacidade){

    }

    //    public Veiculo()
    //    throws TipoVeiculoInvalidoException {
    //        this.nome = null;
    //        this.tipo = null;
    //        this.capacidade = 0;
    //    }
}

