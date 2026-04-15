package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Usuarios;
import com.josueobregon.backendTienda.Repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImplement implements UsuariosService {

    public final UsuariosRepository usuariosRepository;

    public UsuariosServiceImplement(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public Usuarios registrar(String username, String password) {

        if (usuariosRepository.findByUsername(username) != null) {
            return null;
        }

        Usuarios u = new Usuarios();
        u.setUsername(username);
        u.setPassword(password);

        return usuariosRepository.save(u);
    }

    @Override
    public Usuarios login(String username, String password) {

        Usuarios u = usuariosRepository.findByUsername(username);

        if (u != null && u.getPassword().equals(password)) {
            return u;
        }

        return null;
    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios findById(int id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios CreateUsuario(Usuarios usuario) throws RuntimeException {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios UpdateUsuario(Integer id, Usuarios usuario) {
        Optional<Usuarios> usuarioExist = usuariosRepository.findById(id);
        if (usuarioExist.isPresent()) {
            Usuarios usuarioUpdate = usuarioExist.get();

            usuarioUpdate.setEmail(usuario.getEmail());
            usuarioUpdate.setUsername(usuario.getUsername());
            usuarioUpdate.setPassword(usuario.getPassword());
            usuarioUpdate.setEstado(usuario.getEstado());
            usuarioUpdate.setRol(usuario.getRol());
            usuarioUpdate.setFoto(usuario.getFoto());
            return usuariosRepository.save(usuarioUpdate);
        }
        return null;
    }

    @Override
    public void DeleteUsuario(Integer id) {
    usuariosRepository.deleteById(id);
    }


}

