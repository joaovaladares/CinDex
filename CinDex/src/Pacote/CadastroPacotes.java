package Pacote;

import erros.*;

public class CadastroPacotes {
    private RepositorioPacotes pacote;

    public CadastroPacotes(boolean tipo) {
        if (tipo) {
            this.pacote = new RepositorioPacotesLista();
        } else {
            this.pacote = new RepositorioPacotesArray();
        }
    }

    public void cadastrar(Pacote pacote)
            throws PacoteJaCadastradoException, LimiteAtingidoException {
        if (!this.pacote.existe(pacote.getIdentificador())) {
            this.pacote.inserir(pacote);
        } else {
            PacoteJaCadastradoException e;
            e = new PacoteJaCadastradoException();
            throw e;
        }
    }

    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException {
        this.pacote.atualizar(pacote);
    }

    public void remover(int identificador)
            throws PacoteNaoEncontradoException {
        this.pacote.remover(identificador);
    }

    public Pacote procurar(int identificador)
            throws PacoteNaoEncontradoException {
        return this.pacote.procurar(identificador);
    }

    public boolean existe(int identificador) {
        return this.pacote.existe(identificador);
    }
}
