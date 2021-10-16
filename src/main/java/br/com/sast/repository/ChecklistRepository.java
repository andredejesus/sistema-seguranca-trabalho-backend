package br.com.sast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Short> {
	
	
	@Query("select checklist FROM Checklist checklist INNER JOIN checklist.cabecalhoChecklist cabecalho WHERE cabecalho.id = :idCabecalho ")
	List<Checklist> getChecklistPorIdCabecalho(Short idCabecalho);
	
	//List<Checklist> findAllByIdCabecalhoChecklist(Short idCabecalho);
	
	//List<Checklist> findByIdCabecalhoChecklist(Short idCabecalho);

}
