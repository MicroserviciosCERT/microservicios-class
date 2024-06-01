package com.springboot.certificatic.app.oauth.services;

import com.springboot.certificatic.app.oauth.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
