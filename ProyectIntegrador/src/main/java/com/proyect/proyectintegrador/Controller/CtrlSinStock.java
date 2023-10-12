
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.ProductoSinStock;
import com.proyect.proyectintegrador.Entitis.Proveedor;
import com.proyect.proyectintegrador.View.Inventario.ProductoSinStockV;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CtrlSinStock {
    String SQL_PRODUCTOSINSTOCK="{CALL CargarProductosNoEnInventario()}";
    String SQL_INSERT="{CALL InsertarInventario(?,?,?,?,?,?)}";
    public List<ProductoSinStock> cargarInventario() throws SQLException{
        List<ProductoSinStock> inventarioLista=new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_PRODUCTOSINSTOCK); 
             ResultSet rs = callableStatement.executeQuery()){
            
            while (rs.next()) { 
                ProductoSinStock inventario=new ProductoSinStock();
                inventario.setCodprodsinstock(rs.getLong("cod_producto"));
                inventario.setNombreproductoSinStock(rs.getString("nombre"));
                
                inventarioLista.add(inventario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventarioLista;
    
    }
    public void agregarStock(Inventario inventario) throws SQLException {
         Connection conexio = Connect.getConnection();
         CallableStatement callableStatement = null;
         try{
             callableStatement = conexio.prepareCall(SQL_INSERT);
             callableStatement.setLong(1, inventario.getCod_prod());
             callableStatement.setInt(2, inventario.getStock());
             callableStatement.setInt(3, inventario.getStock_inicial());
             callableStatement.setInt(4, inventario.getStock_maximo());
             callableStatement.setInt(5, inventario.getStock_minimo());
             callableStatement.setBoolean(6, inventario.getEstado());
             callableStatement.executeUpdate();
             
         }catch(SQLException e){
             System.out.println("Error"+e);
         }
    }
    
    
}
