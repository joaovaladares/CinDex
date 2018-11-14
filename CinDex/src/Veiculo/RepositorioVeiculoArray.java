package Veiculo;

import erros.*;

public class RepositorioVeiculoArray implements RepositorioVeiculo{
    private Veiculo[] arrayVeiculos;
    private int count;

    public RepositorioVeiculoArray(){
        this.arrayVeiculos = new Veiculo[200];
        this.count = 0;
    }

    public void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida{
        if(arrayVeiculos[count] == null){
            arrayVeiculos[count] = veiculo;
        }
        else{
            count++;
            RepositorioVeiculo./*CHAMAVEICULO??????8/ ;
        }
    }

    public void removeVeiculo(Veiculo nomeVeiculo) throws VeiculoNaoEncontradoException {
        if(arrayVeiculos[count] == nomeVeiculo){
            arrayVeiculos[count] = arrayVeiculos[count + 1];
        }
    }
}
