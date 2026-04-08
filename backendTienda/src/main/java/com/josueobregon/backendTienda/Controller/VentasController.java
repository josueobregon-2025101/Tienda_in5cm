package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Ventas;
import com.josueobregon.backendTienda.Service.VentasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> findAll() {
        return ventasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Ventas venta = ventasService.findById(id);
        if (venta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la venta");
        }else {
            return ResponseEntity.ok().body(venta);
        }
    }
    @PostMapping
    public ResponseEntity<?> createVenta(@RequestBody Ventas ventas) {
        Ventas createVenta = ventasService.CreateVenta(ventas);
        return ResponseEntity.ok().body(createVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable int id, @RequestBody Ventas ventas) {
        Ventas updateVenta = ventasService.UpdateVenta(id, ventas);
        if (updateVenta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la venta");
        }else{
            return ResponseEntity.ok().body(updateVenta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable int id) {
        ventasService.DeleteVenta(id);
        return ResponseEntity.status(200).body("Se elimino la venta con exito");
    }
}
