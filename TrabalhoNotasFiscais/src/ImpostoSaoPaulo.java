
public class ImpostoSaoPaulo extends Imposto {

	public static double aliquotaEstadual = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}

	public double calcularImpostoEstadual(){
		double valor = getValor();
		return valor * aliquotaEstadual;
	}
}
