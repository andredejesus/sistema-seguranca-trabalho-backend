package br.com.sast.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import br.com.sast.dto.ColaboradorDTO;
import br.com.sast.dto.FiltroColaboradorDTO;
import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;
import br.com.sast.repository.DadosEmpresaRepository;
import br.com.sast.service.ColaboradorService;
import br.com.sast.service.DadosEmpresaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API de colaborador")
@RestController
@RequestMapping("api")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private DadosEmpresaService dadosEmpresaService;
	
	
	@PostMapping("colaboradores")
	@ApiOperation(value="teste")
	public ResponseEntity<Colaborador> salvarColaborador(@RequestBody @Valid Colaborador colaborador) {
		
		Colaborador colaboradorRetornado = colaboradorService.salvarColaborador(colaborador);
		
		return new ResponseEntity<Colaborador>(colaboradorRetornado, HttpStatus.CREATED);
	}
	
	@GetMapping("colaboradores/{id}")
	@ApiOperation(value="teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public Colaborador buscarColaborador(@PathVariable("id") Short id) {
		return colaboradorService.buscarColaborador(id);
	}
	
	@GetMapping("colaboradores")
	@ApiOperation(value="teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Colaborador> buscaColaboradores(){
		return colaboradorService.buscaColaboradores();
	}
	
	@PutMapping("colaboradores")
	@ApiOperation(value="teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public void editarColaborador(@RequestBody @Valid Colaborador colaborador) {
		colaboradorService.editarColaborador(colaborador);
	}
	
	@DeleteMapping("colaboradores/{id}")
	@ApiOperation(value="teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletarColaborador(@PathVariable Short id) {
		colaboradorService.deletarColaborador(id);		
	}

	
	@PostMapping("colaboradores/filtro")
	@ApiOperation(value="teste", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Colaborador> filtroColaborador(@RequestBody FiltroColaboradorDTO filtroColaborador){

	return colaboradorService.filtroColaboradores(filtroColaborador);

	}
	
}
