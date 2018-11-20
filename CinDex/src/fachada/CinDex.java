package fachada;

import Local.*;
import Pacote.*;
import Pessoa.*;
import Rota.*;
import Veiculo.*;
import erros.*;

import javax.xml.crypto.Data;

public class CinDex {
    private CadastroRotas rotas;
    private CadastroVeiculo veiculos;
    private CadastroLocal locais;
    private CadastroPacotes pacotes;
    private CadastroCliente clientes;
    private CadastroFuncionario funcionarios;

    public CinDex(boolean tipo) {
        this.rotas = new CadastroRotas(tipo);
        this.veiculos = new CadastroVeiculo(tipo);
        this.locais = new CadastroLocal(tipo);
        this.pacotes = new CadastroPacotes(tipo);
        this.clientes = new CadastroCliente(tipo);
        this.funcionarios = new CadastroFuncionario(tipo);
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
        }else if(!this.veiculos.existeVeiculo(veiculo.getNomeVeiculo())){
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
        }else if(!this.veiculos.existeVeiculo(veiculo.getNomeVeiculo())){
            VeiculoInvalidoException e;
            e = new VeiculoInvalidoException();
            throw e;
        }else{
            this.pacotes.atualizar(pacote);
        }
    }

    public Pacote procurarPacote(String identificador)
            throws PacoteNaoEncontradoException{
        return this.pacotes.procurar(identificador);
    }


    // Rota
    public void cadastrarRota(Rota rota)
            throws RotaJaCadastradaException, CodigoInvalidoException, LocalInvalidoException, LimiteAtingidoException, PericulosidadeInvalidaException, TipoInvalidoException {
        Local local = rota.getLocal();

        // Verifica se existe um local associado para poder cadastrar a rota
        if (this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
            rotas.cadastrar(rota);
        } else if (!this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
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
        Local local = rota.getLocal();

        //Verifica se existe um local associado para poder atualizar a rota
        if (this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
            this.rotas.atualizar(rota);
        } else if (!this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
            LocalInvalidoException e;
            e = new LocalInvalidoException();
            throw e;
        }
    }

    public Rota procurarRota(String codigo)
            throws RotaNaoEncontradaException {
        return rotas.procurar(codigo);
    }


    //Veiculo
    public void cadastrarVeiculo(Veiculo veiculo)
            throws LimiteAtingidoException, VeiculoJaExistenteException, TipoVeiculoInvalidoException, VeiculoCapacidadeInvalida {
        //Verifica se o dado veículo ja existe, se sim jogue um erro, se não, insira.
        if(this.veiculos.existeVeiculo(veiculo.getNomeVeiculo())){
            VeiculoJaExistenteException e;
            e = new VeiculoJaExistenteException();
            throw e;
        }
        else{
            veiculos.cadastrarVeiculo(veiculo);
        }
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        this.veiculos.removerVeiculo(nome);
    }

    public void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException {
        //Verifica se o dado veículo existe ou não, se sim, este será atualizado.
        if (this.veiculos.existeVeiculo(veiculo.getNomeVeiculo())) {
            this.veiculos.atualizarVeiculo(veiculo);
        } else {
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }

    }

    public Veiculo procurarVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        return this.veiculos.procuraVeiculo(nome);
    }

    //Pessoa
    //Cliente
    public void cadastrarCliente(Cliente cliente)
            throws LimiteAtingidoException, ClienteJaCadastradoException, CpfInvalidoException, SexoInvalidoException, DataNascimentoInvalidaException {
        //Verifica se o dado cliente ja existe, se sim jogue um erro, se não, insira.
        if(this.clientes.existe(cliente.getIdentificador())){
            ClienteJaCadastradoException e;
            e = new ClienteJaCadastradoException();
            throw e;
        }
        else{
            clientes.cadastrar(cliente);
        }
    }

    public void removerCliente(String identificador)
            throws ClienteNaoEncontradoException{
        this.clientes.remover(identificador);
    }

    public void atualizarCliente(Cliente cliente)
            throws ClienteNaoEncontradoException {
        //Verifica se o dado cliente existe ou não, se sim, este será atualizado.
        if (this.clientes.existe(cliente.getIdentificador())) {
            this.clientes.atualizar(cliente);
        } else {
            ClienteNaoEncontradoException e;
            e = new ClienteNaoEncontradoException();
            throw e;
        }

    }

    public Cliente procurarCliente(String identtificador)
            throws ClienteNaoEncontradoException{
        return this.clientes.procurar(identtificador);
    }

    //Funcionario
    public void cadastrarFuncionario(Funcionario funcionario)
            throws LimiteAtingidoException, FuncionarioJaCadastradoException, SexoInvalidoException, DataNascimentoInvalidaException, IdentificadorFuncionarioInvalidoException{
        //Verifica se o dado funcionario ja existe, se sim jogue um erro, se não, insira.
        if(this.funcionarios.existe(funcionario.getIdentificador())){
            FuncionarioJaCadastradoException e;
            e = new FuncionarioJaCadastradoException();
            throw e;
        }
        else{
            funcionarios.cadastrar(funcionario);
        }
    }

    public void removerFuncionario(String identificador)
            throws FuncionarioNaoEncontradoException{
        this.funcionarios.remover(identificador);
    }

    public void atualizarFuncionario(Funcionario funcionario)
            throws FuncionarioNaoEncontradoException {
        //Verifica se o dado funcionario existe ou não, se sim, este será atualizado.
        if (this.funcionarios.existe(funcionario.getIdentificador())) {
            this.funcionarios.atualizar(funcionario);
        } else {
            FuncionarioNaoEncontradoException e;
            e = new FuncionarioNaoEncontradoException();
            throw e;
        }

    }

    public Funcionario procurarFuncionario(String identificador)
            throws FuncionarioNaoEncontradoException{
        return this.funcionarios.procurar(identificador);
    }

   //Local
   public void cadastrarLocal(Local local)
           throws LocalJaCadastradoException, LimiteAtingidoException, LogradouroInvalidoException,
           CidadeInvalidaException, BairroInvalidoException {

       //Verifica se o local ja esta cadastrado;
       if (!this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
           // Verifica se o Logradouro e uma string valida;
           if (!(local.getLogradouro().matches("[a-zA-Z0-9]+"))) {
               LogradouroInvalidoException e;
               e = new LogradouroInvalidoException();
               throw e;
           }

           // Verifica se a cidade e uma string valida;
           if (!(local.getCidade().matches("[a-zA-Z0-9]+"))) {
               CidadeInvalidaException e;
               e = new CidadeInvalidaException();
               throw e;
           }

           // Verifica se o bairro e uma string valida;
           if (!(local.getBairro().matches("[a-zA-Z0-9]+"))) {
               BairroInvalidoException e;
               e = new BairroInvalidoException();
               throw e;
           }

           this.locais.cadastrar(local);
       } else {
           LocalJaCadastradoException e;
           e = new LocalJaCadastradoException();
           throw e;
       }
   }


    public void remover(double x, double y)
            throws LocalNaoEncontradoException {
        this.locais.remover(x, y);
    }



    public Local procurar(double x, double y)
            throws LocalNaoEncontradoException {
        return this.locais.procurar(x, y);
    }


    public void atualizar(Local local)
            throws LocalNaoEncontradoException {
        this.locais.atualizar(local);
    }


}

