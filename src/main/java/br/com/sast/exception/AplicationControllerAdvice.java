package br.com.sast.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class AplicationControllerAdvice {
	
/* Esse método é responsável por interceptar toda vez que houver um erro de validação */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // Erro 404
	public ApiErros handleValidationError(MethodArgumentNotValidException ex) {
		
		BindingResult bindingResult = ex.getBindingResult(); // Possui todas as mensagens de erro interceptadas 
		
		List<String> messages = bindingResult.getAllErrors()
			.stream()
			.map(ObjectError -> ObjectError.getDefaultMessage())
			.collect(Collectors.toList());
		
		return new ApiErros(messages);
	}
	
	/* Esse método é responsável por interceptar toda vez que houver um erro de status */
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ApiErros> handleResponseStatusException( ResponseStatusException ex) {
		String mensagemErro = ex.getReason();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErros apiErros = new ApiErros(mensagemErro);
		
		return new ResponseEntity<ApiErros>(apiErros, codigoStatus);
		
	}

}
