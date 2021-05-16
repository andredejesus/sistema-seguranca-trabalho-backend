package br.com.sast.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.sast.model.CabecalhoChecklist;
import br.com.sast.model.Checklist;

public class ChecklistResponseDTO {
	
	private CabecalhoChecklist cabecalhoChecklist;
	
	private List<Checklist> checklists;

	public CabecalhoChecklist getCabecalhoChecklist() {
		return cabecalhoChecklist;
	}

	public void setCabecalhoChecklist(CabecalhoChecklist cabecalhoChecklist) {
		this.cabecalhoChecklist = cabecalhoChecklist;
	}

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}
	
	

}
