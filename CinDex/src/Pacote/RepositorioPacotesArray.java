package Pacote;

import erros.LimiteAtingidoException;
import erros.PacoteNaoEncontradoException;

public class RepositorioPacotesArray implements RepositorioPacotes{
    private Pacote[] arrayPacotes;
    private int indice;

    public RepositorioPacotesArray(){
        arrayPacotes = new Pacote[200];
        this.indice = 0;
    }

    // Insere novo pacote no array
    public void inserir(Pacote pacote)
        throws LimiteAtingidoException {

        // Verifica se ainda há espaço no array
        if(this.indice < arrayPacotes.length) {
            arrayPacotes[indice] = pacote;
            indice = indice + 1;
        }else{
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    // Remove um pacote do array, e reorganiza o array
    public void remover(int identificador)
            throws PacoteNaoEncontradoException {
        int index = this.getIndice(identificador);
        // Reorganiza os pacotes no array
        for (int i = index; i < arrayPacotes.length - 1; i++) {
            arrayPacotes[i] = arrayPacotes [i + 1];
        }
        arrayPacotes[arrayPacotes.length - 1] = null;
        this.indice = this.indice - 1;
    }

    private int getIndice(int identificador)
            throws PacoteNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayPacotes[i].getIdentificador() == identificador) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            PacoteNaoEncontradoException e;
            e = new PacoteNaoEncontradoException();
            throw e;
        }
    }
}
