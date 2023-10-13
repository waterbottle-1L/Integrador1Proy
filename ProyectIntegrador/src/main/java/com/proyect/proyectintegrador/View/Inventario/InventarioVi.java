package com.proyect.proyectintegrador.View.Inventario;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Controller.CtrlInventario;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class InventarioVi extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;

    public InventarioVi() {
        initComponents();
        busyLabel.setVisible(false);
        modificarStockDialog.pack();
        modificarStockDialog.setLocationRelativeTo(this);
        editarStockButton.setEnabled(false);
        sumaTextField.setEnabled(false);
        Habilitar();
        cargarInventario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificarStockDialog = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guardarCambiosStockButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stockTxtField = new javax.swing.JTextField();
        stockInicialTxtField = new javax.swing.JTextField();
        stockMaximoTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        codprodTxtField = new javax.swing.JButton();
        lblNombreProd = new javax.swing.JLabel();
        stockMinimoTxtField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventarioTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ActualizarButton = new javax.swing.JButton();
        busyLabel = new org.jdesktop.swingx.JXBusyLabel();
        verificaciondatos = new javax.swing.JLabel();
        BuscarButton = new javax.swing.JButton();
        textoBusqueda = new javax.swing.JTextField();
        sumaTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        editarStockButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        modificarStockDialog.setModal(true);
        modificarStockDialog.setResizable(false);

        jLabel4.setText("Stock");

        jLabel5.setText("Stock Minimo");

        jLabel6.setText("Stock Maximo");

        guardarCambiosStockButton.setText("Guardar");
        guardarCambiosStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarCambiosStockButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Editar Stock de Producto");

        jLabel3.setText("Stock Inicial");

        jLabel2.setText("Cod Producto");

        javax.swing.GroupLayout modificarStockDialogLayout = new javax.swing.GroupLayout(modificarStockDialog.getContentPane());
        modificarStockDialog.getContentPane().setLayout(modificarStockDialogLayout);
        modificarStockDialogLayout.setHorizontalGroup(
            modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarStockDialogLayout.createSequentialGroup()
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codprodTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockInicialTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockMinimoTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockMaximoTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                                .addComponent(lblNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarStockDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardarCambiosStockButton)
                .addGap(108, 108, 108))
        );
        modificarStockDialogLayout.setVerticalGroup(
            modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificarStockDialogLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(lblNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(codprodTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(stockTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockInicialTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6))
                    .addGroup(modificarStockDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(modificarStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockMinimoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockMaximoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(guardarCambiosStockButton)
                .addGap(32, 32, 32))
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
        ActualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarButtonActionPerformed(evt);
            }
        });

        busyLabel.setText("Actualizando");

        verificaciondatos.setText("Sin Datos");

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        editarStockButton.setText("Editar");
        editarStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarStockButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Buscar por Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoBusqueda))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addComponent(verificaciondatos)
                                .addGap(304, 304, 304))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BuscarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editarStockButton)
                                .addGap(25, 25, 25))))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verificaciondatos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarButton)
                            .addComponent(editarStockButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = inventarioTable.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {

                editarStockButton.setEnabled(true);
            } else {

                editarStockButton.setEnabled(false);
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

    private void editarStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarStockButtonActionPerformed
        // TODO add your handling code here:
        guardarCambiosStockButton.setEnabled(true);
        //lblmodmarcanombre.setText("");
        int selectedRow = inventarioTable.getSelectedRow();
        if (selectedRow != -1) {

            DefaultTableModel model = (DefaultTableModel) inventarioTable.getModel();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Object codigo = model.getValueAt(selectedRow, 0);
            Object nombre = model.getValueAt(selectedRow, 1);
            Object stock = model.getValueAt(selectedRow, 2);
            Object stockInicial = model.getValueAt(selectedRow, 3);
            Object stockMaximo = model.getValueAt(selectedRow, 4);
            Object stockMinimo = model.getValueAt(selectedRow, 5);

            //stockSpinner.setText(data1.toString());
            lblNombreProd.setText(nombre.toString());
            codprodTxtField.setText(codigo.toString());
            stockTxtField.setText(stock.toString());
            stockInicialTxtField.setText(stockInicial.toString());
            stockMinimoTxtField.setText(stockMinimo.toString());
            stockMaximoTxtField.setText(stockMaximo.toString());
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
        try {
            Connection con = Connect.getConnection();
            CtrlInventario ctrproduct = new CtrlInventario();
            String texto = codprodTxtField.getText().trim();
            String nombreProd = lblNombreProd.getText().trim();
            String stock = stockTxtField.getText().trim();
            String stock_inicial = stockInicialTxtField.getText().trim();
            String stock_maximo = stockMaximoTxtField.getText().trim();
            String stock_minimo = stockMinimoTxtField.getText().trim();
            long codproducto = Long.parseLong(texto);
            boolean errores = false;
            if (!errores) {
                Inventario inventario = new Inventario();

                // Long codmarca = producto.obtenerIdMarcaPorNombre(con, idmarca);
                inventario.setCod_prod(codproducto);
                inventario.setNombreproducto(nombreProd);
                inventario.setStock(Integer.parseInt(stock));
                inventario.setStock_inicial(Integer.parseInt(stock_inicial));
                inventario.setStock_maximo(Integer.parseInt(stock_maximo));
                inventario.setStock_minimo(Integer.parseInt(stock_minimo));
                inventario.setEstado(Boolean.TRUE);
                ctrproduct.modificarInventario(inventario);
                Limpiar();
                cargarInventario();
            } else {
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_guardarCambiosStockButtonActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        // TODO add your handling code here:
        CtrlValidacion val = new CtrlValidacion();
        String cadena = textoBusqueda.getText().trim();
        if (textoBusqueda.getText().isEmpty() || !val.validarLetras(cadena)) {
            JOptionPane.showMessageDialog(null, "Rellene el campo para puscar Correctamente");
        } else {
            buscarEnTabla();
        }

    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void ActualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarButtonActionPerformed
        Limpiar();
        cargarInventario();
    }//GEN-LAST:event_ActualizarButtonActionPerformed
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
                Object[] columnNames = {"Codigo", "Nombre", "Stock", "Stock Inicial", "Stock Maximo", "Stock Minimo"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);

                for (Inventario stock : inventario) {
                    if (stock.getEstado()) {
                        Object[] datos = new Object[6];
                        datos[0] = stock.getCod_prod();
                        datos[1] = stock.getNombreproducto();
                        datos[2] = stock.getStock();
                        datos[3] = stock.getStock_inicial();
                        datos[4] = stock.getStock_maximo();
                        datos[5] = stock.getStock_minimo();
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
    private javax.swing.JButton codprodTxtField;
    private javax.swing.JButton editarStockButton;
    private javax.swing.JButton guardarCambiosStockButton;
    private javax.swing.JTable inventarioTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombreProd;
    private javax.swing.JDialog modificarStockDialog;
    private javax.swing.JTextField stockInicialTxtField;
    private javax.swing.JTextField stockMaximoTxtField;
    private javax.swing.JTextField stockMinimoTxtField;
    private javax.swing.JTextField stockTxtField;
    private javax.swing.JTextField sumaTextField;
    private javax.swing.JTextField textoBusqueda;
    private javax.swing.JLabel verificaciondatos;
    // End of variables declaration//GEN-END:variables
}
