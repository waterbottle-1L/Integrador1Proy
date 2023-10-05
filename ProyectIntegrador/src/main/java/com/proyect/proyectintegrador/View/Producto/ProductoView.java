package com.proyect.proyectintegrador.View.Producto;

import java.beans.PropertyVetoException;

public class ProductoView extends javax.swing.JInternalFrame {

    public ProductoView() {
        initComponents();
        this.setSize(800, 600);
        jTabbedPane1.add("Marca", MarcaTabInstance());
        jTabbedPane1.add("Proveedor", ProveedorTabInstance());
        jTabbedPane1.add("Tipo",TipotabInstace());
        jTabbedPane1.add("Producto",ProductoInstace());
    }

    private MarcaV MarcaTabInstance() {
        return new MarcaV();
    }

    private ProveedorV ProveedorTabInstance() {
        return new ProveedorV();
    }
    
    private TipoV TipotabInstace(){
        return new TipoV();
    }

    private ProductoV ProductoInstace(){
        return new ProductoV();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setClosable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
