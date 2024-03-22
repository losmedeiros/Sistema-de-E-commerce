
public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	
	private static int contador=1;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.codigo=contador;
		contador++;
	}

	public String getNome() {
		return nome;
	} 

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}
	
	

}
