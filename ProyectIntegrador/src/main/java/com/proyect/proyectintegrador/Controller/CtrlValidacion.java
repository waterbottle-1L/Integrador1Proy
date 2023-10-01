package com.proyect.proyectintegrador.Controller;

public class CtrlValidacion {

    public boolean validarRuc(String datos) {
        return datos.matches("^\\d{11}$");
    }

    public boolean validarTelefono(String datos) {
        return datos.matches("^\\d{9}$");
    }

}
