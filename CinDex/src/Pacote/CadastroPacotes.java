package Pacote;

import erros.PacoteJaCadastradoException;

public class CadastroPacotes {
    private RepositorioPacotes pacotes;

    public CadastroPacotes(RepositorioPacotes rep){
        this.pacotes = rep;
    }

    public void cadastrar(Pacote pacote)
            throws PacoteJaCadastradoException {

    }
}
