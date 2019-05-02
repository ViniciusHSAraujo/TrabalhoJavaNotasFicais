import java.util.ArrayList;
import java.util.function.Consumer;

public class Principal {

	static ArrayList<Empresa> empresas = new ArrayList<>();
	static Empresa empresa;

	public static void main(String[] args) {

		// Empresa e1 = new Empresa("e1", "124");
		//
		// Empresa e2 = new Empresa("e2", "123");
		//
		// empresas.add(e1);
		// empresas.add(e2);
		//
		// System.out.println(empresas);
		//
		// Empresa e3 = new Empresa("e3", "123");
		//
		// System.out.println(empresas.contains(e3));
		//
		// empresas.remove(e3);
		//
		// System.out.println(empresas);
		//
		// empresas.removeIf(e -> e.getNome().equals("e1"));

		// System.out.println(e1.equals(e2));

		String[] opcoes = { "Cadastrar Empresa", "Listar Empresas", "Excluir Empresa" };

		Boolean continuar = true;

		do {
			int opcao = Console.mostrarMenu(opcoes, "Escolha a opção da operação você deseja fazer:", null);

			switch (opcao) {
			case 1:
				Empresa novaEmpresa = criarEmpresa();
				try {
					cadastrarEmpresa(novaEmpresa);
					System.out.println("Empresa cadastrada com sucesso!");
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				listarEmpresas();
				break;
			case 3:
				String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa que deseja excluir:");
				try {
					Empresa empresaASerExcluida = encontrarEmpresaPeloCNPJ(cnpj);
					excluirEmpresa(empresaASerExcluida);
					System.out.println("Empresa excluída com sucesso!");
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case -1:
				System.out.println("Saindo..");
				continuar = false;
				break;
			}

		} while (continuar);
	}

	private static Empresa criarEmpresa() {
		String nome = Console.recuperaTexto("Insira o nome da empresa:");
		String cnpj = Console.recuperaTexto("Insira o CNPJ da empresa:");
		return new Empresa(nome, cnpj);
	}

	private static void cadastrarEmpresa(Empresa novaEmpresa) throws Excessao {
		for (Empresa empresa : empresas) {
			if (empresa.equals(novaEmpresa)) {
				throw new Excessao("CNPJ existente");
			}
		}
		empresas.add(novaEmpresa);
	}

	private static void listarEmpresas() {
		for (Empresa empresa : empresas) {
			System.out.println(empresa);
		}
	}

	private static Empresa encontrarEmpresaPeloCNPJ(String cnpj) throws Excessao {
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equalsIgnoreCase(cnpj)) {
				return empresa;
			}
		}
		throw new Excessao("Empresa não encontrada! [404]");
	}

	private static void excluirEmpresa(Empresa empresaASerExcluida) throws Excessao {

		if (empresaASerExcluida.getNotasFiscaisValidas().size() > 0) {
			throw new Excessao("A empresa contém notas fiscais válidas.\n"
					+ "Faça o cancelamento das mesmas para realizar a exclusão da empresa.");
		} else {
			empresas.remove(empresaASerExcluida);
		}
	}
}