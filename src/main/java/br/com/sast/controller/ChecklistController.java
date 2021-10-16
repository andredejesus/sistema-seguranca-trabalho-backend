package br.com.sast.controller;

import java.util.List;

import org.modelmapper.Converters.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import br.com.sast.dto.CabecalhoChecklistDTO;
import br.com.sast.dto.ChecklistDTO;
import br.com.sast.model.CabecalhoChecklist;
import br.com.sast.model.Checklist;
import br.com.sast.service.ChecklistService;
import br.com.sast.util.Retorno;

@RestController
@RequestMapping("api")
public class ChecklistController {

	@Autowired
	private ChecklistService checklistService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/checklist/salvaChecklist")
	public ResponseEntity<?> salvaChecklist(@RequestBody CabecalhoChecklistDTO cabecalhoChecklistDTO){
		
		CabecalhoChecklist cabecalhoChecklistRetorno = this.checklistService.salvaChecklist(modelMapper.map(cabecalhoChecklistDTO, CabecalhoChecklist.class));
		
		if(cabecalhoChecklistRetorno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(modelMapper.map(cabecalhoChecklistRetorno, CabecalhoChecklistDTO.class), HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping("checklist/listaCabecalhos")
	public ResponseEntity<?> listaCabecalhos(){
		
		List<CabecalhoChecklist> listaCabecalhos = this.checklistService.listaCabecalhos();
		
		List<CabecalhoChecklistDTO> listaCabecalhosDTO = listaCabecalhos.stream()
				.map(cabecalho -> modelMapper.map(cabecalho, CabecalhoChecklistDTO.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(listaCabecalhosDTO, HttpStatus.OK);
		
	}
	
	@GetMapping("/checklist/listaChecklists/{idCabecalho}")
	public ResponseEntity<List<ChecklistDTO>> listaChecklists(@PathVariable(value = "idCabecalho") Short idCabecalho){
		
		List<Checklist> listaChecklists = this.checklistService.listaChecklists(idCabecalho);
		
		List<ChecklistDTO> listaChecklistsDTO = listaChecklists.stream()
				.map(checklist -> modelMapper.map(checklist, ChecklistDTO.class)).collect(Collectors.toList());
		
	
		return new ResponseEntity<>(listaChecklistsDTO, HttpStatus.OK);

		
		
	}
	
}
