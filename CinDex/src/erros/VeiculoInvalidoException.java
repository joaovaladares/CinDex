package erros;

public class VeiculoInvalidoException extends Exception {
    public VeiculoInvalidoException(){
        super("Veículo informado inválido");
    }
}
