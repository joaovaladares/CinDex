package Pessoa;

import erros.*;

public class CadastroCliente {

    private RepositorioCliente repositorio;
    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroCliente(boolean tipo) {
        if (tipo) {
            this.repositorio = new RepositorioClienteLista();
        } else {
            this.repositorio = new RepositorioClienteArray();
        }
    }



}

