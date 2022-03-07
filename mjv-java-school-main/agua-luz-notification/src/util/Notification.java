package util;

import Model.Contrato;
import Model.Endereco;
import Model.Pessoa;

public class Notification {
    public static void sendNotification(Contrato contrato){
        StringBuilder notification  = new StringBuilder();
        //models
        Pessoa pessoa         = contrato.getPessoa();
        Endereco endereco     = contrato.getPessoa().getEndereco();

        //notification.append()
        notification.append("Senhor(a) "+pessoa.getNome()+",cpf sob o Nº "+pessoa.getCpf()+", Informamos que conforme contrato com protocolo de número "+contrato.getProtocolo());
        notification.append("\nestá agendado para a data "+contrato.getData().toString()+" às "+contrato.getHora().toString()+"h a instalação do serviço de "+contrato.getTipo());
        notification.append("\ncom taxa de valor R$ "+contrato.getValor()+"em sua residência localizada no endereço abaixo:");
        notification.append("\nLogradouro: "  +endereco.getLogradouro());
        notification.append("\nComplemento: " +endereco.getComplemento());
        notification.append("\nBairro: "      +endereco.getBairro());
        notification.append("\nCidade: "      +endereco.getCidade());
        notification.append("\nCEP: "         +endereco.getCep());
        notification.append("\nAtenciosamente, a gerência");

        System.out.println(notification);
        
        /* -- MESSAGE EXAMPLE --
        Senhor(a) Gleyson Sampaio cpf de número 234.765.987-27, Informamos que conforme contrato com protocolo de número 2022025687 está 
        agendado para a data 21/02/2022 as 16:00h  Água com taxa de valor R$ 127,33 em sua
        residência localizada no endereço abaixo:

        Logradouro: Rua das Marias, 243
        Complemento: Ap 207, Bloco C
        Bairro: Santo Antonio
        Cidade: São Paulo / SP
        Cep: 27.310-657


        */
    }
}
