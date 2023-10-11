
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.MetodoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CtrMetodoPago {
    
    String SQL_CONSULTA = "SELECT cod_metodo_pago, metodopago, estado from metodo_pago;";
    
    public List<MetodoPago> cargarMetodoPago() throws SQLException {
        List<MetodoPago> metodopagoList = new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                MetodoPago metodopago = new MetodoPago();
                metodopago.setCodmetodopago(resultSet.getLong("cod_metodo_pago"));
                metodopago.setMetodopago(resultSet.getString("metodopago"));
                metodopago.setEstado(resultSet.getBoolean("estado"));
                metodopagoList.add(metodopago);
            }
        }catch(SQLException e){
            throw e;
        }
        return metodopagoList;
    }
    
    public Long obtenercodMetodoPago(Connection con, String nombre) throws SQLException {
        String consulta = "SELECT cod_metodo_pago FROM metodo_pago WHERE metodopago = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra una fila con el nombre de la marca, devuelve su ID
                    return rs.getLong("cod_metodo_pago");
                }
            }
        }
        // Si no se encontró ninguna coincidencia, puedes manejarlo como desees
        // Por ejemplo, lanzar una excepción o devolver un valor predeterminado
        return null;
    }
    
}
