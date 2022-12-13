package com.tiendavirtual.app.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.dto.PedidoDTO;
import com.tiendavirtual.app.entidades.Pedido;
import com.tiendavirtual.app.repositorios.PedidoRepository;
import com.tiendavirtual.app.repositorios.UsuarioRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	UsuarioRepository usuarioRepository; 
	
	@Autowired 
	DetallePedidoService detallePedidoService;
	@Override
	@Transactional
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
		
	}
	
	public List<PedidoDTO> findByUsuarioById(Long id) {
		List<PedidoDTO> pedidosDto = new ArrayList();
		PedidoDTO pedidoDto = new PedidoDTO();
		
		long idUser = usuarioRepository.findById(id).get().getId();
		List<Pedido> pedidos =(List<Pedido>) pedidoRepository.findAllByUsuarioId(idUser);
		
		for(Pedido p :pedidos) {
			pedidoDto.setCodigo(p.getCodigo());
			pedidoDto.setFechaPedido(p.getFechaPedido());
			pedidoDto.setTotal(p.getTotal());
			pedidoDto.setUsuario(p.getUsuario());
			pedidoDto.setDetallePedido(detallePedidoService.findByPedidoCodigo(p.getCodigo()));
		}
		pedidosDto.add(pedidoDto);
		return pedidosDto ;
		
	}

}
