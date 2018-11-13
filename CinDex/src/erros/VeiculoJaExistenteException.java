package erros;

public class VeiculoJaExistenteException extends Exception{
    public VeiculoJaExistenteException(){
        super("O veiculo nao pode ser adicionado pois ja existe um com o mesmo nome, digite um nome diferente.");
    }
}
