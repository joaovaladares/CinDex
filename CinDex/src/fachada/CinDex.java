package fachada;

import Local.*;
import Pacote.*;
import Pessoa.*;
import Rota.*;
import Veiculo.*;
import erros.*;

public class CinDex {
    private CadastroRotas rotas;
    private CadastroVeiculo veiculos;
    private CadastroLocal locais;
    private CadastroPacotes pacotes;
    private CadastroPessoa pessoas;

    public CinDex(boolean tipo) {
<<<<<<< Updated upstream
        rotas = new CadastroRotas(tipo);
        veiculos = new CadastroVeiculo(3tipo);
        locais = new CadastroLocal(tipo);
        pacotes = new CadastroPacotes(tipo);
        pessoas = new CadastroPessoa(tipo);
=======
        this.rotas = new CadastroRotas(tipo);
        this.veiculos = new CadastroVeiculo(tipo);
        this.locais = new CadastroLocal(tipo);
        this.pacotes = new CadastroPacotes(tipo);
        this.pessoas = new CadastroPessoa(tipo);
>>>>>>> Stashed changes
    }

    // Pacote
    public void cadastrarPacote(Pacote pacote)
        throws PacoteJaCadastradoException, LimiteAtingidoException, RotaInvalidaException, VeiculoInvalidoException{
        Rota rota = pacote.getRota();
        Veiculo veiculo = pacote.getVeiculo();

        if(this.rotas.existe(rota.getCodigo()) && this.veiculos.existe(veiculo.getNome())){
            this.pacotes.cadastrar(pacote);
        }else if(this.rotas.existe(rota.getCodigo())){
            RotaInvalidaException e;
            e = new RotaInvalidaException();
            throw e;
        }else{
            VeiculoInvalidoException e;
            e = new VeiculoInvalidoException();
            throw e;
        }
    }

    public void removerPacote(String identificador) throws PacoteNaoEncontradoException{
        this.pacotes.remover(identificador);
    }

    public void atualizarPacote(Pacote pacote) throws PacoteNaoEncontradoException,
            RotaInvalidaException, VeiculoInvalidoException{
        Rota rota = pacote.getRota();
        Veiculo veiculo = pacote.getVeiculo();

        if(this.rotas.existe(rota.getCodigo()) && this.veiculos.existe(veiculo.getNome())){
            this.pacotes.atualizar(pacote);
        }else if(this.rotas.existe(rota.getCodigo())){
            RotaInvalidaException e;
            e = new RotaInvalidaException();
            throw e;
        }else{
            VeiculoInvalidoException e;
            e = new VeiculoInvalidoException();
            throw e;
        }
    }

    public void procurarPacote(String identificador) throws PacoteNaoEncontradoException{
        this.pacotes.procurar(identificador)
    }
}

