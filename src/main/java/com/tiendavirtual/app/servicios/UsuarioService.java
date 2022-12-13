package com.tiendavirtual.app.servicios;

import java.util.List;
import java.util.Optional;

import com.tiendavirtual.app.entidades.Usuario;

public interface UsuarioService {
	List<Usuario>  findAll();
	
	Usuario findById(Long id);
	
	void save(Usuario categoria);
	
	void deleteById(Long id);
	
	Optional<Usuario> findOneByEmail(String email);
}
