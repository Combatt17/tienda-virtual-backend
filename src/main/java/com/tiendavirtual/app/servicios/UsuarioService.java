package com.tiendavirtual.app.servicios;

import com.tiendavirtual.app.entidades.Usuario;

import java.util.Optional;

public interface UsuarioService {

    void save(Usuario usuario);

    boolean existsByEmail(String email);

     Optional<Usuario> findOneByEmail(String email);
}
