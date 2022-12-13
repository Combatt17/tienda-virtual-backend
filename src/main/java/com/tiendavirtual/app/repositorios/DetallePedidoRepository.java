package com.tiendavirtual.app.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.DetallePedido;
@Repository
public interface DetallePedidoRepository extends PagingAndSortingRepository<DetallePedido, Long>{
	
	List<DetallePedido>findAllByPedidoCodigo(Long id);
}
