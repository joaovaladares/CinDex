package Rota;

import erros.CodigoInvalidoException;
import erros.PericulosidadeInvalidaException;
import erros.TipoInvalidoException;

public class Rota {

    //Atributos exclusivos classe Rota;
    private String tipo;
    private String periculosidade;
    private String codigo;

    public Rota(String periculosidade, String tipo, String codigo)
            throws PericulosidadeInvalidaException, TipoInvalidoException, CodigoInvalidoException {

        //Checa se a periculosidade é uma string valida;
        if (periculosidade.equals("Perigosa") || periculosidade.equals("Segura")) {
            this.periculosidade = periculosidade;
        } else {
            PericulosidadeInvalidaException e;
            e = new PericulosidadeInvalidaException();
            throw e;
        }

        //Checa se o tipo e uma string valida;
        if (tipo.equals("Urbana") || tipo.equals("Rural")) {
            this.tipo = tipo;
        } else {
            TipoInvalidoException e;
            e = new TipoInvalidoException();
            throw e;
        }

        //Checa se o codigo e uma string valida;
        if (codigo.length() == 5) {
            this.codigo = codigo;
        } else {
            CodigoInvalidoException e;
            e = new CodigoInvalidoException();
            throw e;
        }
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getPericulosidade() {
        return this.periculosidade;
    }

    public String getCodigo() {
        return this.codigo;
    }
}


