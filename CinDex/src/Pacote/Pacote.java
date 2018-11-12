package Pacote;

import Rota.CadastroRota;
import Rota.Rota;
import Veiculo.CadastroVeiculo;
import Veiculo.Veiculo;
import erros.*;

public class Pacote {
    private String identificador;
    private int peso;
    private int altura;
    private int largura;
    private int comprimento;
    private Rota rota;
    private Veiculo veiculo;

    public Pacote(String identificador, int peso, int altura, int largura, int comprimento, Veiculo veiculo,Rota rota)
            throws IdentificadorInvalidoException, DimensaoInvalidaException,
            PesoMaximoException {

        // Checa se o identificador informado é válido
        if (identificador.length() >= 6) {
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
