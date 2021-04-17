package br.com.sast.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;


@SpringBootTest
public class ColaboradorServiceTest {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	
	@Test
	@Disabled
	public void verificaSeColaboradorFoiSalvoTest() {
		
		Colaborador colaboradorEsperado = new Colaborador();
		colaboradorEsperado.setNome("Marcos Antonio Araujo");
		colaboradorEsperado.setCpf("83009345020");
		colaboradorEsperado.setData_nascimento("1975-07-08");
		colaboradorEsperado.setRg("0000000");
		colaboradorEsperado.setId(Short.valueOf("7"));
		
		DadosEmpresa dadosEmpresaEsperado = new DadosEmpresa();
		dadosEmpresaEsperado.setFuncao("Funcao teste 1");
		dadosEmpresaEsperado.setLotacao("lotacao teste 1");
		dadosEmpresaEsperado.setDepartamento("Departamento teste 1");
		dadosEmpresaEsperado.setData_admissao("2017-09-20");
		dadosEmpresaEsperado.setSituacao("situacao teste 1");
		dadosEmpresaEsperado.setId(Short.valueOf("7"));
		
		colaboradorEsperado.setDadosEmpresa(dadosEmpresaEsperado);
		
		
		Colaborador colaboradorSalvo = colaboradorService.salvarColaborador(colaboradorEsperado);
		
		assertEquals(colaboradorEsperado.getId(), colaboradorSalvo.getId());
		
	}
	
	@Test
	@Disabled
	public void verificaSeColaboradorNulo() {
		
		List<Colaborador> colaboradores = colaboradorService.buscaColaboradores();
		
		assertNotNull(colaboradores);
		
		System.out.println("Total de colaboradores: " + colaboradores.size());

	}
	
	

}
