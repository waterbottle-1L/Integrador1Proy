
package com.proyect.proyectintegrador.Entitis;


public class DetalleVenta {
    
    private Long coddetalleventa;
    private Long codproducto;
    private Long codventa;
    private int cantidad;
    private Double preciounitario;
    private Double subtotal;
    private Double igv;
    private Double detalleventa;
    private Double totalapagar;
    private Boolean estado1;

    public Boolean  getEstado1() {
        return estado1;
    }

    public void setEstado1(Boolean  estado1) {
        this.estado1 = estado1;
    }
    
    
    public Double getTotalapagar() {
        return totalapagar;
    }

    public void setTotalapagar(Double totalapagar) {
        this.totalapagar = totalapagar;
    }
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Long getCoddetalleventa() {
        return coddetalleventa;
    }

    public void setCoddetalleventa(Long coddetalleventa) {
        this.coddetalleventa = coddetalleventa;
    }

    
    public Long getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(Long codproducto) {
        this.codproducto = codproducto;
    }

    public Long getCodventa() {
        return codventa;
    }

    public void setCodventa(Long codventa) {
        this.codventa = codventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(Double detalleventa) {
        this.detalleventa = detalleventa;
    }
    
    
    
}
