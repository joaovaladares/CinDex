package Rota;

import erros.LimiteAtingidoException;
import erros.RotaNaoEncontradaException;

public class RepositorioRotaArray implements RepositorioRota {
    private Rota[] arrayRota = new Rota[200];
    private int contador = 0;

    //Verifica se o array nao esta cheio e insere a rota
    public void inserir(Rota rota)
            throws LimiteAtingidoException {
        if (this.contador < this.arrayRota.length) {
            this.arrayRota[contador] = rota;
            this.contador++;
        } else {
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    //Remove a rota e tambem reorganiza suas posicoes no array
    public void remover(String codigo)
            throws RotaNaoEncontradaException {
        int indice = this.getIndice(codigo);
        int indiceAux = indice;

        //Troca os elementos de lugar, jogando-os uma posicao a esquerda
        for (int i = 1; i < arrayRota.length - indice; i++) {
            arrayRota[indiceAux] = arrayRota[indiceAux + 1];
            indiceAux++;
        }
        arrayRota[arrayRota.length - 1] = null;
        contador = contador - 1;
    }

    //Procura por uma rota e a retorna a partir de seu codigo
    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException {
        Rota resposta = null;
        boolean achou = false;
        for (int i = 0; i < this.contador && !achou; i++) {
            if (this.arrayRota[i].getCodigo().equalsIgnoreCase(codigo)) {
                resposta = this.arrayRota[i];
                achou = true;
            }
        }

        //Retorna um erro caso a rota nao seja encontrada
        if (achou) {
            return resposta;
        } else {
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
    }

    //Recebe uma rota, procura pelo seu codigo no array e a atualiza
    public void atualizar(Rota rota)
            throws RotaNaoEncontradaException {
        int indice = this.getIndice(rota.getCodigo());
        arrayRota[indice] = rota;
    }

    //Verifica se existe um determinado objeto a partir de um dado codigo
    public boolean existe(String codigo) {
        boolean resposta = false;
        for (int i = 0; i < this.contador && !resposta; i++) {
            if (this.arrayRota[i].getCodigo().equals(codigo)) {
                resposta = true;
            }
        }
        return resposta;
    }

    //Metodo que retorna o indice de um objeto a partir de um codigo
    public int getIndice(String codigo)
            throws RotaNaoEncontradaException {
        int resposta = 0;
        boolean achou = false;
        for (int i = 0; i < this.contador && !achou; i++) {
            if (this.arrayRota[i].getCodigo().equals(codigo)) {
                resposta = i;
                achou = true;
            }
        }

        //Retorna um erro caso a rota nao seja encontrada
        if (achou) {
            return resposta;
        } else {
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
    }
}
