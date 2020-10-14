package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sast.model.Colaborador;
import br.com.sast.repository.colaborador.ColaboradorQuery;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Short>, ColaboradorQuery {
	
	@Query("SELECT c FROM Colaborador c WHERE c.id = :id")
	Colaborador buscarColaborador(@Param("id") Short id);
	
	/*@Query("SELECT c FROM ColaboradorQuery c JOIN c.dadosEmpresa WHERE c.nome = :nome "
											  + "or c.rg = :rg "
											  + "or c.cpf = :cpf "
											  + "or c.data_nascimento = :data_nascimento "
											  + "or c.dadosEmpresa.data_admissao = :data_admissao "
											  + "or c.dadosEmpresa.funcao = :funcao "
											  + "or c.dadosEmpresa.departamento = :departamento "
											  + "or c.dadosEmpresa.lotacao = :lotacao "
											  + "or c.dadosEmpresa.situacao = :situacao ")
	
	List<Colaborador> filtroColaboradores(@Param("nome") String nome,
										  @Param("rg") String rg,
										  @Param("cpf") String cpf,
										  @Param("data_nascimento") String data_nascimento,
										  @Param("data_admissao") String data_admissao,
										  @Param("funcao") String funcao,
										  @Param("departamento") String departamento,
										  @Param("lotacao") String lotacao,
										  @Param("situacao") String situacao);*/

}
