/**
 * 
 * Classe que representa o imposto do Estado de São Paulo
 * 
 * @author Augusto César
 * @author Paulo Henrique
 * @author Vinícius Araújo
 *
 */
public class ImpostoSaoPaulo extends Imposto {

	/**
	 * Alíquota Estadual do Estado de São Paulo: 18%
	 */
	public static double aliquotaEstadual = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}

	public double calcularImpostoEstadual(){
		double valor = getValor();
		return valor * aliquotaEstadual;
	}
}
