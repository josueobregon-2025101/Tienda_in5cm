package com.josueobregon.backendTienda.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleventas")
public class DetalleVenta {
    @Id
    @Column(name = "codigo_detalle_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoDetalleVenta;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "subtotal")
    private double subtotal;

    @Column(name = "productos_codigo_producto")
    private int productosCodigoProducto;

    @Column(name = "ventas_codigo_venta")
    private int ventasCodigoVenta;

    public int getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(int codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(int productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    public int getVentasCodigoVenta() {
        return ventasCodigoVenta;
    }

    public void setVentasCodigoVenta(int ventasCodigoVenta) {
        this.ventasCodigoVenta = ventasCodigoVenta;
    }
}
