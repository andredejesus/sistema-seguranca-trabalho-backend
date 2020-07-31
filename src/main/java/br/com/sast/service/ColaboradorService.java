package br.com.sast.service;

import java.time.LocalDate;
import java.util.List;

import br.com.sast.model.Colaborador;

public interface ColaboradorService {

	void salvarColaborador(Colaborador colaborador);
	
	Colaborador buscarColaborador(Short id);
	
	List<Colaborador>buscaColaboradores();
	
	void editarColaborador(Colaborador colaborador);
	
	void deletarColaborador(Short id);
	
	List<Colaborador> filtroColaboradores(String nome, 
										  String rg, 
										  String cpf, 
										  String data_nascimento, 
										  String data_admissao, 
										  String funcao,
										  String departamento,
										  String lotacao,
										  String situacao);
	
}
