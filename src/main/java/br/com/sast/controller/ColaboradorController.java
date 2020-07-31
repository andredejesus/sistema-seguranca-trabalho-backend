package br.com.sast.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
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

import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;
import br.com.sast.service.ColaboradorService;

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

	
	@GetMapping("colaboradores/filtro")
	public List<Colaborador> filtroColaborador(@PathParam("nome") String nome, 
											   @PathParam("rg") String rg, 
											   @PathParam("cpf") String cpf,
											   @PathParam("data_nascimento") String data_nascimento,
											   @PathParam("data_admissao") String data_admissao,
											   @PathParam("funcao") String funcao,
											   @PathParam("departamento") String departamento,
											   @PathParam("lotacao") String lotacao,
											   @PathParam("situacao") String situacao){
		

		
	return colaboradorService.filtroColaboradores(nome, 
			  rg, 
			  cpf, 
			  data_nascimento,
			  data_admissao,
			  funcao,
			  departamento,
			  lotacao,
			  situacao);

	}
	
}
