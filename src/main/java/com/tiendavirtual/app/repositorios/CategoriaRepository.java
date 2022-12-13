package com.tiendavirtual.app.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tiendavirtual.app.entidades.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	List<Categoria> findByNombreStartsWith(String nombre);
}
