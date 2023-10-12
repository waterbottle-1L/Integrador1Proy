package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Marca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrMarca {

    String SQL_CONSULTA = "SELECT cod_marca, nombre_marca, estado from marca;";
    String SQL_INSERTAR = "{CALL InsertarMarca(?,?)}";
    String SQL_ESTADO = "{CALL CambiarEstadoMarca(?,?)}";
    String SQL_ACTUALIZAR = "{CALL ActualizarMarca(?,?,?)}";

    public List<Marca> cargarMarca() throws SQLException {
        List<Marca> marcaList = new ArrayList<>();

        try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Marca marca = new Marca();
                marca.setCodmarca(resultSet.getLong("cod_marca"));
                marca.setNombre(resultSet.getString("nombre_marca"));
                marca.setEstado(resultSet.getBoolean("estado"));
                marcaList.add(marca);
            }

        } catch (SQLException e) {
            throw e;
        }

        return marcaList;
    }
    
    public boolean verificarNombreExistente(Connection con, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM marca WHERE nombre_marca = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; 
                }
            }
        }
        return false;
    }

    public void agregarMarca(Marca marc) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {

            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setString(1, marc.getNombre());
            callableStatement.setBoolean(2, marc.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.print("Error" + ex);
        }
    }

    public void cambiarEstadoMarca(Marca marca) throws SQLException {
        Connection conexio = Connect.getConnection();
        try {
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, marca.getCodmarca());
            callableStatement.setBoolean(2, marca.getEstado());
            callableStatement.execute();
        } catch (SQLException e) {

            System.out.print("Error estado" + e);

        }
    }
    
    public boolean verificarnombreSimilar(Connection con, String nombre, long idmarca) throws SQLException {
        String sql = "SELECT COUNT(*) FROM marca WHERE nombre_marca = ? AND cod_marca != ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setLong(2, idmarca);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; 
                }
            }
        }
        return false; 
    }

    public void ModificarMarca(Marca marca) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_ACTUALIZAR);
            callableStatement.setLong(1, marca.getCodmarca());
            callableStatement.setString(2, marca.getNombre());
            callableStatement.setBoolean(3, marca.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException e) {

            System.out.print("Error estado" + e);

        }
    }

    public Long obtenerIdMarcaPorNombre(Connection con, String nombreMarca) throws SQLException {
        String consulta = "SELECT cod_marca FROM marca WHERE nombre_marca = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombreMarca);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("cod_marca");
                }
            }
        }
        return null;
    }
    
    public boolean verificarCodigoexisteProducto(Connection con, Long codmarca) throws SQLException {
        String sql = "SELECT COUNT(*) FROM producto WHERE cod_marca = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setLong(1, codmarca);
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
