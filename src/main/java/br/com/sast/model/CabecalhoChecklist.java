package br.com.sast.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CabecalhoChecklist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Short id;
	
	@Column
	private String local;
	
	@Column
	private String periodo_inicio;
	
	@Column
	private String periodo_fim;
	
	@Column
	private String equipamento;
	
	@Column
	private String modelo;
	
	@Column
	private String fabricante;
	
	@Column
	private String operador;
	
	@Column
	private String inspetor;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cabecalho_checklist_id")
	private List<Checklist> checklists;
	

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

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}

	
	
	
}
