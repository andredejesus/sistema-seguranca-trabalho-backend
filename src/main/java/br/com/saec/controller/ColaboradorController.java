package br.com.saec.controller;

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

import br.com.saec.model.Colaborador;
import br.com.saec.model.DadosEmpresa;
import br.com.saec.service.ColaboradorService;

@RestController
@RequestMapping("api")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@PostMapping("colaborador")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarColaborador(@RequestBody @Valid Colaborador colaborador) {
		colaboradorService.salvarColaborador(colaborador);
	}
	
	@GetMapping("colaborador/{id}")
	public Colaborador buscarColaborador(@PathVariable("id") Short id) {
		return colaboradorService.buscarColaborador(id);
	}
	
	@GetMapping("colaboradores")
	public List<Colaborador> buscaColaboradores(){
		return colaboradorService.buscaColaboradores();
	}
	
	@PutMapping("colaborador")
	public void editarColaborador(@RequestBody @Valid Colaborador colaborador) {
		colaboradorService.editarColaborador(colaborador);
	}
	
	@DeleteMapping("colaborador/{id}")
	public void deletarColaborador(@PathVariable Short id) {
		colaboradorService.deletarColaborador(id);		
	}

}
