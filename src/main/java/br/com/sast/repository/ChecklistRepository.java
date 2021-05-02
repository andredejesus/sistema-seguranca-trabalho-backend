package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Checklist;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Short> {

}
