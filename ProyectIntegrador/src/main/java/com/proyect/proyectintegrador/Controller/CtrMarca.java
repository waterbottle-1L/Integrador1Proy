package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrMarca {
    
    String SQL_CONSULTA ="SELECT cod_marca, nombre_marca, estado from marca;";
    String SQL_INSERTAR = "{CALL InsertarMarca(?,?)}";
    
    public List<Marca> cargarMarca() throws SQLException{
        List <Marca> marcaList = new ArrayList<>() ;

        try(Connection connection = Connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTA);
            ResultSet resultSet = preparedStatement.executeQuery()){
            
            while(resultSet.next()){
                Marca marca = new Marca();
                marca.setCodmarca(resultSet.getLong("cod_marca"));
                marca.setNombre(resultSet.getString("nombre_marca"));
                marca.setEstado(resultSet.getBoolean("estado"));
                marcaList.add(marca);
            }
            
        }catch(SQLException e){
            throw e;
        }
        
        return marcaList;
    }
}
