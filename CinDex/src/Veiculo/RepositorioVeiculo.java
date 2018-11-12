package Veiculo;

import erros.VeiculoNaoEncontradoException;

public interface RepositorioVeiculo {

    void inserirVeiculo(Veiculo nomeVeiculo);
    void InserePacote();
    void removeVeiculo(Veiculo nomeVeiculo) throws VeiculoNaoEncontradoException;
    void atualizaDisponibilidadeVeiculo();
    Veiculo ProcuraVeiculo(String nome);

    //Criar o array(tamanho 200) e a lista que contém objetos Veiculo
    //Nome do atributo: Veiculos
}
