package Veiculo;

import erros.VeiculoNaoEncontradoException;

public class RepositorioVeiculoArray implements RepositorioVeiculo{
    private Veiculo[] arrayVeiculos = new Veiculo[200];
    private int count = 0;

    public void inserirVeiculo(Veiculo nomeVeiculo){
        if(arrayVeiculos[count] == null){
            count++;
            inserirVeiculo(nomeVeiculo);
        }
        else{
            arrayVeiculos[count] = nomeVeiculo;
        }
    }

    public void removeVeiculo(Veiculo nomeVeiculo) throws VeiculoNaoEncontradoException {
        if(arrayVeiculos[count] == nomeVeiculo){
            arrayVeiculos[count] = arrayVeiculos[count + 1];
        }
    }
}
