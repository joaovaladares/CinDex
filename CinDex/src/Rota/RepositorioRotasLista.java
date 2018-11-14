package Rota;

import erros.*;

public class RepositorioRotasLista implements RepositorioRotas {
    private Rota rota;
    private RepositorioRotasLista proximo;

    //Construtor da lista
    public RepositorioRotasLista() {
        this.rota = null;
        this.proximo = null;
    }

    //Insere o elemento na lista e faz referencia a proximo para criar uma nova lista
    public void inserir(Rota rota) {
        if (this.rota == null) {
            this.rota = rota;
            this.proximo = new RepositorioRotasLista();
        } else {
            this.proximo.inserir(rota);
        }
    }

    //Remove o elemento da lista a partir de um dado codigo
    public void remover(String codigo)
            throws RotaNaoEncontradaException {
        Rota rotaEncontrada;
        rotaEncontrada = this.procurar(codigo);

        if (this.rota != null) {
            if (this.rota.equals(rotaEncontrada)) {
                this.rota = this.proximo.rota;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(codigo);
            }
            //Caso a rota nao seja encontrada
        } else {
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
    }

    //Retorna a rota dado o seu codigo
    public Rota procurar(String codigo)
            throws RotaNaoEncontradaException {
        Rota resposta;
        resposta = null;
        if (this.rota != null) {
            if (this.rota.getCodigo().equals(codigo)) {
                resposta = this.rota;
            } else {
                this.proximo.procurar(codigo);
            }
            //Caso a rota nao seja encontrada
        } else {
            RotaNaoEncontradaException e;
            e = new RotaNaoEncontradaException();
            throw e;
        }
        return resposta;
    }

    //Recebe uma rota, procura por ela e a atualiza
    public void atualizar(Rota rota)
            throws RotaNaoEncontradaException {
        Rota rotaAlvo;
        rotaAlvo = procurar(rota.getCodigo());
        this.remover(rotaAlvo.getCodigo());
        this.inserir(rota);
    }

    //Verifica se existe um determinado objeto a partir de um dado codigo
    public boolean existe(String codigo) {
        if (this.rota != null) {
            if (this.rota.getCodigo().equals(codigo)) {
                return true;
            } else {
                return this.proximo.existe(codigo);
            }
        } else {
            return false;
        }
    }
}
