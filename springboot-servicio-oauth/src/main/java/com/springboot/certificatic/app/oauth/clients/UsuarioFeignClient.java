package com.springboot.certificatic.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.certificatic.app.oauth.entity.Usuario;

@FeignClient(name="servicio-usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping("/users/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
}
