package br.com.sast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.dto.ChecklistDTO;
import br.com.sast.model.Checklist;
import br.com.sast.repository.ChecklistRepository;
import br.com.sast.repository.DadosChecklistRepository;
import br.com.sast.retorno.ChecklistRetorno;
import br.com.sast.util.Retorno;

@Service
public class ChecklistService {

	@Autowired
	private DadosChecklistRepository dadosChecklistRepository;
	
	@Autowired
	private ChecklistRepository checklistRepository;
	
	public Retorno salvaCabecalhoChecklist(ChecklistDTO checklistDTO) {
		
		Retorno retorno = new Retorno();
		List<String> msgs = new ArrayList<>();

		try {
			
			List<Checklist> checklists = checklistDTO.getChecklists();
			Short idCabecalhoChecklist = this.dadosChecklistRepository.save(checklistDTO.getCabecalhoChecklist()).getId();
			
			if(idCabecalhoChecklist != null && !checklists.isEmpty()) {
				this.salvaChecklist(idCabecalhoChecklist, checklists);
			}
			
			retorno.setTemErro(false);

		} catch (Exception e) {
			e.printStackTrace();
			retorno.setTemErro(true);
			msgs.add("Ocorreu um erro ao salvar o cabeçalho do checklist.");
			retorno.setMsgsErro(msgs);
		}
		
		return retorno;
		
	}
	
	public Retorno salvaChecklist(Short idCabecalho, List<Checklist> checklists) {
	
		Retorno retorno = new Retorno();
		
		List<String> msgs = new ArrayList<>();
		
		try {
			
			if(idCabecalho != null) {	
				
				for(Checklist item : checklists) {
					item.setIdCabecalhoChecklist(idCabecalho);
					this.checklistRepository.save(item);
				}
				
				retorno.setTemErro(false);
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setTemErro(true);
			msgs.add("Ocorreu um erro ao salvar o checklist.");
			retorno.setMsgsErro(msgs);
		}
		
		return retorno;
	}
	
}
