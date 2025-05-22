package vista.ventanas;

import controlador.CtrlRegistroHab;
import excepciones.ExRegistroHab;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;

public class WinRegistroUF extends javax.swing.JFrame {

    private String usuario, pass;
    private String nombre, ap1, ap2, num_tarjeta, idioma, correo;
    private JFrame ventanaAnterior;
    private int habitacion;
    private Huesped nhuesped;
    private List<Huesped> huespedes = new ArrayList<>();
    private JTable tblRegistroFisico;
    CtrlRegistroHab ctrlrh = new CtrlRegistroHab();

    public WinRegistroUF(JFrame ventanaAnterior, int habitacion, JTable tblRegistroFisico) {
        this.setUndecorated(true);
        this.ventanaAnterior = ventanaAnterior;
        this.habitacion = habitacion;
        this.tblRegistroFisico = tblRegistroFisico;
        ctrlrh.getCountHuespedes();
        initComponents();
        txt7.setForeground(Color.GRAY);
        txt7.setText("formato: XXXX-XXXX-XXXX-XXXX");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl9 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        txt4 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        txt9 = new javax.swing.JTextField();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 74, 173));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl9.setForeground(new java.awt.Color(255, 255, 255));
        lbl9.setText("Correo:");
        getContentPane().add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        lbl2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Password:");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lbl1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Usuario:");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

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
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 280, -1));
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 280, -1));

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
        getContentPane().add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 280, -1));
        getContentPane().add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 280, -1));

        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });
        getContentPane().add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 280, -1));

        txt7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7FocusLost(evt);
            }
        });
        txt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt7ActionPerformed(evt);
            }
        });
        getContentPane().add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 280, -1));

        txt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt8ActionPerformed(evt);
            }
        });
        getContentPane().add(txt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 280, -1));
        getContentPane().add(txt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 280, -1));

        lbl4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setText("Nombre:");
        getContentPane().add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        lbl5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setText("Apellido Paterno:");
        getContentPane().add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lbl6.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 255, 255));
        lbl6.setText("Apellido Materno:");
        getContentPane().add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lbl7.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 255, 255));
        lbl7.setText("Tarjeta:");
        getContentPane().add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        lbl8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl8.setForeground(new java.awt.Color(255, 255, 255));
        lbl8.setText("Idioma:");
        getContentPane().add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        Fondo.setBackground(new java.awt.Color(1, 74, 173));
        Fondo.setForeground(new java.awt.Color(1, 74, 173));
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            usuario = txt1.getText();
            pass = txt2.getText();
            nombre = txt4.getText();
            ap1 = txt5.getText();
            ap2 = txt6.getText();
            num_tarjeta = txt7.getText();
            idioma = txt8.getText();
            correo = txt9.getText();
            if (ctrlrh.addHuesped(usuario, pass, nombre, ap1, ap2, num_tarjeta, idioma, correo)) {
                JOptionPane.showMessageDialog(null, "Cliente añadido con exito");
                nhuesped = ctrlrh.findClient(usuario, pass);
                WinRegistroRF wrrf = new WinRegistroRF(ventanaAnterior, habitacion, nhuesped, tblRegistroFisico);
                wrrf.setBounds(200, 100, wrrf.getWidth(), wrrf.getHeight());
                wrrf.setVisible(true);
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos, captura nuevamente");
        } catch (ExRegistroHab ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt6ActionPerformed

    private void txt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt7ActionPerformed

    private void txt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt8ActionPerformed

    private void txt7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusGained
        if (txt7.getText().equals("formato: XXXX-XXXX-XXXX-XXXX")) {
            txt7.setText("");
        }
        txt7.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt7FocusGained

    private void txt7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusLost
        if (txt7.getText().equals("")) {
            txt7.setText("formato: XXXX-XXXX-XXXX-XXXX");
            txt7.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt7FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    public javax.swing.JTextField txt1;
    public javax.swing.JTextField txt2;
    public javax.swing.JTextField txt4;
    public javax.swing.JTextField txt5;
    public javax.swing.JTextField txt6;
    public javax.swing.JTextField txt7;
    public javax.swing.JTextField txt8;
    public javax.swing.JTextField txt9;
    // End of variables declaration//GEN-END:variables
}
