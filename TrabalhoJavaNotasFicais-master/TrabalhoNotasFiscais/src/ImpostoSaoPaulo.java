/**
 * 
 * Classe que representa o imposto do Estado de S�o Paulo
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
	Double ALIQUOTA_ESTADUAL_SAO_PAULO = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}

	public Double calcularImpostoEstadual(){
		return valor * ALIQUOTA_ESTADUAL_SAO_PAULO;
	}
}
