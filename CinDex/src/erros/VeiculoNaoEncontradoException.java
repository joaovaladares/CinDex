package erros;

public class VeiculoNaoEncontradoException extends Exception{
    public VeiculoNaoEncontradoException(){
        super("Veículo não encontrado, favor informar outro veículo");
    }
}
