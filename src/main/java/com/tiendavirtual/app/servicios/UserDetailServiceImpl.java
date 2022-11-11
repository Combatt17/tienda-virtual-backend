package com.tiendavirtual.app.servicios;

import com.tiendavirtual.app.dto.UsuarioPrincipalDTO;
import com.tiendavirtual.app.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =  usuarioService.findOneByEmail(username).get();
        return UsuarioPrincipalDTO.construir(usuario);
    }
}
