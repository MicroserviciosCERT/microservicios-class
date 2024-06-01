package com.springboot.certificatic.app.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class SpringbootServicioOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passEncode;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioOauthApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String passwordbCrypt= passEncode.encode("123456");
		System.out.println(passwordbCrypt);
		
	}

	
	
	

}
