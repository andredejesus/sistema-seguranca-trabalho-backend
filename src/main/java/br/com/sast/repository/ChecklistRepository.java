package br.com.sast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Short> {
	
	List<Checklist> findAllByIdCabecalhoChecklist(Short idCabecalho);
	
	List<Checklist> findByIdCabecalhoChecklist(Short idCabecalho);

}
