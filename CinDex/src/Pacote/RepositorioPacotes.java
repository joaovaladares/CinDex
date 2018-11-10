package Pacote;

import erros.PacoteNaoEncontradoException;

public interface RepositorioPacotes {
    public void inserir(Pacote pacote);
    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException;
    public void remover(int identificador)
            throws PacoteNaoEncontradoException;
    public Pacote procurar(int identificador)
            throws PacoteNaoEncontradoException;
    public boolean existe(int identificador);
}
