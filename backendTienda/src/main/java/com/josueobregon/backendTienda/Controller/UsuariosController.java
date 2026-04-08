package com.josueobregon.backendTienda.Controller;

import com.josueobregon.backendTienda.Entity.Usuarios;
import com.josueobregon.backendTienda.Service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
private final UsuariosService usuariosService;

public UsuariosController(UsuariosService usuariosService) {
    this.usuariosService = usuariosService;
}

@GetMapping
    public List<Usuarios> findAll() {
    return usuariosService.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<?> findById(@PathVariable int id) {
    Usuarios usuario = usuariosService.findById(id);
    if (usuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usuario");
    }else {
        return ResponseEntity.ok().body(usuario);
    }
}
@PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuarios usuarios) {
    Usuarios createUsuario = usuariosService.CreateUsuario(usuarios);
    return ResponseEntity.ok().body(createUsuario);
}

@PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @RequestBody Usuarios usuarios) {
    Usuarios updateUsuario = usuariosService.UpdateUsuario(id, usuarios);
    if (updateUsuario == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usuario");
    }else{
    return ResponseEntity.ok().body(updateUsuario);
    }
}

@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
    usuariosService.DeleteUsuario(id);
    return ResponseEntity.status(200).body("Se elimino el usuario con exito");
}
}
