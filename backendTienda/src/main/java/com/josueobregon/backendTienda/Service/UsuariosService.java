package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Usuarios;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UsuariosService {
     Usuarios login(String username, String password);
     Usuarios registrar(String usuario, String password);

     List<Usuarios> findAll();
     Usuarios findById(int id);
     Usuarios CreateUsuario(Usuarios usuario) throws RuntimeException;
     Usuarios UpdateUsuario(Integer id, Usuarios usuario);
     void DeleteUsuario(Integer id);
}
