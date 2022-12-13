package com.tiendavirtual.app.servicios;

import java.util.List;

import com.tiendavirtual.app.dto.PedidoDTO;
import com.tiendavirtual.app.entidades.Pedido;

public interface PedidoService {
	
	List<PedidoDTO> findByUsuarioById(Long id);
	
	
	public Pedido save(Pedido pedido);
}
