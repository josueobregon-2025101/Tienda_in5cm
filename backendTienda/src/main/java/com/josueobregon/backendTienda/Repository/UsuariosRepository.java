package com.josueobregon.backendTienda.Repository;

import com.josueobregon.backendTienda.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
}
