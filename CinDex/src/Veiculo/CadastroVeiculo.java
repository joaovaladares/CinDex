package Veiculo;

import erros.*;

public class CadastroVeiculo {
    private RepositorioVeiculo veiculos;

    //Se o construtor receber true, inicializa o repositório como lista, senão inicializa como um array;
    public CadastroVeiculo(boolean repo){
        if(!repo){
            this.veiculos = new RepositorioVeiculoArray();
        }
        else{
            this.veiculos = new RepositorioVeiculoLista();
        }
    }

    public void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, LimiteAtingidoException{
        if(!this.veiculos.existeVeiculo(veiculo.getNomeVeiculo())) {
            this.veiculos.inserirVeiculo(veiculo);
        }
        else{
            VeiculoJaExistenteException e;
            e = new VeiculoJaExistenteException();
            throw e;
        }
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        this.veiculos.removerVeiculo(nome);
    }

    public void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException{
        this.veiculos.atualizarVeiculo(veiculo);
    }

    public boolean existeVeiculo(String nome){
        return this.veiculos.existeVeiculo(nome);
    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        return this.veiculos.procuraVeiculo(nome);
    }
}
