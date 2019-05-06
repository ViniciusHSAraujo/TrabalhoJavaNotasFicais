/**
 * 
 * Classe que representa o imposto do Estado do Paran�.
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 *
 */
public class ImpostoParana extends Imposto {

	/**
	 * Al�quota Estadual do Estado do Paran�: 5%
	 */
	public static double aliquotaEstadual = 0.05;

	public ImpostoParana(Double valor) {
		super(valor);
	}

	/**
	 * M�todo que calcula o valor do imposto estadual de acordo com o valor da nota
	 * e a al�quota do estado.
	 */
	public double calcularImpostoEstadual() {
		return this.valor * aliquotaEstadual;
	}
}
