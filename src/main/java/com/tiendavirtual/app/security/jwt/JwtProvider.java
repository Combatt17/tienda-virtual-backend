package com.tiendavirtual.app.security.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.tiendavirtual.app.dto.UsuarioAutenticado;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiracion}")
	private int expiracion;
	
	
	public String generarToken(Authentication autenticacion) {
		UsuarioAutenticado usuario  = (UsuarioAutenticado) autenticacion.getPrincipal();
		String token =  Jwts
						.builder()//construir token
						.setSubject(usuario.getEmail())//Payload
						.setIssuedAt(new Date())//Fecha creacion
						.setExpiration(new Date(new Date().getTime()+expiracion * 1000))//Fecha expiracion
						.signWith(SignatureAlgorithm.HS512, secret)
						.compact();
						
		return token;
	}
	
	public String getEmailUsuario(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validarToken(String token) {
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		return true;
		}catch(MalformedJwtException e){
			
		}catch(UnsupportedJwtException e){
			
		}catch(ExpiredJwtException e){
			
		}catch(IllegalArgumentException e){
			
		}catch(SignatureException e){
			
		}
		return false;
	}
}
