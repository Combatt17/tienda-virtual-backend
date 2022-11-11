package com.tiendavirtual.app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Producto;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{

}
