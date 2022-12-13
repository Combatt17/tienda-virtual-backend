package com.tiendavirtual.app.servicios;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.entidades.DetallePedido;

import com.tiendavirtual.app.repositorios.DetallePedidoRepository;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
	@Autowired
	private DetallePedidoRepository detalleRepository;
	@Override
	@Transactional
	public void save(DetallePedido detalle) {
		detalleRepository.save(detalle);
		
	}
	@Override
	public List<DetallePedido> findByPedidoCodigo(Long id) {
		// TODO Auto-generated method stub
		return (List<DetallePedido>)detalleRepository.findAllByPedidoCodigo(id);
	}
	
	

}
