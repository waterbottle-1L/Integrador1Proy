package com.proyect.proyectintegrador.View.Producto;

import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrProducto;
import com.proyect.proyectintegrador.Entitis.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductoV extends org.jdesktop.swingx.JXPanel {

    public ProductoV() {
        initComponents();
        verificaciondedatos.setVisible(false);
        cargarProducto();
    }

    private void cargarProducto() {
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
                model.addColumn("Fecha de Registro");
                model.addColumn("Precio");

                for (Producto producto : productos) {
                    if (producto.getEstado() == true) {
                        Object[] datos = new Object[9];
                        datos[0] = producto.getCodProducto();
                        datos[1] = producto.getNombreMarca();
                        datos[2] = producto.getNombreProveedor();
                        datos[3] = producto.getNombreTipo();
                        datos[4] = producto.getNombre();
                        datos[5] = producto.getDescripcion();
                        datos[6] = producto.getFechaRegistro();
                        datos[7] = producto.getPrecio();
                        datos[8] = producto.getEstado();
                        model.addRow(datos);
                    }
                }
                verificaciondedatos.setVisible(false);
                tbproducto.setModel(model);

            } else {
                verificaciondedatos.setVisible(true);
                System.out.println("No se encontraron productos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la tabla productos" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproducto = new javax.swing.JTable();
        verificaciondedatos = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("Nuevo");

        jButton2.setText("Eliminar");

        jButton3.setText("Modificar");

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

        verificaciondedatos.setText("Sin Datos");

        jButton4.setText("Recargar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(112, 112, 112)
                        .addComponent(verificaciondedatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(verificaciondedatos)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbproducto;
    private javax.swing.JLabel verificaciondedatos;
    // End of variables declaration//GEN-END:variables
}
