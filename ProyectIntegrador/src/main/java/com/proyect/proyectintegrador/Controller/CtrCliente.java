
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CtrCliente {
    
    String SQL_CONSULTA = "{CALL ObtenerCliente()}";
    
    public List<Cliente> cargarProductos() throws SQLException {
         List<Cliente> clienteList = new ArrayList<>();
         try(Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet resultSet = callableStatement.executeQuery()){
             while (resultSet.next()) {
                 Cliente cliente = new Cliente ();
                 cliente.setCodcliente(resultSet.getLong("cod_cliente"));
                 cliente.setNombre(resultSet.getString("nombre"));
                 cliente.setApellido(resultSet.getString("apellido"));
                 cliente.setDocumento(resultSet.getString("documento"));
                 cliente.setDireccion(resultSet.getString("direccion"));
                 cliente.setTelefono(resultSet.getString("telefono"));
                 cliente.setEstado(resultSet.getBoolean("estado"));
                 clienteList.add(cliente);
             }
         }catch(SQLException e){
             throw e;
         }
         
         return clienteList;
    }
}
