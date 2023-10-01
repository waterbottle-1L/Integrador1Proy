package com.proyect.proyectintegrador.View;

import com.proyect.proyectintegrador.View.Producto.ProductoView;
import java.awt.Dimension;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class MainView extends org.jdesktop.swingx.JXFrame {

    public MainView() {
        initComponents();
        loginDialog.pack();
        loginDialog.setLocationRelativeTo(this);
        this.setSize(new Dimension(1300, 800));
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginDialog = new javax.swing.JDialog(this,false);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UContraseñaPasswordField = new javax.swing.JPasswordField();
        UsarioTextField = new javax.swing.JTextField();
        UsarioLabel = new javax.swing.JLabel();
        ContraseñaLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        ProveedorButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        loginDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        loginDialog.setAlwaysOnTop(true);
        loginDialog.setName("loginDialog"); // NOI18N
        loginDialog.setResizable(false);
        loginDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                loginDialogWindowClosing(evt);
            }
        });
        loginDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/proyect/proyectintegrador/img/b1527a930c8e4522beb05de422aa5647-removebg-preview.png"))); // NOI18N

        UsarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsarioTextFieldActionPerformed(evt);
            }
        });

        UsarioLabel.setText("Usuario");

        ContraseñaLabel.setText("Contraseña");

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(UsarioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UsarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ContraseñaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(UContraseñaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsarioLabel)
                    .addComponent(UsarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContraseñaLabel)
                    .addComponent(UContraseñaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );

        loginDialog.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 270));

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

    private void loginDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_loginDialogWindowClosing

    }//GEN-LAST:event_loginDialogWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginDialog.setVisible(false);
        setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void UsarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsarioTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContraseñaLabel;
    private javax.swing.JButton ProveedorButton;
    private javax.swing.JPasswordField UContraseñaPasswordField;
    private javax.swing.JLabel UsarioLabel;
    private javax.swing.JTextField UsarioTextField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDialog loginDialog;
    // End of variables declaration//GEN-END:variables
}
