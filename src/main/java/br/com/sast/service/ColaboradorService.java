package br.com.sast.service;

import java.time.LocalDate;
import java.util.List;

import br.com.sast.dto.FiltroColaboradorDTO;
import br.com.sast.model.Colaborador;

public interface ColaboradorService {

	Colaborador salvarColaborador(Colaborador colaborador);
	
	Colaborador buscarColaborador(Short id);
	
	List<Colaborador>buscaColaboradores();
	
	void editarColaborador(Colaborador colaborador);
	
	void deletarColaborador(Short id);
	
	List<Colaborador> filtroColaboradores(FiltroColaboradorDTO filtroColaborador);
	
}
