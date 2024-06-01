package com.certificatic.springboot.app.productos.service;

import java.util.List;

import com.certificatic.springboot.app.productos.models.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
	

}
