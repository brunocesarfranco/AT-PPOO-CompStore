public class Celular extends Produtos { 
    private static final long serialVersionUID = 1L;
    private int tela;

public Celular(String modelo, String marca, String processador, int ram, String hd, int tela, int preco){
    super(modelo, marca, processador, ram, hd, preco);
    this.tipoP= "Notebook";
    this.tela = tela;
}

    @Override
    public String toString() {
    return  "\n=======" + this.tipoP + "=======" + 
            "\nModelo: " + this.modelo + 
            "\nMarca: " + this.marca +
            "\nProcessador: " + this.processador +
            "\nMemoria ram: " + this.ram + " gb" +
            "\nHD: " + this.hd +
            "\nTela: " + this.tela + " pol" + 
            "\nPreço: " + this.preco;
    }   

public void setTela(int tela){
    this.tela = tela;
}
public int getTela(){
    return tela;
}

}