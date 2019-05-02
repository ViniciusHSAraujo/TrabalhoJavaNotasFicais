/**
 * 
 * Classe que representa o imposto do Estado do Paran�
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
	Double ALIQUOTA_ESTADUAL_PARANA = 0.05;
	
	public ImpostoParana(Double valor) {
		super(valor);
	}
	
	@Override
	public Double calcularImpostoEstadual() {
		return valor*ALIQUOTA_ESTADUAL_PARANA;
	}
}
