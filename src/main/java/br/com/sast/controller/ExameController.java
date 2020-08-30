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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sast.model.Exames;
import br.com.sast.service.ExameService;

@RestController
@RequestMapping("api")
public class ExameController {
	
	@Autowired
	private ExameService exameService;
	
	@PostMapping("exame")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvaExame(@RequestBody @Valid Exames exame) {
		exameService.salvaExame(exame);
	}
	
	@GetMapping("exame/{id_aso}")
	@ResponseStatus(HttpStatus.OK)
	public List<Exames> buscaExamesPorAso(@PathVariable("id_aso") Short id_aso){
		return exameService.buscaExamesPorAso(id_aso);
	}
	
	@PutMapping("exame")
	public Exames alteraExames(@RequestBody @Valid Exames exame) {
		return exameService.alteraExame(exame);
	}
	
	@DeleteMapping("exame/{id}")
	public void deletaExame(@PathVariable("id") Short id) {
		exameService.deletaExame(id);
	}
	
	//@DeleteMapping("exame/{id_aso}")
	//public void deletaExamePorIdAso(@PathVariable("id_aso") Short id_aso) {
		//exameService.deletaExamePorIdAso(id_aso);
	//}

}
