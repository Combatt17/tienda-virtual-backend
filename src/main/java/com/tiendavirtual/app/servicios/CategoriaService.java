package com.tiendavirtual.app.servicios;

import java.util.List;

import com.tiendavirtual.app.entidades.Categoria;

public interface CategoriaService {
	
	List<Categoria>  findAll();
	
	Categoria findById(Long id);
	
	void save(Categoria categoria);
	
	void deleteById(Long id);
	
}
