package Pacote;

import erros.PacoteNaoEncontradoException;

public class RepositorioPacotesLista implements RepositorioPacotes{
    private Pacote pacote;
    private RepositorioPacotesLista proximo;

    //Construtor da lista
    public RepositorioPacotesLista() {
        this.pacote = null;
        this.proximo = null;
    }

    public void inserir(Pacote pacote) {
        if (this.pacote == null) {
            this.pacote = pacote;
            this.proximo = new RepositorioPacotesLista();
        } else {
            this.proximo.inserir(pacote);
        }
    }

    public void remover(int identificador)
            throws PacoteNaoEncontradoException {
        Pacote pacoteEncontrado = this.procurar(identificador);
        if (this.pacote != null) {
            if (this.pacote.equals(pacoteEncontrado)) {
                this.pacote = this.proximo.pacote;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(identificador);
            }
        } else {
            PacoteNaoEncontradoException e;
            e = new PacoteNaoEncontradoException();
            throw e;
        }
    }

    public Pacote procurar(int identificador)
            throws PacoteNaoEncontradoException {
        Pacote retorno;
        retorno = null;
        if (this.pacote != null) {
            if (this.pacote.getIdentificador() == identificador) {
                retorno = this.pacote;
            } else {
                this.proximo.procurar(identificador);
            }
        } else {
            PacoteNaoEncontradoException e;
            e = new PacoteNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException {
        Pacote pacoteAntigo = procurar(pacote.getIdentificador());
        this.remover(pacoteAntigo.getIdentificador());
        this.inserir(pacote);
    }

    public boolean existe(int identificador) {
        if (this.pacote != null) {
            if (this.pacote.getIdentificador() == identificador) {
                return true;
            } else {
                return this.proximo.existe(identificador);
            }
        } else {
            return false;
        }
    }
}
