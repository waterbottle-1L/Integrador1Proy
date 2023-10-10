
package com.proyect.proyectintegrador.Entitis;


public class DetalleVenta {
    
    private Long codproducto;
    private Long codventa;
    private int cantidad;
    private Double preciounitario;
    private Double subtotal;
    private Double igv;
    private Double detalleventa;

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
