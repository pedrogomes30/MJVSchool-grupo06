package notification.service;

public abstract class TransmissorMensagem {
	
	public abstract void transmitir (String telefoneDestino, String mensagem);
	
	/*
	public void transmitir (String telefoneDestino, String mensagem) {
		System.out.println("Transmitindo SMS");
		System.out.println("Telefone destino: " + telefoneDestino);
		System.out.println(mensagem);
	}
	*/
}
