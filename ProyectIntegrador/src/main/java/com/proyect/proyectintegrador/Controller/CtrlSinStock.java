/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.ProductoSinStock;
import com.proyect.proyectintegrador.Entitis.Proveedor;
import com.proyect.proyectintegrador.View.Inventario.ProductoSinStockV;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CtrlSinStock {
    private PreparedStatement PS;
    private ResultSet RS;
    private final Connect CN;
    private DefaultTableModel DT;
    String SQL_CONSULTA="{CALL ObtenerInventario()}";
    String SQL_PRODUCTOSINSTOCK="{CALL ObtenerProductosSinInventario()}";
    String SQL_INSERT="{CALL InsertarInventario(?,?,?,?,?,?)}";
    public CtrlSinStock(){
        PS = null;
        CN = new Connect();
    }
    
}
