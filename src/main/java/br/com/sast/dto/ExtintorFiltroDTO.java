package br.com.sast.dto;

public class ExtintorFiltroDTO {
	
	private String localizacao;
	private String dataInicioValidade;
	private String dataFimValidade;
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getDataInicioValidade() {
		return dataInicioValidade;
	}
	public void setDataInicioValidade(String dataInicioValidade) {
		this.dataInicioValidade = dataInicioValidade;
	}
	public String getDataFimValidade() {
		return dataFimValidade;
	}
	public void setDataFimValidade(String dataFimValidade) {
		this.dataFimValidade = dataFimValidade;
	}
	
	@Override
	public String toString() {
		return "ExtintorFiltroDTO [localizacao=" + localizacao + ", dataInicioValidade=" + dataInicioValidade
				+ ", dataFimValidade=" + dataFimValidade + "]";
	}
	
	
	
	

}
