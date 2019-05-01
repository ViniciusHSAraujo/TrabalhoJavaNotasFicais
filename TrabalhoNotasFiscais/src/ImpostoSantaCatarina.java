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
	public static double aliquotaEstadual = 0.10;

	public ImpostoSantaCatarina(Double valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularImpostoEstadual(){
		double valor = getValor();
		return valor * aliquotaEstadual;
	}
}
