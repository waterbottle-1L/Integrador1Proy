package com.proyect.proyectintegrador.Entitis;

import java.util.Date;

public class Producto {

    private Long codProducto;
    private Long codMarca;
    private Long codProveedor;
    private Long codTipo;
    private String nombre;
    private String descripcion;
    private Date fechaRegistro;
    private Double precio;
    private Boolean estado;
    
    private String nombreMarca;
    private String nombreProveedor;
    private String nombreTipo;

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public Long getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Long codMarca) {
        this.codMarca = codMarca;
    }

    public Long getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Long codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Long getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Long codTipo) {
        this.codTipo = codTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
