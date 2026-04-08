package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Productos;
import com.josueobregon.backendTienda.Repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImplement implements ProductosService {

    public final ProductosRepository productosRepository;

    public ProductosServiceImplement(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Productos findById(int id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public Productos CreateProducto(Productos productos) throws RuntimeException {
        return productosRepository.save(productos);
    }

    @Override
    public Productos UpdateProducto(Integer id, Productos productos) {
        Optional<Productos> productoExist = productosRepository.findById(id);
        if (productoExist.isPresent()) {
            Productos productoUpdate = productoExist.get();

            productoUpdate.setNombreProducto(productos.getNombreProducto());
            productoUpdate.setPrecio(productos.getPrecio());
            productoUpdate.setStock(productos.getStock());
            productoUpdate.setEstado(productos.getEstado());
            return productosRepository.save(productoUpdate);
        }
        return null;
    }

    @Override
    public void DeleteProducto(Integer id) {
        productosRepository.deleteById(id);
    }
}
