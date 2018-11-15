package erros;

public class PesoMaximoException extends Exception {
    public PesoMaximoException(){
        super("Peso informado excede o permitido, favor informar peso menor ou igual a 10Kg!");
    }
}
