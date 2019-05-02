import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	static ArrayList<Empresa> empresas = new ArrayList<>();
	static Empresa empresa;
	static Scanner sc = new Scanner(System.in);

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

		String[] opcoes = { "Cadastrar Empresa", "Listar Empresas", "Excluir Empresa", "Buscar Empresa", 
				"Cadastrar Nota Fiscal", "Buscar Nota Fiscal" };

		Boolean continuar = true;

		do {
			int opcao = Console.mostrarMenu(opcoes, "Escolha a opção da operação que você deseja fazer:", null);

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
				// buscar empresa
				cnpj = Console.recuperaTexto("Informe o CNPJ da empresa que deseja buscar:");
				try {
					Empresa empresaBuscada = encontrarEmpresaPeloCNPJ(cnpj);
					System.out.println(empresaBuscada);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				// cadastrar nota fiscal
				cnpj = Console.recuperaTexto("Informe o CNPJ da empresa que deseja cadastrar a Nota Fiscal:");
				try {
					Empresa cadastrarNotaNaEmpresaEncontrada = encontrarEmpresaPeloCNPJ(cnpj);
					cadastrarNotaFiscal(cadastrarNotaNaEmpresaEncontrada);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				/* buscar nota fiscal por empresa, utilizar o cnpj para buscar empresa e nota vinculada	*/
				cnpj = Console.recuperaTexto("Informe o CNPJ da empresa que deseja cadastrar a Nota Fiscal:");
				try {
					Empresa buscarNotaFiscal = encontrarEmpresaPeloCNPJ(cnpj);
					System.out.println(buscarNotaFiscal.getNotas());
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				// cancelar nota fiscal
				break;
			case 8:
				// buscar notas ficais canceladas, utilizar o cnpj para buscar empresa e nota
				// vinculada
				break;
			case 9:
				// buscar notas fiscais ordenadas por valor, utilizar o cnpj para buscar empresa
				// e nota vinculada
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

	private static void cadastrarNotaFiscal(Empresa empresaCadNotaFiscal) {
		System.out.println("############  Informe o dados da Nota Fiscal  ############");
		String numero = Console.recuperaTexto("Informe o número da nota:");
		String descricao = Console.recuperaTexto("Descreva a nota fiscal:");
		System.out.println("Informe o valor da nota:");
		Double valor = sc.nextDouble();
		Imposto imposto = null;
		Boolean loop = false;
		do{
			System.out.println("Informe o estado");
			System.out.println("1 - Paraná");
			System.out.println("2 - Santa Catarina");
			System.out.println("3 - São Paulo");
			int estado = sc.nextInt();
			if(estado == 1) {
				System.out.println(estado);
				imposto = new ImpostoParana(valor);
				loop = true;
			}
			if(estado == 2) {
				System.out.println(estado);
				imposto = new ImpostoSantaCatarina(valor);
				loop = true;
			}
			if(estado == 3) {
				System.out.println(estado);
				imposto = new ImpostoSaoPaulo(valor);
				loop = true;
			}else {
				System.out.println("Estado não cadastrado no banco de dados");
				imposto = null;
				loop = false;
			}
		}while(loop = false);
		Date dataEmissao = new Date();
		NotaFiscal notas = new NotaFiscal(numero, descricao, imposto, valor,dataEmissao);
		empresaCadNotaFiscal.notas.add(notas);
	}
}