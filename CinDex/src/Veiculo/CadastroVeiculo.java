package Veiculo;

import erros.*;

public class CadastroVeiculo {
    private RepositorioVeiculo veiculos;

    public CadastroVeiculo(boolean repo){
        if(!repo){
            this.veiculos = new RepositorioVeiculoArray();
        }
        else{
            this.veiculos = new RepositorioVeiculoLista();
        }
    }

    public void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida {
        this.veiculos.inserirVeiculo(veiculo);
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        this.veiculos.removerVeiculo(nome);
    }

    public boolean existeVeiculo(String nome){
        return this.veiculos.existeVeiculo(nome);
    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        return this.veiculos.procuraVeiculo(nome);
    }
}
