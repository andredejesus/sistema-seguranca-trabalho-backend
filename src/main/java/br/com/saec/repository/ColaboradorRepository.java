package br.com.saec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.saec.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Short> {
	
	@Query("SELECT c FROM Colaborador c WHERE c.id = :id")
	Colaborador buscarColaborador(@Param("id") Short id);

}
