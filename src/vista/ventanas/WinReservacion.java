package vista.ventanas;

import componentes.ScrollPaneCustomizer;
import controlador.CtrlFechaReservacion;
import excepciones.ExAgregar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;
import vista.paneles.PanHabitacion;

public class WinReservacion extends javax.swing.JFrame {

    private CtrlFechaReservacion controlador = new CtrlFechaReservacion();
    private Set<Habitacion> habitacionesSeleccionadas = new HashSet<>();
    private List<PanHabitacion> habitaciones;

    private Huesped huesped;
    private int numCamasRequeridas = -1;
    private int totalCamasSeleccionadas = 0;
    private double costoTotal = 0;
    private JFrame ventanaAnterior;

    public WinReservacion(List<PanHabitacion> listaPaneles, Huesped huesped) {
        this(listaPaneles, huesped, null, null);
    }

    public WinReservacion(List<PanHabitacion> listaPaneles, Huesped huesped, LocalDate fechaInicio, LocalDate fechaFin) {
        initComponents();
        setLocationRelativeTo(null);
        this.habitaciones = listaPaneles;
        this.huesped = huesped;

        if (fechaInicio != null && fechaFin != null) {
            dateEntrada.setDate(fechaInicio);
            dateSalida.setDate(fechaFin);
        }

        construirPanelHabitaciones(listaPaneles);
    }

    public WinReservacion(List<PanHabitacion> listaPaneles, Huesped huesped, LocalDate fechaInicio, LocalDate fechaFin, JFrame ventanaAnterior) {
        this(listaPaneles, huesped, fechaInicio, fechaFin);
        this.ventanaAnterior = ventanaAnterior;
    }

    private void construirPanelHabitaciones(List<PanHabitacion> listaPaneles) {
        JPanel contentPanel = new JPanel(new GridLayout(0, 1, 0, 0));
        contentPanel.setPreferredSize(new Dimension(700, listaPaneles.size() * 530 + 100));
        contentPanel.setBackground(new Color(1, 74, 173));
        if (listaPaneles.isEmpty()) {
            construirPanelVacio(contentPanel);
        } else {
            for (PanHabitacion panel : listaPaneles) {
                panel.ocultarMensaje();
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean nuevoEstado = !panel.getSeleccionado();
                        panel.setSeleccionado(nuevoEstado); // Cambia visual y lógicamente el estado
                        actualizarSeleccion(panel.getHabitacion(), nuevoEstado, panel);
                    }
                });
                contentPanel.add(panel);
            }

        }
        JScrollPane scroll = new JScrollPane(contentPanel);
        ScrollPaneCustomizer.customizeScrollPane(scroll);
        pnaelHabitacion.add(scroll, BorderLayout.CENTER);
    }

    private void actualizarSeleccion(Habitacion habitacion, boolean seleccionado, PanHabitacion panel) {
        if (seleccionado) {
            int camasRestantes = numCamasRequeridas - totalCamasSeleccionadas;

            if (camasRestantes <= 0) {
                JOptionPane.showMessageDialog(this, "Ya se ha alcanzado el número requerido de camas.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
                panel.setSeleccionado(false); // Desmarcar visual y lógicamente
                return;
            }

            habitacionesSeleccionadas.add(habitacion);
            totalCamasSeleccionadas += habitacion.getNum_camas();
        } else {
            habitacionesSeleccionadas.remove(habitacion);
            totalCamasSeleccionadas -= habitacion.getNum_camas();
        }

        int camasRestantes = numCamasRequeridas - totalCamasSeleccionadas;
        txtUser.setText(camasRestantes <= 0 ? "Completo" : String.valueOf(camasRestantes));
    }

    private void construirPanelVacio(JPanel contentPanel) {
        JPanel mensajePanel = new JPanel();
        mensajePanel.setBackground(new Color(1, 74, 173));
        mensajePanel.setPreferredSize(new Dimension(700, 150));
        mensajePanel.setLayout(new BoxLayout(mensajePanel, BoxLayout.Y_AXIS));

        JLabel linea1 = new JLabel("Sin favoritos,", SwingConstants.CENTER);
        JLabel linea2 = new JLabel("seleccione en la pestaña de habitaciones", SwingConstants.CENTER);
        JLabel linea3 = new JLabel("nuevos favoritos para reservar", SwingConstants.CENTER);

        // Color y fuente
        Color textoColor = Color.WHITE;
        Font textoFont = new Font("SansSerif", Font.BOLD, 16);
        linea1.setForeground(textoColor);
        linea2.setForeground(textoColor);
        linea3.setForeground(textoColor);
        linea1.setFont(textoFont);
        linea2.setFont(textoFont);
        linea3.setFont(textoFont);

        // Centrar horizontalmente
        linea1.setAlignmentX(Component.CENTER_ALIGNMENT);
        linea2.setAlignmentX(Component.CENTER_ALIGNMENT);
        linea3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Separación entre líneas
        mensajePanel.add(Box.createVerticalGlue());
        mensajePanel.add(linea1);
        mensajePanel.add(linea2);
        mensajePanel.add(linea3);
        mensajePanel.add(Box.createVerticalGlue());

        contentPanel.add(mensajePanel);
        contentPanel.setPreferredSize(new Dimension(700, 200));
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
        lblSalida1 = new javax.swing.JLabel();
        dateSalida = new componentes.DateSelector();
        lblNum = new javax.swing.JLabel();
        panelNumPersona = new javax.swing.JPanel();
        txtUser = new componentes.custom_textfield();
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
        panelFechas.setPreferredSize(new java.awt.Dimension(266, 460));
        panelFechas.setLayout(new java.awt.GridBagLayout());

        lblEntrada.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblEntrada.setForeground(new java.awt.Color(255, 255, 255));
        lblEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEntrada.setText("Fecha de llegada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(lblEntrada, gridBagConstraints);

        dateEntrada.setBackground(new java.awt.Color(1, 74, 173));
        dateEntrada.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateEntrada.setForeground(new java.awt.Color(51, 51, 51));
        dateEntrada.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(dateEntrada, gridBagConstraints);

        lblSalida1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblSalida1.setForeground(new java.awt.Color(255, 255, 255));
        lblSalida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalida1.setText("Fecha de salida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(lblSalida1, gridBagConstraints);

        dateSalida.setBackground(new java.awt.Color(1, 74, 173));
        dateSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateSalida.setForeground(new java.awt.Color(51, 51, 51));
        dateSalida.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(dateSalida, gridBagConstraints);

        lblNum.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNum.setText("Núm camas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(lblNum, gridBagConstraints);

        panelNumPersona.setBackground(new java.awt.Color(1, 74, 173));
        panelNumPersona.setLayout(new java.awt.GridBagLayout());

        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setToolTipText("Presione \"Enter\" para fijar el número de camas");
        txtUser.setCaretColor(new java.awt.Color(255, 204, 0));
        txtUser.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtUser.setPreferredSize(new java.awt.Dimension(150, 50));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        panelNumPersona.add(txtUser, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 20);
        panelFechas.add(panelNumPersona, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        body.add(panelFechas, gridBagConstraints);

        pnaelHabitacion.setBackground(new java.awt.Color(1, 74, 173));
        pnaelHabitacion.setPreferredSize(new java.awt.Dimension(700, 450));
        pnaelHabitacion.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 450;
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

        lblTitulo.setBackground(new java.awt.Color(1, 74, 173));
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
            LocalDate fechaEntrada = LocalDate.of(dateEntrada.getYear(), dateEntrada.getMonth(), dateEntrada.getDay());
            LocalDate fechaSalida = LocalDate.of(dateSalida.getYear(), dateSalida.getMonth(), dateSalida.getDay());

            if (totalCamasSeleccionadas < numCamasRequeridas) {
                JOptionPane.showMessageDialog(this, "Se seleccionaron menos camas de las necesarias.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (totalCamasSeleccionadas > numCamasRequeridas) {
                int opcion = JOptionPane.showConfirmDialog(this,
                        "Has seleccionado más camas de las necesarias. ¿Deseas continuar?",
                        "Camas excedentes", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opcion != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
            if (dias <= 0) {
                JOptionPane.showMessageDialog(this, "La fecha de salida debe ser posterior a la de entrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder mensaje = new StringBuilder("Se seleccionaron las siguientes habitaciones:\n");
            double costoTotal = 0;

            for (Habitacion hab : habitacionesSeleccionadas) {
                Reservacion res = new Reservacion(0, hab.getId_habitacion(), huesped.getId_huesped(), "Pendiente", fechaEntrada, fechaSalida);
                double costoHabitacion = hab.getPrecio() + (hab.getPrecio() * dias / 3);  // Costo por días
                costoTotal += costoHabitacion;
                controlador.ctrAgregarReservacion(res);
                mensaje.append("Habitación #").append(hab.getId_habitacion())
                        .append(" - Coste: ").append(String.format("%.2f", costoHabitacion)).append("\n");
            }

            mensaje.append("Total: ").append(String.format("%.2f", costoTotal));

            JOptionPane.showMessageDialog(this, "Reservación registrada para:\nEntrada: " + fechaEntrada + "\nSalida: " + fechaSalida + "\n" + mensaje,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
                this.dispose();
            } else {
                this.dispose();
            }
        } catch (ExAgregar ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar reservación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnReservacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
            this.dispose();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            try {
                int nuevoValor = Integer.parseInt(txtUser.getText().trim());
                if (nuevoValor <= 0 || nuevoValor > 20) {
                    throw new NumberFormatException("Número fuera de rango permitido (1-20)");
                }

                // Reiniciar variables de control
                numCamasRequeridas = nuevoValor;
                totalCamasSeleccionadas = 0;
                habitacionesSeleccionadas.clear();

                // Reiniciar visualmente todos los paneles
                for (PanHabitacion pan : habitaciones) {
                    pan.setSeleccionado(false);
                }

                txtUser.setText(String.valueOf(nuevoValor));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido de camas (1-20).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtUserKeyPressed

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
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblSalida1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFechas;
    private javax.swing.JPanel panelNumPersona;
    private javax.swing.JPanel pnaelHabitacion;
    private componentes.custom_textfield txtUser;
    // End of variables declaration//GEN-END:variables
}
