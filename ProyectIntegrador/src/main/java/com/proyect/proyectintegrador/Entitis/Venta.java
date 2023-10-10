
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
