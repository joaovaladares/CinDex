package Pacote;

import erros.*;

public interface RepositorioPacotes {
    public void inserir(Pacote pacote)
            throws LimiteAtingidoException;
    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException;
    public void remover(int identificador)
            throws PacoteNaoEncontradoException;
    public Pacote procurar(int identificador)
            throws PacoteNaoEncontradoException;
    public boolean existe(int identificador);
}
