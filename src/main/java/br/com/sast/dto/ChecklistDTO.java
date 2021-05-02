package br.com.sast.dto;

import java.util.List;

import br.com.sast.model.Checklist;
import br.com.sast.model.DadosChecklist;

public class ChecklistDTO {
	
	private DadosChecklist cabecalhoChecklist;
	private List<Checklist> checklists;
	
	
	public DadosChecklist getCabecalhoChecklist() {
		return cabecalhoChecklist;
	}
	public void setCabecalhoChecklist(DadosChecklist cabecalhoChecklist) {
		this.cabecalhoChecklist = cabecalhoChecklist;
	}
	public List<Checklist> getChecklists() {
		return checklists;
	}
	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}
	
	

}
