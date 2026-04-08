package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductosService {
    List<Productos> findAll();
    Productos findById(int id);
    Productos CreateProducto(Productos productos) throws RuntimeException;
    Productos UpdateProducto(Integer id, Productos productos);
    void DeleteProducto(Integer id);
}
