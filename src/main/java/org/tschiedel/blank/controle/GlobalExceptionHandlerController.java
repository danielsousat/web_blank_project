/**
 * 
 */
package org.tschiedel.blank.controle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Descricao: Controller que ira gerenciar todas as excecoes levantadas e nao
 * pelo tratadas sistema.
 * 
 * <br><br>Data: 29/04/2014
 * @author Daniel Tschiedel
 * <br>daniel.sousa@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String defaultHandler(Exception e) {
		
		e.printStackTrace();
		
		return "error";
	}
}
