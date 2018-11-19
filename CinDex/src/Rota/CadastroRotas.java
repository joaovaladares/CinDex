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
            throws RotaJaCadastradaException, LimiteAtingidoException, PericulosidadeInvalidaException, TipoInvalidoException, CodigoInvalidoException {

        //Verifica se já existe uma rota igual
        if (!this.rotas.existe(rota.getCodigo())) {

            //Verifica se a periculosidade é uma string valida;
            if (!(rota.getPericulosidade().equalsIgnoreCase("Perigosa") || rota.getPericulosidade().equalsIgnoreCase("Segura"))) {
                PericulosidadeInvalidaException e;
                e = new PericulosidadeInvalidaException();
                throw e;
            }

            //Verifica se o tipo e uma string valida;
            if (!(rota.getTipo().equalsIgnoreCase("Urbana") || rota.getTipo().equalsIgnoreCase("Rural"))) {
                TipoInvalidoException e;
                e = new TipoInvalidoException();
                throw e;
            }

            //Verifica se o codigo possui tamanho valido;
            if (rota.getCodigo().length() != 5) {
                CodigoInvalidoException e;
                e = new CodigoInvalidoException();
                throw e;
            }

            //Caso tudo dê certo, cadastra a rota
            this.rotas.inserir(rota);

        //Retorna um erro caso a rota já exista
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
