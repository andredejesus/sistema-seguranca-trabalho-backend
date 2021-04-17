package br.com.sast.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sast.model.Extintor;

@SpringBootTest
public class ExtintorServiceTest {
	
	@Autowired
	private ExtintorService extintorService;

	@Test
	public void listaTodosOsExtintoresCadastrados() {
		
		List<Extintor> extintor = new ArrayList<>(); 
		
		extintor = extintorService.listaExtintores();
		
		assertNotNull(extintor);
	}
	
}
