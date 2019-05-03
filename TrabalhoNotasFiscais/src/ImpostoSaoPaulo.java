/**
 * 
 * Classe que representa o imposto do Estado de S�o Paulo.
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 *
 */
public class ImpostoSaoPaulo extends Imposto {

	/**
	 * Al�quota Estadual do Estado de S�o Paulo: 18%
	 */
	public static double aliquotaEstadual = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}

	public double calcularImpostoEstadual(){
		return this.valor * aliquotaEstadual;
	}
}
