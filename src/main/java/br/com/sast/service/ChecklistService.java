package br.com.sast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.model.CabecalhoChecklist;
import br.com.sast.model.Checklist;
import br.com.sast.repository.ChecklistRepository;
import br.com.sast.repository.DadosChecklistRepository;
import br.com.sast.retorno.ChecklistRetorno;

@Service
public class ChecklistService {

	@Autowired
	private DadosChecklistRepository cabecalhoChecklistRepository;
	
	@Autowired
	private ChecklistRepository checklistRepository;
	
	public CabecalhoChecklist salvaChecklist(CabecalhoChecklist cabecalhoChecklist) {

		try {
			
			CabecalhoChecklist cabecalhoChecklistRetorno = this.cabecalhoChecklistRepository.save(cabecalhoChecklist);
			return cabecalhoChecklistRetorno;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
//	public Retorno salvaChecklist(Short idCabecalho, List<Checklist> checklists) {
//	
//		Retorno retorno = new Retorno();
//		
//		List<String> msgs = new ArrayList<>();
//		
//		try {
//			
//			if(idCabecalho != null) {	
//				
//				for(Checklist item : checklists) {
//					item.setIdCabecalhoChecklist(idCabecalho);
//					this.checklistRepository.save(item);
//				}
//				
//				retorno.setTemErro(false);
//					
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			retorno.setTemErro(true);
//			msgs.add("Ocorreu um erro ao salvar o checklist.");
//			retorno.setMsgsErro(msgs);
//		}
//		
//		return retorno;
//	}
	
	public List<CabecalhoChecklist> listaCabecalhos() {

		try {
			
			List<CabecalhoChecklist> listaCabecalhos = this.cabecalhoChecklistRepository.findAll();
			return listaCabecalhos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
		
	}
	
	public List<Checklist> listaChecklists(Short idCabecalho) {
		
		try {
			
			List<Checklist> listaChecklists = this.checklistRepository.getChecklistPorIdCabecalho(idCabecalho);
			return listaChecklists;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	


	
}
