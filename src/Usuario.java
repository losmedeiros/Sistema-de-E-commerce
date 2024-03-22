import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private String senha;
	List<Produto> carrinho;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.carrinho = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha; 
	}

	public List<Produto> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Produto> carrinho) {
		this.carrinho = carrinho;
	}
	
	

}
