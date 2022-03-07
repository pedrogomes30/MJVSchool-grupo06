package com.mjvschool.atracao.util;

public class TextoUtil {
	public static String preencher(String textoOriginal, int tamanhoMaximo) {
		String formato = "%-" + tamanhoMaximo + "s";
		String novaString = String.format(formato, textoOriginal);
		return novaString;
	}
	public static String cortar(String textoOriginal, int tamanhoMaximo) {
		String  novaString = textoOriginal.substring(0, Math.min(tamanhoMaximo, textoOriginal.length()));
		return novaString;
	}
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}
	public static String converterValor(Double valor){
		double valor1 = valor;
		String str = String.valueOf(valor1);
		str = str.replaceAll("\\D+","");
		str =  "000"+ str ;
		return str;
	}
	public static String converterValorProtocolo(long valor){
		long valor1 = valor;
		String str = String.valueOf(valor1);
		str = str.replaceAll("\\D+","");
		str =  "000"+ str ;
		return str;
	}
	public static char primeiraLetra(String nome){
		char inicial = nome.charAt(0);
		return inicial;
	}
	public static String dataNova(String data){
		String[] s = data.split("/"); 
		String novaData = s[2]+"/"+s[1]+"/"+s[0];
		return novaData;
	}
	
}
