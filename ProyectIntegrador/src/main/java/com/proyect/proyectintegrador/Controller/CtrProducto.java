package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrProducto {

    String SQL_CONSULTA = "{CALL ObtenerProductos()}";
    String SQL_INSERTAR = "{}";

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
    
    

}
