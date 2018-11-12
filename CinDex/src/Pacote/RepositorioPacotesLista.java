package Pacote;

import erros.PacoteNaoEncontradoException;

// Classe coleção de dados, que possui repositório em lista
public class RepositorioPacotesLista implements RepositorioPacotes{
    private Pacote pacote;
    private RepositorioPacotesLista proximo;

    // Construtor da lista
    public RepositorioPacotesLista() {
        this.pacote = null;
        this.proximo = null;
    }

    // Insere novo pacote na lista
    public void inserir(Pacote pacote) {
        if (this.pacote == null) {
            this.pacote = pacote;
            this.proximo = new RepositorioPacotesLista();
        } else {
            this.proximo.inserir(pacote);
        }
    }

    // Remove um pacote da lista, caso o mesmo exista
    public void remover(String identificador)
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

    // Procura por um pacote na lista, caso o mesmo exista, retorna o pacote
    public Pacote procurar(String identificador)
            throws PacoteNaoEncontradoException {
        Pacote retorno;
        retorno = null;
        if (this.pacote != null) {
            if (this.pacote.getIdentificador().equals(identificador)) {
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

    // Atualiza um pacote na lista, caso o mesmo exista
    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException {
        Pacote pacoteAntigo = procurar(pacote.getIdentificador());
        this.remover(pacoteAntigo.getIdentificador());
        this.inserir(pacote);
    }

    // Verifica se existe um pacote, dado um identificador
    public boolean existe(String identificador) {
        if (this.pacote != null) {
            if (this.pacote.getIdentificador().equals(identificador)) {
                return true;
            } else {
                return this.proximo.existe(identificador);
            }
        } else {
            return false;
        }
    }
}
