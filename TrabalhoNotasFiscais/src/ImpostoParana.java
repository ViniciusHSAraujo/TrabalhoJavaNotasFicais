
public class ImpostoParana extends Imposto {
	
	public static double aliquotaEstadual = 0.05;

	public ImpostoParana(Double valor) {
		super(valor);
	}
	
	public double calcularImpostoEstadual(){
		double valor = getValor();
		return valor * aliquotaEstadual;
	}
}
