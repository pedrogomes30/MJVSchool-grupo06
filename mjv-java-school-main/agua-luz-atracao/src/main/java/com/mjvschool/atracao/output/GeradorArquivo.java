package com.mjvschool.atracao.output;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.util.TextoUtil;

public class GeradorArquivo {
	public void gerarArquivoCsv(List<Contrato> contratos) {
		StringBuilder conteudo =new StringBuilder();
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getCpf().concat(";"));
			conteudo.append(ct.getCadastro().getRg().concat(";"));
			conteudo.append(ct.getCadastro().getNome().concat(";"));
			conteudo.append(ct.getCadastro().getCelular().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getLogradouro().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getNumero().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getComplemento().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getBairro().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getCidade().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getUf().concat(";"));
			conteudo.append(ct.getCadastro().getEndereco().getCep().concat(";"));
			conteudo.append(ct.getNumeroProtocolo());
			conteudo.append(";");
			conteudo.append(ct.getData());
			conteudo.append(";");
			conteudo.append(ct.getHora());
			conteudo.append(";");
			conteudo.append(ct.getServico().getNome());
			conteudo.append(";");
			conteudo.append(ct.getServico().getValor());
			conteudo.append("\n");
		}
		
		System.out.println(conteudo.toString());
		
		File output = new File("C:\\MJVSchool-gtupo06\\agua-luz-output");
		if(!output.exists())
			output.mkdirs(); 		
		Path path = Paths.get("C:\\MJVSchool-gtupo06\\agua-luz-output\\agua-luz-contratos.csv");
		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void gerarArquivoTxt(List<Contrato> contratos) {
		StringBuilder conteudo =new StringBuilder();
		
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getCpf().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.preencher(ct.getCadastro().getRg().replaceAll("\\p{Punct}", ""),10));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getNome(), 30).toUpperCase());	
			conteudo.append(ct.getCadastro().getCelular().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getEndereco().getLogradouro().toUpperCase(),20));
			conteudo.append(String.format("%06d",Integer.parseInt(ct.getCadastro().getEndereco().getNumero())));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getEndereco().getComplemento(), 10));	
			conteudo.append(TextoUtil.preencher(ct.getCadastro().getEndereco().getBairro().toUpperCase(), 15));
			conteudo.append(TextoUtil.preencher(ct.getCadastro().getEndereco().getCidade().toUpperCase(),30));
			conteudo.append(ct.getCadastro().getEndereco().getUf().toUpperCase());
			conteudo.append(ct.getCadastro().getEndereco().getCep().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.converterValorProtocolo(ct.getNumeroProtocolo()));
			conteudo.append(TextoUtil.dataNova(ct.getData()).replaceAll("\\p{Punct}", ""));
			conteudo.append(ct.getHora().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.primeiraLetra(ct.getServico().getNome()));
			conteudo.append(TextoUtil.converterValor(ct.getServico().getValor()));
		}
		
		System.out.println(conteudo.toString());
		
		File output = new File("C:\\MJVSchool-gtupo06\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();
		
		Path path = Paths.get("C:\\MJVSchool-gtupo06\\agua-luz-output\\agua-luz-contratos.txt");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
