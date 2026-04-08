package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Productos;
import com.josueobregon.backendTienda.Service.ProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> findAll() {
        return productosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Productos productos = productosService.findById(id);
        if (productos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el producto");
        }else {
            return ResponseEntity.ok().body(productos);
        }
    }
    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody Productos productos) {
        Productos createProducto = productosService.CreateProducto(productos);
        return ResponseEntity.ok().body(createProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable int id, @RequestBody Productos productos) {
        Productos updateProducto = productosService.UpdateProducto(id, productos);
        if (updateProducto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el producto");
        }else{
            return ResponseEntity.ok().body(updateProducto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        productosService.DeleteProducto(id);
        return ResponseEntity.status(200).body("Se elimino el producto con exito");
    }
}
