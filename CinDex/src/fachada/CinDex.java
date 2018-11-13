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
        this.rotas = new CadastroRotas(tipo);
        this.veiculos = new CadastroVeiculo(tipo);
        this.locais = new CadastroLocal(tipo);
        this.pacotes = new CadastroPacotes(tipo);
        this.pessoas = new CadastroPessoa(tipo);
    }

    // Pacote
    public void cadastrarPacote(Pacote pacote)
        throws PacoteJaCadastradoException, LimiteAtingidoException, RotaInvalidaException, VeiculoInvalidoException{
        Rota rota = pacote.getRota();
        Veiculo veiculo = pacote.getVeiculo();

        if(!this.rotas.existe(rota.getCodigo())){
            RotaInvalidaException e;
            e = new RotaInvalidaException();
            throw e;
        }else if(!this.veiculos.existe(veiculo.getCodigo())){
            VeiculoInvalidoException e;
            e = new VeiculoInvalidoException();
            throw e;
        }else{
            this.pacotes.cadastrar(pacote);
        }
    }

    public void removerPacote(String identificador)
            throws PacoteNaoEncontradoException{
        this.pacotes.remover(identificador);
    }

    public void atualizarPacote(Pacote pacote)
            throws PacoteNaoEncontradoException,
            RotaInvalidaException, VeiculoInvalidoException{
        Rota rota = pacote.getRota();
        Veiculo veiculo = pacote.getVeiculo();

        if(!this.rotas.existe(rota.getCodigo())){
            RotaInvalidaException e;
            e = new RotaInvalidaException();
            throw e;
        }else if(!this.veiculos.existe(veiculo.getCodigo())){
            VeiculoInvalidoException e;
            e = new VeiculoInvalidoException();
            throw e;
        }else{
            this.pacotes.atualizar(pacote);
        }
    }

    public Pacote procurarPacote(String identificador)
            throws PacoteNaoEncontradoException{
        this.pacotes.procurar(identificador);
    }

    // Rota
    public void cadastrarRota(Rota rota)
            throws RotaJaCadastradaException, LocalInvalidoException, LimiteAtingidoException {
        Local local = rota.getLocal();

        // Verifica se existe um local associado para poder cadastrar a rota
        if (this.locais.existe(local.getCoordenadax()) && this.locais.existe(local.getCoordenaday())) {
            rotas.cadastrar(rota);
        } else if (!this.locais.existe(local.getCoordenadax()) && this.locais.existe(local.getCoordenaday())) {
            LocalInvalidoException e;
            e = new LocalInvalidoException();
            throw e;
        }
    }

    public void removerRota(String codigo)
            throws RotaNaoEncontradaException {
        this.rotas.remover(codigo);
    }

    public void atualizarRota(Rota rota)
            throws RotaNaoEncontradaException, LocalInvalidoException {

        //Verifica se existe um local associado para poder atualizar a rota
        if (this.locais.existe(local.getCoordenadax()) && this.locais.existe(local.getCoordenaday())) {
            this.rotas.atualizar(rota);
        } else if (!this.locais.existe(local.getCoordenadax()) && this.locais.existe(local.getCoordenaday())) {
            LocalInvalidoException e;
            e = new LocalInvalidoException();
            throw e;
        }
    }

    public Rota procurarRota(String codigo)
            throws RotaNaoEncontradaException {
        return rotas.procurar(codigo);
    }
}

