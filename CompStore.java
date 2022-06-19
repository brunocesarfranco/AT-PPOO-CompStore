import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class CompStore {
	private ArrayList<Produtos> produtos;

	public CompStore() {
		this.produtos = new ArrayList<Produtos>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

public Celular leCelular (){

    String [] valores = new String [5];
    String [] nomeVal = {"Modelo", "Marca", "Processador", "Ram", "Hd", "Tela", "Preço"};
    valores = leValores (nomeVal);

    int ram = this.retornaInteiro(valores[3]);
    int tela = this.retornaInteiro(valores[5]);
    int preco = this.retornaInteiro(valores[6]);

    Celular celular = new Celular (valores[0], valores[1], valores[2], ram, valores[4], tela, preco);
    return celular;
}

public Notebook leNotebook (){

    String [] valores = new String [6];
    String [] nomeVal = {"Modelo", "Marca", "Processador", "Ram", "Hd", "Placa de Video", "Preço"};
    valores = leValores (nomeVal);

    int ram = this.retornaInteiro(valores[3]);
    int preco = this.retornaInteiro(valores[6]);

    Notebook notebook = new Notebook (valores[0], valores[1], valores[2], ram, valores[4], valores[5] , preco);
    return notebook;
}

public Desktop leDesktop (){

    String [] valores = new String [6];
    String [] nomeVal = {"Modelo", "Marca", "Processador", "Ram", "Hd", "Placa de Video", "Preço"};
    valores = leValores (nomeVal);

    int ram = this.retornaInteiro(valores[3]);
    int preco = this.retornaInteiro(valores[6]);

    Desktop desktop = new Desktop (valores[0], valores[1], valores[2], ram, valores[4], valores[5], preco);
    return desktop;
}

private boolean intValido(String s) {
    try {
        Integer.parseInt(s); 
        return true;
    } catch (NumberFormatException e) { 
        return false;
    }
}

public int retornaInteiro(String entrada) { 

    while (!this.intValido(entrada)) {
        entrada = JOptionPane.showInputDialog(null, "Valor de "+ entrada +" incorreto!\n\nDigite um numero inteiro como opção.");
    }
    return Integer.parseInt(entrada);
}

public void salvaProdutos (ArrayList<Produtos> produtos){
    ObjectOutputStream outputStream = null;
    try {
        outputStream = new ObjectOutputStream 
                (new FileOutputStream("c:\\temp\\Concessionaria.dados"));
        for (int i=0; i < produtos.size(); i++)
            outputStream.writeObject(produtos.get(i));
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally { 
        try {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

public ArrayList<Produtos> recuperaProdutos (){
    ArrayList<Produtos> ProdutoTemp = new ArrayList<Produtos>();

    ObjectInputStream inputStream = null;

    try {	
        inputStream = new ObjectInputStream
                (new FileInputStream("C:\\Windows\\Temp\\compstore.dados"));
        Object obj = null;
        while ((obj = inputStream.readObject()) != null) {
            if (obj instanceof Produtos) {
                ProdutoTemp.add((Produtos) obj);
            }   
        }          
    } catch (EOFException ex) { 
        System.out.println("Fim de arquivo");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,
                            "===================================           \n" +
                            "       O arquivo com produtos nao existe!\n" + 
                            "===================================\n");
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        return ProdutoTemp;
}

public void menuCompStore (){

    String menu = "";
    String entrada;
    int    opc1, opc2;

    do {
        menu = "Controle de Produtos da Loja - CompStore\n\n" +
                "1. Cadastrar Produtos\n" +
                "2. Listar Produtos\n" +
                "3. Excluir Produtos\n" +
                "4. Gerar arquivo de Produtos\n" +
                "5. Recuperar Produtos\n" +
                "9. Sair";
        entrada = JOptionPane.showInputDialog (menu + "\n\n");
        opc1 = this.retornaInteiro(entrada);

        switch (opc1) {
        case 1:
            menu = "Entrada de Produtos\n\n" +
                    "Opções:\n" + 
                    "1. Celular\n" +
                    "2. Notebook\n" +
                    "3. Desktop\n";

            entrada = JOptionPane.showInputDialog (menu + "\n");
            opc2 = this.retornaInteiro(entrada);

            switch (opc2){
            case 1: produtos.add((Produtos)leCelular());
            break;
            case 2: produtos.add((Produtos)leNotebook());
            break;
            case 3: produtos.add((Produtos)leDesktop());
            break;
            default: 
                JOptionPane.showMessageDialog(null,"Produto para entrada NAO escolhido!");
            }

            break;
        case 2: 
            if (produtos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
                break;
            }
            String dados = "";
            for (int i=0; i < produtos.size(); i++)	{
                dados += produtos.get(i).toString() + "---------------\n";
            }
            JOptionPane.showMessageDialog(null,dados);
            break;
        case 3: 
            if (produtos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
                break;
            }
            produtos.clear();
            JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
            break;
        case 4:
            if (produtos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
                break;
            }
            salvaProdutos(produtos);
            JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
            break;
        case 5:
            produtos = recuperaProdutos();
            if (produtos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                break;
            }
            JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
            break;
        case 9:
            JOptionPane.showMessageDialog(null,"Fim do aplicativo CompStore - Volte Sempre!");
            break;
        }
    } while (opc1 != 9);
}

public static void main (String [] args){

    CompStore pet = new CompStore ();
    pet.menuCompStore();

}
}
