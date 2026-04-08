package com.josueobregon.backendTienda.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @Column(name = "codigo_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoVenta;

    @Column(name = "fecha_venta")
    private String fechaVenta;

    @Column(name = "total")
    private double total;

    @Column(name = "Clientes_dpi_cliente")
    private int Clientes_dpi_cliente;

    @Column(name = "Usuarios_codigo_usuario")
    private int Usuarios_codigo_usuario;

    @Column(name = "estado")
    private int estado;

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getClientes_dpi_cliente() {
        return Clientes_dpi_cliente;
    }

    public void setClientes_dpi_cliente(int clientes_dpi_cliente) {
        Clientes_dpi_cliente = clientes_dpi_cliente;
    }

    public int getUsuarios_codigo_usuario() {
        return Usuarios_codigo_usuario;
    }

    public void setUsuarios_codigo_usuario(int usuarios_codigo_usuario) {
        Usuarios_codigo_usuario = usuarios_codigo_usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
