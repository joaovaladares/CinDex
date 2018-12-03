package Veiculo;

import erros.*;

public class RepositorioVeiculoArray implements RepositorioVeiculo {
    private Veiculo[] arrayVeiculos;
    private int count;

    public RepositorioVeiculoArray() {
        this.arrayVeiculos = new Veiculo[200];
        this.count = 0;
    }

    public void inserirVeiculo(Veiculo veiculo)
            throws LimiteAtingidoException {
        if (this.count < this.arrayVeiculos.length) {
            this.arrayVeiculos[this.count] = veiculo;
            this.count += 1;

        } else {
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }

    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException {
        boolean achou = false;
        count = 0;
        if(this.arrayVeiculos[count].getNomeVeiculo().equalsIgnoreCase(nome)) {
            for (int i = count; i < this.arrayVeiculos.length - 1; i++) {
                this.arrayVeiculos[i] = arrayVeiculos[i + 1];
            }
            this.arrayVeiculos[this.arrayVeiculos.length - 1] = null;
            this.count = this.count - 1;
        }
            count ++;
        }

    public void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException {
        boolean achou = false;
        for (count = 0; count < arrayVeiculos.length && !achou; count++) {
            if (this.arrayVeiculos[count].getNomeVeiculo().equals(veiculo.getNomeVeiculo())) {
                achou = true;
                this.arrayVeiculos[count] = veiculo;
            }
        }

        if (!achou) {
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }

    public boolean existeVeiculo(String nome) {
        boolean existencia = false;
        for (count = 0; count < arrayVeiculos.length && !existencia; count++) {
            if (this.arrayVeiculos[count] == null) {
                return existencia;
            }
            if (this.arrayVeiculos[count].getNomeVeiculo().equals(nome)) {
                existencia = true;
            }
        }

        return existencia;
    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException {

        boolean achou = false;
        Veiculo retorno = null;
        for(int i = 0; i < arrayVeiculos.length; i++) {
            if( !(this.arrayVeiculos[i] == null) ) {
                if (this.arrayVeiculos[i].getNomeVeiculo().equals(nome)) {
                    achou = true;
                    retorno = this.arrayVeiculos[i];
                }
            }
        }

        if (achou) {
            return retorno;
        } else {
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }

    }

}
