package com.springboot.certificatic.app.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.certificatic.app.circuitbreaker.service.MyService;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@RestController
public class RemoteServiceController {
	
	@Autowired
	private MyService myService;
	
	@Autowired
	private CircuitBreaker circuitBreaker;
	
	@GetMapping("/callRemote")
	public String callRemoteService() {
		return myService.callRemoteServiceCircuitBreaker();
	}
	
	@GetMapping("/circuitBreakerStatus")
	public String getCircuitBreakerStatus() {
		
		
		CircuitBreaker.State state = circuitBreaker.getState();
		return "El estado del Circuit Breaker es: " + state.toString();
		
		
		
	}

}
