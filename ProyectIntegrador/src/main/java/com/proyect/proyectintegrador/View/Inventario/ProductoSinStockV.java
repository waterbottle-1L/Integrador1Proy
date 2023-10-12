
package com.proyect.proyectintegrador.View.Inventario;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Controller.CtrlInventario;
import com.proyect.proyectintegrador.Controller.CtrlSinStock;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.Producto;
import com.proyect.proyectintegrador.Entitis.ProductoSinStock;
import com.proyect.proyectintegrador.View.Producto.ProductoV;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductoSinStockV extends javax.swing.JPanel {

    public ProductoSinStockV() {
        initComponents();
        cargarProducto();
        agregarStock.pack();
        agregarStock.setLocationRelativeTo(this);
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
    //Arreglar si se puede
    private void cargarProducto() {
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrlSinStock ctrnostock = new CtrlSinStock();
            List<ProductoSinStock> inventarios = ctrnostock.cargarInventario();
            if (inventarios != null && !inventarios.isEmpty()) {
                Object[] columnNames = { "Codigo","Nombre"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);

                for (ProductoSinStock inventario : inventarios) {
                        Object[] datos = new Object[2];
                        datos[0] = inventario.getCodprodsinstock();
                        datos[1] = inventario.getNombreproductoSinStock();
                        model.addRow(datos);
                        datosEncontrados = true;
                    
                }
                tbsinstock.setModel(model);

            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la tabla productos" + e);
        }

        verificaciondatos.setVisible(!datosEncontrados);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarStock = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        guardarNuevoStockButton = new javax.swing.JButton();
        txtproducto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codProductoField = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsinstock = new javax.swing.JTable();
        verificaciondatos = new javax.swing.JLabel();
        windowagregarStock = new javax.swing.JButton();

        jLabel12.setText("Stock inicial");

        jLabel13.setText("Stock maximo");

        jLabel1.setText("Cod. Producto");

        jLabel14.setText("Stock minimo");

        guardarNuevoStockButton.setText("Guardar");
        guardarNuevoStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNuevoStockButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Stock");

        jLabel2.setText("Nuevo Stock");

        javax.swing.GroupLayout agregarStockLayout = new javax.swing.GroupLayout(agregarStock.getContentPane());
        agregarStock.getContentPane().setLayout(agregarStockLayout);
        agregarStockLayout.setHorizontalGroup(
            agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarStockLayout.createSequentialGroup()
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarStockLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(guardarNuevoStockButton))
                    .addGroup(agregarStockLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGroup(agregarStockLayout.createSequentialGroup()
                                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12))
                                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(agregarStockLayout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarStockLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarStockLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        agregarStockLayout.setVerticalGroup(
            agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addComponent(guardarNuevoStockButton)
                .addGap(15, 15, 15))
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Productos sin stock");

        tbsinstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbsinstock);

        verificaciondatos.setText("Sindatos");

        windowagregarStock.setText("Agregar");
        windowagregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowagregarStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(windowagregarStock)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(verificaciondatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(verificaciondatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(windowagregarStock))
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void windowagregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowagregarStockActionPerformed
        // TODO add your handling code here:
        //lblnombrenuevoproducto.setText("");
        //lblnuevadescripcion.setText("");
        //lblnuevoprecio.setText("");
        guardarNuevoStockButton.setEnabled(false);
        //limpiarCajasdeTexto();
        agregarStock.setVisible(true);
        
    }//GEN-LAST:event_windowagregarStockActionPerformed

    private void guardarNuevoStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevoStockButtonActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = Connect.getConnection();
            //CtrlInventario ctrproduct = new CtrlInventario();
            CtrlSinStock ctrlsinstock=new CtrlSinStock();
             String idprod = codProductoField.getSelectedItem().toString().trim();
             Long codproducto = Long.parseLong(idprod);
            int stock = (int) jSpinner1.getValue();
            int stockini = (int) jSpinner2.getValue();
            int stockmax = (int) jSpinner3.getValue();
            int stockmin = (int)jSpinner4.getValue();

            boolean errores = false;
            /*if (ctrproduct.verificarNombreExistente(con, nombre)) {
                lblnombrenuevoproducto.setText("Producto ya existente");
                errores = true;
            } else {
                lblnombrenuevoproducto.setText("");
            }

            if (idmarca.equalsIgnoreCase("Seleccione la marca:")) {
                lblcodnuevamarca.setText("Seleccione alguna marca");
                errores = true;
            } else {
                lblcodnuevamarca.setText("");
            }

            if (idproveedor.equalsIgnoreCase("Seleccione el proveedor:")) {
                lblcodnuevoproveedor.setText("Seleccione un proveedor");
                errores = true;
            } else {
                lblcodnuevoproveedor.setText("");
            }

            if (idtipo.equalsIgnoreCase("Seleccione el tipo:")) {
                lblcodnuevotipo.setText("Seleccione el tipo");
                errores = true;
            } else {
                lblcodnuevotipo.setText("");
            }*/

            if (!errores) {
                Inventario invent = new Inventario();
                invent.setCod_prod(codproducto);
                invent.setStock(stock);
                invent.setStock_inicial(stockini);
                invent.setStock_maximo(stockmax);
                invent.setStock_minimo(stockmin);
                ctrlsinstock.agregarStock(invent);
                cargarProducto();
                agregarStock.setVisible(false);

            } else {
                // Si se encontraron errores, no se realizará el proceso de guardar
                System.out.println("No se pudo guardar debido a errores.");
            }

        }catch (SQLException e){
            System.out.println("Error" + e);
        }

    }//GEN-LAST:event_guardarNuevoStockButtonActionPerformed
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog agregarStock;
    private javax.swing.JComboBox<String> codProductoField;
    private javax.swing.JButton guardarNuevoStockButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTable tbsinstock;
    private javax.swing.JLabel txtproducto;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windowagregarStock;
    // End of variables declaration//GEN-END:variables
}
