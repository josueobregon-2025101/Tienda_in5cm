package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.DetalleVenta;
import com.josueobregon.backendTienda.Service.DetalleVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> findAll() {
        return detalleVentaService.obtenerDetalle();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        DetalleVenta detalle = detalleVentaService.findById(id);
        if (detalle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el detalle de venta");
        }else {
            return ResponseEntity.ok().body(detalle);
        }
    }
    @PostMapping
    public ResponseEntity<?> createDetalle(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta createDetalle = detalleVentaService.createDetalle(detalleVenta);
        return ResponseEntity.ok().body(createDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalle(@PathVariable int id, @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta updateDetalle = detalleVentaService.updateDetalle(id, detalleVenta);
        if (detalleVenta != null) {
            return ResponseEntity.ok().body(updateDetalle);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el detalle de venta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalle(@PathVariable int id) {
        DetalleVenta existente = detalleVentaService.findById(id);
        if (existente != null) {
            detalleVentaService.deleteDetalle(id);
            return ResponseEntity.status(200).body("Se elimino el usuario con exito");
        }else {
            return ResponseEntity.status(404).body("No se encontro el detalle de venta");
        }
    }
}
