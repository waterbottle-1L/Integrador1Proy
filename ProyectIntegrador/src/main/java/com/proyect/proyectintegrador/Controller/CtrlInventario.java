
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlInventario {
    String SQL_CONSULTA="{CALL obtenerInventario()}"; //{CALL ObtenerInventario()}
    String SQL_ACTUALIZAR="{CALL ActualizarInventario(?, ?, ?, ?, ?, ?)}";
    String SQL_PRODUCTOSINSTOCK="{CALL CargarProductoNoEnInventario()}"; //{CALL ObtenerProductosSinInventario()}
    String SQL_INSERT="{CALL InsertarInventario(?,?,?,?,?,?)}";
    String SQL_ESTADO = "{CALL CambiarEstadoProducto(?,?)}";//Este falta corregir 
    public List<Inventario> cargarInventario() throws SQLException{
        List<Inventario> inventarioLista=new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet rs = callableStatement.executeQuery()){
            
            while (rs.next()) { 
                Inventario inventario=new Inventario();
                inventario.setCod_prod(rs.getLong("cod_producto"));
                inventario.setNombreproducto(rs.getString("nombre_producto"));
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
    
    public void cambiarEstadoProducto(Inventario inventario) throws SQLException{
        Connection conexio = Connect.getConnection();
        try{
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, inventario.getCod_prod());
            callableStatement.setBoolean(2, inventario.getEstado());
            callableStatement.execute();
            
        }catch(SQLException e){
            System.out.print("Error estado" + e);
        }
    }
    int codigos = 0;
    public int obtenerStock(Connection con, Long codigo) throws SQLException {
        String consulta = "SELECT stock FROM inventario WHERE cod_producto = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setLong(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("stock");
                }
            }
        }
        return codigos;
    }
    
    public void agregarInventario(Inventario inventario) throws SQLException {

        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_INSERT);
            callableStatement.setLong(1, inventario.getCod_prod());
            callableStatement.setInt(2, inventario.getStock());
            callableStatement.setInt(3, inventario.getStock_inicial());
            callableStatement.setInt(4, inventario.getStock_maximo());
            callableStatement.setInt(5, inventario.getStock_maximo());
            callableStatement.setBoolean(6, inventario.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "errroorr" + ex);
        }

    }
    
    public void modificarInventario(Inventario inventario)throws SQLException{
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        java.util.Date fechaRegistro = inventario.getFecha_registro();
        try{
            callableStatement = conexio.prepareCall(SQL_ACTUALIZAR);
            callableStatement.setLong(1, inventario.getCod_prod());
            //7=fierro
            callableStatement.setInt(2, inventario.getStock());
            callableStatement.setInt(3, inventario.getStock_inicial());
            callableStatement.setInt(4, inventario.getStock_maximo());
            callableStatement.setInt(5, inventario.getStock_minimo());
            callableStatement.setBoolean(6, inventario.getEstado());//6boolean
            callableStatement.executeUpdate();
        }catch(SQLException e){
            System.out.print("Error estado" + e);
        }
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
}
