package com.marioacosta.api.accenture.album.controllers;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>  globalExceptionHandler(MethodArgumentNotValidException ex){
		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return ResponseEntity.badRequest().body(body);
	}
	
	

}
