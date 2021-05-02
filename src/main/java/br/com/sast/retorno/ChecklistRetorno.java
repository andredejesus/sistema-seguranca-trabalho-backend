package br.com.sast.retorno;

import java.util.List;

import br.com.sast.model.Checklist;
import br.com.sast.model.DadosChecklist;
import br.com.sast.util.Retorno;

public class ChecklistRetorno extends Retorno {
	
	private DadosChecklist dadosChecklist;
	
	private List<Checklist> checklists;

	public DadosChecklist getDadosChecklist() {
		return dadosChecklist;
	}

	public void setDadosChecklist(DadosChecklist dadosChecklist) {
		this.dadosChecklist = dadosChecklist;
	}

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}
	
	
	
	

}
