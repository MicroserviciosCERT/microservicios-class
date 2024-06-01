package com.certificatic.springboot.app.productos.excepcion;

import org.springframework.stereotype.Service;

@Service
public class SomeError {

	public void throwExceptionError() {
		
		throw new RuntimeException("Ocurrio un error en el Controller");
	}
	
}
