package notification.service;

public class TransmissorMensagemWhats extends  TransmissorMensagem {

	@Override
	public void transmitir(String telefoneDestino, String mensagem) {
		System.out.println("Transmitindo WHATS");
		System.out.println("Telefone destino: " + telefoneDestino);
		System.out.println(mensagem);
		
	}

}
