package Pacote;

import Rota.CadastroRota;
import Veiculo.CadastroVeiculo;
import erros.*;

public class Pacote {
    private int identificador;
    private int peso;
    private int altura;
    private int largura;
    private int comprimento;
    private int rota;
    private String veiculo;

    public Pacote(int identificador, int peso, int altura, int largura, int comprimento, String veiculo,String rota)
            throws RotaNaoEncontradaException, IdentificadorInvalidoException, DimensaoInvalidaException,
            PesoMaximoException, VeiculoNaoEncontradoException {

        // Checa se o identificador informado é válido
        if ((identificador + "").length() >= 6) {
            this.identificador = identificador;
        } else {
            IdentificadorInvalidoException e;
            e = new IdentificadorInvalidoException();
            throw e;
        }

        // Checa se o peso informado é válido
        if (peso <= 10) {
            this.peso = peso;
        } else {
           PesoMaximoException e;
           e = new PesoMaximoException();
           throw e;
        }

        // Checa se todas as dimensões informadas são válidas
        if (altura <= 2 && comprimento <= 2 && largura <= 2) {
            this.altura = altura;
            this.largura = largura;
            this.comprimento = comprimento;
        } else {
            DimensaoInvalidaException e;
            e = new DimensaoInvalidaException();
            throw e;
        }

        // Checa se o veículo informado existe
        if(CadastroVeiculo.existe(veiculo)) {
            this.veiculo = veiculo;
        }else{
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }

        // Checa se a rota informada existe
        if(CadastroRota.existe(rota)){
            this.rota = rota;
        }else{
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
    }

    public int getIdentificador() {
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

    public int getRota() {
        return this.rota;
    }

    public String getVeiculo() {
        return this.veiculo;
    }

    public void setIdentificador(int identificador) {
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

    public void setRota(int rota) {
        this.rota = rota;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

}
