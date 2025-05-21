/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.ventanas;

import componentes.Observable;
import componentes.Observer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;
import vista.paneles.PanHabitacion;

/**
 *
 * @author edwin
 */
public class WinCalendario extends JFrame {

    private List<Reservacion> reservaciones;
    private int mounth;
    private PanHabitacion habitacion;
    private List<Observer> observers = new ArrayList<>();
    private Huesped huesped;

    public WinCalendario(int mounth, PanHabitacion habitacion, Huesped huesped) {
        initComponents();
        setMounth(mounth);
        this.setLocationRelativeTo(null);
        this.habitacion = habitacion;
        this.huesped = huesped;
    }

    public void setReservaList(List<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
        calendario.setReservaciones(reservaciones);
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
        calendario.setMonth(mounth);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        btnReservacion = new componentes.RoundedButton();
        calendario = new componentes.Calendario();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        header.setBackground(new java.awt.Color(1, 74, 173));
        header.setPreferredSize(new java.awt.Dimension(97, 100));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(1, 74, 173));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/tituloReserva.png"))); // NOI18N
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        header.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 100));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        header.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 40, -1));

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

        calendario.setBackground(new java.awt.Color(102, 0, 0));
        getContentPane().add(calendario, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        LocalDate fechaInicio = calendario.getFechaInicio();
        LocalDate fechaFin = calendario.getFechaFin();

        WinReservacion reservacion = new WinReservacion(habitacion, huesped, fechaInicio, fechaFin);
        reservacion.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnReservacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.RoundedButton btnReservacion;
    private javax.swing.JButton btnSalir;
    private componentes.Calendario calendario;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables


}
