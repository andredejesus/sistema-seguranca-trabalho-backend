package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sast.model.Treinamento;
import br.com.sast.repository.treinamento.TreinamentoQuery;

public interface TreinamentoRepository extends JpaRepository<Treinamento, Short>, TreinamentoQuery{

}
