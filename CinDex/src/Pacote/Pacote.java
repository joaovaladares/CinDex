package Pacote;

import Rota.Rota;
import Veiculo.Veiculo;
import erros.*;

public class Pacote {

    // Atributos exclusivos dos pacotes
    private String identificador;
    private int peso;
    private int altura;
    private int largura;
    private int comprimento;
    private Rota rota;
    private Veiculo veiculo;

    public Pacote(String identificador, int peso, int altura, int largura, int comprimento, Veiculo veiculo, Rota rota) {

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

    public int getPeso() {
        return this.peso;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getComprimento() {
        return this.comprimento;
    }

    public int getLargura() {
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

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
