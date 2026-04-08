package com.josueobregon.backendTienda.Service;

import com.josueobregon.backendTienda.Entity.DetalleVenta;
import com.josueobregon.backendTienda.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImplement implements DetalleVentaService {
    public final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplement(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> obtenerDetalle() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta findById(int id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta createDetalle(DetalleVenta detalleVenta) throws RuntimeException {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
        public DetalleVenta updateDetalle(Integer id, DetalleVenta detalleVenta) {
        Optional<DetalleVenta> detalleExistente = detalleVentaRepository.findById(id);
        if (detalleExistente.isPresent()) {
            DetalleVenta detalleUpdate = detalleExistente.get();

            detalleUpdate.setCantidad(detalleVenta.getCantidad());
            detalleUpdate.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            detalleUpdate.setSubtotal(detalleVenta.getSubtotal());
            detalleUpdate.setProductosCodigoProducto(detalleVenta.getProductosCodigoProducto());
            detalleUpdate.setVentasCodigoVenta(detalleVenta.getVentasCodigoVenta());
            return detalleVentaRepository.save(detalleUpdate);
        }
        return null;
    }

    @Override
    public void deleteDetalle(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

}
