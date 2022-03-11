package com.mjv.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	private static Connection conexao;
	public static void abrirConexao() throws Exception {
		
		if(conexao==null) {
			//Class.forName("org.mysql.Driver"); 
			String url="jdbc:mySql://localhost:3306/mjv_school";
			String user = "root";
			String pass = "grupo06school";
			conexao = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexao realizada com sucesso");
		}
	}
	public static Connection getConexao() {
		return conexao;
	}
	public static void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
