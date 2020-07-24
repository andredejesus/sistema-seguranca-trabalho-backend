package br.com.saec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saec.model.DadosEmpresa;

@Repository
public interface DadosEmpresaRepository extends JpaRepository<DadosEmpresa, Short> {

}
