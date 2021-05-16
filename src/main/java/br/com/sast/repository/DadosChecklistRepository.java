package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sast.model.CabecalhoChecklist;

@Repository
public interface DadosChecklistRepository extends JpaRepository<CabecalhoChecklist, Short> {

}
