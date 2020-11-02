package br.com.sast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sast.model.DadosEmpresa;
import br.com.sast.repository.DadosEmpresaRepository;

@Service
public class DadosEmpresaServiceImpl implements DadosEmpresaService {
	
	@Autowired
	private DadosEmpresaRepository dadosEmpresaRepository;

	@Override
	public DadosEmpresa salvaDadosEmpresa(DadosEmpresa dadosEmpresa) {
		
		DadosEmpresa empresa = dadosEmpresaRepository.save(dadosEmpresa);
		
		return empresa;
	}

}
