package erros;

public class VeiculoJaExistenteException extends Exception{
    public VeiculoJaExistenteException(){
        super("O veículo não pode ser adicionado pois já existe um com o mesmo nome, digite um nome diferente.");
    }
}
