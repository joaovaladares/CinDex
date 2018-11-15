package Veiculo;

import erros.*;

public interface RepositorioVeiculo {
    void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, LimiteAtingidoException;

    void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException;

    void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException;

    boolean existeVeiculo(String nome);

    Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException;
}
