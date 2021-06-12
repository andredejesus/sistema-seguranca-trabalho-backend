package br.com.sast.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConfigCamposCSV {
	
	@SuppressWarnings("rawtypes")
	public String[] getAtributosClasse(Class cls){
		
		Field atributosClasse[] = cls.getDeclaredFields();
		
		List<String> listaDeAtributos = new ArrayList<>();
		
		/*Adiciona todos os atributos da classe em um arrayList de strings */
		for (Field atributo : atributosClasse) {
			listaDeAtributos.add(atributo.getName());
		}
		
		String[] valoresCampos = listaDeAtributos.toArray(new String[0]); /* Converte o list em um array de string */
		
		return valoresCampos;
	}
	
}
