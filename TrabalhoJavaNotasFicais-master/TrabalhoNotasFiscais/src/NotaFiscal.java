
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe que representa a Nota Fiscal
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
	
	public NotaFiscal(String numero, String descricao, Imposto imposto, Double valor, Date dataEmissao) {
		this.numero = numero;
		this.descricao = descricao;
		this.imposto = imposto;
		this.valor = valor;
		this.dataEmissao = dataEmissao;
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

	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorComImposto() {
		return valorComImposto;
	}

	public void setValorComImposto() {
		this.valorComImposto = imposto.calcularImpostoTotal();
	}

	public Boolean getCancelada() {
		return cancelada;
	}

	public void setCancelada(Boolean cancelada) {
		this.cancelada = cancelada;
	}

	/*
	 * toString para teste, arrumar depois
	 * */
	@Override
	public String toString() {
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yy HH:mm");
		String notaFiscal = "\n" +
						 "Descrição: " + this.descricao + "\n" + 
						 "Número: "+ this.numero + "\n" +
						 "Data Emissao: "+ formatarData.format(this.dataEmissao) + "\n" +  
						 "Valor: "+ this.valor + "\n\n" + 
						 "Valor com imposto: "+ this.valorComImposto + "\n" + 
						 "cancelada: "+ this.cancelada + "\n\n"; 

		return notaFiscal;
	}
	
}
