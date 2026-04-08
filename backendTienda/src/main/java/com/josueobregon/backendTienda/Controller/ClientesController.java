package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Clientes;
import com.josueobregon.backendTienda.Service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> findAll() {
        return clientesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Clientes clientes = clientesService.findById(id);
        if (clientes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
        }else {
            return ResponseEntity.ok().body(clientes);
        }
    }
    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Clientes clientes) {
        Clientes createCliente = clientesService.CreateCliente(clientes);
        return ResponseEntity.ok().body(createCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable int id, @RequestBody Clientes clientes) {
        Clientes updateCliente = clientesService.UpdateCliente(id, clientes);
        if (updateCliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el cliente");
        }else{
            return ResponseEntity.ok().body(updateCliente);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        clientesService.DeleteCliente(id);
        return ResponseEntity.status(200).body("Se elimino el cliente con exito");
    }
}
