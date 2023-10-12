
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CtrVenta {
    
    String SQL_CONSULTA = "{CALL ObtenerVentas()}";
    
    public List<Venta> cargarVenta() throws SQLException {
        List<Venta> ventaList = new ArrayList<>();
        try(Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet resultSet = callableStatement.executeQuery()){
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setCodventa(resultSet.getLong("cod_venta"));
                venta.setNombrecliente(resultSet.getString("nombre_cliente"));
                venta.setNombrecomprobante(resultSet.getString("comprobante"));
                venta.setNombreempleado(resultSet.getString("empleado"));
                venta.setMetodo(resultSet.getString("metodo"));
                venta.setFecha(resultSet.getDate("fecha_registro"));
                venta.setValorpago(resultSet.getDouble("valorpagar"));
                venta.setEstado(resultSet.getBoolean("estado"));
                ventaList.add(venta);
            }
        }catch(SQLException e){
            throw e;
        }
        
        return ventaList;
    }
    
}
