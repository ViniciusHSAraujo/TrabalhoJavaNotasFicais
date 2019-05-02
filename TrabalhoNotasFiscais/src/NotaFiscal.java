import java.sql.Date;

/**
 * Classe que representa a Nota Fiscal
 * 
 * @author Augusto
 *
 */
public class NotaFiscal {

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
	public String toString() {
		
		String situacao = (isCancelada()) ? "Cancelada" : "Autorizada"; 
		
		String notaFiscalEmTexto = "\n"
								+  "Número da Nota: " + this.numero + "\n"
								+  "Descrição/Motivo: " + this.descricao + "\n"
								+  "Valor da nota: " + this.valor + "\n"
								+  "Imposto Federal: " + this.imposto.calcularImpostoFederal() + "\n"
								+  "Imposto Estadual: " + this.imposto.calcularImpostoEstadual() + "\n"
								+  "Valor com os Impostos: " + this.valorComImposto + "\n"
								+  "Situação: " + situacao + "\n";
		
		return notaFiscalEmTexto;

	}
}
