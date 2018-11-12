package erros;

public class VeiculoInvalidoException extends Exception {
    VeiculoInvalidoException(){
        super("Veículo informado inválido");
    }
}
