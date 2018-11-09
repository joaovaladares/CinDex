package Veiculo;

public interface RepositorioVeiculo {

    void NovoVeiculo(String nome, String tipo, int capacidade);
    void InserePacote();
    void RemoveVeiculo(String nome);
    void AtualizaDisponibilidadeVeiculo();
    String ProcuraDisponibilidadeVeiculo(String nome);

    //Criar o array(tamanho 200) e a lista que contém objetos Veiculo
    //Nome do atributo: Veiculos
}
