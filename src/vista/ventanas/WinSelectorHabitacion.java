/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.ventanas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import vista.paneles.PanHabitacion;

/**
 *
 * @author edwin
 */
public class WinSelectorHabitacion extends javax.swing.JFrame {

    List<Habitacion> habitaciones;
    private Huesped huesded;
    public WinSelectorHabitacion(Huesped huesped) {
        initComponents();
        this.huesded = huesped;
    }

    public void setHabitacionList(List<Habitacion> habitaciones){
        this.habitaciones = habitaciones;
        Shabitaciones.setHabitaciones(habitaciones);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectorHabitaciones1 = new componentes.SelectorHabitaciones();
        selectorHabitaciones2 = new componentes.SelectorHabitaciones();
        Shabitaciones = new componentes.SelectorHabitaciones();
        footer = new javax.swing.JPanel();
        btnReservacion = new componentes.RoundedButton();
        header = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        javax.swing.GroupLayout selectorHabitaciones1Layout = new javax.swing.GroupLayout(selectorHabitaciones1);
        selectorHabitaciones1.setLayout(selectorHabitaciones1Layout);
        selectorHabitaciones1Layout.setHorizontalGroup(
            selectorHabitaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        selectorHabitaciones1Layout.setVerticalGroup(
            selectorHabitaciones1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout selectorHabitaciones2Layout = new javax.swing.GroupLayout(selectorHabitaciones2);
        selectorHabitaciones2.setLayout(selectorHabitaciones2Layout);
        selectorHabitaciones2Layout.setHorizontalGroup(
            selectorHabitaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        selectorHabitaciones2Layout.setVerticalGroup(
            selectorHabitaciones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ShabitacionesLayout = new javax.swing.GroupLayout(Shabitaciones);
        Shabitaciones.setLayout(ShabitacionesLayout);
        ShabitacionesLayout.setHorizontalGroup(
            ShabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        ShabitacionesLayout.setVerticalGroup(
            ShabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(Shabitaciones, java.awt.BorderLayout.CENTER);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        habitaciones = Shabitaciones.getHabitacionesSeleccionadas();
        List<PanHabitacion> PanHabitacion = new ArrayList<>();
        
        for (Habitacion h : habitaciones) {
            PanHabitacion.add(new PanHabitacion(h));
        }
        
        int month = LocalDate.now().getMonthValue();
        
        WinCalendario calendario = new WinCalendario(month, PanHabitacion, huesded);
        calendario.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnReservacionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.SelectorHabitaciones Shabitaciones;
    private componentes.RoundedButton btnReservacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblTitulo;
    private componentes.SelectorHabitaciones selectorHabitaciones1;
    private componentes.SelectorHabitaciones selectorHabitaciones2;
    // End of variables declaration//GEN-END:variables
}
