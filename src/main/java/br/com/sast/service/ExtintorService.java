package br.com.sast.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.model.Extintor;
import br.com.sast.repository.ExtintorRepository;

@Service
public class ExtintorService {

	@Autowired
	private ExtintorRepository extintorRepository;
	
	public Extintor salvaExtintor(Extintor extintor) {
		
		Extintor retornoExtintor =  this.extintorRepository.save(extintor);
		
		return retornoExtintor;
	}
	
	
	public List<Extintor> listaExtintores(){
		return this.extintorRepository.findAll();
	}
	
	
}
