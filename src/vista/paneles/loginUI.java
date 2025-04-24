package vista.paneles;

import controlador.CtrlLogin;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;
import vista.ventanas.SelectLogin;

public class loginUI extends javax.swing.JPanel {

    private CtrlLogin ctrll = new CtrlLogin();
    private String usuario, password;
    private int loginselected;

    public loginUI() {
        initComponents();
    }
    
    public void setSeleccion(int loginselected){
        this.loginselected = loginselected;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        body = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        custom_textfield3 = new componentes.custom_textfield();
        jLabel5 = new javax.swing.JLabel();
        custom_textfield4 = new componentes.custom_textfield();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        roundedButton1 = new componentes.RoundedButton();
        roundedButton2 = new componentes.RoundedButton();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(1, 74, 173));
        body.setForeground(new java.awt.Color(1, 74, 173));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/usuario_icono_corto.png"))); // NOI18N
        body.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 130, 40));

        custom_textfield3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_textfield3ActionPerformed(evt);
            }
        });
        body.add(custom_textfield3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 406, 37));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Password_icono_corto.png"))); // NOI18N
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 160, 40));

        custom_textfield4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_textfield4ActionPerformed(evt);
            }
        });
        body.add(custom_textfield4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 406, 37));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/LogoARC.png"))); // NOI18N
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 140, 170));

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

        roundedButton1.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton1.setBorder(null);
        roundedButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Registro_Btn.png"))); // NOI18N
        roundedButton1.setText("");
        roundedButton1.setContentAreaFilled(true);
        roundedButton1.setDefaultCapable(false);
        roundedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton1ActionPerformed(evt);
            }
        });
        footer.add(roundedButton1);

        roundedButton2.setBackground(new java.awt.Color(1, 74, 173));
        roundedButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Inicio_de_sesion.png"))); // NOI18N
        roundedButton2.setText("");
        roundedButton2.setBorderPainted(false);
        roundedButton2.setContentAreaFilled(true);
        roundedButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundedButton2ActionPerformed(evt);
            }
        });
        footer.add(roundedButton2);

        jPanel1.add(footer, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void custom_textfield3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_textfield3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custom_textfield3ActionPerformed

    private void custom_textfield4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_textfield4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custom_textfield4ActionPerformed

    private void roundedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundedButton1ActionPerformed

    private void roundedButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundedButton2ActionPerformed
        usuario = custom_textfield3.getText();
        password = custom_textfield4.getText();
        switch (loginselected) {
            case 1:
                Administrador administrador = new Administrador();
                ctrll.initAdministradores();
                if(ctrll.adminLogged(usuario, password)!=null){
                    administrador = ctrll.adminLogged(usuario, password);
                    JOptionPane.showMessageDialog(null, administrador.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;
            case 2:
                Empleado empleado = new Empleado();
                ctrll.initEmpleados();
                if(ctrll.empleadoLogged(usuario, password)!=null){
                    empleado = ctrll.empleadoLogged(usuario, password);
                    JOptionPane.showMessageDialog(null, empleado.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;
            case 3:
                Huesped huesped = new Huesped();
                ctrll.initHuespedes();
                if(ctrll.huespedLogged(usuario, password)!=null){
                    huesped = ctrll.huespedLogged(usuario, password);
                    JOptionPane.showMessageDialog(null, huesped.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario invalido");
                }
                break;
        }
    }//GEN-LAST:event_roundedButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SelectLogin selectlogin = new SelectLogin();
        selectlogin.setBounds(250, 25, selectlogin.getWidth(), selectlogin.getHeight());
        selectlogin.setVisible(true);
        Window framePadre = SwingUtilities.getWindowAncestor(this);
        framePadre.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.custom_textfield custom_textfield3;
    private componentes.custom_textfield custom_textfield4;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private componentes.RoundedButton roundedButton1;
    private componentes.RoundedButton roundedButton2;
    // End of variables declaration//GEN-END:variables
}
