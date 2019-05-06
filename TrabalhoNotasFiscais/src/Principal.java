import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe principal onde roda todas as funcionalidades do sistema
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 *
 */
public class Principal {

	private static final Double VALOR_MAXIMO_NF = 150000.00;
	static ArrayList<Empresa> empresas = new ArrayList<>();
	static Empresa empresa;

	public static void main(String[] args) {

		String[] opcoes = { "Cadastrar Empresa", "Listar Empresas", "Excluir Empresa", "Lançar Nota Fiscal",
				"Cancelar Nota Fiscal", "Relatório: Notas Fiscais por Empresa",
				"Relatório: Notas Fiscais Canceladas por Empresa",
				"Relatório: Notas Fiscais Por Empresa (Ord.: valor)", "Contabilizar Notas" };

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
					verificarValorDaNota(notaFiscalGerada);
					verificarNumeracao(notaFiscalGerada, empresaLancamentoNota);

					System.out.println("Nota Fiscal Autorizada e Processada com Sucesso!");
					System.out.println(notaFiscalGerada);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					Empresa empresaDaNota = encontrarEmpresaPeloCNPJ();
					System.out.println("Segue abaixo relação de Notas Fiscais dessa empresa:");
					listarNotasFiscais(empresaDaNota);
					Integer numeroDaNota = Console.recuperaInteiro("Digite o número da nota que deseja cancelar:");
					NotaFiscal notaCancelamento = encontrarNotaFiscal(empresaDaNota, numeroDaNota);
					notaCancelamento.setCancelada(true);
					System.out.println("Nota cancelada com sucesso!");
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					Empresa empresaDaNota = encontrarEmpresaPeloCNPJ();
					listarNotasFiscais(empresaDaNota);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				try {
					Empresa empresaDaNota = encontrarEmpresaPeloCNPJ();
					listarNotasFiscaisCanceladas(empresaDaNota);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					Empresa empresaDaNota = encontrarEmpresaPeloCNPJ();
					listarNotasFiscaisPorValor(empresaDaNota);
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				try {
					Empresa empresaContabilizacaoDeNotas = encontrarEmpresaPeloCNPJ();
					Double valorNotas = Contabilidade.realizarContabilizacao(empresaContabilizacaoDeNotas.getNotasFiscaisValidas());
					System.out.println("A soma do valor das notas acima de R$5.000,00 da empresa é: R$" + String.format("%.2f", valorNotas));
				} catch (Excessao e) {
					System.out.println(e.getMessage());
				}
				break;
			case -1:
				System.out.println("Saindo..");
				continuar = false;
				break;
			}
		} while (continuar);
	}

	/**
	 * Método criado para criar uma empresa com o Nome e CNPJ
	 * 
	 * @return uma empresa com o nome e CNPJ.
	 */
	private static Empresa criarEmpresa() {
		String nome = Console.recuperaTexto("Insira o nome da empresa:");
		String cnpj = Console.recuperaTexto("Insira o CNPJ da empresa:");
		return new Empresa(nome, cnpj);
	}

	/**
	 * Método que recebe uma empresa e verifica se ela deve ou não ser cadastrada no
	 * sistema. Seu funcionamento se dá pela verificação se a empresa já existe,
	 * caso não, ele cadastra no array "empresas", senão, retorna um erro informando
	 * que o CNPJ já está cadastrado em outra empresa.
	 * 
	 * @param novaEmpresa - Empreas a ser cadastrada
	 * @throws Excessao - Caso o CNPJ já esteja cadastrado, retorna a mensagem "CNPJ
	 *                  Existente".
	 */
	private static void cadastrarEmpresa(Empresa novaEmpresa) throws Excessao {
		for (Empresa empresa : empresas) {
			if (empresa.equals(novaEmpresa)) {
				throw new Excessao("CNPJ existente");
			}
		}
		empresas.add(novaEmpresa);
	}

	/**
	 * Método que varre o array "empresas" e imprime na tela cada uma delas.
	 */
	private static void listarEmpresas() {
		for (Empresa empresa : empresas) {
			System.out.println(empresa);
		}
	}

	/**
	 * Método que pergunta qual o CNPJ da empresa que o usuário está buscando e
	 * realiza uma varredura no array "empresas" buscando a empresa do CNPJ
	 * informado.
	 * 
	 * @return - A empresa com o CNPJ informado pelo cliente.
	 * @throws Excessao - Caso não exista a empresa, ele retorna um erro informando
	 *                  que a empesa não foi encontrada.
	 */
	private static Empresa encontrarEmpresaPeloCNPJ() throws Excessao {
		String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa:");
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj().equalsIgnoreCase(cnpj)) {
				return empresa;
			}
		}
		throw new Excessao("Empresa não encontrada!");
	}

	/**
	 * Método criado para excluir uma empresa do sistema. Seu funcionamento se dá
	 * por meio do
	 * 
	 * @param empresaASerExcluida
	 * @throws Excessao
	 */
	private static void excluirEmpresa(Empresa empresaASerExcluida) throws Excessao {
		if (empresaASerExcluida.getNotasFiscaisValidas().size() > 0) {
			throw new Excessao("A empresa contém notas fiscais válidas.\n"
					+ "Faça o cancelamento das mesmas para realizar a exclusão da empresa.");
		} else {
			empresas.remove(empresaASerExcluida);
		}
	}

	/**
	 * Método que coleta as informações e gera a nota fiscal.
	 * 
	 * @return - Uma nota fiscal com as informações necessárias para o sistema.
	 */
	private static NotaFiscal gerarNotaFiscal() {

		String descricao = Console.recuperaTexto("Digite o Motivo da Nota Fiscal:");
		double valor = Console.recuperaDecimal("Digite o valor monetário da Nota Fiscal:");
		int numero = Console.recuperaInteiro("Digite o número da Nota Fiscal:");
		Imposto imposto = verificarEstado(valor);
		NotaFiscal notaFiscal = new NotaFiscal(numero, descricao, imposto, valor);

		return notaFiscal;

	}

	/**
	 * Método que verifica se a numeração da Nota Fiscal já foi utilizada por outra
	 * nota na mesma empresa, evitando duplicidade.
	 * 
	 * @param novaNotaFiscal    - Nota Fiscal a ser incluída na empresa.
	 * @param empresaLancamento - Empresa na qual a nota fiscal será incluída.
	 * @throws Excessao - Caso a numeração já tenha sido utilizada, o sistema
	 *                  retorna uma mensagem informando que o número já foi
	 *                  utilizado.
	 */
	private static void verificarNumeracao(NotaFiscal novaNotaFiscal, Empresa empresaLancamento) throws Excessao {
		for (NotaFiscal notaFiscal : empresaLancamento.notas) {
			if (notaFiscal.equals(novaNotaFiscal)) {
				throw new Excessao("Número já utilizado");
			}
		}
		empresaLancamento.notas.add(novaNotaFiscal);
	}

	/**
	 * Método que verifica o valor monetário da nota e retorna uma excessão caso o valor seja superior ao máximo permitido.
	 * @param notaFiscal - Nota Fiscal que o usuário deseja incluir
	 * @throws Excessao - Se o valor for superior ao máximo permitido, o sistema retorna uma mensagem informando que não é possível incluir a nota fiscal.
	 */
	private static void verificarValorDaNota(NotaFiscal notaFiscal) throws Excessao{
		if (notaFiscal.getValor() > VALOR_MAXIMO_NF) {
			throw new Excessao("Operação não permitida! Impossível emitir notas com valor superior a R$150.000,00");
		}
	}
	
	/**
	 * Método que varre o array de Notas Fiscais de uma empresa e imprime na tela
	 * cada uma delas.
	 * 
	 * @param empresa - A empresa em que o sistema verificará as notas fiscais.
	 */
	private static void listarNotasFiscais(Empresa empresa) {
		System.out.println("--------------------------------");
		for (NotaFiscal notaFiscal : empresa.notas) {
			System.out.println(notaFiscal);
			System.out.println("--------------------------------");
		}
		System.out.println("\n");
	}

	/**
	 * Método que varre o array de Notas Fiscais de uma empresa e imprime na tela
	 * cada uma delas.
	 * 
	 * @param empresa - A empresa em que o sistema verificará as notas fiscais.
	 */
	private static void listarNotasFiscaisCanceladas(Empresa empresa) {
		System.out.println("Notas Fiscais Canceladas:\n\n");
		System.out.println("--------------------------------");
		for (NotaFiscal notaFiscal : empresa.getNotasFiscaisCanceladas()) {
			System.out.println(notaFiscal);
			System.out.println("--------------------------------");
		}
		System.out.println("\n");
	}

	/**
	 * Método que varre o array de Notas Fiscais de uma empresa e imprime na tela
	 * cada uma delas. ordenado por valor.
	 * 
	 * @param empresa - A empresa em que o sistema verificará as notas fiscais.
	 */
	private static void listarNotasFiscaisPorValor(Empresa empresa) {
		System.out.println("--------------------------------");
		Collections.sort(empresa.notas);
		for (NotaFiscal notaFiscal : empresa.notas) {
			System.out.println(notaFiscal);
			System.out.println("--------------------------------");
		}
		System.out.println("\n");
	}

	/**
	 * Método que busca uma nota fiscal pelo número dela em uma empresa.
	 * 
	 * @param empresaDaNota - Empresa em que o sistema procurará pela nota.
	 * @param numeroDaNota  - Número da nota que o sistema deve procurar.
	 * @return - Nota Fiscal com o número solicitado pelo usuário.
	 * @throws Excessao - Caso não haja nenhuma nota na empresa com tal numeração, o
	 *                  sistema retorna informando que não encontrou nenhuma nota
	 *                  com tal numeração.
	 */
	private static NotaFiscal encontrarNotaFiscal(Empresa empresaDaNota, Integer numeroDaNota) throws Excessao {
		for (NotaFiscal notaFiscal : empresaDaNota.notas) {
			if (notaFiscal.getNumero() == numeroDaNota) {
				return notaFiscal;
			}
		}
		throw new Excessao("Nota fiscal não encontrada.");
	}

	/**
	 * Verifica o estado para o qual a nota será emitida e retorna o imposto de tal
	 * estado.
	 * 
	 * @param valor - Valor da nota para realização do cálculo do imposto.
	 * @return - Retorna o imposto para o estado escolhido. OBS: Tem um 'return
	 *         null' que foi utilizado somente para o Java compilar, pois o sistema
	 *         ficará no do while e retornará o imposto de algum estado, porém o
	 *         Java não entende isso.
	 */
	private static Imposto verificarEstado(Double valor) {
		String[] UFs = { "Paraná", "Santa Catarina", "São Paulo", "Amapá" };

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
			case 4:
				Imposto impostoAmapa = new ImpostoAmapa(valor);
				return impostoAmapa;
			}

		} while (continuar);
		return null; // NUNCA VAI CAIR AQUI, COLOQUEI SÓ PRO JAVA COMPILAR
	}

}