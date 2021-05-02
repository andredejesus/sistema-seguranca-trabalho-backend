package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sast.model.DadosChecklist;

@Repository
public interface DadosChecklistRepository extends JpaRepository<DadosChecklist, Short> {

}