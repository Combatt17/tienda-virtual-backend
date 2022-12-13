package com.tiendavirtual.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.dto.UsuarioAutenticado;
import com.tiendavirtual.app.entidades.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioServiceImpl.findOneByEmail(email).get();
		return UsuarioAutenticado.construir(usuario);
	}

}
