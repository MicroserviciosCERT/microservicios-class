package com.springboot.certificatic.app.oauth.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.certificatic.app.oauth.clients.UsuarioFeignClient;
import com.springboot.certificatic.app.oauth.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	private UsuarioFeignClient client;
	
		

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = client.findByUsername(username);
		if(usuario==null) {
			throw new UsernameNotFoundException("Error en el login " + username + " no encontrado");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
		
	}
	
	
		
	
	
	@Override
	public Usuario findByUsername(String username) {
		return client.findByUsername(username);
	}


}
