package Veiculo;

import erros.*;

public class RepositorioVeiculoLista implements RepositorioVeiculo {
    private Veiculo veiculo;
    private RepositorioVeiculoLista proximo;

    public RepositorioVeiculoLista(){
        this.veiculo = null;
        this.proximo = null;
    }

    public void inserirVeiculo(String nomeVeiculo, String tipo, int capacidade)
            throws VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida{
        if(this.veiculo == null) {
            this.veiculo.setNomeVeiculo(nomeVeiculo);
            this.veiculo.setTipoVeiculo(tipo);
            this.veiculo.setCapacidade(capacidade);
            this.proximo = new RepositorioVeiculoLista();
        }
        else{
            if(this.veiculo.getNomeVeiculo().equals(nomeVeiculo)){
                VeiculoJaExistenteException e;
                e = new VeiculoJaExistenteException();
                throw e;
            }
            else if(this.proximo.veiculo != null && this.proximo.veiculo.getNomeVeiculo().equals(nomeVeiculo)){
                    VeiculoJaExistenteException e;
                    e = new VeiculoJaExistenteException();
                    throw e;
            }
            else {
                this.proximo.inserirVeiculo(nomeVeiculo, tipo, capacidade);
            }
        }
    }

    public void removerVeiculo(String nomeVeiculo)
            throws VeiculoNaoEncontradoException{
        if(this.veiculo != null) {
            if (this.veiculo.getNomeVeiculo().equals(nomeVeiculo)) {
                this.veiculo = this.proximo.veiculo;
                this.proximo = this.proximo.proximo;
            }
            else if(this.proximo.veiculo != null){
                this.proximo.removerVeiculo(nomeVeiculo);
            }
            else{
                VeiculoNaoEncontradoException e;
                e = new VeiculoNaoEncontradoException();
                throw e;
            }
        }
        else{
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }

    public boolean existeVeiculo(String nome){
        if(this.veiculo != null){
            if(this.veiculo.getNomeVeiculo().equals(nome)){
                return true;
            }
            else if(this.proximo != null){
                return this.proximo.existeVeiculo(nome);
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        if(this.veiculo != null){
            if(this.veiculo.getNomeVeiculo().equals(nome)){
                return this.veiculo;
            }
            else if(this.proximo != null){
                return this.proximo.procuraVeiculo(nome);
            }
            else{
                VeiculoNaoEncontradoException e;
                e = new VeiculoNaoEncontradoException();
                throw e;
            }
        }
        else{
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }

}
