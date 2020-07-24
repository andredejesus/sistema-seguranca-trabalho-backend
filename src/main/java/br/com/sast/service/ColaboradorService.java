package br.com.sast.service;

import java.util.List;

import br.com.sast.model.Colaborador;

public interface ColaboradorService {

	void salvarColaborador(Colaborador colaborador);
	
	Colaborador buscarColaborador(Short id);
	
	List<Colaborador>buscaColaboradores();
	
	void editarColaborador(Colaborador colaborador);
	
	void deletarColaborador(Short id);
	
}
