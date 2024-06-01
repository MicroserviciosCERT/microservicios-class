package com.springboot.certificatic.app.usuarios.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springboot.certificatic.app.usuarios.entity.Usuario;

@RepositoryRestResource(path="users")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	//Query Method
	// Path /users/search/buscar-username
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("username") String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	
	@RestResource(path="buscar-apellido")
	public Usuario findByUsernameAndApellido(@Param("username") String username,@Param("apellido") String apellido);
}
