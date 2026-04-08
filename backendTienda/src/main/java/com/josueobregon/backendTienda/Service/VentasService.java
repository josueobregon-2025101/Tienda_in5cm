package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> findAll();
    Ventas findById(int id);
    Ventas CreateVenta(Ventas venta) throws RuntimeException;
    Ventas UpdateVenta(Integer id, Ventas venta);
    void DeleteVenta(Integer id);
}
