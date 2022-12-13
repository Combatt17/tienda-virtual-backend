package com.tiendavirtual.app.servicios;

import java.util.List;

import com.tiendavirtual.app.entidades.DetallePedido;

public interface DetallePedidoService {
  void save(DetallePedido detalle);
  
  List<DetallePedido> findByPedidoCodigo(Long id);
}
