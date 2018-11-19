package Rota;

import Local.*;
import erros.*;

public class Rota {

    //Atributos exclusivos classe Rota;
    private String tipo;
    private String periculosidade;
    private String codigo;
    private double distancia;
    private Local local;

    public Rota(String periculosidade, String tipo, String codigo, Local local) {
        this.periculosidade = periculosidade;
        this.tipo = tipo;
        this.codigo = codigo;
        this.local = local;
        //Calcula a distancia baseado no endereço do local
        this.distancia = Math.sqrt(Math.pow(local.getCoordenadax() - local.getCoordenaday(), 2));
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPericulosidade() {
        return this.periculosidade;
    }

    public void setPericulosidade(String periculosidade) {
        this.periculosidade = periculosidade;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getDistancia() {
        return this.distancia;
    }

    public Local getLocal() {
        return this.local;
    }
}