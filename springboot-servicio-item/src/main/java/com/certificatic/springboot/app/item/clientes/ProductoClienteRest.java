package com.certificatic.springboot.app.item.clientes;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.certificatic.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}
