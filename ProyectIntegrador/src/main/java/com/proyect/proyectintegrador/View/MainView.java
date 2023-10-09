package com.proyect.proyectintegrador.View;

import com.proyect.proyectintegrador.Controller.CtrlUsuario;
import com.proyect.proyectintegrador.View.Cliente.ClienteView;
import com.proyect.proyectintegrador.View.Inventario.InventarioView;
import com.proyect.proyectintegrador.View.Producto.ProductoView;
import com.proyect.proyectintegrador.View.Venta.VentaView;
import com.proyect.proyectintegrador.modelo.usuario;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class MainView extends org.jdesktop.swingx.JXFrame {
    
    public MainView() {
        initComponents();
        this.setSize(new Dimension(1300, 800));
        this.setLocationRelativeTo(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ProveedorButton = new javax.swing.JButton();
        ClienteButton = new javax.swing.JButton();
        InventarioButton = new javax.swing.JButton();
        VenatsButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.add(filler1);

        ProveedorButton.setText("Producto");
        ProveedorButton.setFocusable(false);
        ProveedorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ProveedorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ProveedorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedorButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ProveedorButton);

        ClienteButton.setText("Cliente");
        ClienteButton.setFocusable(false);
        ClienteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ClienteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ClienteButton);

        InventarioButton.setText("Inventario");
        InventarioButton.setFocusable(false);
        InventarioButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InventarioButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InventarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(InventarioButton);

        VenatsButton.setText("Ventas");
        VenatsButton.setFocusable(false);
        VenatsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        VenatsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        VenatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenatsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(VenatsButton);
        jToolBar1.add(filler2);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProveedorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedorButtonActionPerformed
        ProductoView pro = new ProductoView();
        jDesktopPane1.add(pro);
        pro.setVisible(true);
        pro.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                ProveedorButton.setEnabled(true);
                pro.setVisible(false);
            }
            
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
        ProveedorButton.setEnabled(false);
    }//GEN-LAST:event_ProveedorButtonActionPerformed

    private void ClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteButtonActionPerformed
        ClienteView client = new ClienteView();
        jDesktopPane1.add(client);
        client.setVisible(true);
        client.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                ClienteButton.setEnabled(true);
                client.setVisible(false);
            }
            
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
        
        ClienteButton.setEnabled(false);
    }//GEN-LAST:event_ClienteButtonActionPerformed

    private void InventarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioButtonActionPerformed
        InventarioView IV = new InventarioView();
        jDesktopPane1.add(IV);
        IV.setVisible(true);
        IV.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                InventarioButton.setEnabled(true);
                IV.setVisible(false);
            }
            
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
        InventarioButton.setEnabled(false);
    }//GEN-LAST:event_InventarioButtonActionPerformed

    private void VenatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenatsButtonActionPerformed
        VentaView venta = new VentaView();
        jDesktopPane1.add(venta);
        venta.setVisible(true);
        venta.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                VenatsButton.setEnabled(true);
                venta.setVisible(false);
            }
            
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }
            
            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
        
        VenatsButton.setEnabled(false);
    }//GEN-LAST:event_VenatsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClienteButton;
    private javax.swing.JButton InventarioButton;
    private javax.swing.JButton ProveedorButton;
    private javax.swing.JButton VenatsButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
