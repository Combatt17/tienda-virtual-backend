package com.tiendavirtual.app.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tiendavirtual.app.servicios.UserDetailsServiceImpl;

@Configuration
public class MainSecurity {
	@Autowired
	JwtEntryPoint jwtEntryPoint;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
	@Bean
	SecurityFilterChain filtro(HttpSecurity http, AuthenticationManager manager) throws Exception {
		return http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/api/auth/**").permitAll()
				.antMatchers("/api/categorias/**").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class).build();
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsServiceImpl)
				.passwordEncoder(passwordEncoder()).and().build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
