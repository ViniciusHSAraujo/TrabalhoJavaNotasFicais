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
	Double ALIQUOTA_ESTADUAL_SAO_PAULO = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}

	public Double calcularImpostoEstadual(){
		return valor * ALIQUOTA_ESTADUAL_SAO_PAULO;
	}
}
