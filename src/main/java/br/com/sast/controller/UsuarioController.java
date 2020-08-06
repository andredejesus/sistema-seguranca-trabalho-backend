package br.com.sast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.sast.exception.UsuarioCadastradoException;
import br.com.sast.model.Usuario;
import br.com.sast.service.UsuarioServiceImpl;

@RestController
@RequestMapping("api")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl us;

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUsuario(@RequestBody @Valid Usuario usuario) {
		
		try {
			
			us.salvaUsuario(usuario);
			
		} catch (UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
		
	}
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> listaUsuarios(){
		return us.listaUsuarios();
	}
	
	
	
	
}
