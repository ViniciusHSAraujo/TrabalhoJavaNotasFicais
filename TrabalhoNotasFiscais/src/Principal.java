import java.util.ArrayList;

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

		String[] opcoes = { "Cadastrar Empresa", "Listar Empresas", "Excluir Empresa", "Lançar Nota Fiscal" };

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
				try {
					Empresa empresaASerExcluida = encontrarEmpresaPeloCNPJ();
					excluirEmpresa(empresaASerExcluida);
					System.out.println("Empresa excluída com sucesso!");
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					Empresa empresaLancamentoNota = encontrarEmpresaPeloCNPJ();
					NotaFiscal notaFiscalGerada = gerarNotaFiscal();

					empresaLancamentoNota.notas.add(notaFiscalGerada);
					System.out.println("Nota Fiscal Autorizada e Processada com Sucesso!");
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
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

	private static Empresa encontrarEmpresaPeloCNPJ() throws Excessao {
		String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa:");
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

	private static NotaFiscal gerarNotaFiscal() {

		String descricao = Console.recuperaTexto("Digite o CFOP (Motivo da Nota Fiscal):");
		double valor = Console.recuperaDecimal("Digite o valor monetário da Nota Fiscal:");
		int numero = Console.recuperaInteiro("Digite o número da Nota Fiscal:");
		Imposto imposto = verificarEstado(valor);
		NotaFiscal notaFiscal = new NotaFiscal(numero, descricao, imposto, valor);

		return notaFiscal;

	}

	private static Imposto verificarEstado(Double valor) {
		String[] UFs = { "Paraná", "Santa Catarina", "São Paulo" };

		Boolean continuar = true;

		do {
			int opcao = Console.mostrarMenuSemVoltar(UFs, "Escolha o estado destino da Nota Fiscal:", null);

			switch (opcao) {
			case 1:
				Imposto impostoParana = new ImpostoParana(valor);
				return impostoParana;
			case 2:
				Imposto impostoSantaCatarina = new ImpostoSantaCatarina(valor);
				return impostoSantaCatarina;
			case 3:
				Imposto impostoSaoPaulo = new ImpostoSaoPaulo(valor);
				return impostoSaoPaulo;
			}

		} while (continuar);
		// NUNCA VAI CAIR AQUI, COLOQUEI SÓ PRO JAVA COMPILAR
		return null;
	}
}