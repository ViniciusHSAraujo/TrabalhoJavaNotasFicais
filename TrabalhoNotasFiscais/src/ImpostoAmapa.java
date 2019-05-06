
public class ImpostoAmapa extends Imposto {

	/**
	 * Alíquota Estadual do Estado do Amapá: 18,5%
	 */
	public static double aliquotaEstadual = 0.185;

	public ImpostoAmapa(Double valor) {
		super(valor);
	}

	/**
	 * M�todo que calcula o valor do imposto estadual de acordo com o valor da nota
	 * e a al�quota do estado.
	 */
	public double calcularImpostoEstadual() {
		return this.valor * aliquotaEstadual;
	}

}
