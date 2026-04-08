package com.josueobregon.backendTienda.Repository;

import com.josueobregon.backendTienda.Entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
}
