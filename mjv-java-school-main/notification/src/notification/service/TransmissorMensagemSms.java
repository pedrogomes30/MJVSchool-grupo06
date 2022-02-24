package notification.service;

public class TransmissorMensagemSms extends TransmissorMensagem {

	@Override
	public void transmitir(String telefoneDestino, String mensagem) {
		System.out.println("Transmitindo SMS");
		System.out.println("Telefone destino: " + telefoneDestino);
		System.out.println(mensagem);
		
	}

}
