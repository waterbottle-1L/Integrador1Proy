package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CtrlUsuario {

    public boolean inicioSesionUser(usuario objeto) {
        boolean respuesta = false;
        Connection cn = Connect.getConnection();
        String sql = "select  nombre, password from empleado where nombre = '" + objeto.getNombre() + "' and password = '" + objeto.getPassword() + "' AND estado = 1";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;

            }
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }

    public long obtenerCodEmpleadoPorNombreYPassword(String nombre, String password) throws SQLException {
        long codEmpleado = -1; // Valor predeterminado si no se encuentra el empleado

        // Realizar una consulta SQL para buscar el código de empleado en función del nombre y la contraseña
        String sql = "SELECT cod_empleado FROM empleado WHERE nombre = ? AND password = ?";
        try (Connection con = Connect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    codEmpleado = rs.getLong("cod_empleado");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el código de empleado: " + e);
        }

        return codEmpleado;
    }

}
