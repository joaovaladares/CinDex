package erros;

public class VeiculoCheioException extends Exception {
    public VeiculoCheioException(){
        super ("Impossível inserir pacote, este veículo excedeu capacidade de pacotes!");
    }
}
