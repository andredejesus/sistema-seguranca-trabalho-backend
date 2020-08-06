package br.com.sast.exception;

public class UsuarioCadastradoException extends RuntimeException  {
	
	public UsuarioCadastradoException(String login) {
		super("Usuario ja cadastrado para o login " + login);
	}

}
