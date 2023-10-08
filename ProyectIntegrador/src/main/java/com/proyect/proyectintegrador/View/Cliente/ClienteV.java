package com.proyect.proyectintegrador.View.Cliente;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrCliente;
import com.proyect.proyectintegrador.Entitis.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteV extends org.jdesktop.swingx.JXPanel {

    public ClienteV() {
        initComponents();
        NuevoCliente.pack();
        NuevoCliente.setLocationRelativeTo(this);
        cargarCliente();
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
            List<Cliente> clientes = client.cargarProductos();
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

    private void limpiarcajasTexto() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtdocumento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcliente = new javax.swing.JTable();
        windownuevocliente = new javax.swing.JButton();
        windoweliminarcliente = new javax.swing.JButton();
        windowmodificarcliente = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        verificaciondatos = new javax.swing.JLabel();

        NuevoCliente.setModal(true);

        jLabel1.setText("Nuevo Cliente:");

        jLabel2.setText("Nombre:");

        jLabel8.setText("Apellidos:");

        jLabel9.setText("DNI:");

        jLabel10.setText("Direccion:");

        jLabel11.setText("Telefono:");

        botonguardarcliente.setText("Guardar");

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

        windowmodificarcliente.setText("Modificar");

        jButton4.setText("Recargar");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog NuevoCliente;
    private javax.swing.JButton botonguardarcliente;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lbldocumento;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTable tbcliente;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windoweliminarcliente;
    private javax.swing.JButton windowmodificarcliente;
    private javax.swing.JButton windownuevocliente;
    // End of variables declaration//GEN-END:variables
}
