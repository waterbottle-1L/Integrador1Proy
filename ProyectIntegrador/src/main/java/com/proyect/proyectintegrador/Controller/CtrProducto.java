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
    String SQL_ACTUALIZAR = "{CALL ActualizarProducto(?,?,?,?,?,?,?,?)}";

    public List<Producto> cargarProductos() throws SQLException {
        List<Producto> productoList = new ArrayList<>();

        try (Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet resultSet = callableStatement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setCodProducto(resultSet.getLong("cod_producto"));
                producto.setNombreMarca(resultSet.getString("nombre_marca"));
                producto.setNombreProveedor(resultSet.getString("nombre_proveedor"));
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
    
    public boolean verificarnombreSimilar(Connection con, String nombre, long idproducto) throws SQLException {
        String sql = "SELECT COUNT(*) FROM producto WHERE nombre = ? AND cod_producto != ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setLong(2, idproducto);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, un RUC similar ya existe, excluyendo el RUC específico
                }
            }
        }
        return false; 
    }
    
    public void modificarProducto(Producto producto)throws SQLException{
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try{
            callableStatement = conexio.prepareCall(SQL_ACTUALIZAR);
            callableStatement.setLong(1, producto.getCodProducto());
            callableStatement.setLong(2, producto.getCodMarca());
            callableStatement.setLong(3, producto.getCodProveedor());
            callableStatement.setLong(4, producto.getCodTipo());
            callableStatement.setString(5, producto.getNombre());
            callableStatement.setString(6, producto.getDescripcion());
            callableStatement.setDouble(7, producto.getPrecio());
            callableStatement.setBoolean(8, producto.getEstado());
            callableStatement.executeUpdate();
        }catch(SQLException e){
            System.out.print("Error estado" + e);
        }
    }
    
    
    //Metodo para que me retorne el nombre segun el codigo
    public Long obtenerIdTipoPorNombre(Connection con, String codproducto) throws SQLException {
        String consulta = "SELECT nombre FROM producto WHERE cod_producto = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, codproducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("cod_tipo_producto");
                }
            }
        }
        
        return null;
    }
    
    public Long obtenerIdproductoNombre(Connection con, String nombre) throws SQLException {
        String consulta = "SELECT cod_producto FROM producto WHERE nombre = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("cod_producto");
                }
            }
        }
        
        return null;
    }
    
    double prec = 0.0;
    public double obtenerprecioproducto(Connection con, String nombre) throws SQLException {
        String consulta = "SELECT precio FROM producto WHERE nombre = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("precio");
                }
            }
        }
        
        return prec;
    }
    
    public boolean verificarCodigoexisteInventario(Connection con, Long codproducto) throws SQLException {
        String sql = "SELECT COUNT(*) FROM inventario WHERE cod_producto = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setLong(1, codproducto);
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
