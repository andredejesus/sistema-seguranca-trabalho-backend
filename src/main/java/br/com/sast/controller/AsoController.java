package br.com.sast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sast.model.Aso;
import br.com.sast.service.AsoService;

@RestController
@RequestMapping("api")
public class AsoController {
	
	@Autowired
	private AsoService as;
	
	@PostMapping("/aso")
	@ResponseStatus(HttpStatus.CREATED)
	public Aso salvaAso(@RequestBody @Valid Aso aso){
		Aso asoRetornado = as.salvaAso(aso);
		return asoRetornado;
	}
	
	@GetMapping("/aso")
	@ResponseStatus(HttpStatus.OK)
	public List<Aso> listaAsos(){
		return as.listaAsos();
	}
	
	@PutMapping("/aso")
	@ResponseStatus(HttpStatus.OK)
	public Aso alteraAso(@RequestBody @Valid Aso aso) {
		return as.alteraAso(aso);
	}
	
	@DeleteMapping("/aso/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaAso(@PathVariable("id") Short id) {
		as.deletaAso(id);
	}
	
	@GetMapping("/aso/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Aso buscaAsoPorId(@PathVariable("id") Short id) {
		return as.buscaAsoPorId(id);
	}

	
	

}
