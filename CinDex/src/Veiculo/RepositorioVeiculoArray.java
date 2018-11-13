package Veiculo;

import erros.*;

public class RepositorioVeiculoArray implements RepositorioVeiculo{
    private Veiculo[] arrayVeiculos;
    private int count;

    public RepositorioVeiculoArray(){
        this.arrayVeiculos = new Veiculo[200];
        this.count = 0;
    }

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
