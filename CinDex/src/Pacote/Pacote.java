package Pacote;

import Rota.Rota;
import Veiculo.Veiculo;
import erros.*;

public class Pacote {

    // Atributos exclusivos dos pacotes
    private String identificador;
    private double peso;
    private double altura;
    private double largura;
    private double comprimento;
    private Rota rota;
    private Veiculo veiculo;

    public Pacote(String identificador, double peso, double altura, double largura, double comprimento, Veiculo veiculo, Rota rota) {

        this.identificador = identificador;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.veiculo = veiculo;
        this.rota = rota;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getComprimento() {
        return this.comprimento;
    }

    public double getLargura() {
        return this.largura;
    }

    public Rota getRota() {
        return this.rota;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

}
