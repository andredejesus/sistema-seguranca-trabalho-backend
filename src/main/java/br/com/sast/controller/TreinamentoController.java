package br.com.sast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sast.dto.TreinamentoDTO;
import br.com.sast.model.Treinamento;
import br.com.sast.service.TreinamentoService;

@RestController
@RequestMapping("api")
public class TreinamentoController {

	@Autowired
	private TreinamentoService treinamentoService;
	
	@PostMapping("/treinamento")
	public ResponseEntity<Treinamento> salvaTreinamento(@RequestBody TreinamentoDTO dto){
		
		Treinamento treinamento = treinamentoService.salvaTreinamento(dto);
		
		if(treinamento != null) {
			return new ResponseEntity<Treinamento>(treinamento, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}	
		
	}
	
	@PutMapping("/treinamento/{id}")
	public ResponseEntity<Treinamento> alteraTreinamento(@PathVariable(name = "id") Short id, @RequestBody TreinamentoDTO dto){
		
		Treinamento treinamento = treinamentoService.alteraTreinamento(dto, id);
		
		if(treinamento != null) {
			return new ResponseEntity<Treinamento>(treinamento, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}
		
		
	}
	
	@GetMapping("/treinamento")
	public ResponseEntity<List<Treinamento>> buscaTreinamentos(){
		
		List<Treinamento> treinamentos = treinamentoService.buscaTreinamento();
		
		if(treinamentos.size() > 0) {
			return new ResponseEntity<List<Treinamento>>(treinamentos, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}
		
	}
	
	@DeleteMapping("/treinamento/{id}")
	public ResponseEntity<?> deletaTreinamento(@PathVariable Short id){
		
		String retorno = treinamentoService.deletaTreinamento(id);
		
		if(retorno.equalsIgnoreCase("true")) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}
		
	}
	
}
