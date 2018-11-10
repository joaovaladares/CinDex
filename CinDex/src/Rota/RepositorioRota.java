package Rota;

import erros.*;

public interface RepositorioRota {
    public void inserir(Rota rota)
            throws LimiteAtingidoException, RotaJaCadastradaException;

    public void atualizar(Rota rota)
            throws RotaNaoEncontradaException;

    public void remover(String codigo)
            throws RotaNaoEncontradaException;

    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException;

    public boolean existe(String codigo);
}