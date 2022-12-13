package com.tiendavirtual.app.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Pedido;
import com.tiendavirtual.app.entidades.Usuario;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>{
	 
	 List<Pedido> findAllByUsuarioId(Long id);
}
