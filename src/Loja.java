import java.util.ArrayList;
import java.util.List;

public class Loja {
	List<Produto> produtos;

	public Loja() {
		this.produtos = new ArrayList<>();
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public String listarProdutos() {
		String listaProdutos = "\n"
				+ "Produtos disponíveis na loja: \n";
		for (Produto produto : produtos) {
			String descricao = "Codigo: " + produto.getCodigo() + " - Produto "+ produto.getNome() + " - R$ " + produto.getPreco()+"\n";
			listaProdutos += descricao;
		}
		return listaProdutos;
	}
	
	public Produto obterProduto(int codigoProduto) {
		Produto item = null;
	    for (Produto produto : produtos) {
	        if (produto.getCodigo() == codigoProduto) {
	            item = produto;
	        }
	    }
	    return item; 	    // Retorna null se o produto não for encontrado com o código fornecido

	}
	
	

} 
