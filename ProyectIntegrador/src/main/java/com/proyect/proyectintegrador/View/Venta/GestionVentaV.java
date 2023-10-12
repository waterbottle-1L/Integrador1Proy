
package com.proyect.proyectintegrador.View.Venta;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrVenta;
import com.proyect.proyectintegrador.Entitis.Venta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;


public class GestionVentaV extends org.jdesktop.swingx.JXPanel{

    private boolean canEdit = true;
    private boolean canDelete = true;
    
    public GestionVentaV() {
        initComponents();
        cargarVenta();
        botoneliminar.setEnabled(false);
        Habilitar();
    }
    
    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbventa.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                
                botoneliminar.setEnabled(true);
            } else {
                
                botoneliminar.setEnabled(false);
            }
        });
    }
    
    public class nonEditableTableModel extends DefaultTableModel {

        public nonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void cargarVenta(){
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrVenta ctrventa = new CtrVenta();
            List <Venta> ventas = ctrventa.cargarVenta();
            if(ventas != null && !ventas.isEmpty()){
                Object[] columnNames = {"Codigo", "Cliente", "Comprobante", "Empleado", "Metodo", "Fecha","Total a Pagar"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);
                for(Venta venta : ventas){
                    if(venta.getEstado()){
                        Object[] datos = new Object[7];
                        datos[0] = venta.getCodventa();
                        datos[1] = venta.getNombrecliente();
                        datos[2] = venta.getNombrecomprobante();
                        datos[3] = venta.getNombreempleado();
                        datos[4] = venta.getMetodo();
                        datos[5] = venta.getFecha();
                        datos[6] = venta.getValorpago();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                tbventa.setModel(model);
            }
        }catch(SQLException e){
            System.out.println("Error al cargar venta"+e);
        }
        
        verificaciondatos.setVisible(!datosEncontrados);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbventa = new javax.swing.JTable();
        botoneliminar = new javax.swing.JButton();
        verificaciondatos = new javax.swing.JLabel();

        tbventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbventa);

        botoneliminar.setText("Eliminar");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        verificaciondatos.setText("Sin Datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botoneliminar)
                        .addGap(266, 266, 266)
                        .addComponent(verificaciondatos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificaciondatos)
                    .addComponent(botoneliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
        JOptionPane.showMessageDialog(null, "No se puede Eliminar");
    }//GEN-LAST:event_botoneliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoneliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbventa;
    private javax.swing.JLabel verificaciondatos;
    // End of variables declaration//GEN-END:variables
}
