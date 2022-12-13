package com.tiendavirtual.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tiendavirtual.app.dto.JwtDTO;
import com.tiendavirtual.app.dto.LoginUsuarioDTO;
import com.tiendavirtual.app.entidades.Usuario;
import com.tiendavirtual.app.security.jwt.JwtProvider;
import com.tiendavirtual.app.servicios.UsuarioService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
    JwtProvider jwtProvider;
	@Autowired
	UsuarioService  usuarioService;
	
    @Autowired
    AuthenticationManager authenticationManager;
    
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioService.save(usuario);
		return ResponseEntity.ok(true);
	}
	@PostMapping("/login")
	public ResponseEntity<JwtDTO>login(@RequestBody LoginUsuarioDTO loginUsuario) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
		
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generarToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return ResponseEntity.ok(jwtDto);
	}

}
