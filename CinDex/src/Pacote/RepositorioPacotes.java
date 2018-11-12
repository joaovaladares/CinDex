package Pacote;

import erros.*;

// Classe interface negócio-dados dos repositórios de pacotes
public interface RepositorioPacotes {
    void inserir(Pacote pacote)
            throws LimiteAtingidoException;
    void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException;
    void remover(String identificador)
            throws PacoteNaoEncontradoException;
    Pacote procurar(String identificador)
            throws PacoteNaoEncontradoException;
    boolean existe(String identificador);
}
