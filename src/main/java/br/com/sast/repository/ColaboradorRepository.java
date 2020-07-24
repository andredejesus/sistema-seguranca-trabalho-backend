package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Short> {
	
	@Query("SELECT c FROM Colaborador c WHERE c.id = :id")
	Colaborador buscarColaborador(@Param("id") Short id);

}
