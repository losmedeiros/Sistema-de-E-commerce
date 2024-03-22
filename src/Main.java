import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ECommerceSystem sistema = new ECommerceSystem();
		sistema.cadastrarUsuario("jose", "123");
		sistema.cadastrarUsuario("maria", "456");

		Produto produto1 = new Produto("Produto A", 50.0);
		Produto produto2 = new Produto("Produto B", 30.0);

		sistema.loja.adicionarProduto(produto1);
		sistema.loja.adicionarProduto(produto2);

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Faça login:");
		System.out.print("Nome de usuário: ");
		String nomeUsuario = scanner.nextLine();
		System.out.print("Senha: ");
		String senhaUsuario = scanner.nextLine();

		if (sistema.fazerLogin(nomeUsuario, senhaUsuario)) {
			int opcao;
			do {
				try {
				System.out.println("\n Menu:");
				System.out.println("1. Listar produtos da loja");
				System.out.println("2. Adicionar produto ao carrinho");
				System.out.println("3. Remover produto do carrinho");
				System.out.println("4. Listar produtos do carrinho");
				System.out.println("5. Finalizar compra");
				System.out.println("0. Sair");
				System.out.print("Escolha a opção: ");
				opcao = scanner.nextInt();

				switch (opcao) {
				case 1:
					System.out.println(sistema.loja.listarProdutos());
					break;
				case 2:
					System.out.print("\n" + "Digite o Codigo do produto que você quer Adicionar?  ");
					int produto = scanner.nextInt();
					sistema.adicionarProdutoAoCarrinho(produto);
					break;
				case 3:
					System.out.print("\n" + "Digite o numero correspondente do produto que você quer Remover?  ");
					int numero = scanner.nextInt();
					sistema.removerProdutoDoCarrinho(numero);
					break;
				case 4:
					sistema.listarProdutosDoCarrinho();
					break;
				case 5:
					sistema.finalizarCompra();
					break;
				default:
				System.out.println("Sem opção para este numero");
				}
				} catch (Exception e) {
                    System.out.println("Erro! Digite um Numero valido");
                    scanner.nextLine(); // Limpar o buffer do scanner
                    opcao = -1; // Define uma opção inválida para continuar no loop
                }

			} while (opcao != 0);
		} else {
			System.out.println("Login falhou. Verifique seu nome de usuário e senha.");
		}
	}

}
