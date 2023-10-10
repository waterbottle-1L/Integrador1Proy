package com.proyect.proyectintegrador.View.Venta;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrCliente;
import com.proyect.proyectintegrador.Controller.CtrComprobante;
import com.proyect.proyectintegrador.Controller.CtrMetodoPago;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Controller.CtrlInventario;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Cliente;
import com.proyect.proyectintegrador.Entitis.Comprobante;
import com.proyect.proyectintegrador.Entitis.DetalleVenta;
import com.proyect.proyectintegrador.Entitis.Inventario;
import com.proyect.proyectintegrador.Entitis.MetodoPago;
import com.proyect.proyectintegrador.View.Login.LoginView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaV extends javax.swing.JPanel {
    
    ArrayList<DetalleVenta> listaproductos = new ArrayList<>();
    private DefaultTableModel modeloDatosProductos;

    public VentaV() {
        
        initComponents();
        long valor = LoginView.getCodempleado();
        String cod = String.valueOf(valor);
        lblprueba.setText(cod);
        txtsubtotal.setEnabled(false);
        txttotalapagar.setEnabled(false);
        botonañadir.setEnabled(false);
        cargarCliente();
        cargarInventarioProducto();
        cargarComprobante();
        cargarMetodoPago();
        cargarColumnas();
        
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
    
    private void cargarColumnas() {
        Object[] columnNames = {"N", "Nombre", "Cantidad", "P. Unitario", "Sub Total", "IGV", "Total a Pagar", "Accion"};
        nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);
        tbventa.setModel(model);
    }
    
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaproductos.size());
        for (int i = 0; i < listaproductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getPreciounitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getSubtotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getIgv(), i, 5);
            this.modeloDatosProductos.setValueAt(listaproductos.get(i).getTotalapagar(), i, 6);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 7);//aqui luego poner un boton de eliminar
        }
        tbventa.setModel(modeloDatosProductos);
    }
    
    public void cargarCliente() {
        try (Connection con = Connect.getConnection()) {
            CtrCliente client = new CtrCliente();
            List<Cliente> clientes = client.cargarCliente();
            if (clientes != null && !clientes.isEmpty()) {
                jComboBoxcliente.removeAllItems();
                jComboBoxcliente.addItem("Seleccione el Cliente");
                for (Cliente cliente : clientes) {
                    if (cliente.getEstado()) {
                        jComboBoxcliente.addItem(cliente.getNombre() + "|" + cliente.getDocumento());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar cliente" + e);
        }
    }
    
    public void cargarInventarioProducto() {
        try (Connection con = Connect.getConnection()) {
            CtrlInventario ctrin = new CtrlInventario();
            List<Inventario> inventarios = ctrin.cargarInventario();
            if (inventarios != null && !inventarios.isEmpty()) {
                jComboBoxinventarioproducto.removeAllItems();
                jComboBoxinventarioproducto.addItem("Seleccione el Producto");
                for (Inventario inventario : inventarios) {
                    jComboBoxinventarioproducto.addItem(inventario.getNombreproducto());
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar Producto" + e);
        }
    }
    
    public void cargarComprobante() {
        try (Connection con = Connect.getConnection()) {
            CtrComprobante com = new CtrComprobante();
            List<Comprobante> comprobantes = com.cargarComprobante();
            if (comprobantes != null && !comprobantes.isEmpty()) {
                jComboBoxcomprobante.removeAllItems();
                jComboBoxcomprobante.addItem("Seleccione el Comprobante");
                for (Comprobante comprobante : comprobantes) {
                    jComboBoxcomprobante.addItem(comprobante.getComprobante());
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar Comprobante" + e);
        }
    }
    
    public void cargarMetodoPago() {
        try (Connection con = Connect.getConnection()) {
            CtrMetodoPago met = new CtrMetodoPago();
            List<MetodoPago> metodos = met.cargarMetodoPago();
            if (metodos != null && !metodos.isEmpty()) {
                jComboBoxmetodopago.removeAllItems();
                jComboBoxmetodopago.addItem("Seleccione el Metodo");
                for (MetodoPago metodo : metodos) {
                    jComboBoxmetodopago.addItem(metodo.getMetodopago());
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar Comprobante" + e);
        }
    }
    
    private void validacionVentas() {
        CtrlValidacion val = new CtrlValidacion();
        String cantidad = txtcantidad.getText().trim();
        if (cantidad.isEmpty()) {
            lblcantidad.setText("Cololoque la cantidad");
        } else if (!val.validarNumerosenteros(cantidad)) {
            lblcantidad.setText("Solo Numero enteros");
        }else{
            lblcantidad.setText("");
        }
        
        if (cantidad.isEmpty() || !val.validarNumerosenteros(cantidad) ) {
            botonañadir.setEnabled(false);
        } else {
            botonañadir.setEnabled(true);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblprueba = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbventa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblcliente = new javax.swing.JLabel();
        jComboBoxcliente = new javax.swing.JComboBox<>();
        jComboBoxinventarioproducto = new javax.swing.JComboBox<>();
        lblproducto = new javax.swing.JLabel();
        txtbuscarproducto = new javax.swing.JTextField();
        txtbuscardni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonbuscarproducto = new javax.swing.JButton();
        botonbuscarcliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txttotalapagar = new javax.swing.JTextField();
        jComboBoxcomprobante = new javax.swing.JComboBox<>();
        jComboBoxmetodopago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        botonañadir = new javax.swing.JButton();
        botonregistrarventa = new javax.swing.JButton();
        lblcantidad = new javax.swing.JLabel();

        lblprueba.setText("jLabel1");

        tbventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbventa);

        jLabel1.setText("Empleado:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Producto:");

        jComboBoxcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxinventarioproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Buscar Producto por Nombre");

        jLabel7.setText("Comprobante");

        botonbuscarproducto.setText("Buscar");
        botonbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarproductoActionPerformed(evt);
            }
        });

        botonbuscarcliente.setText("Buscar");
        botonbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarclienteActionPerformed(evt);
            }
        });

        jLabel8.setText("TOTAL A PAGAR");

        jComboBoxcomprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxmetodopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Buscar Cliente por DNI");

        jLabel10.setText("Metodo de Pago");

        jLabel11.setText("Cantidad");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
        });

        jLabel12.setText("Sub Total");

        botonañadir.setText("Añadir");
        botonañadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonañadirActionPerformed(evt);
            }
        });

        botonregistrarventa.setText("Registrar Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonregistrarventa)
                                .addGap(589, 589, 589)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxinventarioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbuscardni, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonbuscarcliente)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jComboBoxcomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jComboBoxmetodopago, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonbuscarproducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonañadir))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttotalapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(38, 38, 38)
                                    .addComponent(lblprueba))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprueba)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBoxcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtbuscardni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonbuscarcliente)
                                    .addComponent(jComboBoxcomprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxmetodopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxinventarioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonbuscarproducto)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonañadir)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalapagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(botonregistrarventa)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarclienteActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrCliente ctrclient = new CtrCliente();
            String documento = txtbuscardni.getText().trim();
            if (!ctrclient.verificarDocumentoExistente(con, documento)) {
                JOptionPane.showMessageDialog(null, "El DNI especificado no existe");
            } else {
                String doc = ctrclient.obtenerNombreCliente(con, documento);
                jComboBoxcliente.setSelectedItem(doc);
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar Comprobante" + e);
        }
    }//GEN-LAST:event_botonbuscarclienteActionPerformed

    private void botonbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarproductoActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrProducto ctrin = new CtrProducto();
            String nombre = txtbuscarproducto.getText().trim();
            if (!ctrin.verificarNombreExistente(con, nombre)) {
                JOptionPane.showMessageDialog(null, "El Nombre del producto no existe");
            } else {
                jComboBoxinventarioproducto.setSelectedItem(nombre);
            }
        } catch (SQLException e) {
            
        }
    }//GEN-LAST:event_botonbuscarproductoActionPerformed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        validacionVentas();
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void botonañadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonañadirActionPerformed

    }//GEN-LAST:event_botonañadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonañadir;
    private javax.swing.JButton botonbuscarcliente;
    private javax.swing.JButton botonbuscarproducto;
    private javax.swing.JButton botonregistrarventa;
    private javax.swing.JComboBox<String> jComboBoxcliente;
    private javax.swing.JComboBox<String> jComboBoxcomprobante;
    private javax.swing.JComboBox<String> jComboBoxinventarioproducto;
    private javax.swing.JComboBox<String> jComboBoxmetodopago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcantidad;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lblproducto;
    private javax.swing.JLabel lblprueba;
    public static javax.swing.JTable tbventa;
    private javax.swing.JTextField txtbuscardni;
    private javax.swing.JTextField txtbuscarproducto;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotalapagar;
    // End of variables declaration//GEN-END:variables
}
