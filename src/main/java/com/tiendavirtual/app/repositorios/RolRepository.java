package com.tiendavirtual.app.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.app.entidades.Rol;

import java.util.Optional;

@Repository
public interface RolRepository extends PagingAndSortingRepository<Rol, Long>{
    Optional<Rol> findByNombre(String Nombre);
}
