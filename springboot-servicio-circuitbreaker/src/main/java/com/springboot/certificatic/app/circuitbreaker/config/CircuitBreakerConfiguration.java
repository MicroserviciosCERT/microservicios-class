package com.springboot.certificatic.app.circuitbreaker.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Configuration
public class CircuitBreakerConfiguration {
	
	@Bean
	public CircuitBreakerConfig circuitBreakerConfig() {
		return CircuitBreakerConfig.custom()
				.failureRateThreshold(100)
			//	.waitDurationInOpenState(Duration.ofMillis(1000))
			//	.slidingWindowSize(5)
				.build();
		
	} 
	

	@Autowired
	private CircuitBreakerRegistry circuitBreakerRegistry;
	
	@Bean
	public CircuitBreaker circuitBreaker() {
		return circuitBreakerRegistry.circuitBreaker("remoteService");
	}

}
