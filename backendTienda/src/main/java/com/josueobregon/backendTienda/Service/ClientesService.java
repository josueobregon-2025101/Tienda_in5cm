package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Clientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientesService {
    List<Clientes> findAll();
    Clientes findById(int id);
    Clientes CreateCliente(Clientes cliente) throws RuntimeException;
    Clientes UpdateCliente(Integer id, Clientes cliente);
    void DeleteCliente(Integer id);
}

