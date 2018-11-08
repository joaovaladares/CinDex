package Rota;

public class Rota {

    //Atributos exclusivos classe Rota;
    private String tipo;
    private int periculosidade;
    private double distancia;

    public Rota(int periculosidade, String tipo) {
        this.periculosidade = periculosidade;
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getPericulosidade() {
        return this.periculosidade;
    }

    public double getDistancia() {
        return this.distancia;
    }
}

