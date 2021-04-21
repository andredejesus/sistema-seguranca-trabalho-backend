package br.com.sast.repository.treinamento;

import java.util.List;

import br.com.sast.dto.TreinamentoFiltroDTO;
import br.com.sast.model.Treinamento;

public interface TreinamentoQuery {

	public List<Treinamento> filtroTreinamento(TreinamentoFiltroDTO treinamentoDto);
	
}
