package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Tipo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrTipo {

    String SQL_CONSULTA = "SELECT cod_tipo_producto, nombre_tipo, estado from tipo;";
    String SQL_INSERTAR = "{CALL InsertarTipo(?,?)}";
    String SQL_ESTADO = "{CALL CambiarEstadoTipo(?,?)}";
    String SQL_ACTUALIZAR = "{CALL ActualizarTipo(?,?,?)}";

    public List<Tipo> cargarTipo() throws SQLException {
        List<Tipo> tipoList = new ArrayList<>();

        try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Tipo tipo = new Tipo();
                tipo.setCodtipo(resultSet.getLong("cod_tipo_producto"));
                tipo.setNombre(resultSet.getString("nombre_tipo"));
                tipo.setEstado(resultSet.getBoolean("estado"));
                tipoList.add(tipo);
            }

        } catch (SQLException e) {
            throw e;
        }

        return tipoList;
    }

    public void agregarTipo(Tipo tip) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setString(1, tip.getNombre());
            callableStatement.setBoolean(2, tip.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.print("Error" + ex);
        }
    }

    public boolean verificarNombreExistente(Connection con, String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tipo WHERE nombre_tipo = ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, el RUC ya existe
                }
            }
        }
        return false; // Si no se encuentra el RUC
    }

    public void cambiarEstadoTipo(Tipo tipo) throws SQLException {
        Connection conexio = Connect.getConnection();
        try {
            CallableStatement callableStatement = conexio.prepareCall(SQL_ESTADO);
            callableStatement.setLong(1, tipo.getCodtipo());
            callableStatement.setBoolean(2, tipo.getEstado());
            callableStatement.execute();
        } catch (SQLException e) {

            System.out.print("Error estado" + e);

        }
    }

    //Metodo usado para verificar nombre repetido en la tabla tipo
    public boolean verificarnombreSimilar(Connection con, String nombre, long idtipo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM tipo WHERE nombre_tipo = ? AND cod_tipo_producto != ? AND estado = 1";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setLong(2, idtipo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Si count > 0, un RUC similar ya existe, excluyendo el RUC específico
                }
            }
        }
        return false; // Si no se encuentra un RUC similar
    }

    public void ModificarTipo(Tipo tipo) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conexio.prepareCall(SQL_ACTUALIZAR);
            callableStatement.setLong(1, tipo.getCodtipo());
            callableStatement.setString(2, tipo.getNombre());
            callableStatement.setBoolean(3, tipo.getEstado());
            callableStatement.executeUpdate();
        } catch (SQLException e) {

            System.out.print("Error estado" + e);

        }
    }
}
