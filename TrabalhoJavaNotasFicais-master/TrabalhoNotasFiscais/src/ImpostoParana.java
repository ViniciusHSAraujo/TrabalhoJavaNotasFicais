/**
 * 
 * Classe que representa o imposto do Estado do Paraná
 * 
 * @author Augusto César
 * @author Paulo Henrique
 * @author Vinícius Araújo
 *
 */
public class ImpostoParana extends Imposto {

	/**
	 * Alíquota Estadual do Estado do Paraná: 5%
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
