package br.com.sast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sast.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Short>{

	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	Usuario buscarUsuario(@Param("username") String username);

}
