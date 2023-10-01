package com.proyect.proyectintegrador.Entitis;

public class Proveedor {

    private Long codproveedor;
    private String nombre;
    private String ruc;
    private String telefono;
    private String direccion;
    private Boolean estado;

    public Long getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(Long codproveedor) {
        this.codproveedor = codproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
}
