package notification.model.cadastro;

public class Cadastro {
	private int numero;
	private boolean ativo;
	private NotificacaoTipo notificacaoTipo;
	private Pessoa pessoa;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public NotificacaoTipo getNotificacaoTipo() {
		return notificacaoTipo;
	}
	public void setNotificacaoTipo(NotificacaoTipo notificacaoTipo) {
		this.notificacaoTipo = notificacaoTipo;
	}
}
