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

	private static Double aliquotaFederal = 0.15;
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public Imposto(Double valor) {
		this.valor = valor;
	}

	public double calcularImpostoTotal() {
		double impostoFederal = calcularImpostoFederal();
		double impostoEstadual = calcularImpostoEstadual();
		return impostoEstadual + impostoFederal;
	}

	public double calcularImpostoFederal() {
		return this.valor * aliquotaFederal;
	}

	public abstract double calcularImpostoEstadual();
}
