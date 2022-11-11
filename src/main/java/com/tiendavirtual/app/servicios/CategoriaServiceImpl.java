package com.tiendavirtual.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tiendavirtual.app.entidades.Categoria;
import com.tiendavirtual.app.repositorios.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	CategoriaRepository categoriaRepository;
	@Override
	public List<Categoria> findAll() {
		
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Override
	public Categoria findById(Long id) {
		
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

	@Override
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
		
	}

}
