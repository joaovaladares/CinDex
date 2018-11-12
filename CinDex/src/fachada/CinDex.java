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
        rotas = new CadastroRotas(tipo);
        veiculos = new CadastroVeiculo(tipo);
        locais = new CadastroLocal(tipo);
        pacotes = new CadastroPacotes(tipo);
        pessoas = new CadastroPessoa(tipo);
    }

    // Pacote
    public void cadastrarPacote(Pacote pacote)
        throws PacoteJaCadastradoException, LimiteAtingidoException, RotaInvalidaException, VeiculoInvalidoException{

    }
}
