package br.com.sast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.sast.exception.UsuarioCadastradoException;
import br.com.sast.exception.UsuarioNaoEncontradoException;
import br.com.sast.model.Usuario;
import br.com.sast.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository ur;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			
			Usuario usuario = ur.buscarUsuario(username);
			
			if(usuario == null) {
				throw new UsuarioNaoEncontradoException();
			}
			
			return User
				   .builder()
				   .username(usuario.getUsername())
				   .password(usuario.getPassword())
				   .roles("USER")
				   .build();
			
		} catch (UsernameNotFoundException e) {
			
			new UsernameNotFoundException("Usuário não encontrado.");
			
		}
		//catch(UsuarioNaoEncontradoException e) {
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		//}
		
		return null;
		
	}
	
	public void salvaUsuario(Usuario usuario) {
		
		boolean usuarioExiste = ur.existsByUsername(usuario.getUsername());
		
		if(usuarioExiste) {
			throw new UsuarioCadastradoException(usuario.getUsername());
		}
		
		ur.save(usuario);
	}
	
	public List<Usuario> listaUsuarios(){
		return ur.findAll();
	}



}
