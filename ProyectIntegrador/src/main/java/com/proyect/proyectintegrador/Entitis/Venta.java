
package com.proyect.proyectintegrador.Entitis;

import java.util.Date;

public class Venta {
    
    private Long codventa;
    private Long codcliente;
    private Long codcomprobbante;
    private Long empleado;
    private Long metodopago;
    private Date fecha;
    private Double valorpago;
    private Boolean estado;
    
    private String nombrecliente;
    private String nombrecomprobante;
    private String nombreempleado;
    private String metodo;

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNombrecomprobante() {
        return nombrecomprobante;
    }

    public void setNombrecomprobante(String nombrecomprobante) {
        this.nombrecomprobante = nombrecomprobante;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    
    
    public Long getCodventa() {
        return codventa;
    }

    public void setCodventa(Long codventa) {
        this.codventa = codventa;
    }

    public Long getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Long codcliente) {
        this.codcliente = codcliente;
    }

    public Long getCodcomprobbante() {
        return codcomprobbante;
    }

    public void setCodcomprobbante(Long codcomprobbante) {
        this.codcomprobbante = codcomprobbante;
    }

    public Long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }

    public Long getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(Long metodopago) {
        this.metodopago = metodopago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValorpago() {
        return valorpago;
    }

    public void setValorpago(Double valorpago) {
        this.valorpago = valorpago;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
