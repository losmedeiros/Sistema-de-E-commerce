import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {

	List<Usuario> usuarios;
	Loja loja;
	Usuario usuarioLogado;

	public ECommerceSystem() {
		this.usuarios = new ArrayList<>();
		this.loja = new Loja();
		this.usuarioLogado = null;
	}

	public void cadastrarUsuario(String nome, String senha) {
		Usuario novoUsuario = new Usuario(nome, senha);
		usuarios.add(novoUsuario);
	}

	public boolean fazerLogin(String nome, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
				usuarioLogado = usuario;
				return true;
			}
		}
		return false;
	}

	public void adicionarProdutoAoCarrinho(int codigoProduto) {

		if (usuarioLogado != null) {
			Produto addProdutoCarrinho = loja.obterProduto(codigoProduto);
			if (addProdutoCarrinho != null) {
				usuarioLogado.carrinho.add(addProdutoCarrinho);
				System.out.println("Produto Adicionado");
			} else {
				System.out.println("Produto não encontrado");
			}
		}

	}

	public void removerProdutoDoCarrinho(int numeroDoContador) {
	    if (usuarioLogado != null && !usuarioLogado.carrinho.isEmpty()) {
	        if (numeroDoContador >= 1 && numeroDoContador <= usuarioLogado.carrinho.size()) {
	            // Subtrai 1 do número do contador para obter o índice correto na lista
	            int indiceDoProduto = numeroDoContador - 1;

	            // Remove o produto do carrinho usando o índice
	            Produto produtoRemovido = usuarioLogado.carrinho.remove(indiceDoProduto);

	            System.out.println("Produto removido do carrinho: " + produtoRemovido.getNome());
	        } else {
	            System.out.println("Número do contador inválido. Por favor, insira um número válido.");
	        }
	    } else {
	        System.out.println("O carrinho está vazio ou o usuário não está logado.");
	    }
	}

	public void listarProdutosDoCarrinho() {
		if (usuarioLogado != null && !usuarioLogado.carrinho.isEmpty()) {
			System.out.println("\n" + "Produtos no carrinho de " + usuarioLogado.getNome() + ":");
			int contador = 1;
			for (Produto produto : usuarioLogado.carrinho) {
				System.out.println(contador + ". " + produto.getNome() + " - R$ " + produto.getPreco());
				contador++;
			}
		} else {
			System.out.println("\n"
					+ "Carrinho vazio ou usuário não logado.");
		}
	}

	public void finalizarCompra() {
		if (usuarioLogado != null) {
			double total = 0;
			System.out.print("");
			System.out.println("Produtos comprados por " + usuarioLogado.getNome() + ":");
			System.out.print("");
			for (Produto produto : usuarioLogado.carrinho) {
				System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
				total += produto.getPreco();
			}
			System.out.println("Total: R$ " + total);
			usuarioLogado.carrinho.clear();
		}
	}

}
