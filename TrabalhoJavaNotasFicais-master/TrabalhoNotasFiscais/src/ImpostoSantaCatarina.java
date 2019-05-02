/**
  * Classe que representa o imposto do Estado de Santa Catarina
 * 
 * @author Augusto César
 * @author Paulo Henrique
 * @author Vinícius Araújo
 *
 */
public class ImpostoSantaCatarina extends Imposto {

	/**
	 * Alíquota Estadual do Estado de Santa Catarina: 10%
	 */
	Double ALIQUOTA_ESTADUAL_SANTA_CATARINA = 0.10;

	public ImpostoSantaCatarina(Double valor) {
		super(valor);
	}
	
	public Double calcularImpostoEstadual(){
		return valor * ALIQUOTA_ESTADUAL_SANTA_CATARINA;
	}
}
