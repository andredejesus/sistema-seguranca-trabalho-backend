package br.com.sast.repository.aso;

import java.util.List;

import br.com.sast.dto.AsoFiltroDTO;
import br.com.sast.model.Aso;

public interface AsoQuery {
	
	public List<Aso> filtroAso(AsoFiltroDTO asoDto);

}
