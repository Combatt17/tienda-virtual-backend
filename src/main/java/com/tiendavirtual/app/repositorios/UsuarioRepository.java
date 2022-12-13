package com.tiendavirtual.app.repositorios;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
	Optional<Usuario> findOneByEmail(String email);
}
