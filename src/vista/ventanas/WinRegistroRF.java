package vista.ventanas;

import controlador.CtrlFechaReservacion;
import controlador.CtrlRegistroHab;
import excepciones.ExAgregar;
import excepciones.ExRegistroHab;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.componentes.mtRegistroHab;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

public class WinRegistroRF extends javax.swing.JFrame {

    private int id_reservacion, id_habitacion, id_huesped;
    private LocalDate f_entrada, f_salida;
    private JFrame ventanaAnterior;
    private int nuevoNumId;
    private CtrlFechaReservacion ctrlFR = new CtrlFechaReservacion();
    private JTable tblRegistroFisico;
    CtrlRegistroHab ctrlrh = new CtrlRegistroHab();

    public WinRegistroRF(JFrame ventanaAnterior, int habitacion, Huesped nhuesped, JTable tblRegistroFisico) {
        this.setUndecorated(true);
        this.ventanaAnterior = ventanaAnterior;
        this.tblRegistroFisico = tblRegistroFisico;
        nuevoNumId = ctrlrh.getCountReservaciones() + 1;
        initComponents();
        txt1.setText("" + nuevoNumId);
        txt2.setText("" + habitacion);
        txt3.setText("" + nhuesped.getId_huesped());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        lbl3 = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
        dateEntrada = new componentes.DateSelector();
        lblSalida = new javax.swing.JLabel();
        dateSalida = new componentes.DateSelector();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 74, 173));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Id Habitacion:");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lbl1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Id Reservacion:");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 153));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar Reservacion");
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
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        txt1.setEnabled(false);
        txt1.setFocusable(false);
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 130, -1));

        txt2.setEnabled(false);
        txt2.setFocusable(false);
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 130, -1));

        txt3.setEnabled(false);
        txt3.setFocusable(false);
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 130, -1));

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

        lbl3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setText("Id Huesped:");
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lblEntrada.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrada.setText("Fecha de llegada");
        getContentPane().add(lblEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 201, 45));

        dateEntrada.setBackground(new java.awt.Color(1, 74, 173));
        dateEntrada.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateEntrada.setForeground(new java.awt.Color(51, 51, 51));
        dateEntrada.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        getContentPane().add(dateEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 190, 75));

        lblSalida.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblSalida.setForeground(new java.awt.Color(255, 255, 255));
        lblSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalida.setText("Fecha de salida");
        getContentPane().add(lblSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 190, 45));

        dateSalida.setBackground(new java.awt.Color(1, 74, 173));
        dateSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateSalida.setForeground(new java.awt.Color(51, 51, 51));
        dateSalida.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        getContentPane().add(dateSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 190, 75));

        Fondo.setBackground(new java.awt.Color(1, 74, 173));
        Fondo.setForeground(new java.awt.Color(1, 74, 173));
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 210));

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
            id_reservacion = Integer.parseInt(txt1.getText());
            id_habitacion = Integer.parseInt(txt2.getText());
            id_huesped = Integer.parseInt(txt3.getText());
            // Obtener fecha de entrada
            int dayEntrada = dateEntrada.getDay();
            int monthEntrada = dateEntrada.getMonth();
            int yearEntrada = dateEntrada.getYear();
            LocalDate fechaEntrada = LocalDate.of(yearEntrada, monthEntrada, dayEntrada);

            // Obtener fecha de salida
            int daySalida = dateSalida.getDay();
            int monthSalida = dateSalida.getMonth();
            int yearSalida = dateSalida.getYear();
            LocalDate fechaSalida = LocalDate.of(yearSalida, monthSalida, daySalida);
            Reservacion reservacion = new Reservacion(id_reservacion, id_habitacion, id_huesped, fechaEntrada, fechaSalida);
            ctrlFR.ctrAgregarReservacion(reservacion);

            JOptionPane.showMessageDialog(this, "Reservación registrada para las fechas:\nEntrada: " + fechaEntrada + "\nSalida: " + fechaSalida, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            }
            ((mtRegistroHab) tblRegistroFisico.getModel()).recargarTabla();
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos, captura nuevamente");
        } catch (ExAgregar ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar reservación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private componentes.DateSelector dateEntrada;
    private componentes.DateSelector dateSalida;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblSalida;
    public javax.swing.JTextField txt1;
    public javax.swing.JTextField txt2;
    public javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables
}
