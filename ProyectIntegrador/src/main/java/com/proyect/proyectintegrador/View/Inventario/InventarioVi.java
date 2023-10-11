
package com.proyect.proyectintegrador.View.Inventario;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrlInventario;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class InventarioVi extends org.jdesktop.swingx.JXPanel{


    public InventarioVi() {
        initComponents();
        busyLabel.setVisible(false);
        modificarStockDialog.pack();
        nuevoStockDialog.pack();
        modificarStockDialog.setLocationRelativeTo(this);
        nuevoStockDialog.setLocationRelativeTo(this);
        cargarInventario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificarStockDialog = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stockSpinner = new javax.swing.JSpinner();
        stockInicialSpinner = new javax.swing.JSpinner();
        stockMinimoSpinner = new javax.swing.JSpinner();
        guardarCambiosStockButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        stockMaximoSpinner = new javax.swing.JSpinner();
        nuevoStockDialog = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        guardarNuevoStockButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventarioTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ActualizarButton = new javax.swing.JButton();
        busyLabel = new org.jdesktop.swingx.JXBusyLabel();
        verificaciondatos = new javax.swing.JLabel();
        BuscarButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textoBusqueda = new javax.swing.JTextField();
        sumaTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        editarStockButton = new javax.swing.JButton();
        nuevoStockButton = new javax.swing.JButton();

        modificarStockDialog.setModal(true);
        modificarStockDialog.setResizable(false);

        jLabel4.setText("Stock");

        jLabel5.setText("Stock Minimo");

        jLabel6.setText("Stock Maximo");

        jLabel7.setText("Fecha de Registro");

        guardarCambiosStockButton.setText("Guardar");
        guardarCambiosStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosStockButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Editar Stock de Producto");

        jLabel3.setText("Stock Inicial");

        javax.swing.GroupLayout modificarStockDialogLayout = new javax.swing.GroupLayout(modificarStockDialog.getContentPane());
        modificarStockDialog.getContentPane().setLayout(modificarStockDialogLayout);
        modificarStockDialogLayout.setHorizontalGroup(
            modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarStockDialogLayout.createSequentialGroup()
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guardarCambiosStockButton)
                                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                                                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(28, 28, 28))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarStockDialogLayout.createSequentialGroup()
                                                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stockMaximoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stockInicialSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stockMinimoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
                            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(14, 14, 14)))
                .addGap(39, 39, 39))
        );
        modificarStockDialogLayout.setVerticalGroup(
            modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(88, 88, 88)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockInicialSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockMinimoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockMaximoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(guardarCambiosStockButton)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jLabel9.setText("Nuevo Stock");

        jLabel11.setText("Stock");

        jLabel12.setText("Stock inicial");

        jLabel13.setText("Stock maximo");

        jLabel14.setText("Stock minimo");

        guardarNuevoStockButton.setText("Guardar");
        guardarNuevoStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNuevoStockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nuevoStockDialogLayout = new javax.swing.GroupLayout(nuevoStockDialog.getContentPane());
        nuevoStockDialog.getContentPane().setLayout(nuevoStockDialogLayout);
        nuevoStockDialogLayout.setHorizontalGroup(
            nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel9))
                    .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(guardarNuevoStockButton)))))
                .addGap(61, 61, 61))
        );
        nuevoStockDialogLayout.setVerticalGroup(
            nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(guardarNuevoStockButton)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        inventarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(inventarioTable);

        jLabel1.setText("Total Productos:");

        ActualizarButton.setText("Actualizar");

        busyLabel.setText("Actualizando");

        verificaciondatos.setText("Sin Datos");

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Nombre", "Por Código" }));

        jLabel2.setText("Buscar");

        editarStockButton.setText("Editar");
        editarStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarStockButtonActionPerformed(evt);
            }
        });

        nuevoStockButton.setText("Nuevo");
        nuevoStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoStockButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(sumaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ActualizarButton)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(BuscarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verificaciondatos)
                        .addGap(161, 161, 161)
                        .addComponent(nuevoStockButton)
                        .addGap(18, 18, 18)
                        .addComponent(editarStockButton)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActualizarButton)
                    .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(sumaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verificaciondatos)
                            .addComponent(editarStockButton)
                            .addComponent(nuevoStockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        // TODO add your handling code here:
        buscarEnTabla();
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void editarStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarStockButtonActionPerformed
        // TODO add your handling code here:
        guardarCambiosStockButton.setEnabled(true);
        //lblmodmarcanombre.setText("");
        int selectedRow = inventarioTable.getSelectedRow();
        if (selectedRow != -1) {

            DefaultTableModel model = (DefaultTableModel) inventarioTable.getModel();
            Object data0 = model.getValueAt(selectedRow, 0);
            Object data1 = model.getValueAt(selectedRow, 1);
            Object data2 = model.getValueAt(selectedRow, 2);
            Object data3 = model.getValueAt(selectedRow, 3);
            Object data4 = model.getValueAt(selectedRow, 4);
            Object data5 = model.getValueAt(selectedRow, 5);
            //stockSpinner.setText(data1.toString());
            
            stockSpinner.setValue(data1);
            stockInicialSpinner.setValue(data2);
            stockMaximoSpinner.setValue(data3);
            stockMinimoSpinner.setValue(data4);
            dateChooser.setDate((Date) data5);
            //txtmodnombremarc.setText(data2.toString());
            modificarStockDialog.setVisible(true);
        } else {
            System.out.print("Error al cargar la fila marca");
        }
    }//GEN-LAST:event_editarStockButtonActionPerformed
    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) inventarioTable.getModel();
        model.setRowCount(0);
    }
    private void guardarCambiosStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarCambiosStockButtonActionPerformed
        // TODO add your handling code here:
       /* try {
            Connection con = Connect.getConnection();
            CtrlInventario ctrinventario = new CtrlInventario();
            Object stock = jSpinner1.getValue();
            Object stock_inicial = jSpinner2.getValue();
            Object stock_minimo = jSpinner3.getValue();
            Object stock_maximo = jSpinner4.getValue();
            Object fecha_registro = txtareardescripcion.getText().trim();
            boolean errores = false;
            if (ctrproduct.verificarNombreExistente(con, nombre)) {
                lblnombrenuevoproducto.setText("Producto ya existente");
                errores = true;
            } else {
                lblnombrenuevoproducto.setText("");
            }
                 Limpiar();
                cargarInventario();
                modificarStockDialog.setVisible(false);
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }*/
    }//GEN-LAST:event_guardarCambiosStockButtonActionPerformed

    private void guardarNuevoStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevoStockButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarNuevoStockButtonActionPerformed

    private void nuevoStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoStockButtonActionPerformed
        // TODO add your handling code here:
        nuevoStockDialog.setVisible(true);
    }//GEN-LAST:event_nuevoStockButtonActionPerformed
    private void buscarEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) inventarioTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        inventarioTable.setRowSorter(sorter);

        if (textoBusqueda.getText().trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(textoBusqueda.getText(), 0, 1));
        }
    }
    
    private void cargarInventario() {
        
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrlInventario ctrinventario = new CtrlInventario();
            List<Inventario> inventario = ctrinventario.cargarInventario();
            if (inventario != null && !inventario.isEmpty()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nombre");
                model.addColumn("Stock");
                model.addColumn("Stock inicial");
                model.addColumn("Stock maximo");
                model.addColumn("Stock minimo");
                model.addColumn("Fecha");
                for (Inventario stock : inventario) {
                    if (stock.isEstado()) {
                        Object[] datos = new Object[6];
                        datos[0] = stock.getNombreproducto();
                        datos[1] = stock.getStock();
                        datos[2] = stock.getStock_inicial();
                        datos[3] = stock.getStock_maximo();
                        datos[4] = stock.getStock_minimo();
                        datos[5] = stock.getFecha_registro();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                inventarioTable.setModel(model);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la tabla productos" + e);
        }
        int numeroDeColumnas = inventarioTable.getRowCount(); // Obtiene el número de columnas del JTable
        sumaTextField.setText(String.valueOf(numeroDeColumnas));
        verificaciondatos.setVisible(!datosEncontrados);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarButton;
    private javax.swing.JButton BuscarButton;
    private org.jdesktop.swingx.JXBusyLabel busyLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton editarStockButton;
    private javax.swing.JButton guardarCambiosStockButton;
    private javax.swing.JButton guardarNuevoStockButton;
    private javax.swing.JTable inventarioTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JDialog modificarStockDialog;
    private javax.swing.JButton nuevoStockButton;
    private javax.swing.JDialog nuevoStockDialog;
    private javax.swing.JSpinner stockInicialSpinner;
    private javax.swing.JSpinner stockMaximoSpinner;
    private javax.swing.JSpinner stockMinimoSpinner;
    private javax.swing.JSpinner stockSpinner;
    private javax.swing.JTextField sumaTextField;
    private javax.swing.JTextField textoBusqueda;
    private javax.swing.JLabel verificaciondatos;
    // End of variables declaration//GEN-END:variables
}
