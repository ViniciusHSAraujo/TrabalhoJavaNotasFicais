import java.util.ArrayList;

/**
 * 
 * Classe que representa a empresa
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 *
 */
public class Empresa {
	
	private String nome;
	private String cnpj;

	ArrayList<NotaFiscal> notas = new ArrayList<>();
	/**
	 * Construtor de uma empresa completa, com nome e CNPJ.
	 * @param nome
	 * @param cnpj
	 */
	public Empresa(String nome, String cnpj) {

		this.nome = nome;
		this.cnpj = cnpj;

		//this.notas = new ArrayList<NotaFiscal>();
	}
	/**
	 * Construtor de uma empresa somente com o CNPJ, utilizado na exclusão da empresa.
	 * @param cnpj
	 */
	public Empresa(String cnpj) {

		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<NotaFiscal> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<NotaFiscal> notas) {
		this.notas = notas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	public ArrayList<NotaFiscal> getNotasFiscaisValidas() {
		ArrayList<NotaFiscal> notasValidas = new ArrayList<>();
		for (NotaFiscal notaFiscal : this.notas) {
			if (!notaFiscal.getCancelada()) {
				notasValidas.add(notaFiscal);
			}
		}
		return notasValidas;
	}

	public ArrayList<NotaFiscal> getNotasFiscaisCanceladas() {
		ArrayList<NotaFiscal> notasCanceladas = new ArrayList<>();
		for (NotaFiscal notaFiscal : this.notas) {
			if (notaFiscal.getCancelada()) {
				notasCanceladas.add(notaFiscal);
			}
		}
		return notasCanceladas;
	}
	
	@Override
	public String toString() {
		String empresa = "\n" +
						 "Nome da Empresa: " + this.nome + "\n" + 
						 "CNPJ: " + this.cnpj + "\n\n";
		return empresa;
	}
}
