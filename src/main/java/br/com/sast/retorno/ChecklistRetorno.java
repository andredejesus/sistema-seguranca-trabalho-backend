package br.com.sast.retorno;

import java.util.List;

import br.com.sast.model.Checklist;
import br.com.sast.dto.ChecklistResponseDTO;
import br.com.sast.model.CabecalhoChecklist;
import br.com.sast.util.Retorno;

public class ChecklistRetorno extends Retorno {
	
	private CabecalhoChecklist cabecalhoChecklist;
	
	private List<CabecalhoChecklist> listaCabecalhos;
	
	private List<Checklist> checklists;
	

	public CabecalhoChecklist getCabecalhoChecklist() {
		return cabecalhoChecklist;
	}

	public void setCabecalhoChecklist(CabecalhoChecklist cabecalhoChecklist) {
		this.cabecalhoChecklist = cabecalhoChecklist;
	}

	public List<CabecalhoChecklist> getListaCabecalhos() {
		return listaCabecalhos;
	}

	public void setListaCabecalhos(List<CabecalhoChecklist> listaCabecalhos) {
		this.listaCabecalhos = listaCabecalhos;
	}

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}


	
	
	
	
	

}
