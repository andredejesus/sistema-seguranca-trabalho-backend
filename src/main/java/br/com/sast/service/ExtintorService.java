package br.com.sast.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.dto.ExtintorFiltroDTO;
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
	
	public Extintor alteraExtintor(Short id, Extintor extintor) {
		
		extintor.setId(id);
		
		Extintor extintorRetorno = this.extintorRepository.save(extintor);
		
		return extintorRetorno;
		
	}
	
	public void deletaExtintor(Short id) {
		
	 this.extintorRepository.deleteById(id);
		
	}
	
	public Extintor buscaExtintorPorId(Short id) {
		return this.extintorRepository.findById(id).get();
	}
	
	public List<Extintor> filtroExtintor(ExtintorFiltroDTO dto){
		return this.extintorRepository.filtroExtintor(dto);
	}
	
	
}
