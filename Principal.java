	import java.util.ArrayList;
	
	public class Principal {
	
		static ArrayList<Empresa> empresas = new ArrayList<>();
		static Empresa empresa;
	
		public static void main(String[] args) {
	
	//		Empresa e1 = new Empresa("e1", "124");
	//
	//		Empresa e2 = new Empresa("e2", "123");
	//		
	//		empresas.add(e1);
	//		empresas.add(e2);
	//
	//		System.out.println(empresas);
	//
	//		Empresa e3 = new Empresa("e3", "123");
	//
	//		System.out.println(empresas.contains(e3));
	//
	//		empresas.remove(e3);
	//
	//		System.out.println(empresas);
	//
	//		empresas.removeIf(e -> e.getNome().equals("e1"));
	
			// System.out.println(e1.equals(e2));
	
			String[] opcoes = { "Op��o 01", "Op��o 02" };
	
			Boolean continuar = true;
	
			do {
				int opcao = Console.mostrarMenu(opcoes, "Escolha a op��o da opera��o voc� deseja fazer:", null);
	
				switch (opcao) {
				case 1:
					Empresa nova = criarEmpresa();
					try {
						cadastrarEmpresa(nova);
						System.out.println("deu boa");
					} catch (EmpresaJaCadastrada e) {
						System.out.println("Erro na opera��o: " + e.getMessage());
					}
					break;
				case 2:
					break;
				case 3:
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
	
		private static void cadastrarEmpresa(Empresa nova) throws EmpresaJaCadastrada {
			for (Empresa empresa : empresas) {
				if (empresa.equals(nova)) {
					throw new EmpresaJaCadastrada("CNPJ existente");
				}
			}
			empresas.add(nova);
		}
	}