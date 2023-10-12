
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CtrCliente {
    
    String SQL_CONSULTA = "{CALL ObtenerCliente()}";
    String SQL_INSERTAR = "{CALL InsertarCliente(?,?,?,?,?,?)}";
    String SQL_ESTADO = "{CALL CambiarEstadoCliente (?,?)}";
    String SQL_ACTUALIZAR = "{CALL ActualizarCliente(?,?,?,?,?,?,?)}";
    
    public List<Cliente> cargarCliente() throws SQLException {
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
    
    public boolean verificarDocumentoExistente(Connection con, String documento) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente WHERE documento = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, documento);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; 
                }
            }
        }
        return false;
    }
    
    public void agregarCliente(Cliente cliente) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try{
            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setString(1, cliente.getNombre());
            callableStatement.setString(2, cliente.getApellido());
            callableStatement.setString(3, cliente.getDocumento());
            callableStatement.setString(4, cliente.getDireccion());
            callableStatement.setString(5, cliente.getTelefono());
            callableStatement.setBoolean(6, cliente.getEstado());
            callableStatement.executeUpdate();
        }catch(SQLException e){
            System.out.print("Error" + e);
        }
    }
    
    public void cambiarEstadoCliente(Cliente cliente) throws SQLException {
        Connection conexio = Connect.getConnection();
        try{
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, cliente.getCodcliente());
            callableStatement.setBoolean(2, cliente.getEstado());
            callableStatement.execute();
        }catch(SQLException e){
             System.out.print("Error estado" + e);
        }
    }
    
    public boolean verificarDocumentoSimilar(Connection con, String documento, long idcliente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente WHERE documento = ? AND cod_cliente!= ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, documento);
            preparedStatement.setLong(2, idcliente);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; 
                }
            }
        }
        return false; 
    }
    
    public void ModificarCliente(Cliente cliente)throws SQLException{
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try{
            callableStatement = conexio.prepareCall(SQL_ACTUALIZAR);
            callableStatement.setLong(1, cliente.getCodcliente());
            callableStatement.setString(2, cliente.getNombre());
            callableStatement.setString(3, cliente.getApellido());
            callableStatement.setString(4, cliente.getDocumento());
            callableStatement.setString(5, cliente.getDireccion());
            callableStatement.setString(6, cliente.getTelefono());
            callableStatement.setBoolean(7, cliente.getEstado());
            callableStatement.executeUpdate();
        }catch(SQLException e){
            System.out.print("Error modificar" + e);
        }
    }
    
    public String obtenerNombreCliente(Connection con, String documento) throws SQLException {
        String consulta = "SELECT nombre FROM cliente WHERE documento = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, documento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   
                    return rs.getString("nombre");
                }
            }
        }

        return null;
    }
    
    public Long obtenercodCliente(Connection con, String nombredoc) throws SQLException {
        String consulta = "select cod_cliente from cliente where concat(nombre,' ',documento) = ?";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombredoc);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   
                    return rs.getLong("cod_cliente");
                }
            }
        }
     
        return null;
    }
    
    public boolean verificarCodigoexisteVenta(Connection con, Long codcliente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Venta WHERE cod_cliente = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setLong(1, codcliente);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; 
                }
            }
        }
        return false;
    }
}
