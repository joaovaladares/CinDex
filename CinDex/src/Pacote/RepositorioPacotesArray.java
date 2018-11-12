package Pacote;

import erros.LimiteAtingidoException;
import erros.PacoteNaoEncontradoException;

// Classe coleção de dados, que possui repositório em array
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
    public void remover(String identificador)
            throws PacoteNaoEncontradoException {
        int index = this.getIndice(identificador);
        // Reorganiza os pacotes no array
        if (arrayPacotes.length - 1 - index >= 0) {
            System.arraycopy(arrayPacotes, index + 1, arrayPacotes, index, arrayPacotes.length - 1 - index);
        }
        arrayPacotes[arrayPacotes.length - 1] = null;
        this.indice = this.indice - 1;
    }

    // Procura um pacote no array, caso exista, retorna o pacote
    public Pacote procurar(String identificador)
        throws PacoteNaoEncontradoException{
        Pacote retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayPacotes[i].getIdentificador().equals(identificador)) {
                retorno = this.arrayPacotes[i];
                achou = true;
            }
        }
        if(achou) {
            return retorno;
        }else{
            PacoteNaoEncontradoException e;
            e = new PacoteNaoEncontradoException();
            throw e;
        }
    }

    // Atualiza um pacote no array, caso o mesmo exista
    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException{
        int index = this.getIndice(pacote.getIdentificador());
        arrayPacotes[index] = pacote;
    }

    // Verifica se existe um pacote no array
    public boolean existe(String identificador){
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayPacotes[i].getIdentificador().equals(identificador)) {
                achou = true;
            }
        }
        return achou;
    }

    // Retorna o indice de um determinado pacote no array
    private int getIndice(String identificador)
        throws PacoteNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayPacotes[i].getIdentificador().equals(identificador)) {
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
