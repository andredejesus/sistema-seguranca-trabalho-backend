package br.com.sast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.dto.AsoFiltroDTO;
import br.com.sast.model.Aso;
import br.com.sast.repository.AsoRepository;

@Service
public class AsoServiceImpl implements AsoService{
	
	@Autowired
	private AsoRepository ar;

	@Override
	public Aso salvaAso(Aso aso) {
		Aso asoRetornado =  ar.save(aso);
		return  asoRetornado;
	}

	@Override
	public List<Aso> listaAsos() {
		return ar.findAll();
	}

	@Override
	public Aso alteraAso(Aso aso) {
		Aso asoRetornado = ar.save(aso);
		return asoRetornado;
	}

	@Override
	public void deletaAso(Short id) {
		ar.deleteById(id);
	}

	@Override
	public Aso buscaAsoPorId(Short id) {
		Aso asoRetornado = ar.buscaAsoPorId(id);
		return asoRetornado;
	}

	@Override
	public List<Aso> filtroAso(AsoFiltroDTO asoDto) {
		return ar.filtroAso(asoDto);
	}
	
	

}
