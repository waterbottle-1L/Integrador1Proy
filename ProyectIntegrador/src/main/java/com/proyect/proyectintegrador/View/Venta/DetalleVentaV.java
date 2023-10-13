package com.proyect.proyectintegrador.View.Venta;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrDetalleVenta;
import com.proyect.proyectintegrador.Entitis.DetalleVenta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetalleVentaV extends org.jdesktop.swingx.JXPanel {

    public DetalleVentaV() {
        initComponents();
        cargartabla();
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

    private void cargartabla() {
        try (Connection con = Connect.getConnection()) {
            CtrDetalleVenta ctrdeta = new CtrDetalleVenta();
            List<DetalleVenta> detalles = ctrdeta.tablaDetalleVenta();
            if (detalles != null && !detalles.isEmpty()) {
                Object[] columnNames = {"Codigo", "Producto", "Codigo Venta","Cantidad", "Precio Unitario", "Sub Total", "IGV", "Total a Pagar"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);
                for(DetalleVenta detalle : detalles){
                    if(detalle.getEstado1()){
                        Object[] datos = new Object[8];
                        datos[0] = detalle.getCoddetalleventa();
                        datos[1] = detalle.getNombre();
                        datos[2] = detalle.getCodventa();
                        datos[3] = detalle.getCantidad();
                        datos[4] = detalle.getPreciounitario();
                        datos[5] = detalle.getSubtotal();
                        datos[6] = detalle.getIgv();
                        datos[7] = detalle.getTotalapagar();
                        model.addRow(datos);
                    }
                }
                tbdetalleventa.setModel(model);
            }
        } catch (SQLException e) {
             System.out.println("Error al cargar la tabla detalle venta"+e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetalleventa = new javax.swing.JTable();

        tbdetalleventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbdetalleventa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdetalleventa;
    // End of variables declaration//GEN-END:variables
}
