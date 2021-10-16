package br.com.sast.dto;

import java.util.List;

public class CabecalhoChecklistDTO {
	
	private Short id;
	private String local;
	private String periodo_inicio;
	private String periodo_fim;
	private String equipamento;
	private String modelo;
	private String fabricante;
	private String operador;
	private String inspetor;
	
	private List<ChecklistDTO> checklists;
	
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getPeriodo_inicio() {
		return periodo_inicio;
	}
	public void setPeriodo_inicio(String periodo_inicio) {
		this.periodo_inicio = periodo_inicio;
	}
	public String getPeriodo_fim() {
		return periodo_fim;
	}
	public void setPeriodo_fim(String periodo_fim) {
		this.periodo_fim = periodo_fim;
	}
	public String getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getInspetor() {
		return inspetor;
	}
	public void setInspetor(String inspetor) {
		this.inspetor = inspetor;
	}
	public List<ChecklistDTO> getChecklists() {
		return checklists;
	}
	public void setChecklists(List<ChecklistDTO> checklists) {
		this.checklists = checklists;
	}
	
	
	
	
	
	

}
