package com.tiendavirtual.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendavirtual.app.entidades.Rol;
import com.tiendavirtual.app.repositorios.RolRepository;

@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	RolRepository rolRepository;
	@Override
	public void save(Rol rol) {
		rolRepository.save(rol);
		
	}

}
