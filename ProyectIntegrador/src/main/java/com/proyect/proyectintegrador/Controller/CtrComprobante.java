
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Comprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CtrComprobante {
    
    String SQL_CONSULTA = "SELECT cod_comprobante, comprobante, estado from comprobante;";
    
    public List<Comprobante> cargarComprobante() throws SQLException {
        List<Comprobante> comprobanteList = new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Comprobante comprobante = new Comprobante();
                comprobante.setCodcomprobante(resultSet.getLong("cod_comprobante"));
                comprobante.setComprobante(resultSet.getString("comprobante"));
                comprobante.setEstado(resultSet.getBoolean("estado"));
                comprobanteList.add(comprobante);
            }
        }catch(SQLException e){
            System.out.println("Error "+ e);
        }
        
        return comprobanteList;
    }
    
}
