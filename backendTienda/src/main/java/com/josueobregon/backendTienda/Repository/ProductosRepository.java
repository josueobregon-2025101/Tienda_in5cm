package com.josueobregon.backendTienda.Repository;

import com.josueobregon.backendTienda.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer> {
}
