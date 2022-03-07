package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.Contrato;
import Model.Endereco;
import Model.Pessoa;
import Model.Tipo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class getContentsFromFile {

    public static List <Contrato> docHandle( boolean typeFile){
        List <Contrato> contratos = new ArrayList<Contrato>();
        if(typeFile){
            //default CSV
            contratos = getCsv();
            return contratos;
        }
        contratos = fileTxt();

        return contratos;
    }
    
    public static List <Contrato> getCsv(){
        List <Contrato> contratos = new ArrayList<Contrato>();
        //ATENÇÂO!, ALTERAR O PATCH DO ARQUIVO QUANDO TROCAR DE MAQUINA
        String patch        = "D:\\Projetos\\JAVA\\MJVSchool-grupo06\\mjv-java-school-main\\agua-luz-output\\agua-luz-contratos.csv";
        BufferedReader br   = null;
        String linha        = "";
        String divisor      = ";";
        
        try{
            br = new BufferedReader(new FileReader(patch));
            while ((linha = br.readLine()) != null ){
                String[] aux                = linha.split(divisor);
                //teste do arquivo
                Contrato contrato           = new Contrato();
                Pessoa pessoa               = new Pessoa();
                Endereco endereco           = new Endereco();
                //pessoa
                pessoa.setCpf               (aux[0]);
                System.out.println(pessoa.getCpf());
                pessoa.setRg                (aux[1]);
                pessoa.setNome              (aux[2]);
                pessoa.setCelular           (aux[3]);//criar ajuste
                //endereco
                endereco.setLogradouro      (aux[4]);
                endereco.setNumero          (aux[5]);
                endereco.setComplemento     (aux[6]);
                endereco.setBairro          (aux[7]);
                endereco.setCidade          (aux[8]);
                endereco.setUf              (aux[9]);
                endereco.setCep             (aux[10]);//criar ajuste
                //contrato
                contrato.setProtocolo       (Long.parseLong(aux[11]));
                //data
                contrato.setData            (dataConvert(aux[12]));
                //hora
                contrato.setHora            (hourConvert(aux[13]));
                //definir tipo
                Tipo tipo                   = aux[14] == "A"? Tipo.AGUA : Tipo.LUZ;
                contrato.setTipo            (tipo);
                contrato.setValor           (valorConvert(aux[15]));
                //chaves estrangeiras
                pessoa.setEndereco          (endereco);
                contrato.setPessoa          (pessoa);
                contratos.add(contrato);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return contratos;
    }

    public static List <Contrato> fileTxt(){
        List <Contrato> contratos       = new ArrayList<Contrato>();
        String patch                    = "D:\\Projetos\\JAVA\\MJVSchool-grupo06\\mjv-java-school-main\\agua-luz-output\\agua-luz-contratos.txt";
        BufferedReader br               = null;
        String linha                    = "";
        try{
            br = new BufferedReader(new FileReader(patch));
            while ((linha = br.readLine()) != null ){
                StringBuilder linhaAux = new StringBuilder(linha);
                //teste do arquivo
                Contrato contrato           = new Contrato();
                Pessoa pessoa               = new Pessoa();
                Endereco endereco           = new Endereco();
                //pessoa
                pessoa.setCpf               (linhaAux.substring(0,11));//11 caracteres
                pessoa.setRg                (linhaAux.substring(11,17));//10 caracteres
                pessoa.setNome              (linhaAux.substring(17,47));//30 caracteres
                pessoa.setCelular           (linhaAux.substring(47,58));//11 caracteres
                //endereco
                endereco.setLogradouro      (linhaAux.substring(58,78));//20 caracteres
                endereco.setNumero          (linhaAux.substring(78,84));//06 caracteres
                endereco.setComplemento     (linhaAux.substring(84,94));//10 caracteres
                endereco.setBairro          (linhaAux.substring(94,109));//15 caracteres
                endereco.setCidade          (linhaAux.substring(109,139));//30 caracteres
                endereco.setUf              (linhaAux.substring(139,141));//02 caracteres
                endereco.setCep             (linhaAux.substring(141,149));//08 caracteres
                //contrato
                contrato.setProtocolo       (Long.parseLong(linhaAux.substring(149,159)));//10 caracteres
                //data
                contrato.setData            (dataConvert(linhaAux.substring(159,167)));//08 caracteres
                //hora
                contrato.setHora            (hourConvert(linhaAux.substring(167,171)));//04 caracteres
                //definir tipo
                Tipo tipo                   = linhaAux.substring(171,172) == "A"? Tipo.AGUA : Tipo.LUZ;//01 caractere
                contrato.setTipo            (tipo);
                contrato.setValor           (valorConvert(linhaAux.substring(172,180)));//08 caracteres
                //chaves estrangeiras
                pessoa.setEndereco          (endereco);
                contrato.setPessoa          (pessoa);
                contratos.add(contrato);
            }
        }catch(Exception e){
            System.out.println("Documento formatado de forma incorreta!\n"+patch);
            //e.printStackTrace();
        }        
        return contratos;
    }

    public static Date dataConvert (String data) throws ParseException{
        Date dataConvertida         = null;
        StringBuilder SBdata        = new StringBuilder(data);
        //SBdata                      = SBdata.insert(4,"/").insert(7,"/");
        SimpleDateFormat formato    = new SimpleDateFormat("dd/MM/yyyy"); 
        dataConvertida              = formato.parse(SBdata.toString());
        return dataConvertida;
    }

    public static Date hourConvert (String hora) throws ParseException{
        Date horaConvertida         = null;
        StringBuilder SBhora        = new StringBuilder(hora);
        //SBhora                      = SBhora.insert(2,":");
        SimpleDateFormat formato    = new SimpleDateFormat("HH:mm"); 
        horaConvertida              = formato.parse(SBhora.toString());
        return horaConvertida;
    }

    public static Double valorConvert (String valor){
        StringBuilder SBvalor       = new StringBuilder(valor);
        //SBvalor                     = SBvalor.insert(5,',');
        return Double.parseDouble(SBvalor.toString());
    }
    public static String cpfConvert (String cpf){
        StringBuilder SBcpf         = new StringBuilder(cpf);
        SBcpf                       = SBcpf.insert(2,'.').insert(5,'.').insert(7,'-');
        return SBcpf.toString();
    }
}
