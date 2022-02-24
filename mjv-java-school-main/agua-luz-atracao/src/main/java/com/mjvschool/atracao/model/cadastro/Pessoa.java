package com.mjvschool.atracao.model.cadastro;

public class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	private String celular;
	private Endereco endereco;
	private Pais pais;
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Pais getPais() {
		return pais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
