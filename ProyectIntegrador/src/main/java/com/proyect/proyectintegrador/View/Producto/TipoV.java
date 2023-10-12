package com.proyect.proyectintegrador.View.Producto;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrTipo;
import com.proyect.proyectintegrador.Entitis.Tipo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class TipoV extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;

    public TipoV() {
        initComponents();
        NuevoTipo.pack();
        NuevoTipo.setLocationRelativeTo(this);
        ModificarTipo.pack();
        ModificarTipo.setLocationRelativeTo(this);
        windoweliminartipo.setEnabled(false);
        windowmodtipo.setEnabled(false);
        txtcodtipo.setEnabled(false);
        cargarTipo();
        Habilitar();
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

    private void cargarTipo() {
        boolean datosEncontrados = false;

        try (Connection con = Connect.getConnection()) {
            CtrTipo tip = new CtrTipo();
            List<Tipo> tipos = tip.cargarTipo();
            if (tipos != null && !tipos.isEmpty()) {

                Object[] columnNames = {"Codigo", "Nombre"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);

                for (Tipo tipo : tipos) {
                    if (tipo.getEstado()) {
                        Object[] datos = new Object[2];
                        datos[0] = tipo.getCodtipo();
                        datos[1] = tipo.getNombre();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                tbtipo.setModel(model);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla: " + e.getMessage());
        }

        verificaciondatos.setVisible(!datosEncontrados);
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbtipo.getModel();
        model.setRowCount(0);
    }

    private void limpiarcajastexto() {
        txtnombretipo.setText("");
    }

    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbtipo.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                windoweliminartipo.setEnabled(true);
                windowmodtipo.setEnabled(true);
            } else {
                windoweliminartipo.setEnabled(false);
                windowmodtipo.setEnabled(false);
            }
        });
    }

    private void validarNuevaTipo() {
        if (txtnombretipo.getText().isEmpty()) {
            lblnombtipo.setText("Rellene el campo");
        } else {
            lblnombtipo.setText("");
        }

        if (txtnombretipo.getText().isEmpty()) {
            botonguardartipo.setEnabled(false);
        } else {
            botonguardartipo.setEnabled(true);
        }
    }

    private void validarModificarTipo() {
        if (txtmodnombtipo.getText().isEmpty()) {
            lblmodnombtipo.setText("Rellene el campo");
        } else {
            lblmodnombtipo.setText("");
        }

        if (txtmodnombtipo.getText().isEmpty()) {
            botonmodificartipo.setEnabled(false);
        } else {
            botonmodificartipo.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevoTipo = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblnombtipo = new javax.swing.JLabel();
        txtnombretipo = new javax.swing.JTextField();
        botonguardartipo = new javax.swing.JButton();
        ModificarTipo = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodtipo = new javax.swing.JTextField();
        lblmodnombtipo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmodnombtipo = new javax.swing.JTextField();
        botonmodificartipo = new javax.swing.JButton();
        windownuevotipo = new javax.swing.JButton();
        windoweliminartipo = new javax.swing.JButton();
        windowmodtipo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtipo = new javax.swing.JTable();
        verificaciondatos = new javax.swing.JLabel();
        botonrecargar = new javax.swing.JButton();

        NuevoTipo.setModal(true);

        jLabel1.setText("Nuevo Tipo");

        jLabel2.setText("Nombre: ");

        txtnombretipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombretipoKeyReleased(evt);
            }
        });

        botonguardartipo.setText("Guardar");
        botonguardartipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardartipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NuevoTipoLayout = new javax.swing.GroupLayout(NuevoTipo.getContentPane());
        NuevoTipo.getContentPane().setLayout(NuevoTipoLayout);
        NuevoTipoLayout.setHorizontalGroup(
            NuevoTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoTipoLayout.createSequentialGroup()
                .addGroup(NuevoTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NuevoTipoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(NuevoTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(NuevoTipoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtnombretipo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(NuevoTipoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblnombtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoTipoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonguardartipo)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        NuevoTipoLayout.setVerticalGroup(
            NuevoTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoTipoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnombtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(NuevoTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombretipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonguardartipo)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel3.setText("Modificar Tipo de Producto");

        jLabel4.setText("Codigo: ");

        jLabel6.setText("Nombre: ");

        txtmodnombtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmodnombtipoKeyReleased(evt);
            }
        });

        botonmodificartipo.setText("Guardar");
        botonmodificartipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificartipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificarTipoLayout = new javax.swing.GroupLayout(ModificarTipo.getContentPane());
        ModificarTipo.getContentPane().setLayout(ModificarTipoLayout);
        ModificarTipoLayout.setHorizontalGroup(
            ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarTipoLayout.createSequentialGroup()
                .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ModificarTipoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonmodificartipo))
                    .addGroup(ModificarTipoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarTipoLayout.createSequentialGroup()
                                .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblmodnombtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcodtipo)
                                    .addComponent(txtmodnombtipo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))))
                .addGap(26, 26, 26))
        );
        ModificarTipoLayout.setVerticalGroup(
            ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarTipoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcodtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmodnombtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ModificarTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtmodnombtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonmodificartipo)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        windownuevotipo.setText("Nuevo");
        windownuevotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windownuevotipoActionPerformed(evt);
            }
        });

        windoweliminartipo.setText("Eliminar");
        windoweliminartipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windoweliminartipoActionPerformed(evt);
            }
        });

        windowmodtipo.setText("Modificar");
        windowmodtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowmodtipoActionPerformed(evt);
            }
        });

        tbtipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtipo);

        verificaciondatos.setText("Sin Datos");

        botonrecargar.setText("Recargar");
        botonrecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonrecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(windownuevotipo)
                        .addGap(18, 18, 18)
                        .addComponent(windoweliminartipo)
                        .addGap(18, 18, 18)
                        .addComponent(windowmodtipo)
                        .addGap(105, 105, 105)
                        .addComponent(verificaciondatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonrecargar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windownuevotipo)
                    .addComponent(windoweliminartipo)
                    .addComponent(windowmodtipo)
                    .addComponent(verificaciondatos)
                    .addComponent(botonrecargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonrecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonrecargarActionPerformed
        Limpiar();
        cargarTipo();
    }//GEN-LAST:event_botonrecargarActionPerformed

    private void windownuevotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windownuevotipoActionPerformed
        lblnombtipo.setText("");
        botonguardartipo.setEnabled(false);
        NuevoTipo.setVisible(true);
        limpiarcajastexto();
    }//GEN-LAST:event_windownuevotipoActionPerformed

    private void txtnombretipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombretipoKeyReleased
        validarNuevaTipo();
    }//GEN-LAST:event_txtnombretipoKeyReleased

    private void botonguardartipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardartipoActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrTipo ctrtip = new CtrTipo();
            Tipo tipo = new Tipo();
            String nombreingresado = txtnombretipo.getText().trim();

            if (ctrtip.verificarNombreExistente(con, nombreingresado)) {
                lblnombtipo.setText("El tipo ya existe");
            } else {
                tipo.setNombre(txtnombretipo.getText());
                tipo.setEstado(Boolean.TRUE);
                ctrtip.agregarTipo(tipo);
                Limpiar();
                cargarTipo();
                NuevoTipo.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.print("Error al agregar tipo de producto " + e);
        }
    }//GEN-LAST:event_botonguardartipoActionPerformed

    private void windoweliminartipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windoweliminartipoActionPerformed
        try {
            int selectedRow = tbtipo.getSelectedRow();
            long idtipo = 0;
            Connection con = Connect.getConnection();
            CtrTipo ctrtip = new CtrTipo();
            Tipo tipo = new Tipo();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbtipo.getModel();
                String idValue = model.getValueAt(selectedRow, 0).toString();
                idtipo = Long.parseLong(idValue);
                if (ctrtip.verificarCodigoexisteProducto(con, idtipo)) {
                    JOptionPane.showMessageDialog(null, "No se puede Eliminar");
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el tipo de producto?");
                    switch (opcion) {

                        case 0:
                            boolean estado = false;
                            try {
                                tipo.setCodtipo(idtipo);
                                tipo.setEstado(estado);
                                ctrtip.cambiarEstadoTipo(tipo);
                                Limpiar();
                                cargarTipo();
                            } catch (SQLException e) {
                                System.out.print("Error al eliminar tipo" + e);
                            }
                            break;
                        case 1:
                            break;
                        default:
                            break;
                    }
                }
            } else {
                System.out.print("Error al seleccionar tipo");
            }
        } catch (SQLException e) {
            System.out.print("Error AL eliminar");
        }
    }//GEN-LAST:event_windoweliminartipoActionPerformed

    private void windowmodtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowmodtipoActionPerformed
        lblmodnombtipo.setText("");
        botonmodificartipo.setEnabled(true);
        int selectedRow = tbtipo.getSelectedRow();
        if (selectedRow != -1) {

            DefaultTableModel model = (DefaultTableModel) tbtipo.getModel();
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);

            txtcodtipo.setText(data1.toString());
            txtmodnombtipo.setText(data2.toString());
            ModificarTipo.setVisible(true);
        } else {
            System.out.print("Error al cargar la fila marca");
        }
    }//GEN-LAST:event_windowmodtipoActionPerformed

    private void txtmodnombtipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodnombtipoKeyReleased
        validarModificarTipo();
    }//GEN-LAST:event_txtmodnombtipoKeyReleased

    private void botonmodificartipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificartipoActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrTipo ctrtip = new CtrTipo();
            Tipo tipo = new Tipo();

            String texto = txtcodtipo.getText();
            long codtipo = Long.parseLong(texto);
            String nombre = txtmodnombtipo.getText();
            if (ctrtip.verificarnombreSimilar(con, nombre, codtipo)) {
                lblmodnombtipo.setText("El nombre ya esta registrado");
            } else {
                tipo.setCodtipo(codtipo);
                tipo.setNombre(txtmodnombtipo.getText());
                tipo.setEstado(Boolean.TRUE);
                ctrtip.ModificarTipo(tipo);
                Limpiar();
                cargarTipo();
                ModificarTipo.setVisible(false);
            }

        } catch (SQLException e) {
            System.out.print("Error al modiciar el Tipo" + e);
        }
    }//GEN-LAST:event_botonmodificartipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ModificarTipo;
    private javax.swing.JDialog NuevoTipo;
    private javax.swing.JButton botonguardartipo;
    private javax.swing.JButton botonmodificartipo;
    private javax.swing.JButton botonrecargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblmodnombtipo;
    private javax.swing.JLabel lblnombtipo;
    private javax.swing.JTable tbtipo;
    private javax.swing.JTextField txtcodtipo;
    private javax.swing.JTextField txtmodnombtipo;
    private javax.swing.JTextField txtnombretipo;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windoweliminartipo;
    private javax.swing.JButton windowmodtipo;
    private javax.swing.JButton windownuevotipo;
    // End of variables declaration//GEN-END:variables
}
