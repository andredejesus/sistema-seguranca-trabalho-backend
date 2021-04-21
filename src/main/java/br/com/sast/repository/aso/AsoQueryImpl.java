package br.com.sast.repository.aso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.influx.InfluxDbOkHttpClientBuilderProvider;

import br.com.sast.dto.AsoFiltroDTO;
import br.com.sast.model.Aso;
import br.com.sast.repository.AsoRepository;

public class AsoQueryImpl implements AsoQuery{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AsoRepository asoRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Aso> filtroAso(AsoFiltroDTO asoDto) {
		
		String sql = "SELECT * FROM aso " + this.restricoes(asoDto);
		
		System.out.println(sql);
		
		Query query = em.createNativeQuery(sql.toString());
		
		List<Object[]> result = query.getResultList();
		
		List<Aso> listaAso = new ArrayList<>();
		
		for(Object[] r : result) {
			
			Aso aso = new Aso();
			
			try {
				
				aso.setId(Short.parseShort(r[0].toString()));
				aso.setColaborador(r[1].toString());
				aso.setData_emissao(r[2].toString());
				aso.setData_vencimento(r[3].toString());
				aso.setDias_vencimento(Integer.valueOf(r[4].toString()));
				aso.setTipo_aso(r[5].toString());
				
				listaAso.add(aso);

			} catch (Exception e) {
				System.out.println("Ocorreu algum erro.. " + e);
				e.printStackTrace();
			}
			
		}
		
		return listaAso;
	}
	
	public String restricoes(AsoFiltroDTO asoDto) {
		
		int incremento = 0;
		String where = "";
		
		if(asoDto.getColaborador() != null) {
			
			if(incremento == 0){
				where = where.concat("WHERE ");
				where = where.concat("aso.colaborador LIKE " + "'%" + asoDto.getColaborador() + "%'" );
			}else {
				where = where.concat("AND " );
				where = where.concat("aso.colaborador LIKE " + "'%" + asoDto.getColaborador() + "%'" );
			}
			
			incremento++;
			
		}
		
		if(asoDto.getTipoAso() != null) {
			if(incremento == 0){
				where = where.concat("WHERE ");
				where = where.concat("aso.tipo_aso = '"+asoDto.getTipoAso()+"'");
			}else {
				where = where.concat("AND ");
				where = where.concat("aso.tipo_aso = '"+asoDto.getTipoAso()+"'");
			}
			
			incremento++;
		}
		
		if(asoDto.getDataInicioEmissao() != null && asoDto.getDataFimEmissao() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("aso.data_emissao >= '"+asoDto.getDataInicioEmissao()+"'" + " AND " + " aso.data_emissao <= '"+asoDto.getDataFimEmissao()+"'");
			}else {
				where = where.concat("AND ");
				where = where.concat("aso.data_emissao >= '"+asoDto.getDataInicioEmissao()+"'" + " AND " + " aso.data_emissao <= '"+asoDto.getDataFimEmissao()+"'");
			}
			
			incremento++;
		}
		

		return where;
		
	}

}
