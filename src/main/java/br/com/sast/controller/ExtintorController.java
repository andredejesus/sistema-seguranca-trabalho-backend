package br.com.sast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
