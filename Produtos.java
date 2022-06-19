import java.io.Serializable;

public abstract class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String modelo;
	protected String marca;
	protected String processador;
	protected int ram;
	protected String hd;
	protected int preco;
	protected String tipoP;

	public Produtos(String modelo,
				    String marca, 
					String processador, 
					int ram, 
					String hd,
					int preco  ) {
		this.modelo = modelo;				
		this.marca = marca;
		this.processador = processador;
		this.ram = ram;
		this.hd = hd;
		this.preco = preco;
	}
	
	public String getNome() {
		return marca + modelo;
	}	
}
