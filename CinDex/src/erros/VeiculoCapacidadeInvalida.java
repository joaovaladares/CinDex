package erros;

public class VeiculoCapacidadeInvalida extends Exception {
    public VeiculoCapacidadeInvalida(){
        super ("Capacidade inválida, o veículo não pode ter menos que 0 pacotes!");
    }
}
