package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Clientes;
import com.josueobregon.backendTienda.Repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientesServiceImplement  implements ClientesService {

    public final ClientesRepository clientesRepository;

    public ClientesServiceImplement(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes findById(int id) {
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes CreateCliente(Clientes clientes) throws RuntimeException {
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes UpdateCliente(Integer id, Clientes clientes) {
        Optional<Clientes> clienteExist = clientesRepository.findById(id);
        if (clienteExist.isPresent()) {
            Clientes clienteUpdate = clienteExist.get();

            clienteUpdate.setApellidoCliente(clientes.getApellidoCliente());
            clienteUpdate.setNombreCliente(clientes.getNombreCliente());
            clienteUpdate.setDireccion(clientes.getDireccion());
            clienteUpdate.setEstado(clientes.getEstado());
            return clientesRepository.save(clienteUpdate);
        }
        return null;
    }

    @Override
    public void DeleteCliente(Integer id) {
        clientesRepository.deleteById(id);
    }
}


