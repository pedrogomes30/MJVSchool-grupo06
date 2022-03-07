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
                int ini                     = 0;
                int fim                     = 0;
            
                //pessoa
                ini                         = fim;fim +=11;
                pessoa.setCpf               (linhaAux.substring(ini,fim));//11 caracteres
                ini                         = fim;fim +=10;
                pessoa.setRg                (linhaAux.substring(ini,fim));//10 caracteres
                ini                         = fim;fim +=30;
                pessoa.setNome              (linhaAux.substring(ini,fim));//30 caracteres
                ini                         = fim;fim +=11;
                pessoa.setCelular           (linhaAux.substring(ini,fim));//11 caracteres
                //endereco
                ini                         = fim;fim +=20;
                endereco.setLogradouro      (linhaAux.substring(ini,fim));//20 caracteres
                ini                         = fim;fim +=6;
                endereco.setNumero          (linhaAux.substring(ini,fim));//06 caracteres
                ini                         = fim;fim +=10;
                endereco.setComplemento     (linhaAux.substring(ini,fim));//10 caracteres
                ini                         = fim;fim +=15;
                endereco.setBairro          (linhaAux.substring(ini,fim));//15 caracteres
                ini                         = fim;fim +=30;
                endereco.setCidade          (linhaAux.substring(ini,fim));//30 caracteres
                ini                         = fim;fim +=2;
                endereco.setUf              (linhaAux.substring(ini,fim));//02 caracteres
                ini                         = fim;fim +=8;
                endereco.setCep             (linhaAux.substring(ini,fim));//08 caracteres
                //contrato
                ini                         = fim;fim +=10;
                contrato.setProtocolo       (Long.parseLong(linhaAux.substring(ini,fim)));//10 caracteres
                //data
                ini                         = fim;fim +=8;
                contrato.setData            (dataConvert(linhaAux.substring(ini,fim)));//08 caracteres
                //hora
                ini                         = fim;fim +=4;
                contrato.setHora            (hourConvert(linhaAux.substring(ini,fim)));//04 caracteres
                //definir tipo
                ini                         = fim;fim +=1;
                Tipo tipo                   = linhaAux.substring(ini,fim) == "A"? Tipo.AGUA : Tipo.LUZ;//01 caractere
                contrato.setTipo            (tipo);
                ini                         = fim;fim +=8;
                contrato.setValor           (valorConvert(linhaAux.substring(ini,fim)));//08 caracteres
                //chaves estrangeiras
                pessoa.setEndereco          (endereco);
                contrato.setPessoa          (pessoa);
                contratos.add(contrato);
            }
        }catch(Exception e){
            System.out.println("Documento formatado de forma incorreta!\n"+patch);
            e.printStackTrace();
        }        
        return contratos;
    }

    public static Date dataConvert (String data) throws ParseException{
        Date dataConvertida         = null;
        StringBuilder SBdata        = new StringBuilder(data);
        SBdata                      = SBdata.insert(4,"/").insert(7,"/");
        SimpleDateFormat formato    = new SimpleDateFormat("dd/MM/yyyy"); 
        dataConvertida              = formato.parse(SBdata.toString());
        return dataConvertida;
    }

    public static Date hourConvert (String hora) throws ParseException{
        Date horaConvertida         = null;
        StringBuilder SBhora        = new StringBuilder(hora);
        SBhora                      = SBhora.insert(2,":");
        SimpleDateFormat formato    = new SimpleDateFormat("HH:mm"); 
        horaConvertida              = formato.parse(SBhora.toString());
        return horaConvertida;
    }

    public static Double valorConvert (String valor){
        StringBuilder SBvalor       = new StringBuilder(valor);
        SBvalor                     = SBvalor.insert(5,'.');
        return Double.parseDouble(SBvalor.toString());
    }
    public static String cpfConvert (String cpf){
        StringBuilder SBcpf         = new StringBuilder(cpf);
        SBcpf                       = SBcpf.insert(2,'.').insert(5,'.').insert(7,'-');
        return SBcpf.toString();
    }
}
