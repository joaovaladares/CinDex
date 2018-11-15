package Veiculo;

import erros.*;

public interface RepositorioVeiculo {
    void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida;

    void removerVeiculo(String nomeVeiculo)
            throws VeiculoNaoEncontradoException;

    boolean existeVeiculo(String nome);

    Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException;

}
