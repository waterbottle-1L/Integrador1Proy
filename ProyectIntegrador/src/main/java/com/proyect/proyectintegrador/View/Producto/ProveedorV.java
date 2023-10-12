package com.proyect.proyectintegrador.View.Producto;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrProveedor;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ProveedorV extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;

    public ProveedorV() {
        initComponents();
        NuevoProveedor.pack();
        NuevoProveedor.setLocationRelativeTo(this);
        ModificarProveedor.pack();
        ModificarProveedor.setLocationRelativeTo(this);
        insertarproveedor.setEnabled(false);
        BotonEliminar.setEnabled(false);
        BotonModificar.setEnabled(false);
        txtModCod.setEnabled(false);
        verificaciondedatos.setVisible(false);
        Habilitar();
        cargarProveedor();

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

    private void cargarProveedor() {
        try (Connection con = Connect.getConnection()) {
            CtrProveedor pro = new CtrProveedor();
            List<Proveedor> proveedores = pro.cargarProveedor();

            if (proveedores != null && !proveedores.isEmpty()) {
                Object[] columnNames = {"Codigo", "Nombre", "Ruc", "Telefono", "Direccion"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);

                for (Proveedor proveedor : proveedores) {
                    if (proveedor.getEstado()) {
                        Object[] datos = new Object[6];
                        datos[0] = proveedor.getCodproveedor();
                        datos[1] = proveedor.getNombre();
                        datos[2] = proveedor.getRuc();
                        datos[3] = proveedor.getTelefono();
                        datos[4] = proveedor.getDireccion();
                        datos[5] = proveedor.getEstado();
                        model.addRow(datos);
                    }
                }
                verificaciondedatos.setVisible(false);
                tbproveedor.setModel(model);
            } else {
                verificaciondedatos.setVisible(true);
                System.out.println("No se encontraron proveedores.");
            }
        } catch (SQLException e) {

            System.out.println("Error al cargar la tabla: " + e.getMessage());
        }
    }

    private void limpiarCajasDeTexto() {
        txtnombre.setText("");
        txtruc.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbproveedor.getModel();
        model.setRowCount(0);
    }

    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbproveedor.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                BotonEliminar.setEnabled(true);
                BotonModificar.setEnabled(true);
            } else {
                BotonEliminar.setEnabled(false);
                BotonModificar.setEnabled(false);
            }
        });
    }

    private void validarNuevoProveedor() {
        CtrlValidacion val = new CtrlValidacion();
        String ruc = txtruc.getText().trim();
        String telefono = txttelefono.getText().trim();

        if (txtnombre.getText().isEmpty()) {
            lblnombre.setText("Rellene el campo");
        } else {
            lblnombre.setText("");
        }

        if (txtruc.getText().isEmpty()) {
            lblruc.setText("Rellene el campo");
        } else if (!val.validarRuc(ruc)) {
            lblruc.setText("Coloque 11 digitos");
        } else {
            lblruc.setText("");
        }

        if (txttelefono.getText().isEmpty()) {
            lbltelefono.setText("Rellene el campo");
        } else if (!val.validarTelefono(telefono)) {
            lbltelefono.setText("coloque 9 digitos");
        } else {
            lbltelefono.setText("");
        }

        if (txtdireccion.getText().isEmpty()) {
            lbldireccion.setText("Rellene el campo");
        } else {
            lbldireccion.setText("");
        }

        if (txtruc.getText().isEmpty() || txttelefono.getText().isEmpty() || txtnombre.getText().isEmpty()
                || txtdireccion.getText().isEmpty() || lbltelefono.getText().equals("coloque 9 digitos")
                || lblruc.getText().equals("Coloque 11 digitos")) {
            insertarproveedor.setEnabled(false);
        } else {
            insertarproveedor.setEnabled(true);
        }
    }

    private void validarModificar() {
        CtrlValidacion val = new CtrlValidacion();
        String ruc = txtModRuc.getText().trim();
        String telefono = txtModTelefono.getText().trim();

        if (txtModNombre.getText().isEmpty()) {
            jLabel13.setText("Rellene el Campo");
        } else {
            jLabel13.setText("");
        }

        if (txtModRuc.getText().isEmpty()) {
            jLabel14.setText("Rellene el Campo");
        } else if (!val.validarRuc(ruc)) {
            jLabel14.setText("Coloque 11 digitos");
        } else {
            jLabel14.setText("");
        }

        if (txtModTelefono.getText().isEmpty()) {
            jLabel15.setText("Rellene el Campo");
        } else if (!val.validarTelefono(telefono)) {
            jLabel15.setText("Coloque 9 digitos");
        } else {
            jLabel15.setText("");
        }

        if (txtMoDireccion.getText().isEmpty()) {
            jLabel16.setText("Rellene el Campo");
        } else {
            jLabel16.setText("");
        }

        if (txtModNombre.getText().isEmpty() || txtModRuc.getText().isEmpty() || txtModTelefono.getText().isEmpty()
                || txtMoDireccion.getText().isEmpty() || jLabel15.getText().equals("Coloque 9 digitos")
                || jLabel14.getText().equals("Coloque 11 digitos")) {
            botonguardar.setEnabled(false);
        } else {
            botonguardar.setEnabled(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevoProveedor = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtruc = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        insertarproveedor = new javax.swing.JButton();
        lblruc = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ModificarProveedor = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonguardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtModCod = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtModNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtModRuc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtModTelefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMoDireccion = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproveedor = new javax.swing.JTable();
        verificaciondedatos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        NuevoProveedor.setAlwaysOnTop(true);
        NuevoProveedor.setModal(true);
        NuevoProveedor.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        NuevoProveedor.setResizable(false);

        jLabel1.setText("Nombre :");

        jLabel2.setText("Ruc :");

        jLabel3.setText("Telefono :");

        jLabel4.setText("Direccion :");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        txtruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrucActionPerformed(evt);
            }
        });
        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrucKeyReleased(evt);
            }
        });

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
        });

        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdireccionKeyReleased(evt);
            }
        });

        insertarproveedor.setText("Guardar");
        insertarproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarproveedorActionPerformed(evt);
            }
        });

        jLabel9.setText("AÑADIR PROVEEDOR");

        javax.swing.GroupLayout NuevoProveedorLayout = new javax.swing.GroupLayout(NuevoProveedor.getContentPane());
        NuevoProveedor.getContentPane().setLayout(NuevoProveedorLayout);
        NuevoProveedorLayout.setHorizontalGroup(
            NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoProveedorLayout.createSequentialGroup()
                .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(insertarproveedor)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NuevoProveedorLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(NuevoProveedorLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                        .addGroup(NuevoProveedorLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblruc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        NuevoProveedorLayout.setVerticalGroup(
            NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoProveedorLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblruc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertarproveedor)
                .addGap(27, 27, 27))
        );

        ModificarProveedor.setResizable(false);

        jLabel5.setText("Modificar Proveedor");

        jLabel6.setText("Codigo: ");

        jLabel7.setText("Nombre:");

        jLabel8.setText("Ruc:");

        jLabel10.setText("Telefono");

        jLabel11.setText("Direccion:");

        botonguardar.setText("Guardar");
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });

        txtModNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModNombreKeyReleased(evt);
            }
        });

        txtModRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModRucKeyReleased(evt);
            }
        });

        txtModTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModTelefonoKeyReleased(evt);
            }
        });

        txtMoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoDireccionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout ModificarProveedorLayout = new javax.swing.GroupLayout(ModificarProveedor.getContentPane());
        ModificarProveedor.getContentPane().setLayout(ModificarProveedorLayout);
        ModificarProveedorLayout.setHorizontalGroup(
            ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarProveedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ModificarProveedorLayout.createSequentialGroup()
                        .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ModificarProveedorLayout.createSequentialGroup()
                                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(ModificarProveedorLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ModificarProveedorLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModCod)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModNombre)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModRuc)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModTelefono)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                    .addComponent(botonguardar))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        ModificarProveedorLayout.setVerticalGroup(
            ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarProveedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ModificarProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtModCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(txtModNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtModRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ModificarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMoDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(botonguardar)
                .addGap(36, 36, 36))
        );

        BotonGuardar.setText("Nuevo");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonEliminar.setText("Eliminar");
        BotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonEliminarMouseClicked(evt);
            }
        });
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonModificar.setText("Modificar");
        BotonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarActionPerformed(evt);
            }
        });

        tbproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbproveedor);

        verificaciondedatos.setText("Sin Datos");

        jButton1.setText("Recargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonModificar)
                        .addGap(91, 91, 91)
                        .addComponent(verificaciondedatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonEliminar)
                    .addComponent(BotonModificar)
                    .addComponent(verificaciondedatos)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        lblruc.setText("");
        lbltelefono.setText("");
        lblnombre.setText("");
        lbldireccion.setText("");
        insertarproveedor.setEnabled(false);
        NuevoProveedor.setVisible(true);
        limpiarCajasDeTexto();
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void insertarproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarproveedorActionPerformed

        try {
            Connection con = Connect.getConnection();
            Proveedor prov = new Proveedor();
            CtrProveedor ctrprov = new CtrProveedor();
            String rucIngresado = txtruc.getText().trim();
            if (ctrprov.verificarRucExistente(con, rucIngresado)) {
                lblruc.setText("Ruc ya existente");
            } else {
                prov.setNombre(txtnombre.getText());
                prov.setRuc(txtruc.getText());
                prov.setTelefono(txttelefono.getText());
                prov.setDireccion(txtdireccion.getText());
                prov.setEstado(Boolean.TRUE);

                ctrprov.agregarProveedor(prov);

                Limpiar();
                cargarProveedor();
                NuevoProveedor.setVisible(false);
            }
        } catch (SQLException e) {

            NuevoProveedor.setVisible(false);
            JOptionPane.showMessageDialog(null, "Error al agregar proveedor: " + e.getMessage());
        }

    }//GEN-LAST:event_insertarproveedorActionPerformed

    private void txtrucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrucActionPerformed

    private void txtrucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyReleased
        validarNuevoProveedor();
    }//GEN-LAST:event_txtrucKeyReleased

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        validarNuevoProveedor();
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        validarNuevoProveedor();
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyReleased
        validarNuevoProveedor();
    }//GEN-LAST:event_txtdireccionKeyReleased

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        try {
            Connection con = Connect.getConnection();
            long idproveedor = 0;
            int selectedRow = tbproveedor.getSelectedRow();
            Proveedor prov = new Proveedor();
            CtrProveedor ctrprov = new CtrProveedor();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbproveedor.getModel();
                String idValue = model.getValueAt(selectedRow, 0).toString();
                idproveedor = Long.parseLong(idValue);
                if (ctrprov.verificarCodigoexisteProducto(con, idproveedor)) {
                    JOptionPane.showMessageDialog(null, "No se puede Eliminar");
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar Proveedor?");
                    switch (opcion) {
                        case 0:
                            boolean estado = false;
                            prov.setCodproveedor(idproveedor);
                            prov.setEstado(estado);
                            ctrprov.Cambiarestadoproveedor(prov);
                            Limpiar();
                            cargarProveedor();
                            break;
                        case 1:
                            break;
                        default:
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar: No se ha seleccionado un proveedor.");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void tbproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproveedorMouseClicked

    }//GEN-LAST:event_tbproveedorMouseClicked

    private void BotonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarActionPerformed
        jLabel13.setText("");
        jLabel14.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        botonguardar.setEnabled(true);
        int selectedRow = tbproveedor.getSelectedRow();
        if (selectedRow != -1) { // Verifica si se ha seleccionado una fila
            DefaultTableModel model = (DefaultTableModel) tbproveedor.getModel();

            // Obtén los datos de las cuatro columnas de la fila seleccionada
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);
            Object data3 = model.getValueAt(selectedRow, 2);
            Object data4 = model.getValueAt(selectedRow, 3);
            Object data5 = model.getValueAt(selectedRow, 4);

            // Asigna los datos a los JTextField correspondientes
            txtModCod.setText(data1.toString());
            txtModNombre.setText(data2.toString());
            txtModRuc.setText(data3.toString());
            txtModTelefono.setText(data4.toString());
            txtMoDireccion.setText(data5.toString());
            ModificarProveedor.setVisible(true);
        } else {
            System.out.print("Error al cargar la fila proveedor");
        }
    }//GEN-LAST:event_BotonModificarActionPerformed

    private void BotonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonEliminarMouseClicked

    }//GEN-LAST:event_BotonEliminarMouseClicked

    private void txtModNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModNombreKeyReleased
        validarModificar();
    }//GEN-LAST:event_txtModNombreKeyReleased

    private void txtModRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModRucKeyReleased
        validarModificar();
    }//GEN-LAST:event_txtModRucKeyReleased

    private void txtModTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModTelefonoKeyReleased
        validarModificar();
    }//GEN-LAST:event_txtModTelefonoKeyReleased

    private void txtMoDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoDireccionKeyReleased
        validarModificar();
    }//GEN-LAST:event_txtMoDireccionKeyReleased

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        try {
            Connection con = Connect.getConnection();
            Proveedor prov = new Proveedor();
            CtrProveedor ctrprov = new CtrProveedor();
            String rucIngresado = txtModRuc.getText().trim();
            String texto = txtModCod.getText();
            long codproveedor = Long.parseLong(texto);

            if (ctrprov.verificarRucSimilar(con, rucIngresado, codproveedor)) {
                jLabel14.setText("El ruc ya existe");
            } else {

                prov.setCodproveedor(codproveedor);
                prov.setNombre(txtModNombre.getText());
                prov.setRuc(txtModRuc.getText());
                prov.setTelefono(txtModTelefono.getText());
                prov.setDireccion(txtMoDireccion.getText());
                prov.setEstado(Boolean.TRUE);

                ctrprov.ModificarProveedor(prov);
                Limpiar();
                cargarProveedor();
                ModificarProveedor.setVisible(false);
            }

        } catch (SQLException e) {
            NuevoProveedor.setVisible(false);
            System.out.print("Error estado" + e);
        }
    }//GEN-LAST:event_botonguardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Limpiar();
        cargarProveedor();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonModificar;
    private javax.swing.JDialog ModificarProveedor;
    private javax.swing.JDialog NuevoProveedor;
    private javax.swing.JButton botonguardar;
    private javax.swing.JButton insertarproveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblruc;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTable tbproveedor;
    private javax.swing.JTextField txtMoDireccion;
    private javax.swing.JTextField txtModCod;
    private javax.swing.JTextField txtModNombre;
    private javax.swing.JTextField txtModRuc;
    private javax.swing.JTextField txtModTelefono;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtruc;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JLabel verificaciondedatos;
    // End of variables declaration//GEN-END:variables
}
