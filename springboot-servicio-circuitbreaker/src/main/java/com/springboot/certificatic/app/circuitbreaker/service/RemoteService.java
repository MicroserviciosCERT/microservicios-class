package com.springboot.certificatic.app.circuitbreaker.service;

import org.springframework.stereotype.Service;

@Service
public class RemoteService {
	
	
	public String callRemoteService() {
		throw new RuntimeException("Error al llamar al servicio remoto");
		
	}
	
	public String callRemoteService2() {
		throw new RuntimeException("Error al llamar al servicio remoto");
	}

}
