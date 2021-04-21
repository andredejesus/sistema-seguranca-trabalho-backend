package br.com.sast.service;

import java.util.List;

import org.hibernate.loader.plan.build.spi.ReturnGraphTreePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.dto.TreinamentoDTO;
import br.com.sast.dto.TreinamentoFiltroDTO;
import br.com.sast.model.Colaborador;
import br.com.sast.model.Treinamento;
import br.com.sast.repository.ColaboradorRepository;
import br.com.sast.repository.TreinamentoRepository;

@Service
public class TreinamentoService {

	@Autowired
	private TreinamentoRepository treinamentoRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public Treinamento salvaTreinamento(TreinamentoDTO dto) {
		
		Colaborador colaborador = colaboradorRepository.findById(dto.getId_colaborador()).get();
		
		Treinamento treinamento = new Treinamento();
		treinamento = dto.converteParaTreinamento();//Pega o que veio do JSON e converte para o tipo treinamento
		treinamento.setColaborador(colaborador);
		
		treinamento = treinamentoRepository.save(treinamento);

		return treinamento;
	}
	
	public Treinamento alteraTreinamento(TreinamentoDTO dto, Short id) {
		
		Treinamento treinamento = treinamentoRepository.findById(id).get();
		
			Colaborador colaborador = colaboradorRepository.findById(dto.getId_colaborador()).get();
			treinamento = dto.converteParaTreinamento();
			treinamento.setId(id);
			treinamento.setColaborador(colaborador);
			treinamento = treinamentoRepository.save(treinamento);
			
			return treinamento;
		
	}
	
	
	public List<Treinamento> buscaTreinamento(){
		return treinamentoRepository.findAll();
	}
	
	public String deletaTreinamento(Short id) {
		
		if(treinamentoRepository.existsById(id)) {
			treinamentoRepository.deleteById(id);
			return "true";
		}else {
			return "false";
		}
		
	}
	
	public Treinamento buscaTreinamentoPorId(Short id) {
		
		return treinamentoRepository.findById(id).get();
		
	}
	
	public List<Treinamento> filtroTreinamento(TreinamentoFiltroDTO dto){
		return treinamentoRepository.filtroTreinamento(dto);
	}
	
}
