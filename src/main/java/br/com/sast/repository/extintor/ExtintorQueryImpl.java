package br.com.sast.repository.extintor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.sast.dto.ExtintorFiltroDTO;
import br.com.sast.model.Extintor;

public class ExtintorQueryImpl implements ExtintorQuery {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Extintor> filtroExtintor(ExtintorFiltroDTO dto) {
		
		String sql = "SELECT * FROM extintor ex " + this.restricoes(dto);
		
		System.out.println(sql);
		
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> result = query.getResultList();
		
		List<Extintor> extintores = new ArrayList<>();
		
		for(Object[] ex: result) {
			
			Extintor extintor = new Extintor();
			
			extintor.setId(Short.parseShort(ex[0].toString()));
			extintor.setData_recarga(ex[1].toString());
			extintor.setData_vencimento(ex[2].toString());
			extintor.setDias_vencimento(Integer.parseInt(ex[3].toString()));
			extintor.setLacre(ex[4].toString());
			extintor.setLocalizacao(ex[5].toString());
			extintor.setLtKg(Integer.parseInt(ex[6].toString()));
			extintor.setNuInmetro(ex[7].toString());
			extintor.setTipo(ex[8].toString());
			extintor.setNuPatrimonio(ex[9].toString());
			
			extintores.add(extintor);
		}

		return extintores;
	}
	
	@SuppressWarnings("unused")
	private String restricoes(ExtintorFiltroDTO dto) {
		
		Integer incremento = 0;
		String where = "";
		
		if(dto.getLocalizacao() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("ex.localizacao = '"+dto.getLocalizacao()+"'");
			}else {
				where = where.concat("AND ");
				where = where.concat("ex.localizacao = '"+dto.getLocalizacao()+"'");
			}
			
			incremento++;
		}
		
		if(dto.getDataInicioValidade() != null && dto.getDataFimValidade() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("ex.data_recarga >= '"+dto.getDataInicioValidade()+"'" + " AND " + " ex.data_recarga <= '"+dto.getDataFimValidade()+"'");
			}else {
				where = where.concat("AND ");
				where = where.concat("ex.data_recarga >= '"+dto.getDataInicioValidade()+"'" + " AND " + " ex.data_recarga <= '"+dto.getDataFimValidade()+"'");
			}
			
			incremento++;
		}
		
		return where;
		
	}

}
