package com.certificatic.springboot.app.productos.excepcion;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomSQLException.class)
	public ResponseEntity<?> handleException(Exception e){
		e.printStackTrace();
		
		//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error en el servidor");
		return retornaEnJson();
	}
	
	
	public  ResponseEntity<?> retornaEnJson() {
		Map<String,Object> objeto = new HashMap<>();
		objeto.put("idError", -1);
		objeto.put("mensaje","Ocurrio un error en el servidor");
		return new ResponseEntity<>(objeto,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
	static class CustomSQLException extends SQLException {
		public CustomSQLException(String message) {
			super(message);
		}
	}
	
}
