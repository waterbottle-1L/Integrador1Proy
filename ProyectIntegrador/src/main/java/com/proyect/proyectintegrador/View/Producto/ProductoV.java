package com.proyect.proyectintegrador.View.Producto;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrMarca;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Controller.CtrProveedor;
import com.proyect.proyectintegrador.Controller.CtrTipo;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Marca;
import com.proyect.proyectintegrador.Entitis.Producto;
import com.proyect.proyectintegrador.Entitis.Proveedor;
import com.proyect.proyectintegrador.Entitis.Tipo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ProductoV extends org.jdesktop.swingx.JXPanel {

    private boolean canEdit = true;
    private boolean canDelete = true;
    
    public ProductoV() {
        initComponents();
        NuevoProducto.pack();
        NuevoProducto.setLocationRelativeTo(this);
        botonguardarproducto.setEnabled(false);
        windoweliminarproducto.setEnabled(false);
        windowmodifyproducto.setEnabled(false);
        Habilitar();
        cargarProducto();
    }
    
    private void Habilitar() {
        ListSelectionModel selectionModel;
        selectionModel = tbproducto.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!canDelete || !canEdit) {
                return;
            }
            if (selectionModel.getSelectedItemsCount() == 1) {
                windoweliminarproducto.setEnabled(true);
                windowmodifyproducto.setEnabled(true);
            } else {
                windoweliminarproducto.setEnabled(false);
                windowmodifyproducto.setEnabled(false);
            }
        });
    }

    private void cargarProducto() {
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrProducto ctrproducto = new CtrProducto();
            List<Producto> productos = ctrproducto.cargarProductos();
            if (productos != null && !productos.isEmpty()) {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Código");
                model.addColumn("Marca");
                model.addColumn("Proveedor");
                model.addColumn("Tipo");
                model.addColumn("Nombre");
                model.addColumn("Descripcion");
                model.addColumn("Fecha");
                model.addColumn("Precio");

                for (Producto producto : productos) {
                    if (producto.getEstado()) {
                        Object[] datos = new Object[8];
                        datos[0] = producto.getCodProducto();
                        datos[1] = producto.getNombreMarca();
                        datos[2] = producto.getNombreProveedor();
                        datos[3] = producto.getNombreTipo();
                        datos[4] = producto.getNombre();
                        datos[5] = producto.getDescripcion();
                        datos[6] = producto.getFechaRegistro();
                        datos[7] = producto.getPrecio();

                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                tbproducto.setModel(model);

            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la tabla productos" + e);
        }

        verificaciondatos.setVisible(!datosEncontrados);
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbproducto.getModel();
        model.setRowCount(0);
    }

    private void validarNuevoProducto() {
        CtrlValidacion val = new CtrlValidacion();
        String precio = txtprecioproducto.getText();

        // Validar el campo de nombre
        if (txtnombreproducto.getText().isEmpty()) {
            lblnombrenuevoproducto.setText("Rellene el Campo");
        } else {
            lblnombrenuevoproducto.setText("");
        }

        // Validar el campo de descripción
        if (txtareardescripcion.getText().isEmpty()) {
            lblnuevadescripcion.setText("Rellene el campo");
        } else {
            lblnuevadescripcion.setText("");
        }
        if (precio.isEmpty()) {
            lblnuevoprecio.setText("Rellene el campo");
        } else if (!val.validarNumeros(precio)) {
            lblnuevoprecio.setText("Solo coloque 'Numeros'");
        } else {
            lblnuevoprecio.setText("");
        }

        // Habilitar o deshabilitar el botón según la validación
        if (txtnombreproducto.getText().isEmpty() || txtareardescripcion.getText().isEmpty()
                || precio.isEmpty() || !val.validarNumeros(precio)) {
            botonguardarproducto.setEnabled(false);
        } else {
            botonguardarproducto.setEnabled(true);
        }
    }

    public void cargarMarca() {
        try (Connection con = Connect.getConnection()) {
            CtrMarca marc = new CtrMarca();
            List<Marca> marcas = marc.cargarMarca();
            if (marcas != null && !marcas.isEmpty()) {
                jComboBoxnuevamarca.removeAllItems();
                jComboBoxnuevamarca.addItem("Seleccione la marca:");
                for (Marca marca : marcas) {
                    if (marca.getEstado()) {
                        jComboBoxnuevamarca.addItem(marca.getNombre());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar marca" + e);
        }
    }

    public void cargarProveedor() {
        try (Connection con = Connect.getConnection()) {
            CtrProveedor pro = new CtrProveedor();
            List<Proveedor> proveedores = pro.cargarProveedor();

            if (proveedores != null && !proveedores.isEmpty()) {
                jComboBoxnuevoproveedor.removeAllItems();
                jComboBoxnuevoproveedor.addItem("Seleccione el proveedor:");
                for (Proveedor proveedor : proveedores) {
                    if (proveedor.getEstado()) {
                        jComboBoxnuevoproveedor.addItem(proveedor.getNombre());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar proveedor" + e);
        }
    }

    public void cargarTipo() {
        try (Connection con = Connect.getConnection()) {
            CtrTipo tip = new CtrTipo();
            List<Tipo> tipos = tip.cargarTipo();
            if (tipos != null && !tipos.isEmpty()) {
                jComboBoxnuevotipo.removeAllItems();
                jComboBoxnuevotipo.addItem("Seleccione el tipo:");
                for (Tipo tipo : tipos) {
                    if (tipo.getEstado()) {
                        jComboBoxnuevotipo.addItem(tipo.getNombre());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Error al cargar tipo" + e);
        }
    }
    
    private void limpiarCajasdeTexto(){
        txtnombreproducto.setText("");
        txtareardescripcion.setText("");
        txtprecioproducto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevoProducto = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblnombrenuevoproducto = new javax.swing.JLabel();
        txtnombreproducto = new javax.swing.JTextField();
        lblnuevadescripcion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareardescripcion = new javax.swing.JTextArea();
        lblnuevoprecio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblcodnuevamarca = new javax.swing.JLabel();
        jComboBoxnuevamarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblcodnuevoproveedor = new javax.swing.JLabel();
        jComboBoxnuevoproveedor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblcodnuevotipo = new javax.swing.JLabel();
        jComboBoxnuevotipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        botonguardarproducto = new javax.swing.JButton();
        txtprecioproducto = new javax.swing.JTextField();
        windownuevoproducto = new javax.swing.JButton();
        windoweliminarproducto = new javax.swing.JButton();
        windowmodifyproducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproducto = new javax.swing.JTable();
        verificaciondatos = new javax.swing.JLabel();
        botoncargar = new javax.swing.JButton();

        NuevoProducto.setModal(true);
        NuevoProducto.setResizable(false);

        jLabel1.setText("Nuevo Producto");

        jLabel2.setText("Nombre: ");

        txtnombreproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreproductoKeyReleased(evt);
            }
        });

        jLabel5.setText("Descripcion:");

        txtareardescripcion.setColumns(20);
        txtareardescripcion.setRows(5);
        txtareardescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtareardescripcionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtareardescripcion);

        jLabel3.setText("Precio:");

        jComboBoxnuevamarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No existe Marca", " " }));

        jLabel4.setText("Marca:");

        jComboBoxnuevoproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No existe Proveedor" }));

        jLabel6.setText("Proveedor:");

        jComboBoxnuevotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No existe Tipo" }));

        jLabel7.setText("Tipo:");

        botonguardarproducto.setText("Guardar");
        botonguardarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarproductoActionPerformed(evt);
            }
        });

        txtprecioproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioproductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout NuevoProductoLayout = new javax.swing.GroupLayout(NuevoProducto.getContentPane());
        NuevoProducto.getContentPane().setLayout(NuevoProductoLayout);
        NuevoProductoLayout.setHorizontalGroup(
            NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoProductoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonguardarproducto)
                    .addGroup(NuevoProductoLayout.createSequentialGroup()
                        .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxnuevotipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxnuevoproveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxnuevamarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblnombrenuevoproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombreproducto)
                            .addComponent(lblnuevadescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(lblnuevoprecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcodnuevamarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcodnuevoproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcodnuevotipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprecioproducto))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        NuevoProductoLayout.setVerticalGroup(
            NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoProductoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(lblnombrenuevoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnuevadescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnuevoprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtprecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcodnuevamarca, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxnuevamarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcodnuevoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxnuevoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcodnuevotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxnuevotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(botonguardarproducto)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        windownuevoproducto.setText("Nuevo");
        windownuevoproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windownuevoproductoActionPerformed(evt);
            }
        });

        windoweliminarproducto.setText("Eliminar");
        windoweliminarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windoweliminarproductoActionPerformed(evt);
            }
        });

        windowmodifyproducto.setText("Modificar");

        tbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbproducto);

        verificaciondatos.setText("Sin Datos");

        botoncargar.setText("Recargar");
        botoncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(windownuevoproducto)
                        .addGap(18, 18, 18)
                        .addComponent(windoweliminarproducto)
                        .addGap(18, 18, 18)
                        .addComponent(windowmodifyproducto)
                        .addGap(112, 112, 112)
                        .addComponent(verificaciondatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botoncargar)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windownuevoproducto)
                    .addComponent(windoweliminarproducto)
                    .addComponent(windowmodifyproducto)
                    .addComponent(verificaciondatos)
                    .addComponent(botoncargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncargarActionPerformed
        Limpiar();
        cargarProducto();
    }//GEN-LAST:event_botoncargarActionPerformed

    private void windownuevoproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windownuevoproductoActionPerformed
        lblnombrenuevoproducto.setText("");
        lblnuevadescripcion.setText("");
        lblnuevoprecio.setText("");
        botonguardarproducto.setEnabled(false);
        cargarMarca();
        cargarProveedor();
        cargarTipo();
        limpiarCajasdeTexto();
        NuevoProducto.setVisible(true);
        

    }//GEN-LAST:event_windownuevoproductoActionPerformed

    private void txtnombreproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreproductoKeyReleased
        validarNuevoProducto();
    }//GEN-LAST:event_txtnombreproductoKeyReleased

    private void txtareardescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtareardescripcionKeyReleased
        validarNuevoProducto();
    }//GEN-LAST:event_txtareardescripcionKeyReleased

    private void txtprecioproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioproductoKeyReleased
        validarNuevoProducto();
    }//GEN-LAST:event_txtprecioproductoKeyReleased

    private void botonguardarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarproductoActionPerformed
        try {
            Connection con = Connect.getConnection();
            CtrProducto ctrproduct = new CtrProducto();
            String nombre = txtnombreproducto.getText().trim();
            String idmarca = jComboBoxnuevamarca.getSelectedItem().toString().trim();
            String idproveedor = jComboBoxnuevoproveedor.getSelectedItem().toString().trim();
            String idtipo = jComboBoxnuevotipo.getSelectedItem().toString().trim();
            String descipcion = txtareardescripcion.getText().trim();
            Double precio =  Double.parseDouble(txtprecioproducto.getText().trim());
            boolean errores = false;
            if (ctrproduct.verificarNombreExistente(con, nombre)) {
                lblnombrenuevoproducto.setText("Producto ya existente");
                errores = true;
            }else{
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
            }

            if (!errores) {
                CtrMarca marca = new CtrMarca();
                CtrProveedor prov = new CtrProveedor();
                CtrTipo tipo = new CtrTipo();
                Producto produc = new Producto();
                
                Long codmarca = marca.obtenerIdMarcaPorNombre(con, idmarca);
                Long codprov = prov.obtenerIdProveedorPorNombre(con, idproveedor);
                Long codtipo = tipo.obtenerIdTipoPorNombre(con, idtipo);
                
                produc.setCodMarca(codmarca);
                produc.setCodProveedor(codprov);
                produc.setCodTipo(codtipo);
                produc.setNombre(nombre);
                produc.setDescripcion(descipcion);
                produc.setPrecio(precio);
                produc.setEstado(Boolean.TRUE);
                ctrproduct.agregarProducto(produc);
                
                Limpiar();
                cargarProducto();
                NuevoProducto.setVisible(false);
                
            } else {
                // Si se encontraron errores, no se realizará el proceso de guardar
                System.out.println("No se pudo guardar debido a errores.");
            }

        } catch (SQLException e) {
            System.out.println("Error" +e);
        }
    }//GEN-LAST:event_botonguardarproductoActionPerformed

    private void windoweliminarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windoweliminarproductoActionPerformed
       int selectedRow = tbproducto.getSelectedRow();
        long idproducto = 0;
        Connection con = Connect.getConnection();
        CtrProducto ctrproduct = new CtrProducto();
        Producto produc = new Producto();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tbproducto.getModel();
            String idValue = model.getValueAt(selectedRow, 0).toString();
            idproducto = Long.parseLong(idValue);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?");
            switch (opcion) {
                case 0:
                    boolean estado = false;
                    try{
                        produc.setCodProducto(idproducto);
                        produc.setEstado(Boolean.FALSE);
                        ctrproduct.cambiarEstadoProducto(produc);
                        Limpiar();
                        cargarProducto();
                    }catch(SQLException e){
                        System.out.print("Error al eliminar producto" + e);
                    }
                case 1:
                    break;
                default:
                    break;
            }
            
        }else{
            System.out.print("Error al seleccionar producto");
        }
    }//GEN-LAST:event_windoweliminarproductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog NuevoProducto;
    private javax.swing.JButton botoncargar;
    private javax.swing.JButton botonguardarproducto;
    private javax.swing.JComboBox<String> jComboBoxnuevamarca;
    private javax.swing.JComboBox<String> jComboBoxnuevoproveedor;
    private javax.swing.JComboBox<String> jComboBoxnuevotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcodnuevamarca;
    private javax.swing.JLabel lblcodnuevoproveedor;
    private javax.swing.JLabel lblcodnuevotipo;
    private javax.swing.JLabel lblnombrenuevoproducto;
    private javax.swing.JLabel lblnuevadescripcion;
    private javax.swing.JLabel lblnuevoprecio;
    private javax.swing.JTable tbproducto;
    private javax.swing.JTextArea txtareardescripcion;
    private javax.swing.JTextField txtnombreproducto;
    private javax.swing.JTextField txtprecioproducto;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JButton windoweliminarproducto;
    private javax.swing.JButton windowmodifyproducto;
    private javax.swing.JButton windownuevoproducto;
    // End of variables declaration//GEN-END:variables
}
