import java.util.ArrayList;

public class Contabilidade {

	private static final Double ZERO = 0.00;
	private static final Double VALOR_MINIMO_CONTABILIZACAO_DE_NOTAS = 5000.00;

	/**
	 * Método que realiza a contabilização dos valores das notas fiscais acima do valor mínimo específicado na contante VALOR_MINIMO_CONTABILIZACAO_DE_NOTAS.
	 * @param notasFiscais - Notas fiscais de uma empresa
	 * @return - Soma do valor das notas acima do "Valor Mínimo de Contabilização"
	 * @throws Excessao - Caso a empresa não tenha nenhuma nota, retorna uma mensagem informando que a empresa não contém nenhuma nota.
	 */
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
