package com.tiendavirtual.app.servicios;

import com.tiendavirtual.app.entidades.Usuario;
import com.tiendavirtual.app.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Transactional
    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public Optional<Usuario> findOneByEmail(String email) {
        return usuarioRepository.findOneByEmail(email);
    }


}
