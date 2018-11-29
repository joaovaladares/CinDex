package Local;

import erros.*;

public class CadastroLocal {
    private RepositorioLocal locais;

    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array;
    public CadastroLocal(boolean tipo) {

        if (tipo) {
            this.locais = new RepositorioLocalLista();
        } else {
            this.locais = new RepositorioLocalArray();
        }
    }

    //Verifica se o local ja esta cadastrado, caso nao esteja, o cadastra;
    public void cadastrar(Local local)
            throws LocalJaCadastradoException, LimiteAtingidoException, LogradouroInvalidoException,
            CidadeInvalidaException, BairroInvalidoException {

        //Verifica se o local ja esta cadastrado;
        if (!this.locais.existe(local.getCoordenadax(), local.getCoordenaday())) {
            // Verifica se o Logradouro e uma string valida;
            if (!(local.getLogradouro().matches("[a-zA-Z0-9 ]+"))) {
                LogradouroInvalidoException e;
                e = new LogradouroInvalidoException();
                throw e;
            }

            // Verifica se a cidade e uma string valida;
            if (!(local.getCidade().matches("[a-zA-Z0-9 ]+"))) {
                CidadeInvalidaException e;
                e = new CidadeInvalidaException();
                throw e;
            }

            this.locais.inserir(local);
        } else {
            LocalJaCadastradoException e;
            e = new LocalJaCadastradoException();
            throw e;
        }
    }

    //Chama o remover da interface;
    public void remover(double x, double y)
            throws LocalNaoEncontradoException {
        this.locais.remover(x, y);
    }


    //Chama o procurar da interface;
    public Local procurar(double x, double y)
            throws LocalNaoEncontradoException {
        return this.locais.procurar(x, y);
    }

    //Chama o atualizar da interface;
    public void atualizar(Local local)
            throws LocalNaoEncontradoException {
        this.locais.atualizar(local);
    }

    //Chama o existe da interface;
    public boolean existe(double x, double y) {
        return this.locais.existe(x, y);
    }
}

