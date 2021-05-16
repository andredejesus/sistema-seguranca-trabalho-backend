package br.com.sast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sast.dto.ChecklistDTO;
import br.com.sast.service.ChecklistService;
import br.com.sast.util.Retorno;

@RestController
@RequestMapping("api")
public class ChecklistController {

	@Autowired
	private ChecklistService checklistService;
	
	@PostMapping("/checklist/salvaChecklist")
	public ResponseEntity<?> salvaChecklist(@RequestBody ChecklistDTO checklistDTO){
		
		Retorno retorno = this.checklistService.salvaCabecalhoChecklist(checklistDTO);
		
		if(retorno.isTemErro()) {
			return new ResponseEntity<>(retorno, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(retorno, HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping("checklist/listaCabecalhos")
	public ResponseEntity<?> listaCabecalhos(){
		
		Retorno retorno = this.checklistService.listaCabecalhos();
		
		if(retorno.isTemErro()) {
			return new ResponseEntity<>(retorno, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(retorno, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/checklist/listaChecklists/{idCabecalho}")
	public ResponseEntity<?> listaChecklists(@PathVariable(value = "idCabecalho") Short idCabecalho){
		
		Retorno retorno = this.checklistService.listaChecklists(idCabecalho);
		
		if(retorno.isTemErro()) {
			return new ResponseEntity<>(retorno, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(retorno, HttpStatus.OK);
		}
		
		
	}
	
}
