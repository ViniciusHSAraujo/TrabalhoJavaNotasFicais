
public class ImpostoSantaCatarina extends Imposto {

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
