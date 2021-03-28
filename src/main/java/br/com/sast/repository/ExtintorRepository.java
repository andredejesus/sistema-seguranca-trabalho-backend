package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Extintor;

@Repository
public interface ExtintorRepository extends JpaRepository<Extintor, Short>{

}
