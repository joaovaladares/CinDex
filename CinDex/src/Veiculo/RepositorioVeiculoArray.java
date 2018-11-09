package Veiculo;

public class RepositorioVeiculoArray implements RepositorioVeiculo{
    private Veiculo[] frotaVeiculos = new Veiculo[200];
    private static int count = 0;

    public void NovoVeiculo(String nome, String tipo, int capacidade){
        Veiculo novo = new Veiculo(nome, tipo, capacidade);
    }

    public void InserirPacote(String nome, Veiculo veiculo, int quantidade){
        frotaVeiculos[count] = aInserir;
        count++;
    }

}
