package com.tiendavirtual.app.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.entidades.Producto;
import com.tiendavirtual.app.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() {
		
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Page<Producto> findAll(Pageable page) {
		List<Producto> productos = new ArrayList<>();
		Iterable<Producto> registros = productoRepository.findAll(page);
		for(Producto p:registros) {
			productos.add(p);
		}
		return new PageImpl<Producto>(productos);
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}
	@Transactional
	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
		
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		
	}

}
