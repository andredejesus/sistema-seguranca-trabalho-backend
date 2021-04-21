package br.com.sast.dto;

public class TreinamentoFiltroDTO {
	
	private String dataInicioTreinamento;
	private String dataFimTreinamento;
	private String nomeTreinamento;
	private String nomeColaborador;
	
	
	public String getDataInicioTreinamento() {
		return dataInicioTreinamento;
	}
	public void setDataInicioTreinamento(String dataInicioTreinamento) {
		this.dataInicioTreinamento = dataInicioTreinamento;
	}
	public String getDataFimTreinamento() {
		return dataFimTreinamento;
	}
	public void setDataFimTreinamento(String dataFimTreinamento) {
		this.dataFimTreinamento = dataFimTreinamento;
	}
	public String getNomeTreinamento() {
		return nomeTreinamento;
	}
	public void setNomeTreinamento(String nomeTreinamento) {
		this.nomeTreinamento = nomeTreinamento;
	}
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
	
	@Override
	public String toString() {
		return "TreinamentoFiltroDTO [dataInicioTreinamento=" + dataInicioTreinamento + ", dataFimTreinamento="
				+ dataFimTreinamento + ", nomeTreinamento=" + nomeTreinamento + ", nomeColaborador=" + nomeColaborador
				+ "]";
	}
	
	
	
	
	

}
