package br.com.sast.service;

import java.util.List;

import br.com.sast.model.Aso;

public interface AsoService {
	
	Aso salvaAso(Aso aso);
	
	List<Aso> listaAsos();
	
	Aso alteraAso(Aso aso);
	
	void deletaAso(Short id);
	
	Aso buscaAsoPorId(Short id);

}
