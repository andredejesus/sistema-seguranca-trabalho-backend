package br.com.sast.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import br.com.sast.dto.ExtintorFiltroDTO;
import br.com.sast.model.Extintor;
import br.com.sast.service.ExtintorService;

@RestController
@RequestMapping("/api")
public class ExtintorController {

	@Autowired
	private ExtintorService extintorService;
	
	@PostMapping("/extintor")
	public ResponseEntity<?> salvaExtintor(@RequestBody Extintor extintor){
		
		Extintor extintorRetorno = this.extintorService.salvaExtintor(extintor);
		
		if(extintorRetorno == null) {
			return new ResponseEntity<Extintor>(HttpStatus.valueOf(400));
		}
		
		return new ResponseEntity<Extintor>(extintorRetorno, HttpStatus.CREATED);
	}
	
	@GetMapping("/extintor")
	public ResponseEntity<?> listaExtintores(){
		
		List<Extintor> extintores = this.extintorService.listaExtintores();
		
		if(extintores.isEmpty()) {
			return new ResponseEntity<List<Extintor>>(HttpStatus.valueOf(400));
		}
		
		return new ResponseEntity<List<Extintor>>(extintores, HttpStatus.OK);
	}
	
	@PutMapping("extintor/{id}")
	public ResponseEntity<?> alteraExtintor(@PathVariable(name = "id") Short id, @RequestBody Extintor extintor){
		
		
		Extintor extintorRetorno = this.extintorService.alteraExtintor(id, extintor);
		
		if(extintorRetorno == null) {
			return new ResponseEntity<Extintor>(HttpStatus.valueOf(400));
		}
		
		return new ResponseEntity<Extintor>(extintorRetorno, HttpStatus.OK);
	}
	
	
	@DeleteMapping("extintor/{id}")
	public ResponseEntity<?> deletaExtintor(@PathVariable(name="id") Short id){
		
		this.extintorService.deletaExtintor(id);
	
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("extintor/{id}")
	public ResponseEntity<?> buscaExtintorPorId(@PathVariable(name = "id") Short id){
		
		Extintor extintor = this.extintorService.buscaExtintorPorId(id);
		
		if(extintor == null) {
			return new ResponseEntity<Extintor>(HttpStatus.valueOf(400));
		}
		
		return new ResponseEntity<Extintor>(extintor, HttpStatus.OK);
	}
	
	@PostMapping("extintor/filtro")
	public ResponseEntity<?> filtroExtintor(@RequestBody ExtintorFiltroDTO dto){
		
		List<Extintor> extintoresRetorno = this.extintorService.filtroExtintor(dto);
		
		if(extintoresRetorno == null) {
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}
		
		return new ResponseEntity<List<Extintor>>(extintoresRetorno, HttpStatus.OK);
	}
	
	@GetMapping("extintor/exportar-csv")
	public ResponseEntity<?> exportarCSV(HttpServletResponse response){
		
		this.extintorService.exportarCSV(response);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
