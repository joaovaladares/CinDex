package erros;

public class TipoVeiculoInvalidoException extends Exception {
    public TipoVeiculoInvalidoException(){
        super ("Tipo de veículo inválido, por favor insira um tipo válido. (Navio, Carro ou Avião) ");
    }
}
