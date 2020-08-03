package br.com.sast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
			
			return User
				   .builder()
				   .username(usuario.getUsername())
				   .password(usuario.getPassword())
				   .roles("USER")
				   .build();
			
		} catch (UsernameNotFoundException e) {
			
			new UsernameNotFoundException("Usuário não encontrado.");
			
		}
		
		return null;
	}
	
	public void salvaUsuario(Usuario usuario) {
		ur.save(usuario);
	}
	
	public List<Usuario> listaUsuarios(){
		return ur.findAll();
	}



}
