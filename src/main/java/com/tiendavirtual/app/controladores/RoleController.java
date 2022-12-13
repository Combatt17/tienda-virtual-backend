package com.tiendavirtual.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.app.entidades.Categoria;
import com.tiendavirtual.app.entidades.Producto;
import com.tiendavirtual.app.entidades.Rol;
import com.tiendavirtual.app.servicios.RoleServiceImpl;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	RoleServiceImpl roleServiceImpl;

	@PostMapping("/guardar")
	public ResponseEntity<Boolean> guardar(@RequestBody Rol rol){
		roleServiceImpl.save(rol);
		return ResponseEntity.ok(true);
	}

}
