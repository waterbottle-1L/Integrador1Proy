package com.proyect.proyectintegrador.View;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.proyect.proyectintegrador.Connection.Connect;
import com.proyect.proyectintegrador.Controller.CtrEmpleado;
import com.proyect.proyectintegrador.Controller.CtrlUsuario;
import com.proyect.proyectintegrador.Controller.CtrlValidacion;
import com.proyect.proyectintegrador.Entitis.Empleado;

import com.proyect.proyectintegrador.View.Cliente.ClienteView;
import com.proyect.proyectintegrador.View.Inventario.InventarioView;
import com.proyect.proyectintegrador.View.Producto.ProductoView;
import com.proyect.proyectintegrador.View.Venta.GestionVentaView;
import com.proyect.proyectintegrador.View.Venta.VentaView;
import com.proyect.proyectintegrador.modelo.usuario;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class MainView extends org.jdesktop.swingx.JXFrame {

    public MainView() {
        initComponents();
        this.setSize(new Dimension(1300, 800));
        this.setLocationRelativeTo(null);
        LoginDialoj.pack();
        GestionEmpleado.pack();
        LoginDialoj.setLocationRelativeTo(this);
        GestionEmpleado.setLocationRelativeTo(this);
        NuevoEmpleado.pack();
        NuevoEmpleado.setLocationRelativeTo(this);
        botonisertarempleado.setEnabled(false);
        txtfechanacimiento.setMaxSelectableDate(new Date());

        cargarTablaEmpleado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LoginDialoj = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtloginempleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        verificacionloginempleado = new javax.swing.JLabel();
        txtcotraempleadologin = new javax.swing.JPasswordField();
        GestionEmpleado = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbgestionempleado = new javax.swing.JTable();
        botonagregarempleado = new javax.swing.JButton();
        verificaciondatos = new javax.swing.JLabel();
        NuevoEmpleado = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblapellido = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        lbldireccion = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lbldni = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lblfechnacimiento = new javax.swing.JLabel();
        txtfechanacimiento = new com.toedter.calendar.JDateChooser();
        lbltelefono = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblpassword = new javax.swing.JLabel();
        botonisertarempleado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jToolBar1 = new javax.swing.JToolBar();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        botonempleado = new javax.swing.JButton();
        ProveedorButton = new javax.swing.JButton();
        ClienteButton = new javax.swing.JButton();
        InventarioButton = new javax.swing.JButton();
        VenatsButton = new javax.swing.JButton();
        GestionVentas = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        aparencedbuton = new javax.swing.JMenu();
        Dark = new javax.swing.JRadioButtonMenuItem();
        Light = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();

        LoginDialoj.setModal(true);
        LoginDialoj.setResizable(false);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Login Registrar Empleado");

        javax.swing.GroupLayout LoginDialojLayout = new javax.swing.GroupLayout(LoginDialoj.getContentPane());
        LoginDialoj.getContentPane().setLayout(LoginDialojLayout);
        LoginDialojLayout.setHorizontalGroup(
            LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDialojLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginDialojLayout.createSequentialGroup()
                        .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(LoginDialojLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LoginDialojLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtloginempleado)
                                    .addComponent(txtcotraempleadologin, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                        .addGap(27, 27, 27))
                    .addGroup(LoginDialojLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LoginDialojLayout.createSequentialGroup()
                        .addComponent(verificacionloginempleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        LoginDialojLayout.setVerticalGroup(
            LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginDialojLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtloginempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(LoginDialojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcotraempleadologin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verificacionloginempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        GestionEmpleado.setModal(true);
        GestionEmpleado.setResizable(false);

        tbgestionempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbgestionempleado);

        botonagregarempleado.setText("Agregar");
        botonagregarempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarempleadoActionPerformed(evt);
            }
        });

        verificaciondatos.setText("Sin Datos");

        javax.swing.GroupLayout GestionEmpleadoLayout = new javax.swing.GroupLayout(GestionEmpleado.getContentPane());
        GestionEmpleado.getContentPane().setLayout(GestionEmpleadoLayout);
        GestionEmpleadoLayout.setHorizontalGroup(
            GestionEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionEmpleadoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(GestionEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GestionEmpleadoLayout.createSequentialGroup()
                        .addComponent(botonagregarempleado)
                        .addGap(215, 215, 215)
                        .addComponent(verificaciondatos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        GestionEmpleadoLayout.setVerticalGroup(
            GestionEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GestionEmpleadoLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(GestionEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonagregarempleado)
                    .addComponent(verificaciondatos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        NuevoEmpleado.setModal(true);
        NuevoEmpleado.setResizable(false);

        jLabel1.setText("Agregar Empleado: ");

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

        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdireccionKeyReleased(evt);
            }
        });

        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdniKeyReleased(evt);
            }
        });

        txtfechanacimiento.setDateFormatString("yyyy-MM-dd");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
        });

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });

        botonisertarempleado.setText("Guardar");
        botonisertarempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonisertarempleadoActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre:");

        jLabel13.setText("Apellido:");

        jLabel14.setText("Direccion:");

        jLabel15.setText("DNI:");

        jLabel16.setText("Fecha de Nacimiento:");

        jLabel17.setText("Telefono:");

        jLabel18.setText("Email:");

        jLabel19.setText("Password:");

        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout NuevoEmpleadoLayout = new javax.swing.GroupLayout(NuevoEmpleado.getContentPane());
        NuevoEmpleado.getContentPane().setLayout(NuevoEmpleadoLayout);
        NuevoEmpleadoLayout.setHorizontalGroup(
            NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoEmpleadoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoEmpleadoLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonisertarempleado)
                    .addGroup(NuevoEmpleadoLayout.createSequentialGroup()
                        .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtapellido)
                            .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre)
                            .addComponent(lbldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdireccion)
                            .addComponent(lbldni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdni)
                            .addComponent(lblfechnacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfechanacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txttelefono)
                            .addComponent(lbltelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtemail)
                            .addComponent(lblemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpassword))))
                .addGap(51, 51, 51))
        );
        NuevoEmpleadoLayout.setVerticalGroup(
            NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoEmpleadoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldni, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfechnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(botonisertarempleado)
                .addGap(30, 30, 30))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.add(filler1);

        botonempleado.setText("Empleados");
        botonempleado.setFocusable(false);
        botonempleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonempleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonempleadoActionPerformed(evt);
            }
        });
        jToolBar1.add(botonempleado);

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

        GestionVentas.setText("Gestionar Ventas");
        GestionVentas.setFocusable(false);
        GestionVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GestionVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        GestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionVentasActionPerformed(evt);
            }
        });
        jToolBar1.add(GestionVentas);
        jToolBar1.add(filler2);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        aparencedbuton.setText("Apariencia");

        buttonGroup1.add(Dark);
        Dark.setSelected(true);
        Dark.setText("Oscuro");
        Dark.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DarkItemStateChanged(evt);
            }
        });
        Dark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkActionPerformed(evt);
            }
        });
        aparencedbuton.add(Dark);

        buttonGroup1.add(Light);
        Light.setText("Claro");
        aparencedbuton.add(Light);

        jMenuBar1.add(aparencedbuton);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void DarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DarkActionPerformed

    private void DarkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DarkItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            FlatAnimatedLafChange.showSnapshot();
            //appearanceButton.setIcon(iconos.iconoDarkMode);
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                // MessageHandler.exceptionMessage(ex);
                System.out.println("Fail changing feel color to dark");
            }

            com.formdev.flatlaf.FlatLaf.updateUI();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            FlatAnimatedLafChange.showSnapshot();
            //appearanceButton.setIcon(iconos.iconoLightMode);
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            } catch (Exception ex) {
                // MessageHandler.exceptionMessage(ex);
                System.out.println("Fail changing feel color to light");
            }
            com.formdev.flatlaf.FlatLaf.updateUI();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        }
    }//GEN-LAST:event_DarkItemStateChanged

    private void botonempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonempleadoActionPerformed
        LoginDialoj.setVisible(true);
    }//GEN-LAST:event_botonempleadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection con = Connect.getConnection();
            String nombrelogin = txtloginempleado.getText().trim();
            String contra = txtcotraempleadologin.getText().trim();
            if (!nombrelogin.isEmpty() && !contra.isEmpty()) {
                CtrlUsuario ctrlUser = new CtrlUsuario();
                usuario user = new usuario();
                String contras = hashPassword(contra);
                user.setNombre(nombrelogin);
                user.setPassword(contras);
                if (ctrlUser.inicioSesionUser(user)) {
                    CtrEmpleado ctremple = new CtrEmpleado();
                    Long codempleado = ctremple.obtenerCodEmpleado(con, nombrelogin);
                    Long rol = ctremple.obtenerCodRol(con, codempleado);

                    if (rol == 1) {
                        LoginDialoj.setVisible(false);
                        GestionEmpleado.setVisible(true);
                    }else if(rol == null || rol!= 1){
                        LoginDialoj.setVisible(false);
                        JOptionPane.showMessageDialog(null, "No cuenta con las credenciales suficientes");
                    }
                }else{
                    verificacionloginempleado.setText("Usuario o contraseña Incorrectas");
                }
            } else {
                verificacionloginempleado.setText("Rellene los campos");
            }

            
        } catch (SQLException e) {
            System.out.println("Error login" + e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonagregarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarempleadoActionPerformed
        NuevoEmpleado.setVisible(true);
    }//GEN-LAST:event_botonagregarempleadoActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtapellidoKeyReleased

    private void txtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtdireccionKeyReleased

    private void txtdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtdniKeyReleased

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtemailKeyReleased

    private void botonisertarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonisertarempleadoActionPerformed
        try {
            Date fechan = txtfechanacimiento.getDate();
            long fecha = fechan.getTime();
            java.sql.Date fechasql = new java.sql.Date(fecha);

            if (fechan == null) {
                lblfechnacimiento.setText("Rellene el campo");
            } else {
                CtrEmpleado ctremple = new CtrEmpleado();
                Empleado empleado = new Empleado();
                String nombre = txtnombre.getText().trim();
                String apellido = txtapellido.getText().trim();
                String direccion = txtdireccion.getText().trim();
                String documento = txtdni.getText().trim();
                String telefono = txttelefono.getText().trim();
                String email = txtemail.getText().trim();
                String pass = txtpassword.getText().trim();
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setDireccion(direccion);
                empleado.setDocumento(documento);
                empleado.setFechanacimiento(fechasql);
                empleado.setTelefono(telefono);
                empleado.setEmail(email);
                empleado.setPassword(pass);
                empleado.setEstado(Boolean.TRUE);
                ctremple.agregarEmpleado(empleado);
                Limpiar();
                cargarTablaEmpleado();
                NuevoEmpleado.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.println("Error en empleado" + e);
        }
    }//GEN-LAST:event_botonisertarempleadoActionPerformed

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        validarNuevoEmpleado();
    }//GEN-LAST:event_txtpasswordKeyReleased

    private void GestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionVentasActionPerformed
        GestionVentaView gestion = new GestionVentaView();
        jDesktopPane1.add(gestion);
        gestion.setVisible(true);
        gestion.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                GestionVentas.setEnabled(true);
                gestion.setVisible(false);
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
        GestionVentas.setEnabled(false);
    }//GEN-LAST:event_GestionVentasActionPerformed

    public class nonEditableTableModel extends DefaultTableModel {

        public nonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void cargarTablaEmpleado() {
        boolean datosEncontrados = false;
        try (Connection con = Connect.getConnection()) {
            CtrEmpleado ctrempleado = new CtrEmpleado();
            List<Empleado> empleados = ctrempleado.cargarEmpleado();
            if (empleados != null && !empleados.isEmpty()) {
                Object[] columnNames = {"Codigo", "Nombre", "Apellido", "Direccion", "Documento", "Fecha", "Telefono", "Email", "Password"};
                nonEditableTableModel model = new nonEditableTableModel(columnNames, 0);
                for (Empleado empleado : empleados) {
                    if (empleado.getEstado()) {
                        Object[] datos = new Object[9];
                        datos[0] = empleado.getCodempleado();
                        datos[1] = empleado.getNombre();
                        datos[2] = empleado.getApellido();
                        datos[3] = empleado.getDireccion();
                        datos[4] = empleado.getDocumento();
                        datos[5] = empleado.getFechanacimiento();
                        datos[6] = empleado.getTelefono();
                        datos[7] = empleado.getEmail();
                        datos[8] = empleado.getPassword();
                        model.addRow(datos);
                        datosEncontrados = true;
                    }
                }
                tbgestionempleado.setModel(model);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos de la tabla empleado: " + e);
        }
        verificaciondatos.setVisible(!datosEncontrados);
    }

    private void Limpiar() {
        DefaultTableModel model = (DefaultTableModel) tbgestionempleado.getModel();
        model.setRowCount(0);
    }

    private void validarNuevoEmpleado() {
        CtrlValidacion val = new CtrlValidacion();
        String documento = txtdni.getText().trim();
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

        if (txtdireccion.getText().isEmpty()) {
            lbldireccion.setText("Rellene el campo");
        } else {
            lbldireccion.setText("");
        }

        if (documento.isEmpty()) {
            lbldni.setText("Rellene el campo");
        } else if (!val.validarDni(documento)) {
            lbldni.setText("Coloque 8 digitos numeros");
        } else {
            lbldni.setText("");
        }

        if (telefono.isEmpty()) {
            lbltelefono.setText("Rellene el campo");
        } else if (!val.validarTelefono(telefono)) {
            lbltelefono.setText("Coloque 9 digitos numericos");
        } else {
            lbltelefono.setText("");
        }
        if (txtemail.getText().isEmpty()) {
            lblemail.setText("Rellene el campo");
        } else if (!txtemail.getText().contains("@")) {
            lblemail.setText("Correo invallid @");
        } else {
            lblemail.setText("");
        }

        if (txtpassword.getText().isEmpty()) {
            lblpassword.setText("Rellene el campo");
        } else {
            lblpassword.setText("");
        }

        if (txtnombre.getText().isEmpty() || txtapellido.getText().isEmpty()
                || txtdireccion.getText().isEmpty() || documento.isEmpty() || !val.validarDni(documento)
                || telefono.isEmpty() || !val.validarTelefono(telefono) || txtemail.getText().isEmpty()
                || !txtemail.getText().contains("@") || txtpassword.getText().isEmpty()) {

            botonisertarempleado.setEnabled(false);

        } else {
            botonisertarempleado.setEnabled(true);
        }
    }
    
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hexPassword = new StringBuilder();

            for (byte hashByte : hashBytes) {
                hexPassword.append(String.format("%02x", hashByte));
            }

            return hexPassword.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClienteButton;
    private javax.swing.JRadioButtonMenuItem Dark;
    private javax.swing.JDialog GestionEmpleado;
    private javax.swing.JButton GestionVentas;
    private javax.swing.JButton InventarioButton;
    private javax.swing.JRadioButtonMenuItem Light;
    private javax.swing.JDialog LoginDialoj;
    private javax.swing.JDialog NuevoEmpleado;
    private javax.swing.JButton ProveedorButton;
    private javax.swing.JButton VenatsButton;
    private javax.swing.JMenu aparencedbuton;
    private javax.swing.JButton botonagregarempleado;
    private javax.swing.JButton botonempleado;
    private javax.swing.JButton botonisertarempleado;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lbldni;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfechnacimiento;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTable tbgestionempleado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JPasswordField txtcotraempleadologin;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtemail;
    private com.toedter.calendar.JDateChooser txtfechanacimiento;
    private javax.swing.JTextField txtloginempleado;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JLabel verificaciondatos;
    private javax.swing.JLabel verificacionloginempleado;
    // End of variables declaration//GEN-END:variables
}
