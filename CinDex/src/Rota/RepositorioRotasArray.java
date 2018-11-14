package Rota;

import erros.*;

public class RepositorioRotasArray implements RepositorioRotas {
    private Rota[] arrayRota;
    private int indice;

    //Construtor basico
    public RepositorioRotasArray() {
        this.arrayRota = new Rota[200];
        this.indice = 0;
    }

    //Verifica se o array nao esta cheio e insere a rota
    public void inserir(Rota rota)
            throws LimiteAtingidoException {
        if (this.indice < this.arrayRota.length) {
            this.arrayRota[indice] = rota;
            this.indice = this.indice + 1;
        } else {
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    //Remove a rota e tambem reorganiza suas posicoes no array
    public void remover(String codigo)
            throws RotaNaoEncontradaException {
        int index = this.getIndice(codigo);

        //Troca os elementos de lugar, jogando-os uma posicao a esquerda
        for (int i = index; i < this.arrayRota.length - 1; i++) {
            this.arrayRota[i] = arrayRota[i + 1];
        }
        this.arrayRota[this.arrayRota.length - 1] = null;
        this.indice = this.indice - 1;
    }

    //Procura por uma rota e a retorna a partir de seu codigo
    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException {
        Rota resposta = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
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
        this.arrayRota[indice] = rota;
    }

    //Verifica se existe um determinado objeto a partir de um dado codigo
    public boolean existe(String codigo) {
        boolean resposta = false;
        for (int i = 0; i < this.indice && !resposta; i++) {
            if (this.arrayRota[i].getCodigo().equals(codigo)) {
                resposta = true;
            }
        }
        return resposta;
    }

    //Metodo que retorna o indice de um objeto a partir de um codigo
    public int getIndice(String codigo)
            throws RotaNaoEncontradaException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayRota[i].getCodigo().equals(codigo)) {
                retorno = i;
                achou = true;
            }
        }

        //Retorna um erro caso a rota nao seja encontrada
        if (achou) {
            return retorno;
        } else {
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
    }
}
