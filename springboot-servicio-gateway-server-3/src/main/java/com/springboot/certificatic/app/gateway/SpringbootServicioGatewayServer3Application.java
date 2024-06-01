package com.springboot.certificatic.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootServicioGatewayServer3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioGatewayServer3Application.class, args);
	}

}
