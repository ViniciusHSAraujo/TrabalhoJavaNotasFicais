/**
  * Classe que representa o imposto do Estado de Santa Catarina
 * 
 * @author Augusto C�sar
 * @author Paulo Henrique
 * @author Vin�cius Ara�jo
 *
 */
public class ImpostoSantaCatarina extends Imposto {

	/**
	 * Al�quota Estadual do Estado de Santa Catarina: 10%
	 */
	Double ALIQUOTA_ESTADUAL_SANTA_CATARINA = 0.10;

	public ImpostoSantaCatarina(Double valor) {
		super(valor);
	}
	
	public Double calcularImpostoEstadual(){
		return valor * ALIQUOTA_ESTADUAL_SANTA_CATARINA;
	}
}
