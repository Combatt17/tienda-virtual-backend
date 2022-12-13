package com.tiendavirtual.app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tiendavirtual.app.servicios.UserDetailsServiceImpl;

public class JwtTokenFilter extends OncePerRequestFilter{
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Override
	protected void doFilterInternal(
			HttpServletRequest req,
			HttpServletResponse res,
			FilterChain filter)throws ServletException, IOException {
		try {
			//obtener el token en la peticion http
			String token = req.getHeader("Authorization");
			if(token != null && token.contains("Bearer")) {
				token = token.replace("Bearer", "");
			}
			
			if(jwtProvider.validarToken(token)) {
				//se valida que el usuario sea el correcto
				String email = jwtProvider.getEmailUsuario(token);//test@mail.com
				UserDetails userDatail = userDetailsServiceImpl.loadUserByUsername(email);// se hace la consulta en la base de datos a traves del servicio
				//se valida la autenticacion
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDatail,null, userDatail.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}catch(Exception e) {
			
		}
		filter.doFilter(req, res);
	}
}
