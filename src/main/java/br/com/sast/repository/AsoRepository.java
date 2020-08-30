package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Aso;

@Repository
public interface AsoRepository extends JpaRepository<Aso, Short> {

	@Query("SELECT a FROM Aso a WHERE a.id = :id")
	Aso buscaAsoPorId(@Param("id") Short id);
	
	

}
