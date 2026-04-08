package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.Ventas;
import com.josueobregon.backendTienda.Repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasServiceImplemets implements VentasService {
    public final VentasRepository ventasRepository;

    public VentasServiceImplemets(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas findById(int id) {
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas CreateVenta(Ventas venta) throws RuntimeException {
        return ventasRepository.save(venta);
    }

    @Override
    public Ventas UpdateVenta(Integer id, Ventas venta) {
        Optional<Ventas> ventaExist = ventasRepository.findById(id);
        if (ventaExist.isPresent()) {
            Ventas ventaUpdate = ventaExist.get();

            ventaUpdate.setFechaVenta(venta.getFechaVenta());
            ventaUpdate.setTotal(venta.getTotal());
            ventaUpdate.setClientes_dpi_cliente(venta.getClientes_dpi_cliente());
            ventaUpdate.setEstado(venta.getEstado());
            ventaUpdate.setUsuarios_codigo_usuario(venta.getUsuarios_codigo_usuario());
            return ventasRepository.save(ventaUpdate);
        }
        return null;
    }

    @Override
    public void DeleteVenta(Integer id) {
        ventasRepository.deleteById(id);
    }
}
