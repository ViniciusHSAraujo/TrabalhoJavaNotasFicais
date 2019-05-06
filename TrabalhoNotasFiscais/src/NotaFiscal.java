import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa a Nota Fiscal.
 * 
 * @author Augusto Cï¿½sar
 * @author Paulo Henrique
 * @author Vinï¿½cius Araï¿½jo
 *
 */
public class NotaFiscal implements Comparable<NotaFiscal> {

	private Integer numero;
	private String descricao;
	private Date dataEmissao;
	private Imposto imposto;
	private Double valor;
	private Double valorComImposto;
	private Boolean cancelada;

	public NotaFiscal(Integer numero, String descricao, Imposto imposto, Double valor) {
		this.numero = numero;
		this.descricao = descricao;
		this.setImposto(imposto);
		this.valor = valor;
		this.dataEmissao = new Date();
		this.cancelada = false;
		this.valorComImposto = valor + imposto.calcularImpostoTotal();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(Boolean cancelada) {
		this.cancelada = cancelada;
	}

	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

	public Double getValorComImposto() {
		return valorComImposto;
	}

	public void setValorComImposto(Double valorComImposto) {
		this.valorComImposto = valorComImposto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {

		/**
		 * Se a nota estiver cancelada (isCancelada = TRUE), situação receberá
		 * "Cancelada", se a nota não estiver cancelada (isCancelada = FALSE) a nota
		 * receberá "Autorizada" na impressão.
		 */
		String situacao = (isCancelada()) ? "Cancelada" : "Autorizada";

		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		String notaFiscalEmTexto = "\n" + "NÃºmero da Nota: " + this.numero + "\n" + "DescriÃ§Ã£o/Motivo: "
				+ this.descricao + "\n" + "Valor da nota: R$" + String.format("%.2f", this.valor) + "\n"
				+ "Data de EmissÃ£o: " + formatarData.format(this.dataEmissao) + "\n" + "Imposto Federal: R$"
				+ String.format("%.2f", this.imposto.calcularImpostoFederal()) + "\n" + "Imposto Estadual: R$"
				+ String.format("%.2f", this.imposto.calcularImpostoEstadual()) + "\n" + "Valor com os Impostos: R$"
				+ String.format("%.2f", this.valorComImposto) + "\n" + "SituaÃ§Ã£o: " + situacao + "\n";

		return notaFiscalEmTexto;

	}

	@Override
	public int compareTo(NotaFiscal o) {
		if (this.getValor() > o.getValor()) {
			return 1;
		} else if (this.getValor() < o.getValor()) {
			return -1;
		} else {
			return 0;
		}
	}

}
