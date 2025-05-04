package vista.ventanas;

import controlador.CtrlFechaReservacion;
import excepciones.ExAgregar;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;
import vista.paneles.PanHabitacion;

public class WinFecha extends javax.swing.JFrame {

    private CtrlFechaReservacion controlador = new CtrlFechaReservacion();
    private Habitacion habitacion;
    private Huesped huesped;

    public WinFecha(PanHabitacion Phabitacion, Huesped huesped) {
        initComponents();
        setLocationRelativeTo(null);
        this.habitacion = Phabitacion.getHabitacion();
        this.huesped = huesped;
        this.pnaelHabitacion.add(Phabitacion, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        LayeredPane = new javax.swing.JLayeredPane();
        lblFondo = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        panelFechas = new javax.swing.JPanel();
        lblEntrada = new javax.swing.JLabel();
        dateEntrada = new componentes.DateSelector();
        lblSalida = new javax.swing.JLabel();
        dateSalida = new componentes.DateSelector();
        pnaelHabitacion = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        btnReservacion = new componentes.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/fondoFechaReservacion.png"))); // NOI18N
        LayeredPane.add(lblFondo);
        lblFondo.setBounds(0, 0, 1000, 500);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setOpaque(false);
        body.setPreferredSize(new java.awt.Dimension(1000, 500));
        body.setLayout(new java.awt.GridBagLayout());

        panelFechas.setOpaque(false);
        panelFechas.setLayout(new java.awt.GridBagLayout());

        lblEntrada.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrada.setText("Fecha de llegada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        panelFechas.add(lblEntrada, gridBagConstraints);

        dateEntrada.setBackground(new java.awt.Color(1, 74, 173));
        dateEntrada.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateEntrada.setForeground(new java.awt.Color(51, 51, 51));
        dateEntrada.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        panelFechas.add(dateEntrada, gridBagConstraints);

        lblSalida.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblSalida.setForeground(new java.awt.Color(255, 255, 255));
        lblSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalida.setText("Fecha de salida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        panelFechas.add(lblSalida, gridBagConstraints);

        dateSalida.setBackground(new java.awt.Color(1, 74, 173));
        dateSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateSalida.setForeground(new java.awt.Color(51, 51, 51));
        dateSalida.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        panelFechas.add(dateSalida, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        body.add(panelFechas, gridBagConstraints);

        pnaelHabitacion.setBackground(new java.awt.Color(1, 74, 173));
        pnaelHabitacion.setPreferredSize(new java.awt.Dimension(700, 470));
        pnaelHabitacion.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 30);
        body.add(pnaelHabitacion, gridBagConstraints);

        LayeredPane.setLayer(body, javax.swing.JLayeredPane.PALETTE_LAYER);
        LayeredPane.add(body);
        body.setBounds(0, 0, 1000, 500);

        getContentPane().add(LayeredPane, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setPreferredSize(new java.awt.Dimension(97, 100));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/tituloReserva.png"))); // NOI18N
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        header.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 100));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, -1));

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footer.setBackground(new java.awt.Color(1, 74, 173));
        footer.setPreferredSize(new java.awt.Dimension(90, 100));
        footer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnReservacion.setBackground(new java.awt.Color(1, 74, 173));
        btnReservacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/btnReservar.png"))); // NOI18N
        btnReservacion.setText("");
        btnReservacion.setOpaque(true);
        btnReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionActionPerformed(evt);
            }
        });
        footer.add(btnReservacion);

        getContentPane().add(footer, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        try {
            // Obtener fecha de entrada
            int dayEntrada = dateEntrada.getDay();
            int monthEntrada = dateEntrada.getMonth();
            int yearEntrada = dateEntrada.getYear();
            LocalDate fechaEntrada = LocalDate.of(yearEntrada, monthEntrada, dayEntrada);

            // Obtener fecha de salida
            int daySalida = dateSalida.getDay();
            int monthSalida = dateSalida.getMonth();
            int yearSalida = dateSalida.getYear();
            LocalDate fechaSalida = LocalDate.of(yearSalida, monthSalida, daySalida); // <-- corregido

            // Crear reservación
            Reservacion reservacion = new Reservacion(0, habitacion.getId_habitacion(), huesped.getId_huesped(), fechaEntrada, fechaSalida);
            controlador.ctrAgregarReservacion(reservacion);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Reservación registrada para las fechas:\nEntrada: " + fechaEntrada + "\nSalida: " + fechaSalida, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (ExAgregar ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar reservación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReservacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JPanel body;
    private componentes.RoundedButton btnReservacion;
    private componentes.DateSelector dateEntrada;
    private componentes.DateSelector dateSalida;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel pnaelHabitacion;
    // End of variables declaration//GEN-END:variables
}
