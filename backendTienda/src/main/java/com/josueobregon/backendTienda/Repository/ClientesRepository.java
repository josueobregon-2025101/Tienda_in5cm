package com.josueobregon.backendTienda.Repository;

import com.josueobregon.backendTienda.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,Integer> {
}
