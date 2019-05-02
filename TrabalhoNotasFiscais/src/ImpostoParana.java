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
	public static double aliquotaEstadual = 0.05;

	public ImpostoParana(Double valor) {
		super(valor);
	}
	
	public double calcularImpostoEstadual(){
		return this.valor * aliquotaEstadual;
	}
}
