
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
    
}
