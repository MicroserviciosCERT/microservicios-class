package com.springboot.certificatic.app.circuitbreaker.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MyService {
	
	@Autowired
	private RemoteService remoteService;
	
	@Autowired
	private CircuitBreakerRegistry circuitBreakerRegistry;
	
	@CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
	public String  callRemoteServiceCircuitBreaker() {
		 return remoteService.callRemoteService();
	}
	
	public String fallback(Exception e) {
		return "Ocurrio un error " + e.getMessage();
	}

	
	/*@CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
	public String  callRemoteServiceCircuitBreaker2() {
	
		CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("remoteService", 
                circuitBreakerRegistry.getDefaultConfig()
                    .toBuilder()
                    .slidingWindowType(SlidingWindowType.COUNT_BASED)
                    .slidingWindowSize(5)
                    .build());
	}*/
	
}
