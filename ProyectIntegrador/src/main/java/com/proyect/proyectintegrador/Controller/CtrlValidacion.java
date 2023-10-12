package com.proyect.proyectintegrador.Controller;

public class CtrlValidacion {

    public boolean validarRuc(String datos) {
        return datos.matches("^\\d{11}$");
    }

    public boolean validarDni(String datos) {
        return datos.matches("^\\d{8}$");
    }

    public boolean validarTelefono(String datos) {
        return datos.matches("^\\d{9}$");
    }

    public boolean validarNumeros(String datos) {
        return datos.matches("^[0-9.]+$");
    }

    public boolean validarNumerosenteros(String datos) {
        return datos.matches("^[0-9]+$");
    }

    public boolean validarCadenaSinComaPuntoYComa(String cadena) {
        return !cadena.matches(".*[;,].*");
    }

    public boolean validarLetras(String datos) {
        return datos.matches("^[A-Za-z]+$");
    }
}
