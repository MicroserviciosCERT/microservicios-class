package com.certificatic.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.certificatic.springboot.app.productos.excepcion.SomeError;
import com.certificatic.springboot.app.productos.models.Producto;
import com.certificatic.springboot.app.productos.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private Environment env;
	
	/*@Value("${server.port}")
	private Integer port;*/
	
	@Value("${eureka.instance.instance-id}")
	private String app;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	SomeError error;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		
		return productoService.findAll().stream().map(producto->{
			//actualizacion a cada elemento de un ArrayList
			
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setApp(app);
			return producto;
		}).collect(Collectors.toList());
		
		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws InterruptedException {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setApp(app);
		
		if(true) throw new InterruptedException("Timeout encontrado");
		
		
		return producto;
		
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		productoService.deleteById(id);
	}

	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		producto.setId(id);
		return productoService.save(producto);
		
	}
	
	@GetMapping("/handle-error")
	public ResponseEntity<String> handleError(){
		error.throwExceptionError();
		
		return ResponseEntity.ok("Operacion exitosa");
		
	}
	

}
