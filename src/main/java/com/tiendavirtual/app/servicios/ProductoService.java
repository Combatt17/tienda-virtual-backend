package com.tiendavirtual.app.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tiendavirtual.app.entidades.Producto;

public interface ProductoService {
	
	List<Producto>  findAll();
	
	Page<Producto> findAll(Pageable page);
	
	Producto findById(Long id);
	
	void save(Producto categoria);
	
	void deleteById(Long id);
}
