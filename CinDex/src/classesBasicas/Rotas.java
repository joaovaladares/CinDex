package classesBasicas;

public class Rotas {

    //Atributos exclusivos classe Rotas;
    private String tipo;
    private int periculosidade;
    private Pacotes[] pacote;
    
    //Construtor da classe Rotas
    public Rotas(Pacotes pacote) {
        if (pacote.getEndereco[0] >= 0) {
            this.periculosidade = 0;
        } else {
            this.periculosidade = 1;
        }
        if (pacote.getEndereco[1] >= 0) {
            this.tipo = "Urbano";
        } else {
            this.tipo = "Rural";
        }
    }
}

