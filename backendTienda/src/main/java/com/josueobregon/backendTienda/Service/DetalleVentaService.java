package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> obtenerDetalle();
    DetalleVenta findById(int id);
    DetalleVenta createDetalle(DetalleVenta detalleVenta) throws RuntimeException;
    DetalleVenta updateDetalle(Integer id, DetalleVenta detalleVenta);
    void deleteDetalle(Integer id);
}
