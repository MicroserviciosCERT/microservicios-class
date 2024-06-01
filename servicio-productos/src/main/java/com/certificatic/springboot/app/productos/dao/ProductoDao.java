package com.certificatic.springboot.app.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.certificatic.springboot.app.productos.models.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
