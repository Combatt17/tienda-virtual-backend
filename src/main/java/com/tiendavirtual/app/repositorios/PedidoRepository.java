package com.tiendavirtual.app.repositorios;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Pedido;


@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>{
	 
	 List<Pedido> findAllByUsuarioId(Long id);

}
