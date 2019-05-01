import java.sql.Date;

/**
 * Função que irá criar a nota fiscal
 * 
 * @author Augusto
 *
 */
public class NotaFiscal {

	private String numero;
	private String descricao;
	private Date dataEmissao;
	private Imposto imposto;
	private Double valor;
	private Double valorComImposto;
	private Boolean cancelada;

	public NotaFiscal(String numero, String descricao, Imposto imposto, Double valor) {
		this.numero = numero;
		this.descricao = descricao;
		this.imposto = imposto;
		this.valor = valor;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public Boolean getCancelada() {
		return cancelada;
	}

	public void setCancelada(Boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
		public String toString() {
			// TODO - FAZER O toString
			return super.toString();
		}
	
}
