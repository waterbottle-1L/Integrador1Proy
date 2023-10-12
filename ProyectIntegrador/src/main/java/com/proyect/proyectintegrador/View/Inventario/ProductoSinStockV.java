package com.proyect.proyectintegrador.View.Inventario;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Controller.CtrlInventario;
import com.proyect.proyectintegrador.Controller.CtrlSinStock;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
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
        cargarcombo();
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
                Object[] columnNames = {"Codigo", "Nombre"};
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

    private void cargarcombo() {
        try (Connection con = Connect.getConnection()) {
            CtrlSinStock ctrnostock = new CtrlSinStock();
            List<ProductoSinStock> inventarios = ctrnostock.cargarInventario();
            if (inventarios != null && !inventarios.isEmpty()) {
                codProductoField.removeAllItems();
                codProductoField.addItem("Seleccione Producto");
                for (ProductoSinStock inventario : inventarios) {
                    codProductoField.addItem(inventario.getNombreproductoSinStock());
                }
            }else{
                codProductoField.addItem("No existen Productos");
            }
        } catch (SQLException e) {
            System.out.print("Error al combo" + e);
        }
    }

    private void validarNuevoStock() {

        CtrlValidacion val = new CtrlValidacion();
        String stock = txtStock.getText().trim();
        String stockinicial = txtstockinicial.getText().trim();
        String stockmaximo = txtstockmaximo.getText().trim();
        String stockminimo = txtstockminimo.getText().trim();

        if (stock.isEmpty()) {
            lblstock.setText("Rellene el campo");
        } else if (!val.validarNumerosenteros(stock)) {
            lblstock.setText("Coloque solo Numeros");
        } else {
            lblstock.setText("");
        }

        if (stockinicial.isEmpty()) {
            lblstockinicial.setText("Rellene el campo");
        } else if (!val.validarNumerosenteros(stockinicial)) {
            lblstockinicial.setText("Coloque solo Numeros");
        } else {
            lblstockinicial.setText("");
        }

        if (stockmaximo.isEmpty()) {
            lblstockmaximo.setText("Rellene el campo");
        } else if (!val.validarNumerosenteros(stockmaximo)) {
            lblstockmaximo.setText("Coloque solo Numeros");
        } else {
            lblstockmaximo.setText("");
        }

        if (stockminimo.isEmpty()) {
            lblstockminimo.setText("Rellene el campo");
        } else if (!val.validarNumerosenteros(stockminimo)) {
            lblstockminimo.setText("Coloque solo Numeros");
        } else {
            lblstockminimo.setText("");
        }

        if (stock.isEmpty() || !val.validarNumerosenteros(stock) || stockinicial.isEmpty()
                || !val.validarNumerosenteros(stockinicial) || stockmaximo.isEmpty() || !val.validarNumerosenteros(stockmaximo)
                || stockminimo.isEmpty() || !val.validarNumerosenteros(stockminimo)) {
            guardarNuevoStockButton.setEnabled(false);
        } else {
            guardarNuevoStockButton.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarStock = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        guardarNuevoStockButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codProductoField = new javax.swing.JComboBox<>();
        txtStock = new javax.swing.JTextField();
        lblstock = new javax.swing.JLabel();
        lblstockinicial = new javax.swing.JLabel();
        txtstockinicial = new javax.swing.JTextField();
        lblstockmaximo = new javax.swing.JLabel();
        txtstockmaximo = new javax.swing.JTextField();
        txtstockminimo = new javax.swing.JTextField();
        lblstockminimo = new javax.swing.JLabel();
        lblcombo = new javax.swing.JLabel();
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

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        txtstockinicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstockinicialKeyReleased(evt);
            }
        });

        txtstockmaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstockmaximoKeyReleased(evt);
            }
        });

        txtstockminimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstockminimoKeyReleased(evt);
            }
        });

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
                                .addComponent(jLabel1)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel2))
                            .addComponent(jLabel14))
                        .addGap(25, 25, 25)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStock)
                            .addComponent(codProductoField, 0, 116, Short.MAX_VALUE)
                            .addComponent(txtstockinicial)
                            .addComponent(lblstockinicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtstockmaximo)
                            .addComponent(lblstockmaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtstockminimo)
                            .addComponent(lblstockminimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        agregarStockLayout.setVerticalGroup(
            agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agregarStockLayout.createSequentialGroup()
                .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarStockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(29, 29, 29))
                    .addGroup(agregarStockLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(codProductoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblstock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblstockinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstockinicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblstockmaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(agregarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstockmaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblstockminimo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtstockminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(windowagregarStock)
                        .addGap(198, 198, 198)
                        .addComponent(verificaciondatos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windowagregarStock)
                    .addComponent(verificaciondatos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void windowagregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowagregarStockActionPerformed
        txtStock.setText("");
        txtstockinicial.setText("");
        txtstockmaximo.setText("");
        txtstockminimo.setText("");
        guardarNuevoStockButton.setEnabled(false);

        agregarStock.setVisible(true);

    }//GEN-LAST:event_windowagregarStockActionPerformed

    private void guardarNuevoStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevoStockButtonActionPerformed
        try {
            Connection con = Connect.getConnection();
            String stock = txtStock.getText().trim();
            String stockinicial = txtstockinicial.getText().trim();
            String stockmaximo = txtstockmaximo.getText().trim();
            String stockminimo = txtstockminimo.getText().trim();
            String producto = codProductoField.getSelectedItem().toString().trim();
            boolean errores = false;

            if (producto.equalsIgnoreCase("Seleccione Producto") || producto.equalsIgnoreCase("No existen Productos")) {
                lblcombo.setText("Escoja Producto");
                errores = true;
            } else {
                lblcombo.setText("");
            }
            if (!errores) {
                CtrlInventario ctrinven = new CtrlInventario();
                Long codproducto = ctrinven.obtenerIdproductoNombre(con, producto);
                int idstock = Integer.parseInt(stock);
                int idstockinicial = Integer.parseInt(stockinicial);
                int idstockmaximo = Integer.parseInt(stockmaximo);
                int idstockminimo = Integer.parseInt(stockminimo);
                Inventario inventario = new Inventario();
                

                inventario.setCod_prod(codproducto);
                inventario.setStock(idstock);
                inventario.setStock_inicial(idstockinicial);
                inventario.setStock_maximo(idstockmaximo);
                inventario.setStock_minimo(idstockminimo);
                inventario.setEstado(Boolean.TRUE);
                ctrinven.agregarInventario(inventario);
                agregarStock.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar inventario"+e);
        }

    }//GEN-LAST:event_guardarNuevoStockButtonActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        validarNuevoStock();
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtstockinicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockinicialKeyReleased
        validarNuevoStock();
    }//GEN-LAST:event_txtstockinicialKeyReleased

    private void txtstockmaximoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockmaximoKeyReleased
        validarNuevoStock();
    }//GEN-LAST:event_txtstockmaximoKeyReleased

    private void txtstockminimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockminimoKeyReleased
        validarNuevoStock();
    }//GEN-LAST:event_txtstockminimoKeyReleased


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
    private javax.swing.JLabel lblcombo;
    private javax.swing.JLabel lblstock;
    private javax.swing.JLabel lblstockinicial;
    private javax.swing.JLabel lblstockmaximo;
    private javax.swing.JLabel lblstockminimo;
    private javax.swing.JTable tbsinstock;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtstockinicial;
    private javax.swing.JTextField txtstockmaximo;
    private javax.swing.JTextField txtstockminimo;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windowagregarStock;
    // End of variables declaration//GEN-END:variables
}
