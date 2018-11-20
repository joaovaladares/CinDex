package Pacote;

import erros.*;

// Classe coleção de negócio, que cadastra, remove, atualiza e procura por pacotes
public class CadastroPacotes {
    private RepositorioPacotes repositorio;

    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array
    public CadastroPacotes(boolean tipo) {
        if (tipo) {
            this.repositorio = new RepositorioPacotesLista();
        } else {
            this.repositorio = new RepositorioPacotesArray();
        }
    }

    // Cadastra um novo pacote, verificando se o mesmo ainda não existe
    public void cadastrar(Pacote pacote)
            throws PacoteJaCadastradoException, LimiteAtingidoException, IdentificadorInvalidoException,
            PesoMaximoException, DimensaoInvalidaException{

        if (!this.repositorio.existe(pacote.getIdentificador())) {
            // Checa se o identificador informado é válido
            if (pacote.getIdentificador().length() < 6) {
                IdentificadorInvalidoException e;
                e = new IdentificadorInvalidoException();
                throw e;
            }

            // Checa se o peso informado é válido
            if (pacote.getPeso() <= 10) {
                PesoMaximoException e;
                e = new PesoMaximoException();
                throw e;
            }

            // Checa se todas as dimensões informadas são válidas
            if (pacote.getAltura() <= 2 && pacote.getComprimento() <= 2 && pacote.getLargura() <= 2) {
                DimensaoInvalidaException e;
                e = new DimensaoInvalidaException();
                throw e;
            }


            this.repositorio.inserir(pacote);


        } else {
            PacoteJaCadastradoException e;
            e = new PacoteJaCadastradoException();
            throw e;
        }
    }

    // Recebe um pacote a ser atualizado no repositório
    public void atualizar(Pacote pacote)
            throws PacoteNaoEncontradoException {
        this.repositorio.atualizar(pacote);
    }

    // Remove um pacote com um determinado identificador
    public void remover(String identificador)
            throws PacoteNaoEncontradoException {
        this.repositorio.remover(identificador);
    }

    // Procura um pacote com um determinado identificador, e retorna o pacote caso exista
    public Pacote procurar(String identificador)
            throws PacoteNaoEncontradoException {
        return this.repositorio.procurar(identificador);
    }

    // Verifica se um dado pacote existe
    public boolean existe(String identificador) {
        return this.repositorio.existe(identificador);
    }
}
