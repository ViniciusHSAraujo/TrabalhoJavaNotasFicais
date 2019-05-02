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

	private Double ALIQUOTA_FEDERAL = 0.15;
	protected Double valor;

	public Double getValor() {
		return valor;
	}

	public Imposto(Double valor) {
		this.valor = valor;
	}

	public Double calcularImpostoTotal() {
		Double total = calcularImpostoFederal() + calcularImpostoEstadual();
		return total;
	}

	public Double calcularImpostoFederal() {
		return this.valor * ALIQUOTA_FEDERAL;
	}

	public abstract Double calcularImpostoEstadual();
}
