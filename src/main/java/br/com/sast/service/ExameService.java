package br.com.sast.service;

import java.util.List;

import br.com.sast.model.Exames;

public interface ExameService {
	
	void salvaExame(Exames exame);
	
	List<Exames> listaExames();
	
	List<Exames> buscaExamesPorAso(Short id_aso);
	
	Exames alteraExame(Exames exame);
	
	void deletaExame(Short id);
	
	void deletaExamePorIdAso(Short id_aso);

}
