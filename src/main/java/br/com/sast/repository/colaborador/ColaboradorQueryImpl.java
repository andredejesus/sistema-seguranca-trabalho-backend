package br.com.sast.repository.colaborador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sast.dto.FiltroColaboradorDTO;
import br.com.sast.model.Colaborador;
import br.com.sast.model.DadosEmpresa;
import br.com.sast.repository.DadosEmpresaRepository;

public class ColaboradorQueryImpl implements ColaboradorQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private DadosEmpresaRepository empresaRepository;
	
	@Override
	public List<Colaborador> filtroColaborador(FiltroColaboradorDTO filtroColaborador) {

		String sql = "select c.id, c.nome, c.rg, c.cpf, c.data_nascimento, c.id_empresa from colaborador as c inner join dados_empresa as d on d.id = c.id_empresa " 
		+ restricoes(filtroColaborador);
		
		System.out.println(sql);
		
		
		List<Colaborador> listaColaboradores = new ArrayList<>();
		
		Query q = manager.createNativeQuery(sql);
		
		List<Object[]> result = q.getResultList();
		
		for(Object[] w: result) {
			Colaborador colab= new Colaborador();
			DadosEmpresa empresa = new DadosEmpresa();
			try {
				colab.setId(Short.parseShort(w[0].toString()));
				colab.setNome(w[1].toString());
				colab.setRg(w[2].toString());
				colab.setCpf(w[3].toString());
				colab.setData_nascimento(w[4].toString());
				
				Short cdDadosEmpresa = Short.parseShort(w[5].toString());
				empresa = empresaRepository.findById(cdDadosEmpresa).get();
				//colab.setDadosEmpresa(empresa);
	
			} catch (Exception e) {
				colab = null;
				empresa = null;
			}
			
			listaColaboradores.add(colab);
			
		}
		
		return listaColaboradores;
	}
	
	public String restricoes(FiltroColaboradorDTO filtroColaborador) {
		
		int incremento = 0;
		
		String where = "";
		
		if(filtroColaborador.getNome() != null) {
			
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" c.nome like '%"+ filtroColaborador.getNome() +"%'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" c.nome like '% "+ filtroColaborador.getNome() +"%'");
			}
			
			incremento++;
			
		}
		
		if(filtroColaborador.getRg() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" c.rg = '"+filtroColaborador.getRg()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" c.rg = '"+filtroColaborador.getRg()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getCpf() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" c.cpf = '"+filtroColaborador.getCpf()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" c.cpf = '"+filtroColaborador.getCpf()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getData_nascimento() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" cast(c.data_nascimento as date) = '"+filtroColaborador.getData_nascimento()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" cast(c.data_nascimento as date) = '"+filtroColaborador.getData_nascimento()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getData_admissao() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" cast(d.data_admissao as date) = '"+filtroColaborador.getData_admissao()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" cast(d.data_admissao as date) = '"+filtroColaborador.getData_admissao()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getFuncao() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" d.funcao = '"+filtroColaborador.getFuncao()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" d.funcao = '"+filtroColaborador.getFuncao()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getDepartamento() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" d.departamento = '"+filtroColaborador.getDepartamento()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" d.departamento = '"+filtroColaborador.getDepartamento()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getLotacao() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" d.lotacao = '"+filtroColaborador.getLotacao()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" d.lotacao = '"+filtroColaborador.getLotacao()+"'");
			}
			incremento++;
		}
		
		if(filtroColaborador.getSituacao() != null) {
			if(incremento == 0) {
				where = where.concat(" WHERE ");
				where = where.concat(" d.situacao = '"+filtroColaborador.getSituacao()+"'");
			}else {
				where = where.concat(" AND ");
				where = where.concat(" d.situacao = '"+filtroColaborador.getSituacao()+"'");
			}
			incremento++;
		}
		
		
		return where;
		
	}

}
