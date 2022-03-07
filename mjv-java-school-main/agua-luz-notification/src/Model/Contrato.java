package Model;

import java.util.Date;

//java beans
public class Contrato {
	private long protocolo;
	private Date data;
	private Date hora;
	private Double valor;
	//chaves estrangeiras
	private Pessoa pessoa;
	private Tipo tipo;
	public Tipo getTipo() {
		return tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getData() {
		return data;
	}
	public long getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public String toString() {
		return "Contrato [numeroProtocolo=" + protocolo + ", data=" + data + "]";
	}
	
}
