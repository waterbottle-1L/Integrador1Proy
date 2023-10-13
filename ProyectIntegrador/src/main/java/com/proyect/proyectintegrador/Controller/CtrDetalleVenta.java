package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.DetalleVenta;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrDetalleVenta {

    String SQL_RESTAR = "{CALL RestarStock(?,?)}";
    String SQL_SUMAR = "{CALL SumarStock(?,?)}";
    String SQL_INSERTAR = "{CALL InsertarVenta(?,?,?,?,?,?)}";
    String SQL_INSERTARDETALLE = "{CALL InsertarDetalleVenta(?,?,?,?,?,?,?,?)}";
    String SQL_CONSULTA = "{CALL ObtenerDetallVenta()}";
    
    public List<DetalleVenta> tablaDetalleVenta() throws SQLException{
        List<DetalleVenta> detalleList = new ArrayList<>();
        
        try(Connection connection = Connect.getConnection(); 
             CallableStatement callableStatement = connection.prepareCall(SQL_CONSULTA); 
             ResultSet resultSet = callableStatement.executeQuery()){
            while (resultSet.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setCoddetalleventa(resultSet.getLong("cod_detalle_venta"));
                detalle.setNombre(resultSet.getString("nombre_producto"));
                detalle.setCodventa(resultSet.getLong("cod_venta"));
                detalle.setCantidad(resultSet.getInt("cantidad"));
                detalle.setPreciounitario(resultSet.getDouble("precionunitario"));
                detalle.setSubtotal(resultSet.getDouble("subtotal"));
                detalle.setIgv(resultSet.getDouble("igv"));
                detalle.setTotalapagar(resultSet.getDouble("tatalpagar"));
                detalle.setEstado1(resultSet.getBoolean("estado"));
                detalleList.add(detalle);
            }
        }catch(SQLException e){
            throw e;
        }
        return detalleList;
    }
    
    public void agregaDetalleVenta(DetalleVenta detalle) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try{
            callableStatement = conexio.prepareCall(SQL_INSERTARDETALLE);
            callableStatement.setLong(1, detalle.getCodproducto());
            callableStatement.setLong(2, detalle.getCodventa());
            callableStatement.setInt(3, detalle.getCantidad());
            callableStatement.setDouble(4, detalle.getPreciounitario());
            callableStatement.setDouble(5, detalle.getSubtotal());
            callableStatement.setDouble(6, detalle.getIgv());
            callableStatement.setDouble(7, detalle.getTotalapagar());
            callableStatement.setBoolean(8, detalle.getEstado1());
            callableStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al insertar"+e);
        }
    }
    
    

    public void agregaVenta(Venta venta) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setLong(1, venta.getCodcliente());
            callableStatement.setLong(2, venta.getCodcomprobbante());
            callableStatement.setLong(3, venta.getEmpleado());
            callableStatement.setLong(4, venta.getMetodopago());
            callableStatement.setDouble(5, venta.getValorpago());
            callableStatement.setBoolean(6, venta.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error" + e);
        }
    }

    public void restarTipo(Inventario inventario) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_RESTAR);
            callableStatement.setLong(1, inventario.getCod_prod());
            callableStatement.setInt(2, inventario.getStock());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error" + e);
        }

    }

    public void sumarTipo(Inventario inventario) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_SUMAR);
            callableStatement.setLong(1, inventario.getCod_prod());
            callableStatement.setInt(2, inventario.getStock());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error" + e);
        }
    }

    public Long obtenerCodVenta(Connection con) throws SQLException {
        String consulta = "SELECT cod_venta FROM venta ORDER BY fecha_registro DESC LIMIT 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("cod_venta");
                }
            }
        }
        
        return null;
    }

}
