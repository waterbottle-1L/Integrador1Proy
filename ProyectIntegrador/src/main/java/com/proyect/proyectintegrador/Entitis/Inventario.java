
package com.proyect.proyectintegrador.Entitis;

import java.util.Date;


public class Inventario {
    private Long cod_prod;
    private int stock;
    private int stock_inicial;
    private int stock_maximo;
    private int stock_minimo;
    private Date fecha_registro;
    private boolean estado;
    
    private String nombreproducto;
    private String productoSinStock;

    public String getProductoSinStock() {
        return productoSinStock;
    }

    public void setProductoSinStock(String productoSinStock) {
        this.productoSinStock = productoSinStock;
    }
    
    
    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }
    
    

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    

    public Long getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(Long cod_prod) {
        this.cod_prod = cod_prod;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public int getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(int stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
