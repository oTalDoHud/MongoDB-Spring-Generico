package com.hudlucas.mongodbspringgenerico.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hudlucas.mongodbspringgenerico.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, 
			HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(),
				"Id não existe", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
