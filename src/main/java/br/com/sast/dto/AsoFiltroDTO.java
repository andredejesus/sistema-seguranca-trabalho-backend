package br.com.sast.dto;

public class AsoFiltroDTO {
	
	private String colaborador;
	private String tipoAso;
	private String dataInicioEmissao;
	private String dataFimEmissao;
	
	
	public String getColaborador() {
		return colaborador;
	}
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
	public String getTipoAso() {
		return tipoAso;
	}
	public void setTipoAso(String tipoAso) {
		this.tipoAso = tipoAso;
	}
	public String getDataInicioEmissao() {
		return dataInicioEmissao;
	}
	public void setDataInicioEmissao(String dataInicioEmissao) {
		this.dataInicioEmissao = dataInicioEmissao;
	}
	public String getDataFimEmissao() {
		return dataFimEmissao;
	}
	public void setDataFimEmissao(String dataFimEmissao) {
		this.dataFimEmissao = dataFimEmissao;
	}
	
	@Override
	public String toString() {
		return "AsoFiltroDTO [colaborador=" + colaborador + ", tipoAso=" + tipoAso + ", dataInicioEmissao="
				+ dataInicioEmissao + ", dataFimEmissao=" + dataFimEmissao + "]";
	}
	
	
	
	
	
	
	
	

}
