package vista.paneles;

import controlador.CtrlLogin;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;
import modelo.vo.Puesto;
import vista.ventanas.WinAdmin;
import vista.ventanas.WinAdministrador;
import vista.ventanas.WinEmpleado;
import vista.ventanas.WinRecepcion;
import vista.ventanas.WinRegistroUV;
import vista.ventanas.WinSelectLogin;
import vista.ventanas.WinUsuario;

public class PanLogin extends javax.swing.JPanel {

    private CtrlLogin ctrll = new CtrlLogin();
    private String usuario, password;
    private int loginselected;
    private JFrame ventanaAnterior;

    public PanLogin() {
        initComponents();
    }

    public PanLogin(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        initComponents();
    }

    public void setSeleccion(int loginselected) {
        this.loginselected = loginselected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        body = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new componentes.custom_textfield();
        lblPassword = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        txtPassword2 = new componentes.PasswordField();
        header = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        btnRegistro = new componentes.RoundedButton();
        btnIS = new componentes.RoundedButton();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setForeground(new java.awt.Color(1, 74, 173));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/usuario_icono_corto.png"))); // NOI18N
        body.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 130, 40));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        body.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 406, 37));

        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Password_icono_corto.png"))); // NOI18N
        body.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 160, 40));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/LogoARC.png"))); // NOI18N
        body.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 436, -1));
        body.add(txtPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 410, -1));

        jPanel1.add(body, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, -1));

        jPanel1.add(header, java.awt.BorderLayout.PAGE_START);

        footer.setBackground(new java.awt.Color(1, 74, 173));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 110, 10);
        flowLayout2.setAlignOnBaseline(true);
        footer.setLayout(flowLayout2);

        btnRegistro.setBackground(new java.awt.Color(1, 74, 173));
        btnRegistro.setBorder(null);
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Registro_Btn.png"))); // NOI18N
        btnRegistro.setText("");
        btnRegistro.setContentAreaFilled(true);
        btnRegistro.setDefaultCapable(false);
        btnRegistro.setPreferredSize(new java.awt.Dimension(160, 50));
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        footer.add(btnRegistro);

        btnIS.setBackground(new java.awt.Color(1, 74, 173));
        btnIS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Inicio_de_sesion.png"))); // NOI18N
        btnIS.setText("");
        btnIS.setBorderPainted(false);
        btnIS.setContentAreaFilled(true);
        btnIS.setPreferredSize(new java.awt.Dimension(160, 50));
        btnIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnISActionPerformed(evt);
            }
        });
        footer.add(btnIS);

        jPanel1.add(footer, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        if (loginselected == 1 || loginselected == 2) {
            JOptionPane.showMessageDialog(null, "Opcion deshabilitada para Administradores y Empleados");
        } else {
            ventanaAnterior = (JFrame) SwingUtilities.getWindowAncestor(this);
            ventanaAnterior.setVisible(false);
            WinRegistroUV wruv = new WinRegistroUV(ventanaAnterior);
            wruv.setBounds(200, 100, wruv.getWidth(), wruv.getHeight());
            wruv.setVisible(true);
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnISActionPerformed
        usuario = txtUser.getText();
        password = txtPassword2.getText();
        switch (loginselected) {
            case 1:
                Administrador administrador = new Administrador();
                //ctrll.initAdministradores();
                if (ctrll.adminLogged(usuario, password) != null) {
                    administrador = ctrll.adminLogged(usuario, password);
                    //JOptionPane.showMessageDialog(null, administrador.getNombre());
//                    WinAdministrador adminWindow = new WinAdministrador();
//                    adminWindow.setVisible(true);
                    
                    WinAdmin adminWindow = new WinAdmin(administrador);
                    adminWindow.setVisible(true);
                    adminWindow.setBounds(100, 10, 1000, 700);
                    Window framePadre = SwingUtilities.getWindowAncestor(this);
                    framePadre.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;
            case 2:
                Empleado empleado;
//                ctrll.initEmpleados();
//                ctrll.initPuestos();
                String nombrePuesto;
                if (ctrll.empleadoLogged(usuario, password) != null) {
                    empleado = ctrll.empleadoLogged(usuario, password);
//                    JOptionPane.showMessageDialog(null, empleado.getNombre());
                    nombrePuesto = ctrll.searchPuesto(empleado);
                    if (nombrePuesto.equals("Recepcionista")) {
//                        JOptionPane.showMessageDialog(null, "Recep");
                        WinRecepcion empleadoWindow = new WinRecepcion(empleado, nombrePuesto);
                        empleadoWindow.setBounds(100, 10, 1000, 700);
                        empleadoWindow.setVisible(true);
                        Window framePadre = SwingUtilities.getWindowAncestor(this);
                        framePadre.dispose();
                    } else if (nombrePuesto.equals("Limpieza")) {
//                        JOptionPane.showMessageDialog(null, "Limpieza");
                        WinEmpleado empleadoWindow = new WinEmpleado(empleado, nombrePuesto);
                        empleadoWindow.setBounds(100, 10, 1000, 700);
                        empleadoWindow.setVisible(true);
                        Window framePadre = SwingUtilities.getWindowAncestor(this);
                        framePadre.dispose();
                    } else if (nombrePuesto.equals("Camarero")) {
//                        JOptionPane.showMessageDialog(null, "Camarero");
                        WinEmpleado empleadoWindow = new WinEmpleado(empleado, nombrePuesto);
                        empleadoWindow.setBounds(100, 10, 1000, 700);
                        empleadoWindow.setVisible(true);
                        Window framePadre = SwingUtilities.getWindowAncestor(this);
                        framePadre.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Puesto no asignado");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;

            case 3:
                Huesped huesped = new Huesped();
                //ctrll.initHuespedes();
                if (ctrll.huespedLogged(usuario, password) != null) {
                    huesped = ctrll.huespedLogged(usuario, password);
//                    JOptionPane.showMessageDialog(null, huesped.getNombre());
                    WinUsuario usuarioWindow = new WinUsuario(huesped);
                    usuarioWindow.setVisible(true);
                    Window framePadre = SwingUtilities.getWindowAncestor(this);
                    framePadre.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;
        }
    }//GEN-LAST:event_btnISActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WinSelectLogin selectlogin = new WinSelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        Window framePadre = SwingUtilities.getWindowAncestor(this);
        framePadre.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.RoundedButton btnIS;
    private componentes.RoundedButton btnRegistro;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private componentes.PasswordField txtPassword2;
    private componentes.custom_textfield txtUser;
    // End of variables declaration//GEN-END:variables
}
