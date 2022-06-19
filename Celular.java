public class Celular extends Produtos { 
    private static final long serialVersionUID = 1L;

public Celular(String modelo, String marca, String processador, int ram, String hd, int preco){
    super(modelo, marca, processador, ram, hd, preco);
    this.tipoP= "Celular";
}

    @Override
    public String toString() {
    return  "\n=======" + this.tipoP + "=======" + 
            "\nModelo: " + this.modelo + 
            "\nMarca: " + this.marca +
            "\nProcessador: " + this.processador +
            "\nMemoria ram: " + this.ram +
            "\nHD: " + this.hd +
            "\nPreço: " + this.preco;
    }   
}