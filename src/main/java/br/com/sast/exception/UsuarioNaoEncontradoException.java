package br.com.sast.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

	public UsuarioNaoEncontradoException() {
		super("Usuario nao encontrado.");
	}
	
}
