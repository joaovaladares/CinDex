package Veiculo;

import erros.*;

public interface RepositorioVeiculo {
    void inserirVeiculo(String nomeVeiculo, String tipo, int capacidade)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida;

    void removerVeiculo(String nomeVeiculo)
            throws VeiculoNaoEncontradoException;

    void inserirPacote(int quantidade) throws VeiculoCheioException;

    boolean existeVeiculo(String nome);

    Veiculo procuraVeiculo(String nome);

    //Criar o array(tamanho 200) e a lista que contém objetos Veiculo
    //Nome do atributo: Veiculos
}
