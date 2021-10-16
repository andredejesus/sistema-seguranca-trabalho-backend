package br.com.sast.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ChecklistDTO {
	
	private Short id;
	private String nomeChecklist;

	
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

	

}
