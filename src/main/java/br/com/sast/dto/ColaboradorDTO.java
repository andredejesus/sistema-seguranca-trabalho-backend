package br.com.sast.dto;

import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;

public class ColaboradorDTO {
	
	private Colaborador colaborador;
	
	private DadosEmpresa dadosEmpresa;

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public DadosEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}

	public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}
	
	
	
}
