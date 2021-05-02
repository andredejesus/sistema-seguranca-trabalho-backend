package br.com.sast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Checklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column
	private String nomeChecklist;
	
	@Column
	private Short idCabecalhoChecklist;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNomeChecklist() {
		return nomeChecklist;
	}

	public void setNomeChecklist(String nomeChecklist) {
		this.nomeChecklist = nomeChecklist;
	}

	public Short getIdCabecalhoChecklist() {
		return idCabecalhoChecklist;
	}

	public void setIdCabecalhoChecklist(Short idCabecalhoChecklist) {
		this.idCabecalhoChecklist = idCabecalhoChecklist;
	}

	
	
	

}
