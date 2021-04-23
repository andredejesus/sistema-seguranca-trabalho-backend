package br.com.sast.repository.extintor;

import java.util.List;

import br.com.sast.dto.ExtintorFiltroDTO;
import br.com.sast.model.Extintor;

public interface ExtintorQuery {
	
	public List<Extintor> filtroExtintor(ExtintorFiltroDTO dto);

}
