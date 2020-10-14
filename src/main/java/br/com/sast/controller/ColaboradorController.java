package br.com.sast.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sast.dto.FiltroColaboradorDTO;
import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;
import br.com.sast.service.ColaboradorService;

@RestController
@RequestMapping("api")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@PostMapping("colaboradores")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarColaborador(@RequestBody @Valid Colaborador colaborador) {
		colaboradorService.salvarColaborador(colaborador);
	}
	
	@GetMapping("colaboradores/{id}")
	public Colaborador buscarColaborador(@PathVariable("id") Short id) {
		return colaboradorService.buscarColaborador(id);
	}
	
	@GetMapping("colaboradores")
	public List<Colaborador> buscaColaboradores(){
		return colaboradorService.buscaColaboradores();
	}
	
	@PutMapping("colaboradores")
	public void editarColaborador(@RequestBody @Valid Colaborador colaborador) {
		colaboradorService.editarColaborador(colaborador);
	}
	
	@DeleteMapping("colaboradores/{id}")
	public void deletarColaborador(@PathVariable Short id) {
		colaboradorService.deletarColaborador(id);		
	}

	
	@GetMapping("colaboradores/filtro")
	public List<Colaborador> filtroColaborador(@RequestBody FiltroColaboradorDTO filtroColaborador){

	return colaboradorService.filtroColaboradores(filtroColaborador);

	}
	
}
