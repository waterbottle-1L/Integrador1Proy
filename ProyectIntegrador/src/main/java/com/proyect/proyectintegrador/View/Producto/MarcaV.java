package com.proyect.proyectintegrador.View.Producto;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrMarca;
import com.proyect.proyectintegrador.Entitis.Marca;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class MarcaV extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;

    public MarcaV() {
        initComponents();
        NuevaMarca.pack();
        NuevaMarca.setLocationRelativeTo(this);
        ModificarMarca.pack();
        ModificarMarca.setLocationRelativeTo(this);
        verificaciondatos.setVisible(false);
        botonguardarmarca.setEnabled(false);
        windowDeleteMarc.setEnabled(false);
        windowModifyMarc.setEnabled(false);
        txtmodcodmarc.setEnabled(false);
        Habilitar();
        cargarMarca();
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

    private void cargarMarca() {
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrMarca marc = new CtrMarca();
            List<Marca> marcas = marc.cargarMarca();
            if (marcas != null && !marcas.isEmpty()) {
                Object[] columnNames = {"codigo", "nombre"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);

                for (Marca marca : marcas) {
                    if (marca.getEstado()) {
                        Object[] datos = new Object[2];
                        datos[0] = marca.getCodmarca();
                        datos[1] = marca.getNombre();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }

                tbmarca.setModel(model);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla: " + e.getMessage());
        }

        verificaciondatos.setVisible(!datosEncontrados);
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbmarca.getModel();
        model.setRowCount(0);
    }

    private void limpiarcajastexto() {
        txtnombremarca.setText("");
    }

    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbmarca.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                windowDeleteMarc.setEnabled(true);
                windowModifyMarc.setEnabled(true);
            } else {
                windowDeleteMarc.setEnabled(false);
                windowModifyMarc.setEnabled(false);
            }
        });
    }

    private void validarNuevaMarca() {
        if (txtnombremarca.getText().isEmpty()) {
            lblnombre.setText("Rellene el campo");
        } else {
            lblnombre.setText("");
        }

        if (txtnombremarca.getText().isEmpty()) {
            botonguardarmarca.setEnabled(false);
        } else {
            botonguardarmarca.setEnabled(true);
        }
    }

    private void validarModificarMarca() {
        if (txtmodnombremarc.getText().isEmpty()) {
            lblmodmarcanombre.setText("Rellene el campo");
        } else {
            lblmodmarcanombre.setText("");
        }

        if (txtmodnombremarc.getText().isEmpty()) {
            botonmodmarca.setEnabled(false);
        } else {
            botonmodmarca.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevaMarca = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombremarca = new javax.swing.JTextField();
        botonguardarmarca = new javax.swing.JButton();
        ModificarMarca = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblmodmarcanombre = new javax.swing.JLabel();
        txtmodcodmarc = new javax.swing.JTextField();
        txtmodnombremarc = new javax.swing.JTextField();
        botonmodmarca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmarca = new javax.swing.JTable();
        windowNewMarc = new javax.swing.JButton();
        windowDeleteMarc = new javax.swing.JButton();
        windowModifyMarc = new javax.swing.JButton();
        verificaciondatos = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        NuevaMarca.setModal(true);
        NuevaMarca.setResizable(false);

        jLabel1.setText("Nueva Marca");

        jLabel2.setText("Nombre");

        txtnombremarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombremarcaKeyReleased(evt);
            }
        });

        botonguardarmarca.setText("Guardar");
        botonguardarmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarmarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NuevaMarcaLayout = new javax.swing.GroupLayout(NuevaMarca.getContentPane());
        NuevaMarca.getContentPane().setLayout(NuevaMarcaLayout);
        NuevaMarcaLayout.setHorizontalGroup(
            NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaMarcaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NuevaMarcaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(NuevaMarcaLayout.createSequentialGroup()
                                .addGroup(NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonguardarmarca)
                                    .addComponent(txtnombremarca, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 17, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        NuevaMarcaLayout.setVerticalGroup(
            NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaMarcaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevaMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombremarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonguardarmarca)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ModificarMarca.setAlwaysOnTop(true);
        ModificarMarca.setModal(true);
        ModificarMarca.setResizable(false);

        jLabel3.setText("Modificar Marca");

        jLabel4.setText("Cdigo:");

        jLabel5.setText("Nombre:");

        txtmodnombremarc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmodnombremarcKeyReleased(evt);
            }
        });

        botonmodmarca.setText("Guardar");
        botonmodmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodmarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificarMarcaLayout = new javax.swing.GroupLayout(ModificarMarca.getContentPane());
        ModificarMarca.getContentPane().setLayout(ModificarMarcaLayout);
        ModificarMarcaLayout.setHorizontalGroup(
            ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarMarcaLayout.createSequentialGroup()
                .addGroup(ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ModificarMarcaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonmodmarca))
                    .addGroup(ModificarMarcaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmodcodmarc, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(lblmodmarcanombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmodnombremarc, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(33, 33, 33))
        );
        ModificarMarcaLayout.setVerticalGroup(
            ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarMarcaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGroup(ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarMarcaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4))
                    .addGroup(ModificarMarcaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtmodcodmarc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblmodmarcanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ModificarMarcaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmodnombremarc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(botonmodmarca)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tbmarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbmarca);

        windowNewMarc.setText("Nuevo ");
        windowNewMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowNewMarcActionPerformed(evt);
            }
        });

        windowDeleteMarc.setText("Eliminar");
        windowDeleteMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowDeleteMarcActionPerformed(evt);
            }
        });

        windowModifyMarc.setText("Modificar");
        windowModifyMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowModifyMarcActionPerformed(evt);
            }
        });

        verificaciondatos.setText("Sin Datos");

        jButton4.setText("Recargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(windowNewMarc)
                        .addGap(18, 18, 18)
                        .addComponent(windowDeleteMarc)
                        .addGap(18, 18, 18)
                        .addComponent(windowModifyMarc)
                        .addGap(123, 123, 123)
                        .addComponent(verificaciondatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windowNewMarc)
                    .addComponent(windowDeleteMarc)
                    .addComponent(windowModifyMarc)
                    .addComponent(verificaciondatos)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void windowNewMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowNewMarcActionPerformed
        lblnombre.setText("");
        botonguardarmarca.setEnabled(false);
        NuevaMarca.setVisible(true);
        limpiarcajastexto();
    }//GEN-LAST:event_windowNewMarcActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Limpiar();
        cargarMarca();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void botonguardarmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarmarcaActionPerformed
        try {
            Connection con = Connect.getConnection();
            Marca marc = new Marca();
            CtrMarca ctrmarc = new CtrMarca();
            String nombre = txtnombremarca.getText().trim();
            if (ctrmarc.verificarNombreExistente(con, nombre)) {
                lblnombre.setText("Existe una marca con el mismo nombre");
            } else {
                marc.setNombre(txtnombremarca.getText());
                marc.setEstado(Boolean.TRUE);
                ctrmarc.agregarMarca(marc);
                Limpiar();
                cargarMarca();
                NuevaMarca.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.print("Error marca" + e);
        }
    }//GEN-LAST:event_botonguardarmarcaActionPerformed

    private void txtnombremarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombremarcaKeyReleased
        validarNuevaMarca();
    }//GEN-LAST:event_txtnombremarcaKeyReleased

    private void windowDeleteMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowDeleteMarcActionPerformed
        try {
            long idmarca = 0;
            int selectedRow = tbmarca.getSelectedRow();
            Marca marc = new Marca();
            CtrMarca ctrmarc = new CtrMarca();
            Connection con = Connect.getConnection();

            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbmarca.getModel();
                String idValue = model.getValueAt(selectedRow, 0).toString();
                idmarca = Long.parseLong(idValue);
                if (ctrmarc.verificarCodigoexisteProducto(con, idmarca)) {
                     JOptionPane.showMessageDialog(null, "No se puede Eliminar");
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la Marca?");
                    switch (opcion) {
                        case 0:
                            boolean estado = false;
                            try {
                                marc.setCodmarca(idmarca);
                                marc.setEstado(estado);
                                ctrmarc.cambiarEstadoMarca(marc);
                                Limpiar();
                                cargarMarca();
                            } catch (SQLException e) {
                                System.out.print("Error marca" + e);
                            }
                            break;
                        case 1:
                            break;
                        default:
                            break;
                    }
                }
            } else {
                System.out.print("Error al eliminar la Marca");
            }
        } catch (SQLException e) {

        }
    }//GEN-LAST:event_windowDeleteMarcActionPerformed

    private void windowModifyMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowModifyMarcActionPerformed
        botonmodmarca.setEnabled(true);
        lblmodmarcanombre.setText("");
        int selectedRow = tbmarca.getSelectedRow();
        if (selectedRow != -1) {

            DefaultTableModel model = (DefaultTableModel) tbmarca.getModel();
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);

            txtmodcodmarc.setText(data1.toString());
            txtmodnombremarc.setText(data2.toString());
            ModificarMarca.setVisible(true);
        } else {
            System.out.print("Error al cargar la fila marca");
        }
    }//GEN-LAST:event_windowModifyMarcActionPerformed

    private void txtmodnombremarcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodnombremarcKeyReleased
        validarModificarMarca();
    }//GEN-LAST:event_txtmodnombremarcKeyReleased

    private void botonmodmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodmarcaActionPerformed
        try {
            Connection con = Connect.getConnection();
            Marca marc = new Marca();
            CtrMarca ctrmarc = new CtrMarca();

            String texto = txtmodcodmarc.getText();
            long codmarca = Long.parseLong(texto);
            String nombre = txtmodnombremarc.getText().trim();
            if (ctrmarc.verificarnombreSimilar(con, nombre, codmarca)) {
                lblmodmarcanombre.setText("Marca existente");
            } else {
                marc.setCodmarca(codmarca);
                marc.setNombre(txtmodnombremarc.getText());
                marc.setEstado(Boolean.TRUE);
                ctrmarc.ModificarMarca(marc);
                Limpiar();
                cargarMarca();
                ModificarMarca.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.print("error" + e);
        }
    }//GEN-LAST:event_botonmodmarcaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ModificarMarca;
    private javax.swing.JDialog NuevaMarca;
    private javax.swing.JButton botonguardarmarca;
    private javax.swing.JButton botonmodmarca;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblmodmarcanombre;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTable tbmarca;
    private javax.swing.JTextField txtmodcodmarc;
    private javax.swing.JTextField txtmodnombremarc;
    private javax.swing.JTextField txtnombremarca;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windowDeleteMarc;
    private javax.swing.JButton windowModifyMarc;
    private javax.swing.JButton windowNewMarc;
    // End of variables declaration//GEN-END:variables
}
