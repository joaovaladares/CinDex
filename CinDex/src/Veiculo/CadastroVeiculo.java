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

    public void inserirVeiculo(String nome, String tipo, int capacidade)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida {
        this.veiculos.inserirVeiculo(nome, tipo, capacidade);
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        this.veiculos.removerVeiculo(nome);
    }

    public void inserirPacote(int quantidade)
            throws VeiculoCheioException{
        this.veiculos.inserirPacote(quantidade);
    }

    public boolean existeVeiculo(String nome){
        return this.veiculos.existeVeiculo(nome);
    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        return this.veiculos.procuraVeiculo(nome);
    }
}
