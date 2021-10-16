package br.com.sast.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Checklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column
	private String nomeChecklist;
	
	@ManyToOne
	private CabecalhoChecklist cabecalhoChecklist;

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

	public CabecalhoChecklist getCabecalhoChecklist() {
		return cabecalhoChecklist;
	}

	public void setCabecalhoChecklist(CabecalhoChecklist cabecalhoChecklist) {
		this.cabecalhoChecklist = cabecalhoChecklist;
	}

	

	

	
	
	

}
