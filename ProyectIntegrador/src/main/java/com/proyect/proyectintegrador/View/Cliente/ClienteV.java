package com.proyect.proyectintegrador.View.Cliente;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrCliente;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ClienteV extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;

    public ClienteV() {
        initComponents();
        NuevoCliente.pack();
        NuevoCliente.setLocationRelativeTo(this);
        ModificarCliente.pack();
        ModificarCliente.setLocationRelativeTo(this);
        botonguardarcliente.setEnabled(false);
        windoweliminarcliente.setEnabled(false);
        windowmodificarcliente.setEnabled(false);
        txtcodigocliente.setEnabled(false);
        cargarCliente();
        Habilitar();
    }

    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbcliente.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                windoweliminarcliente.setEnabled(true);
                windowmodificarcliente.setEnabled(true);
            } else {
                windoweliminarcliente.setEnabled(false);
                windowmodificarcliente.setEnabled(false);
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

    private void cargarCliente() {
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrCliente client = new CtrCliente();
            List<Cliente> clientes = client.cargarCliente();
            if (clientes != null && !clientes.isEmpty()) {
                Object[] columnNames = {"Codigo", "Nombre", "Apellido", "Documento", "Direccion", "Telefono"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);
                for (Cliente cliente : clientes) {
                    if (cliente.getEstado()) {
                        Object[] datos = new Object[6];
                        datos[0] = cliente.getCodcliente();
                        datos[1] = cliente.getNombre();
                        datos[2] = cliente.getApellido();
                        datos[3] = cliente.getDocumento();
                        datos[4] = cliente.getDireccion();
                        datos[5] = cliente.getTelefono();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                tbcliente.setModel(model);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla: " + e.getMessage());
        }

        verificaciondatos.setVisible(!datosEncontrados);
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbcliente.getModel();
        model.setRowCount(0);
    }

    private void limpiarcajasTexto() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtdocumento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
    }

    private void validarNuevoCliente() {
        CtrlValidacion val = new CtrlValidacion();
        String documento = txtdocumento.getText().trim();
        String telefono = txttelefono.getText().trim();
        if (txtnombre.getText().isEmpty()) {
            lblnombre.setText("Rellene el campo");
        } else {
            lblnombre.setText("");
        }

        if (txtapellido.getText().isEmpty()) {
            lblapellido.setText("Rellene el campo");
        } else {
            lblapellido.setText("");
        }

        if (documento.isEmpty()) {
            lbldocumento.setText("Rellene el campo");
        } else if (!val.validarDni(documento)) {
            lbldocumento.setText("Coloque 8 digitos Numericos");
        } else {
            lbldocumento.setText("");
        }

        if (txtdireccion.getText().isEmpty()) {
            lbldireccion.setText("Rellene el campo");
        } else {
            lbldireccion.setText("");
        }

        if (telefono.isEmpty()) {
            lbltelefono.setText("Rellene el campo");
        } else if (!val.validarTelefono(telefono)) {
            lbltelefono.setText("Coloque 9 digitos Numericos");
        } else {
            lbltelefono.setText("");
        }

        if (txtnombre.getText().isEmpty() || txtapellido.getText().isEmpty() || documento.isEmpty()
                || !val.validarDni(documento) || txtdireccion.getText().isEmpty() || telefono.isEmpty()
                || !val.validarTelefono(telefono)) {

            botonguardarcliente.setEnabled(false);

        } else {
            botonguardarcliente.setEnabled(true);
        }

    }

    private void validarmodCliente() {
        CtrlValidacion val = new CtrlValidacion();
        String documento = txtmoddocumento.getText().trim();
        String telefono = txtmodtelefono.getText().trim();

        if (txtmodnombre.getText().isEmpty()) {
            lblmodnombre.setText("Rellene el campo");
        } else {
            lblmodnombre.setText("");
        }

        if (txtmodapellido.getText().isEmpty()) {
            lblmodapellido.setText("Rellene el campo");
        } else {
            lblmodapellido.setText("");
        }
        if (documento.isEmpty()) {
            lblmoddocumento.setText("Rellene el campo");
        } else if (!val.validarDni(documento)) {
            lblmoddocumento.setText("Coloque 8 digitos Numericos");
        } else {
            lblmoddocumento.setText("");
        }

        if (txtmoddireccion.getText().isEmpty()) {
            lblmoddireccion.setText("Rellene el campo");
        } else {
            lblmoddireccion.setText("");
        }

        if (telefono.isEmpty()) {
            lblmodtelefono.setText("Rellene el campo");
        } else if (!val.validarTelefono(telefono)) {
            lblmodtelefono.setText("Coloque 9 digitos Numericos");
        } else {
            lblmodtelefono.setText("");
        }

        if (txtmodnombre.getText().isEmpty() || txtmodapellido.getText().isEmpty()
                || documento.isEmpty() || !val.validarDni(documento) || txtmoddireccion.getText().isEmpty()
                || telefono.isEmpty() || !val.validarTelefono(telefono)) {
            guardarmodcliente.setEnabled(false);
        } else {
            guardarmodcliente.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevoCliente = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblapellido = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        lbldocumento = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        lbldireccion = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lbltelefono = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonguardarcliente = new javax.swing.JButton();
        ModificarCliente = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        txtmodapellido = new javax.swing.JTextField();
        lblmoddocumento = new javax.swing.JLabel();
        txtmoddocumento = new javax.swing.JTextField();
        lblmoddireccion = new javax.swing.JLabel();
        txtmoddireccion = new javax.swing.JTextField();
        lblmodtelefono = new javax.swing.JLabel();
        txtmodtelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblmodnombre = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtmodnombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblmodapellido = new javax.swing.JLabel();
        guardarmodcliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtcodigocliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcliente = new javax.swing.JTable();
        windownuevocliente = new javax.swing.JButton();
        windoweliminarcliente = new javax.swing.JButton();
        windowmodificarcliente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        verificaciondatos = new javax.swing.JLabel();

        NuevoCliente.setModal(true);
        NuevoCliente.setResizable(false);

        jLabel1.setText("Nuevo Cliente:");

        jLabel2.setText("Nombre:");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidoKeyReleased(evt);
            }
        });

        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyReleased(evt);
            }
        });

        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdireccionKeyReleased(evt);
            }
        });

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
        });

        jLabel8.setText("Apellidos:");

        jLabel9.setText("DNI:");

        jLabel10.setText("Direccion:");

        jLabel11.setText("Telefono:");

        botonguardarcliente.setText("Guardar");
        botonguardarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarclienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NuevoClienteLayout = new javax.swing.GroupLayout(NuevoCliente.getContentPane());
        NuevoCliente.getContentPane().setLayout(NuevoClienteLayout);
        NuevoClienteLayout.setHorizontalGroup(
            NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoClienteLayout.createSequentialGroup()
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NuevoClienteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonguardarcliente))
                    .addGroup(NuevoClienteLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtdireccion)
                            .addComponent(txtdocumento)
                            .addComponent(txtapellido)
                            .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre)
                            .addComponent(lblapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        NuevoClienteLayout.setVerticalGroup(
            NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoClienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(botonguardarcliente)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        ModificarCliente.setResizable(false);

        jLabel12.setText("Telefono:");

        txtmodapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmodapellidoKeyReleased(evt);
            }
        });

        txtmoddocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmoddocumentoKeyReleased(evt);
            }
        });

        txtmoddireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmoddireccionKeyReleased(evt);
            }
        });

        txtmodtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmodtelefonoKeyReleased(evt);
            }
        });

        jLabel3.setText("Nombre:");

        jLabel13.setText("Apellidos:");

        jLabel14.setText("DNI:");

        txtmodnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmodnombreKeyReleased(evt);
            }
        });

        jLabel15.setText("Direccion:");

        guardarmodcliente.setText("Guardar");
        guardarmodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarmodclienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Modificar Cliente");

        jLabel5.setText("Codigo:");

        javax.swing.GroupLayout ModificarClienteLayout = new javax.swing.GroupLayout(ModificarCliente.getContentPane());
        ModificarCliente.getContentPane().setLayout(ModificarClienteLayout);
        ModificarClienteLayout.setHorizontalGroup(
            ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarClienteLayout.createSequentialGroup()
                        .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ModificarClienteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(guardarmodcliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ModificarClienteLayout.createSequentialGroup()
                                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12)
                                    .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmodtelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txtmoddireccion)
                                    .addComponent(txtmoddocumento)
                                    .addComponent(txtmodapellido)
                                    .addComponent(lblmodnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmodnombre)
                                    .addComponent(lblmodapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblmoddocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblmoddireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblmodtelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcodigocliente))))
                        .addGap(32, 32, 32))))
        );
        ModificarClienteLayout.setVerticalGroup(
            ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificarClienteLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addComponent(lblmodnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmodnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmodapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmodapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmoddocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmoddocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmoddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmoddireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmodtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmodtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(guardarmodcliente)
                .addGap(17, 17, 17))
        );

        tbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbcliente);

        windownuevocliente.setText("Nuevo");
        windownuevocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windownuevoclienteActionPerformed(evt);
            }
        });

        windoweliminarcliente.setText("Eliminar");
        windoweliminarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windoweliminarclienteActionPerformed(evt);
            }
        });

        windowmodificarcliente.setText("Modificar");
        windowmodificarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowmodificarclienteActionPerformed(evt);
            }
        });

        jButton4.setText("Recargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        verificaciondatos.setText("Sin Datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(windownuevocliente)
                        .addGap(18, 18, 18)
                        .addComponent(windoweliminarcliente)
                        .addGap(18, 18, 18)
                        .addComponent(windowmodificarcliente)
                        .addGap(126, 126, 126)
                        .addComponent(verificaciondatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windownuevocliente)
                    .addComponent(windoweliminarcliente)
                    .addComponent(windowmodificarcliente)
                    .addComponent(jButton4)
                    .addComponent(verificaciondatos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void windownuevoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windownuevoclienteActionPerformed
        lblnombre.setText("");
        lblapellido.setText("");
        lbldocumento.setText("");
        lbldireccion.setText("");
        lbltelefono.setText("");
        limpiarcajasTexto();
        NuevoCliente.setVisible(true);
        botonguardarcliente.setEnabled(false);
    }//GEN-LAST:event_windownuevoclienteActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        validarNuevoCliente();
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased
        validarNuevoCliente();
    }//GEN-LAST:event_txtapellidoKeyReleased

    private void txtdocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyReleased
        validarNuevoCliente();
    }//GEN-LAST:event_txtdocumentoKeyReleased

    private void txtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyReleased
        validarNuevoCliente();
    }//GEN-LAST:event_txtdireccionKeyReleased

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        validarNuevoCliente();
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void botonguardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarclienteActionPerformed
        try {
            Connection con = Connect.getConnection();
            Cliente client = new Cliente();
            CtrCliente ctrclient = new CtrCliente();
            String documento = txtdocumento.getText().trim();
            if (ctrclient.verificarDocumentoExistente(con, documento)) {
                lbldocumento.setText("Cliente ya existente");
            } else {
                client.setNombre(txtnombre.getText().trim());
                client.setApellido(txtapellido.getText().trim());
                client.setDocumento(documento);
                client.setDireccion(txtdireccion.getText().trim());
                client.setTelefono(txttelefono.getText().trim());
                client.setEstado(Boolean.TRUE);
                ctrclient.agregarCliente(client);
                Limpiar();
                cargarCliente();
                NuevoCliente.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.print("Error al agregar Cliente: " + e);
        }
    }//GEN-LAST:event_botonguardarclienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Limpiar();
        cargarCliente();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void windoweliminarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windoweliminarclienteActionPerformed
        try {
            int selectedRow = tbcliente.getSelectedRow();
            long idcliente = 0;
            Connection con = Connect.getConnection();
            CtrCliente ctrclient = new CtrCliente();
            Cliente client = new Cliente();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbcliente.getModel();
                String idValue = model.getValueAt(selectedRow, 0).toString();
                idcliente = Long.parseLong(idValue);
                if (ctrclient.verificarCodigoexisteVenta(con, idcliente)) {
                    JOptionPane.showMessageDialog(null, "No se puede Eliminar");
                } else {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el Cliente?");
                    switch (opcion) {
                        case 0:
                            boolean estado = false;
                            try {
                                client.setCodcliente(idcliente);
                                client.setEstado(estado);
                                ctrclient.cambiarEstadoCliente(client);
                                Limpiar();
                                cargarCliente();

                            } catch (SQLException e) {
                                System.out.print("Error al eliminar el Cliente" + e);
                            }
                        case 1:
                            break;
                        default:
                            break;
                    }
                }
            } else {
                System.out.print("Error al seleccionar Cliente");
            }
        } catch (SQLException e) {
            System.out.print("Error"+e);
        }
    }//GEN-LAST:event_windoweliminarclienteActionPerformed

    private void txtmodapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodapellidoKeyReleased
        validarmodCliente();
    }//GEN-LAST:event_txtmodapellidoKeyReleased

    private void txtmoddocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmoddocumentoKeyReleased
        validarmodCliente();
    }//GEN-LAST:event_txtmoddocumentoKeyReleased

    private void txtmoddireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmoddireccionKeyReleased
        validarmodCliente();
    }//GEN-LAST:event_txtmoddireccionKeyReleased

    private void txtmodtelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodtelefonoKeyReleased
        validarmodCliente();
    }//GEN-LAST:event_txtmodtelefonoKeyReleased

    private void txtmodnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodnombreKeyReleased
        validarmodCliente();
    }//GEN-LAST:event_txtmodnombreKeyReleased

    private void windowmodificarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowmodificarclienteActionPerformed
        lblmodnombre.setText("");
        lblmodapellido.setText("");
        lblmoddocumento.setText("");
        lblmoddireccion.setText("");
        lblmodtelefono.setText("");
        guardarmodcliente.setEnabled(true);
        int selectedRow = tbcliente.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tbcliente.getModel();
            Object data1 = model.getValueAt(selectedRow, 0);
            Object data2 = model.getValueAt(selectedRow, 1);
            Object data3 = model.getValueAt(selectedRow, 2);
            Object data4 = model.getValueAt(selectedRow, 3);
            Object data5 = model.getValueAt(selectedRow, 4);
            Object data6 = model.getValueAt(selectedRow, 5);

            txtcodigocliente.setText(data1.toString());
            txtmodnombre.setText(data2.toString());
            txtmodapellido.setText(data3.toString());
            txtmoddocumento.setText(data4.toString());
            txtmoddireccion.setText(data5.toString());
            txtmodtelefono.setText(data6.toString());

            ModificarCliente.setVisible(true);
        } else {
            System.out.print("Error al cargar la fila cliente");
        }
    }//GEN-LAST:event_windowmodificarclienteActionPerformed

    private void guardarmodclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarmodclienteActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrCliente ctrclient = new CtrCliente();
            Cliente client = new Cliente();

            String texto = txtcodigocliente.getText().trim();
            long codcliente = Long.parseLong(texto);
            String documento = txtmoddocumento.getText().trim();

            if (ctrclient.verificarDocumentoSimilar(con, documento, codcliente)) {
                lblmoddocumento.setText("El Cliente ya existe");
            } else {
                client.setCodcliente(codcliente);
                client.setNombre(txtmodnombre.getText().trim());
                client.setApellido(txtmodapellido.getText().trim());
                client.setDocumento(documento);
                client.setDireccion(txtmoddireccion.getText().trim());
                client.setTelefono(txtmodtelefono.getText().trim());
                client.setEstado(Boolean.TRUE);
                ctrclient.ModificarCliente(client);
                Limpiar();
                cargarCliente();
                ModificarCliente.setVisible(false);
            }
        } catch (SQLException e) {

        }
    }//GEN-LAST:event_guardarmodclienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ModificarCliente;
    private javax.swing.JDialog NuevoCliente;
    private javax.swing.JButton botonguardarcliente;
    private javax.swing.JButton guardarmodcliente;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lbldocumento;
    private javax.swing.JLabel lblmodapellido;
    private javax.swing.JLabel lblmoddireccion;
    private javax.swing.JLabel lblmoddocumento;
    private javax.swing.JLabel lblmodnombre;
    private javax.swing.JLabel lblmodtelefono;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTable tbcliente;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcodigocliente;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtmodapellido;
    private javax.swing.JTextField txtmoddireccion;
    private javax.swing.JTextField txtmoddocumento;
    private javax.swing.JTextField txtmodnombre;
    private javax.swing.JTextField txtmodtelefono;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windoweliminarcliente;
    private javax.swing.JButton windowmodificarcliente;
    private javax.swing.JButton windownuevocliente;
    // End of variables declaration//GEN-END:variables
}
