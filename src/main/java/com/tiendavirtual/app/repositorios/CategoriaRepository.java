package com.tiendavirtual.app.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tiendavirtual.app.entidades.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
