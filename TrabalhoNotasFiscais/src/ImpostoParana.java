/**
 * 
 * Classe que representa o imposto do Estado do Paranï¿½.
 * 
 * @author Augusto Cï¿½sar
 * @author Paulo Henrique
 * @author Vinï¿½cius Araï¿½jo
 *
 */
public class ImpostoParana extends Imposto {

	/**
	 * Alï¿½quota Estadual do Estado do Paranï¿½: 5%
	 */
	public static double aliquotaEstadual = 0.05;

	public ImpostoParana(Double valor) {
		super(valor);
	}

	/**
	 * Método que calcula o valor do imposto estadual de acordo com o valor da nota
	 * e a alíquota do estado.
	 */
	public double calcularImpostoEstadual() {
		return this.valor * aliquotaEstadual;
	}
}
