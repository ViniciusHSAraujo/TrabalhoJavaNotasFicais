import java.util.ArrayList;

public class Contabilidade {

	private static final Double ZERO = 0.00;
	private static final Double VALOR_MINIMO_CONTABILIZACAO_DE_NOTAS = 5000.00;
	

	public Contabilidade() {
		
	}

	public static Double realizarContabilizacao(ArrayList<NotaFiscal> notasFiscais) throws Excessao{
		Double somaAuxiliar = ZERO;
		
		if (notasFiscais.size() == 0) {
			throw new Excessao("Essa empresa não contém nenhuma nota.\n"); 
		}
		
		for (NotaFiscal notaFiscal : notasFiscais) {
			if (notaFiscal.getValor() >= VALOR_MINIMO_CONTABILIZACAO_DE_NOTAS) {
				somaAuxiliar += notaFiscal.getValor();
			}
		}
		return somaAuxiliar;
	}

}
