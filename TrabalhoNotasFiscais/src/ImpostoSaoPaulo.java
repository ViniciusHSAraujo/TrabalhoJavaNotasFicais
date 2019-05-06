/**
 * 
 * Classe que representa o imposto do Estado de Sï¿½o Paulo.
 * 
 * @author Augusto Cï¿½sar
 * @author Paulo Henrique
 * @author Vinï¿½cius Araï¿½jo
 *
 */
public class ImpostoSaoPaulo extends Imposto {

	/**
	 * Alï¿½quota Estadual do Estado de Sï¿½o Paulo: 18%
	 */
	public static double aliquotaEstadual = 0.18;

	public ImpostoSaoPaulo(Double valor) {
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
