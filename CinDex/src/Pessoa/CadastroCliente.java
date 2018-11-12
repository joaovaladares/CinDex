package Pessoa;

import erros.*;

public class CadastroCliente {

    private RepositorioCliente repositorio;

    public CadastroCliente(boolean tipo) {
        if (tipo) {
            this.repositorio = new RepositorioClienteLista();
        } else {
            this.repositorio = new RepositorioFuncionarioArray();
        }
    }
}
