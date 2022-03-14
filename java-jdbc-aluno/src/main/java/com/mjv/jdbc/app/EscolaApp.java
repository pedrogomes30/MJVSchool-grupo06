package com.mjv.jdbc.app;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.repository.AlunoRepository;
import com.mjv.jdbc.util.FabricaConexao;

public class EscolaApp {
	public static void main(String[] args) {
		try {
			Aluno alunos = new Aluno();
			alunos.setAltura(1.70);
			alunos.setAtivo(true);
			alunos.setNome("Aluno MJV");
			alunos.setSexo("F");
			
			
			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.gravar(alunos);
			//alunoRepository.update(alunos);
			//alunoRepository.delete(alunos);
			//alunoRepository.read(alunos);
			
			FabricaConexao.fecharConexao();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
