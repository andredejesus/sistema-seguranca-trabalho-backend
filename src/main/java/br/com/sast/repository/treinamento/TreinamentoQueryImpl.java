package br.com.sast.repository.treinamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sast.dto.TreinamentoFiltroDTO;
import br.com.sast.model.Colaborador;
import br.com.sast.model.Treinamento;
import br.com.sast.repository.ColaboradorRepository;

public class TreinamentoQueryImpl implements TreinamentoQuery {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Treinamento> filtroTreinamento(TreinamentoFiltroDTO treinamentoDto) {
		
		String sql = "SELECT t.id, t.data_treinamento, t.data_vencimento, t.dias_vencimento, t.nm_treinamento, t.id_colaborador"
				+ " FROM treinamento AS t INNER JOIN colaborador AS c ON t.id_colaborador = c.id " + this.restricoes(treinamentoDto);
		
		System.out.println(sql);
		
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> result = query.getResultList();
		
		List<Treinamento> treinamentos = new ArrayList<>();
		
		for(Object[] t : result) {
			
			Treinamento treinamento = new Treinamento();
			treinamento.setId(Short.valueOf(t[0].toString()));
	
			LocalDate dataTreinamento = LocalDate.parse(t[1].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			treinamento.setData_treinamento(dataTreinamento);
			
			LocalDate dataVencimento = LocalDate.parse(t[2].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			treinamento.setData_vencimento(dataVencimento);
			
			treinamento.setDias_vencimento(Integer.parseInt(t[3].toString()));
			treinamento.setNm_treinamento(t[4].toString());
			
			try {
				Colaborador colaborador = colaboradorRepository.buscarColaborador(Short.parseShort(t[5].toString()));
				treinamento.setColaborador(colaborador);
			} catch (Exception e) {
				e.printStackTrace();
			}

			treinamentos.add(treinamento);
			
		}
		
		return treinamentos;
	}
	
	
	@SuppressWarnings("unused")
	private String restricoes(TreinamentoFiltroDTO dto) {
		
		String where = "";
		Integer incremento = 0;
		
		if(dto.getNomeColaborador() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("c.nome LIKE " + "'%"+dto.getNomeColaborador()+"%'");
			}else {
				where = where.concat("AND ");
				where = where.concat("c.nome LIKE " + "'%"+dto.getNomeColaborador()+"%'");
			}
			
			incremento++;
		}
		
		if(dto.getNomeTreinamento() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("t.nm_treinamento LIKE " + "'%"+dto.getNomeTreinamento()+"%'");
			}else {
				where = where.concat("AND ");
				where = where.concat("t.nm_treinamento LIKE " + "'%"+dto.getNomeTreinamento()+"%'");
			}
			
			incremento++;
		}
		
		if(dto.getDataInicioTreinamento() != null && dto.getDataFimTreinamento() != null) {
			if(incremento == 0) {
				where = where.concat("WHERE ");
				where = where.concat("t.data_treinamento >= '"+dto.getDataInicioTreinamento()+"'" + " AND " + " t.data_treinamento <= '"+dto.getDataFimTreinamento()+"'");
			}else {
				where = where.concat("AND ");
				where = where.concat("t.data_treinamento >= '"+dto.getDataInicioTreinamento()+"'" + " AND " + " t.data_treinamento <= '"+dto.getDataFimTreinamento()+"'");
			}
			
			incremento++;
		}
		
		
		
		return where;
		
	}

}
