package br.com.sast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.dto.ChecklistDTO;
import br.com.sast.dto.ChecklistResponseDTO;
import br.com.sast.model.CabecalhoChecklist;
import br.com.sast.model.Checklist;
import br.com.sast.repository.ChecklistRepository;
import br.com.sast.repository.DadosChecklistRepository;
import br.com.sast.retorno.ChecklistRetorno;
import br.com.sast.util.Retorno;

@Service
public class ChecklistService {

	@Autowired
	private DadosChecklistRepository cabecalhoChecklistRepository;
	
	@Autowired
	private ChecklistRepository checklistRepository;
	
	public Retorno salvaCabecalhoChecklist(ChecklistDTO checklistDTO) {
		
		Retorno retorno = new Retorno();
		List<String> msgs = new ArrayList<>();

		try {
			
			List<Checklist> checklists = checklistDTO.getChecklists();
			Short idCabecalhoChecklist = this.cabecalhoChecklistRepository.save(checklistDTO.getCabecalhoChecklist()).getId();
			
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
	
	public ChecklistRetorno listaCabecalhos() {
		
		ChecklistRetorno retorno = new ChecklistRetorno();
		List<String> msgs = new ArrayList<>();
		
		
		try {
			
			List<CabecalhoChecklist> listaCabecalhos = this.cabecalhoChecklistRepository.findAll();
			
			retorno.setListaCabecalhos(listaCabecalhos);
			retorno.setTemErro(false);
			
		} catch (Exception e) {
			retorno.setTemErro(true);
			msgs.add("Erro ao listar todos os cabeçalhos.");
			retorno.setMsgsErro(msgs);
			e.printStackTrace();
		}
	
		return retorno;
		
	}
	
	public ChecklistRetorno listaChecklists(Short idCabecalho) {
		
		ChecklistRetorno retorno = new ChecklistRetorno();
		List<String> msgs = new ArrayList<>();
		
		try {
			
			List<Checklist> listaChecklists = this.checklistRepository.findAllByIdCabecalhoChecklist(idCabecalho);
			retorno.setChecklists(listaChecklists);
			retorno.setTemErro(false);
			
		} catch (Exception e) {
			retorno.setTemErro(true);
			msgs.add("Erro ao listar todos os checklists.");
			retorno.setMsgsErro(msgs);
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	/*public ChecklistRetorno listaChecklists() {
	
		
		ChecklistRetorno retorno = new ChecklistRetorno();
		List<String> msgs = new ArrayList<>();
		
		
		try {
			
			List<ChecklistResponseDTO> listaResponse = new ArrayList<>();
			List<CabecalhoChecklist> listaCabecalhos = this.cabecalhoChecklistRepository.findAll();
			
			listaCabecalhos.forEach(cabecalho ->{
				
				ChecklistResponseDTO checklistResponse = new ChecklistResponseDTO();
				
				checklistResponse.setCabecalhoChecklist(cabecalho);
				
				List<Checklist> checklists = this.checklistRepository.findByIdCabecalhoChecklist(cabecalho.getId());
				checklistResponse.setChecklists(checklists);
				
				listaResponse.add(checklistResponse);
				
			});
			
			
			retorno.setChecklistResponse(listaResponse);
			retorno.setTemErro(false);
		} catch (Exception e) {
			retorno.setTemErro(true);
			msgs.add("Erro ao listar todos os checklists.");
			retorno.setMsgsErro(msgs);
			e.printStackTrace();
		}
	
		return retorno;
		
	}*/
	
}
