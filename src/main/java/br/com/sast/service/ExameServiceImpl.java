package br.com.sast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.model.Exames;
import br.com.sast.repository.ExamesRepository;

@Service
public class ExameServiceImpl implements ExameService {
	
	@Autowired
	private ExamesRepository er;

	@Override
	public void salvaExame(Exames exame) {
		er.save(exame);
	}

	@Override
	public List<Exames> listaExames() {
		return er.findAll();
	}

	@Override
	public List<Exames> buscaExamesPorAso(Short id_aso) {
		return er.buscaExamesPorAso(id_aso);
	}

	@Override
	public Exames alteraExame(Exames exame) {
		return er.save(exame);
	}


}
