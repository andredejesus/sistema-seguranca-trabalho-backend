package br.com.sast.repository.colaborador;

import java.util.List;

import br.com.sast.dto.FiltroColaboradorDTO;
import br.com.sast.model.Colaborador;


public interface ColaboradorQuery {
	
	public List<Colaborador> filtroColaborador(FiltroColaboradorDTO filtroColaborador);

}
