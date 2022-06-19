public class Desktop extends Produtos { 
    private static final long serialVersionUID = 1L;
    private String pv;

public Desktop(String modelo, String marca, String processador, int ram, String hd, String pv, int preco){
    super(modelo, marca, processador, ram, hd, preco);
    this.tipoP= "Notebook";
    this.pv = pv;
}

    @Override
    public String toString() {
    return  "\n=======" + this.tipoP + "=======" + 
            "\nModelo: " + this.modelo + 
            "\nMarca: " + this.marca +
            "\nProcessador: " + this.processador +
            "\nMemoria ram: " + this.ram +
            "\nHD: " + this.hd +
            "\nPlaca de video: " + this.pv +
            "\nPreço: " + this.preco;
    }   

public void setPv(String pv){
    this.pv = pv;
}
public String getPv(){
    return pv;
}

}