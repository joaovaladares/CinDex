package Veiculo;

import erros.*;

public class RepositorioVeiculoLista implements RepositorioVeiculo {
    private Veiculo veiculo;
    private RepositorioVeiculoLista proximo;

    //Construtor
    public RepositorioVeiculoLista(){
        this.veiculo = null;
        this.proximo = null;
    }


    public void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException{
        if(this.veiculo == null) {
            this.veiculo = veiculo;
            this.proximo = new RepositorioVeiculoLista();
        }
        else{
            if(this.veiculo.getNomeVeiculo().equals(veiculo.getNomeVeiculo())){
                VeiculoJaExistenteException e;
                e = new VeiculoJaExistenteException();
                throw e;
            }
            else if(this.proximo.veiculo != null && this.proximo.veiculo.getNomeVeiculo().equals(veiculo.getNomeVeiculo())){
                VeiculoJaExistenteException e;
                e = new VeiculoJaExistenteException();
                throw e;
            }
            else {
                this.proximo.inserirVeiculo(veiculo);
            }
        }
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        if(this.veiculo != null) {
            if (this.veiculo.getNomeVeiculo().equals(nome)) {
                this.veiculo = this.proximo.veiculo;
                this.proximo = this.proximo.proximo;
            }
            else if(this.proximo.veiculo != null){
                this.proximo.removerVeiculo(nome);
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

    public void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException{
        if(this.veiculo != null){
            if(this.veiculo.getNomeVeiculo().equals(veiculo.getNomeVeiculo())){
                this.veiculo = veiculo;
            }
        }
        else if(this.proximo.veiculo != null){
            this.proximo.atualizarVeiculo(veiculo);
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
