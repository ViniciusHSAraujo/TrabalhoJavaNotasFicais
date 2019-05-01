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
	public static double aliquotaEstadual = 0.05;

	public ImpostoParana(Double valor) {
		super(valor);
	}
	
	public double calcularImpostoEstadual(){
		double valor = getValor();
		return valor * aliquotaEstadual;
	}
}
