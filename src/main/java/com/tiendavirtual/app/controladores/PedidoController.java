package com.tiendavirtual.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.app.dto.PedidoDTO;
import com.tiendavirtual.app.entidades.Pedido;
import com.tiendavirtual.app.servicios.DetallePedidoService;
import com.tiendavirtual.app.servicios.PedidoService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private  DetallePedidoService detallePedidoService;
	
	@GetMapping("/listar/{id}")
	ResponseEntity<List<PedidoDTO>> realizarPedido(@PathVariable long id){
		PedidoDTO data = new PedidoDTO();
		return ResponseEntity.ok(pedidoService.findByUsuarioById(id));
	}
	@PostMapping("/realizarPedido")
	ResponseEntity<Boolean> realizarPedido(@RequestBody Pedido pedido){
	
		pedidoService.save(pedido);
		return ResponseEntity.ok(true);
	}
}
