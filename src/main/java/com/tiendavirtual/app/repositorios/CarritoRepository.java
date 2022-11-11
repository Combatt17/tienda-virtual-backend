package com.tiendavirtual.app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Carrito;
@Repository
public interface CarritoRepository extends PagingAndSortingRepository<Carrito, Long>{

}
