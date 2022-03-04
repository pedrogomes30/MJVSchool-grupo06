

import Model.Contrato;
import Model.Endereco;

public class App {
	public static void main(String[] args) {
		Contrato contrato = new Contrato();
		contrato.setNumeroProtocolo(123);
		
		System.out.println(contrato.getNumeroProtocolo());
		
		Endereco endereco = new Endereco();
		endereco.setEstado("SP"); 
	}
}
