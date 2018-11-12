package Rota;

import erros.*;

public class CadastroRotas {
    private RepositorioRotas rotas;

    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroRotas(boolean tipo) {
        if (tipo) {
            this.rotas = new RepositorioRotasLista();
        } else {
            this.rotas = new RepositorioRotasArray();
        }
    }

    //Verifica se a rota ja esta cadastrada, caso nao esteja, a cadastra
    public void cadastrar(Rota rota)
            throws RotaJaCadastradaException, LimiteAtingidoException {
        if (!this.rotas.existe(rota.getCodigo())) {
            this.rotas.inserir(rota);
        } else {
            RotaJaCadastradaException e;
            e = new RotaJaCadastradaException();
            throw e;
        }
    }

    //Chama o remover da interface
    public void remover(String codigo)
            throws RotaNaoEncontradaException {
        this.rotas.remover(codigo);
    }

    //Chama o atualizar da interface
    public void atualizar(Rota rota)
            throws RotaNaoEncontradaException {
        this.rotas.atualizar(rota);
    }

    //Chama o procurar da interface
    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException {
        return this.rotas.procurar(codigo);
    }

    //Chama o existe da interface
    public boolean existe(String codigo) {
        return this.rotas.existe(codigo);
    }
}
