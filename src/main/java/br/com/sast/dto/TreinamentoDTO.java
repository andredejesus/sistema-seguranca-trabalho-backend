package br.com.sast.dto;

import java.time.LocalDate;

import br.com.sast.model.Treinamento;

public class TreinamentoDTO {
	
	private Short id;
	private Short id_colaborador;
	private String nm_treinamento;
	private LocalDate data_treinamento;
	private Integer dias_vencimento;
	private LocalDate data_vencimento;
	
	public Treinamento converteParaTreinamento() {
		
		Treinamento treinamento = new Treinamento();
		
		treinamento.setNm_treinamento(nm_treinamento);
		treinamento.setData_treinamento(data_treinamento);
		treinamento.setDias_vencimento(dias_vencimento);
		treinamento.setData_vencimento(data_vencimento);
		
		return treinamento;
	}
	
	
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getId_colaborador() {
		return id_colaborador;
	}
	public void setId_colaborador(Short id_colaborador) {
		this.id_colaborador = id_colaborador;
	}
	public String getNm_treinamento() {
		return nm_treinamento;
	}
	public void setNm_treinamento(String nm_treinamento) {
		this.nm_treinamento = nm_treinamento;
	}
	public LocalDate getData_treinamento() {
		return data_treinamento;
	}
	public void setData_treinamento(LocalDate data_treinamento) {
		this.data_treinamento = data_treinamento;
	}
	public Integer getDias_vencimento() {
		return dias_vencimento;
	}
	public void setDias_vencimento(Integer dias_vencimento) {
		this.dias_vencimento = dias_vencimento;
	}
	public LocalDate getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(LocalDate data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	
	

}
