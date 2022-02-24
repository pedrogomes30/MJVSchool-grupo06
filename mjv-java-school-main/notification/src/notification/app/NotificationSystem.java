package notification.app;

import java.util.Date;

import notification.model.cadastro.Cadastro;
import notification.model.cadastro.Endereco;
import notification.model.cadastro.NotificacaoTipo;
import notification.model.cadastro.Pessoa;
import notification.model.contrato.Contrato;
import notification.service.ContratoService;
import notification.service.TransmissorMensagem;
import notification.service.TransmissorMensagemSms;
import notification.service.TransmissorMensagemWhats;

public class NotificationSystem {
	public static void main(String[] args) {
		Contrato contrato = new Contrato();
		contrato.setNumeroProtocolo(123);
		Cadastro cadastro = new Cadastro();
		cadastro.setAtivo(true);
		cadastro.setNumero(27);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("123213");
		pessoa.setNome("Gleyson Sampaio");
		pessoa.setRg("89789");
		
		pessoa.setTelefone("897789");
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Santo Antonio");
		endereco.setCep("27.310-657");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setLogradouro("Rua das Marias");
		endereco.setNumero("243");
		cadastro.setPessoa(pessoa);
		cadastro.setNotificacaoTipo(NotificacaoTipo.WHATS);
		contrato.setCadastro(cadastro);
		contrato.setDataHora(new Date());
		
		ContratoService service = new ContratoService(); 
		String mensagem =  service.gerarConteudoContrato(contrato);
		
		TransmissorMensagem transmissor = null;
		
		if(cadastro.getNotificacaoTipo() == NotificacaoTipo.SMS)
			transmissor = new TransmissorMensagemSms();
		else
			transmissor = new TransmissorMensagemWhats();
		
		transmissor.transmitir(contrato.getCadastro().getPessoa().getTelefone(), mensagem);
	}
}
