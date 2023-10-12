package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Proveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrProveedor {

    String SQL_INSERTAR = "{CALL InsertarProveedor(?,?,?,?,?)}";
    String SQL_CONSULTA = "select cod_proveedor, nombre, ruc, telefono, direccion, estado from proveedor;";
    String SQL_ESTADO = "{CALL CambiarEstadoProveedor(?,?)}";
    String SQL_ACTUALIZAR = "{CALL ActualizarProveedor(?,?,?,?,?,?)}";

    public List<Proveedor> cargarProveedor() throws SQLException {
        List<Proveedor> proveedorList = new ArrayList<>();
        try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setCodproveedor(resultSet.getLong("cod_proveedor"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setRuc(resultSet.getString("ruc"));
                proveedor.setTelefono(resultSet.getString("telefono"));
                proveedor.setDireccion(resultSet.getString("direccion"));
                proveedor.setEstado(resultSet.getBoolean("estado"));
                proveedorList.add(proveedor);
            }

        } catch (SQLException e) {
            // Maneja la excepción adecuadamente, ya sea lanzándola nuevamente o registrándola
            throw e;
        }
        return proveedorList;
    }

    public void agregarProveedor(Proveedor prov) throws SQLException {

        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setString(1, prov.getNombre());
            callableStatement.setString(2, prov.getRuc());
            callableStatement.setString(3, prov.getTelefono());
            callableStatement.setString(4, prov.getDireccion());
            callableStatement.setBoolean(5, prov.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "errroorr" + ex);
        }

    }
    
    // Metodo utilizado para insertar proveedor
    public boolean verificarRucExistente(Connection con, String ruc) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Proveedor WHERE RUC = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, ruc);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, el RUC ya existe
                }
            }
        }
        return false; // Si no se encuentra el RUC
    }
    
    // Metodo utilizado para modificar proveedor
    public boolean verificarRucSimilar(Connection con, String ruc, long idProveedor) throws SQLException {
    String sql = "SELECT COUNT(*) FROM Proveedor WHERE ruc = ? AND cod_proveedor != ? AND estado = 1";
    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        preparedStatement.setString(1, ruc);
        preparedStatement.setLong(2, idProveedor);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Si count > 0, un RUC similar ya existe, excluyendo el RUC específico
            }
        }
    }
    return false; // Si no se encuentra un RUC similar
}
    
    public void Cambiarestadoproveedor(Proveedor proveedor){
        Connection conexio = Connect.getConnection();
        
         try {
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, proveedor.getCodproveedor());
            callableStatement.setBoolean(2, proveedor.getEstado());

            callableStatement.execute();
        }catch(SQLException e){
            System.out.print("Error estado"+e);
        }
        
    }
    
    public void ModificarProveedor(Proveedor prov) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        
        try{
           callableStatement = conexio.prepareCall(SQL_ACTUALIZAR); 
           callableStatement.setLong(1, prov.getCodproveedor());
           callableStatement.setString(2, prov.getNombre());
           callableStatement.setString(3, prov.getRuc());
           callableStatement.setString(4, prov.getTelefono());
           callableStatement.setString(5, prov.getDireccion());
           callableStatement.setBoolean(6, prov.getEstado());
           callableStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "errroorr" + e);
        }
    }
    
    public Long obtenerIdProveedorPorNombre(Connection con, String nombreProveedor) throws SQLException {
        String consulta = "SELECT cod_proveedor FROM proveedor WHERE nombre = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombreProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra una fila con el nombre de la marca, devuelve su ID
                    return rs.getLong("cod_proveedor");
                }
            }
        }
        // Si no se encontró ninguna coincidencia, puedes manejarlo como desees
        // Por ejemplo, lanzar una excepción o devolver un valor predeterminado
        return null;
    }
    
    public boolean verificarCodigoexisteProducto(Connection con, Long codproveedor) throws SQLException {
        String sql = "SELECT COUNT(*) FROM producto WHERE cod_proveedor = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setLong(1, codproveedor);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, el RUC ya existe
                }
            }
        }
        return false;
    }

}
