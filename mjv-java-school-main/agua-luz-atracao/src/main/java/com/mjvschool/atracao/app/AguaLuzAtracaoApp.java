package com.mjvschool.atracao.app;

import java.util.Date;
import java.util.List;

import com.mjvschool.atracao.model.cadastro.Endereco;
import com.mjvschool.atracao.model.cadastro.Pais;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;
import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.output.GeradorArquivo;
import com.mjvschool.atracao.repository.ContratoRepository;

public class AguaLuzAtracaoApp {
	private static ContratoRepository contratoRepositorio = new ContratoRepository();
	public static void main(String[] args) {
		faseAtracao();
		faseGeracaoArquivo();
	}
	private static void faseGeracaoArquivo() {
		List<Contrato> contratos =  contratoRepositorio.listarTodos();
		GeradorArquivo gerador = new GeradorArquivo();
		gerador.gerarArquivoCsv(contratos);
		gerador.gerarArquivoTxt(contratos);
		
	}
	private static void faseAtracao() {
		Contrato contrato1 = new Contrato();
		contrato1.setNumeroProtocolo(123);
		contrato1.setServico(Servico.LUZ);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("56737284094");
		pessoa.setNome("Gleyson Sampaio de Oliveira");
		pessoa.setRg("89789");
		pessoa.setPais(Pais.BRASIL);
		
		pessoa.setCelular("98965498760");
		
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Santo Antonio");
		endereco.setCep("27310657");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setLogradouro("Rua das Cajazeiras 26");
		endereco.setNumero("243");
		pessoa.setEndereco(endereco);
		contrato1.setCadastro(pessoa);
		contrato1.setDataHora(new Date());
		
		contratoRepositorio.gravar(contrato1);
		
		Contrato contrato2 = new Contrato();
		contrato2.setNumeroProtocolo(78678);
		contrato2.setServico(Servico.AGUA);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCpf("11094986089");
		pessoa2.setNome("Raimundo Nonato Loureiro Castelo Branco");
		pessoa2.setRg("98908");
		pessoa2.setPais(Pais.ESTADOS_UNIDOS);
		
		pessoa2.setCelular("11976349678");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Santo Antonio");
		endereco2.setCep("27310657");
		endereco2.setCidade("São Paulo");
		endereco2.setEstado("SP");
		endereco2.setLogradouro("Rua das Marias");
		endereco2.setNumero("243");
		pessoa2.setEndereco(endereco2);
		contrato2.setCadastro(pessoa2);
		contrato2.setDataHora(new Date());
		
		contratoRepositorio.gravar(contrato2);
	}
}
