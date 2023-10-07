package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrProducto {

    String SQL_CONSULTA = "{CALL ObtenerProductos()}";
    String SQL_INSERTAR = "{CALL InsertarProducto(?,?,?,?,?,?,?)}";
    String SQL_ESTADO = "{CALL CambiarEstadoProducto(?,?)}";

    public List<Producto> cargarProductos() throws SQLException {
        List<Producto> productoList = new ArrayList<>();

        try (Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet resultSet = callableStatement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setCodProducto(resultSet.getLong("cod_producto"));
                producto.setNombreMarca(resultSet.getString("nombre_marca"));
                producto.setNombreProveedor(resultSet.getString("nombre"));
                producto.setNombreTipo(resultSet.getString("nombre_tipo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setFechaRegistro(resultSet.getDate("fecha_registro"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setEstado(resultSet.getBoolean("estado"));
                productoList.add(producto);
            }

        } catch (SQLException e) {
            throw e;
        }

        return productoList;
    }
    
    public boolean verificarNombreExistente(Connection con, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM producto WHERE nombre = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, el RUC ya existe
                }
            }
        }
        return false;
    }
    
    
    public void agregarProducto(Producto producto) throws SQLException {
         Connection conexio = Connect.getConnection();
         CallableStatement callableStatement = null;
         try{
             callableStatement = conexio.prepareCall(SQL_INSERTAR);
             callableStatement.setLong(1, producto.getCodMarca());
             callableStatement.setLong(2, producto.getCodProveedor());
             callableStatement.setLong(3, producto.getCodTipo());
             callableStatement.setString(4, producto.getNombre());
             callableStatement.setString(5, producto.getDescripcion());
             callableStatement.setDouble(6, producto.getPrecio());
             callableStatement.setBoolean(7, producto.getEstado());
             callableStatement.executeUpdate();
             
         }catch(SQLException e){
             System.out.println("Error"+e);
         }
    }
    
    
    public void cambiarEstadoProducto(Producto producto) throws SQLException{
        Connection conexio = Connect.getConnection();
        try{
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, producto.getCodProducto());
            callableStatement.setBoolean(2, producto.getEstado());
            callableStatement.execute();
            
        }catch(SQLException e){
            System.out.print("Error estado" + e);
        }
    }
    

}
