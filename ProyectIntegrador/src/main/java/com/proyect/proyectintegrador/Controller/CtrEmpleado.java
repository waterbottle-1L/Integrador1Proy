package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrEmpleado {

    String SQL_CONSULTA = "{CALL ObtenerEmpleado()}";
    String SQL_INSERTAR = "{CALL InsertarEmpleado(?,?,?,?,?,?,?,?,?)}";
    
    public Long obtenerCodEmpleado(Connection con, String nombreempleado) throws SQLException {
        String consulta = "SELECT cod_empleado FROM empleado WHERE nombre = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setString(1, nombreempleado);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   
                    return rs.getLong("cod_empleado");
                }
            }
        }
        return null;
    }
    long codrol = 3;
    public Long obtenerCodRol(Connection con, Long nombreTipo) throws SQLException {
        String consulta = "SELECT rol_id FROM usuario_rol WHERE empleado_id = ? AND estado = 1";
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setLong(1, nombreTipo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    
                    return rs.getLong("rol_id");
                }
            }
        }
        return codrol ;
    }
    
    public List<Empleado> cargarEmpleado() throws SQLException {
       List<Empleado> empleadoList = new ArrayList<>(); 
       try (Connection connection = Connect.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA); 
             ResultSet resultSet = preparedStatement.executeQuery()) {
           
           while (resultSet.next()) {
               Empleado empleado = new Empleado();
               empleado.setCodempleado(resultSet.getLong("cod_empleado"));
               empleado.setNombre(resultSet.getString("nombre"));
               empleado.setApellido(resultSet.getString("apellido"));
               empleado.setDireccion(resultSet.getString("direccion"));
               empleado.setDocumento(resultSet.getString("documento"));
               empleado.setFechanacimiento(resultSet.getDate("fecha_nacimiento"));
               empleado.setTelefono(resultSet.getString("telefono"));
               empleado.setEmail(resultSet.getString("email"));
               empleado.setPassword(resultSet.getString("password"));
               empleado.setEstado(resultSet.getBoolean("estado"));
               empleadoList.add(empleado);
           }
       }catch(SQLException e){
           throw e;
       }
       
       return empleadoList;
    }
    
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        Connection conexio = Connect.getConnection();
        CallableStatement callableStatement = null;
        try{
            callableStatement = conexio.prepareCall(SQL_INSERTAR);
            callableStatement.setString(1, empleado.getNombre());
            callableStatement.setString(2, empleado.getApellido());
            callableStatement.setString(3, empleado.getDireccion());
            callableStatement.setString(4, empleado.getDocumento());
            callableStatement.setDate(5, (Date) empleado.getFechanacimiento());
            callableStatement.setString(6, empleado.getTelefono());
            callableStatement.setString(7, empleado.getEmail());
            callableStatement.setString(8, empleado.getPassword());
            callableStatement.setBoolean(9, empleado.getEstado());
            callableStatement.executeUpdate();
        }catch(SQLException e){
             System.out.print("Error en empleado" + e);
        }
        
    }
}
