package com.tiendavirtual.app.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {
	  private String token;
	    private String bearer = "Bearer";
	    private String email;
	    private Collection<? extends GrantedAuthority> authorities;

	    public JwtDTO(String token,  String email, Collection<? extends GrantedAuthority> authorities) {
	        this.token = token;
	        this.bearer = bearer;
	        this.email = email;
	        this.authorities = authorities;
	    }

	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

	    public String getBearer() {
	        return bearer;
	    }

	    public void setBearer(String bearer) {
	        this.bearer = bearer;
	    }
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	        this.authorities = authorities;
	    }
}
