/**
 * Classe que representa o imposto do Estado de Santa Catarina.
 * 
 * @author Augusto Cï¿½sar
 * @author Paulo Henrique
 * @author Vinï¿½cius Araï¿½jo
 *
 */
public class ImpostoSantaCatarina extends Imposto {

	/**
	 * Alï¿½quota Estadual do Estado de Santa Catarina: 10%
	 */
	public static double aliquotaEstadual = 0.10;

	public ImpostoSantaCatarina(Double valor) {
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
