package com.tiendavirtual.app.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.entidades.Usuario;
import com.tiendavirtual.app.repositorios.UsuarioRepository;
@Service
public class UsuarioServiceImpl  implements UsuarioService{
	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void save(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Usuario> findOneByEmail(String email) {
		return usuarioRepository.findOneByEmail(email);
	}

}
