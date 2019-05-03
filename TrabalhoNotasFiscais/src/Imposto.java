/**
 * 
 * Classe abstrata que representa o imposto. 
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 * 
 */
public abstract class Imposto {
	
	private static Double ALIQUOTA_FEDERAL = 0.15;

	protected Double valor;

	public Imposto(Double valor) {
		this.valor = valor;
	}

	public double calcularImpostoTotal() {
		return calcularImpostoFederal() + calcularImpostoEstadual();
	}

	public double calcularImpostoFederal() {
		return this.valor * ALIQUOTA_FEDERAL;
	}

	public abstract double calcularImpostoEstadual();
}
