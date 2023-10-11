/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.proyectintegrador.Controller;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Entitis.ProductoSinStock;
import com.proyect.proyectintegrador.View.Inventario.ProductoSinStockV;
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
    String SQL_INSERT="{}";
    public CtrlSinStock(){
        PS = null;
        CN = new Connect();
    }
    private DefaultTableModel setTitulosEntrada(){
        DT = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        DT.addColumn("N° de Factura");
        DT.addColumn("Fecha");
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
        return DT;
    }
    
    public DefaultTableModel getDatosEntradas(){
        try {
            setTitulosEntrada();
            PS = CN.getConnection().prepareStatement(SQL_CONSULTA);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while(RS.next()){
                fila[0] = RS.getLong(1);
                fila[1] = RS.getInt(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getDate(6);
                
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos."+e.getMessage());
        } finally{
            PS = null;
            RS = null;
        }
        return DT;
    }
    
    public int registrarEntrada(Long cod_prod,int stock,int stock_inicial, int stock_maximo,int stock_minimo,Date fecha_registro, boolean estado){
        int res=0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setLong(1, cod_prod);
            PS.setInt(2, stock);
            PS.setInt(3, stock_inicial);
            PS.setInt(4, stock_maximo);
            PS.setInt(5, stock_minimo);
            PS.setDate(6, fecha_registro);
            res = PS.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Entrada realizada con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la entrada.");
            System.err.println("Error al registrar la entrada." +e.getMessage());
        } finally{
            PS = null;
        }
        return res;
    }
}
