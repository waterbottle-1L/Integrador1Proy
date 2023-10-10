
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrlInventario {
    String SQL_CONSULTA="{CALL ObtenerInventario()}";
    String SQL_ACTUALIZAR="{CALL ActualizarDatosProducto(?, ?, ?, ?, ?, ?, ?)}";
    
    public List<Inventario> cargarInventario() throws SQLException{
        List<Inventario> inventarioLista=new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet rs = callableStatement.executeQuery()){
            
            while (rs.next()) {
                Inventario inventario=new Inventario();
                inventario.setCod_prod(rs.getLong("cod_producto"));
                inventario.setStock(rs.getInt("stock"));
                inventario.setStock_inicial(rs.getInt("stock_inicial"));
                inventario.setStock_maximo(rs.getInt("stock_maximo"));
                inventario.setStock_minimo(rs.getInt("stock_minimo"));
                inventario.setFecha_registro(rs.getDate("fecha_registro"));
                inventario.setEstado(rs.getBoolean("estado"));
                inventarioLista.add(inventario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventarioLista;
    }
}
