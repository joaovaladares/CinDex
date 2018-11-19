package Rota;

import erros.*;

public interface RepositorioRotas {
    public void inserir(Rota rota)
            throws LimiteAtingidoException;

    public void atualizar(Rota rota)
            throws RotaNaoEncontradaException;

    public void remover(String codigo)
            throws RotaNaoEncontradaException;

    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException;

    public boolean existe(String codigo);
}