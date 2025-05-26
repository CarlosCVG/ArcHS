package vista.ventanas;

import controlador.CtrlAdmin;
import excepciones.ExRegistroHab;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.vo.Empleado;

public class WinRegistroEmp extends javax.swing.JFrame {

    private CtrlAdmin ctrlad = new CtrlAdmin();
    private JFrame ventanaAnterior;
    private int num2;
    private int id_empleado;
    private String usuario, pass, nombre, ap1, ap2, curp, telefono, email, puesto;

    public WinRegistroEmp(JFrame ventanaAnterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaAnterior = ventanaAnterior;

    }

    public WinRegistroEmp(JFrame ventanaAnterior, Empleado empleado, int num2) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaAnterior = ventanaAnterior;
        this.num2 = num2;
        txtUsuario.setText(empleado.getUsuario());
        txtPassword.setText(empleado.getPass());
        txtNombre.setText(empleado.getNombre());
        txtAp1.setText(empleado.getAp1());
        txtAp2.setText(empleado.getAp2());
        txtCurp.setText(empleado.getCurp());
        txtTelefono.setText(empleado.getTelefono());
        txtEmail.setText(empleado.getEmail());
        this.id_empleado = empleado.getId_empleado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboPuestos = new componentes.VComboBox();
        lbl9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtCurp = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        txtAp1 = new javax.swing.JTextField();
        txtAp2 = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 74, 173));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboPuestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Recepcionista", "Limpieza", "Camarero", " " }));
        getContentPane().add(comboPuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 280, -1));

        lbl9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl9.setForeground(new java.awt.Color(255, 255, 255));
        lbl9.setText("Puesto");
        getContentPane().add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 153));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 280, -1));

        btnVolver.setBackground(new java.awt.Color(0, 0, 153));
        btnVolver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Usuario:");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 280, -1));

        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });
        getContentPane().add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 280, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 280, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 280, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 280, -1));

        lbl2.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Password:");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lbl6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 255, 255));
        lbl6.setText("CURP:");
        getContentPane().add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lbl7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 255, 255));
        lbl7.setText("Telefono:");
        getContentPane().add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        lbl8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl8.setForeground(new java.awt.Color(255, 255, 255));
        lbl8.setText("Email:");
        getContentPane().add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        lbl5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setText("Segundo apellido:");
        getContentPane().add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        getContentPane().add(txtAp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 280, -1));
        getContentPane().add(txtAp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 280, -1));

        lbl3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setText("Nombre:");
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lbl4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setText("Primer apellido:");
        getContentPane().add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        Fondo.setBackground(new java.awt.Color(1, 74, 173));
        Fondo.setForeground(new java.awt.Color(1, 74, 173));
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (num2 == 2) {
            try {
                usuario = txtUsuario.getText();
                pass = txtPassword.getText();
                nombre = txtNombre.getText();
                ap1 = txtAp1.getText();
                ap2 = txtAp2.getText();
                curp = txtCurp.getText();
                telefono = txtTelefono.getText();
                email = txtEmail.getText();
                puesto = (String) comboPuestos.getSelectedItem();
                if (ctrlad.modEmpleado(id_empleado, usuario, pass, nombre, ap1, ap2, curp, telefono, email, puesto)) {
                    JOptionPane.showMessageDialog(null, "Empleado actualizado con exito");
                    if (ventanaAnterior != null) {
                        ventanaAnterior.setVisible(true);
                    }
                    dispose();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al procesar los datos, captura nuevamente");
            } catch (ExRegistroHab ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            try {
                usuario = txtUsuario.getText();
                pass = txtPassword.getText();
                nombre = txtNombre.getText();
                ap1 = txtAp1.getText();
                ap2 = txtAp2.getText();
                curp = txtCurp.getText();
                telefono = txtTelefono.getText();
                email = txtEmail.getText();
                puesto = (String) comboPuestos.getSelectedItem();
                if (ctrlad.addEmpleado(usuario, pass, nombre, ap1, ap2, curp, telefono, email, puesto)) {
                    JOptionPane.showMessageDialog(null, "Empleado añadido con exito");
                    if (ventanaAnterior != null) {
                        ventanaAnterior.setVisible(true);
                    }
                    dispose();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al procesar los datos, captura nuevamente");
            } catch (ExRegistroHab ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private componentes.VComboBox comboPuestos;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    public javax.swing.JTextField txtAp1;
    public javax.swing.JTextField txtAp2;
    public javax.swing.JTextField txtCurp;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPassword;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
