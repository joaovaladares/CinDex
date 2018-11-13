package erros;

public class VeiculoJaExistenteException extends Exception{
    VeiculoJaExistenteException(){
        super("O veiculo nao pode ser adicionado pois ja existe.");
    }
}
