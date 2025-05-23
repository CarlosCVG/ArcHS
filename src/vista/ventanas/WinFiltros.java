/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.ventanas;

import modelo.util.Observable;
import modelo.util.Observer;
import controlador.CtrlFiltroReserva;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.vo.Habitacion;

/**
 *
 * @author feriv
 */
public class WinFiltros extends JFrame implements Observable {

    private List<Observer> observadores = new ArrayList<>();
    private Map<String, Object> filtros = new HashMap<>();
    private CtrlFiltroReserva controlador = new CtrlFiltroReserva();
    private boolean filtroFavoritos = false;

    public WinFiltros() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        personalizarSliderPrecio();

        List<Habitacion> habitaciones = controlador.ctrHabitaciones();

        double max = 0;

        for (Habitacion habitacion : habitaciones) {
            double precio = habitacion.getPrecio();
            if (precio > max) {
                max = precio;
            }
        }

        double min = max;
        for (Habitacion habitacion : habitaciones) {
            double precio = habitacion.getPrecio();
            if (precio < min) {
                min = precio;
            }
        }

        int minInt = (int) Math.floor(min);
        int maxInt = (int) Math.ceil(max);

        precios.setMinimum(minInt);
        precios.setMaximum(maxInt);

        precios.setValue(maxInt);

        lblCosto.setText("$" + precios.getValue());
        lblMin.setText("$" + minInt);
        lblMax.setText("$" + maxInt);

        filtros.put("costo", maxInt);
        filtros.put("id", -1);
    }

    public Map<String, Object> getFiltros() {
        return filtros;
    }

    @Override
    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {

    }

    //Notifico al carrusel para que cargue las nuevas habitaciones en funcion de los filtros
    @Override
    public void notifyObservers() {
        for (Observer o : observadores) {
            o.update();
        }
    }

    private void personalizarSliderPrecio() {
        Color colorPrincipal = new Color(255, 204, 0); // amarillo
        Color colorFondo = new Color(1, 74, 173);      // azul

        precios.setForeground(colorPrincipal);
        precios.setBackground(colorFondo);
        precios.setOpaque(true);

        precios.setUI(new javax.swing.plaf.metal.MetalSliderUI() {
            @Override
            public void paintThumb(Graphics g) {
                g.setColor(colorPrincipal);
                g.fillRect(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
            }

            @Override
            public void paintTrack(Graphics g) {
                // Fondo del track
                g.setColor(colorFondo);
                g.fillRect(trackRect.x, trackRect.y, trackRect.width, trackRect.height);

                // Línea central del track
                g.setColor(colorPrincipal);
                int y = trackRect.y + trackRect.height / 2;
                g.drawLine(trackRect.x, y, trackRect.x + trackRect.width, y);
            }
        });

        precios.repaint(); // aplica los cambios
    }

    private void personalizarCheckbox() {
        Color amarilloPersonalizado = new Color(255, 204, 0);

        checkBox.setBackground(amarilloPersonalizado); 
        checkBox.setForeground(Color.WHITE);           

        checkBox.setFont(new Font("Arial", Font.BOLD, 14));

        checkBox.setFocusPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblFondo = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        precios = new javax.swing.JSlider();
        lblMin = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAplicar = new javax.swing.JButton();
        dateEntrada = new componentes.DateSelector();
        dateSalida = new componentes.DateSelector();
        jLabel6 = new javax.swing.JLabel();
        checkBox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/fondoFiltroHabitacion.png"))); // NOI18N
        jLayeredPane1.add(lblFondo);
        lblFondo.setBounds(0, 0, 1000, 600);

        Body.setBackground(new java.awt.Color(1, 74, 173));
        Body.setPreferredSize(new java.awt.Dimension(1000, 600));
        Body.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("STXihei", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("PRECIO:");
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(jLabel2, gridBagConstraints);

        precios.setForeground(new java.awt.Color(255, 204, 0));
        precios.setPreferredSize(new java.awt.Dimension(200, 40));
        precios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                preciosStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(precios, gridBagConstraints);

        lblMin.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        lblMin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMin.setText("$100");
        lblMin.setMaximumSize(new java.awt.Dimension(30, 30));
        lblMin.setMinimumSize(new java.awt.Dimension(30, 30));
        lblMin.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(lblMin, gridBagConstraints);

        lblCosto.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCosto.setText("$0");
        lblCosto.setPreferredSize(new java.awt.Dimension(37, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(lblCosto, gridBagConstraints);

        lblMax.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        lblMax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMax.setText("$3000");
        lblMax.setMaximumSize(new java.awt.Dimension(30, 30));
        lblMax.setMinimumSize(new java.awt.Dimension(30, 30));
        lblMax.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(lblMax, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("STXihei", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("FAVORITOS");
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(jLabel5, gridBagConstraints);

        btnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Aplicar_btn.png"))); // NOI18N
        btnAplicar.setBorder(null);
        btnAplicar.setBorderPainted(false);
        btnAplicar.setContentAreaFilled(false);
        btnAplicar.setPreferredSize(new java.awt.Dimension(117, 40));
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(btnAplicar, gridBagConstraints);

        dateEntrada.setBackground(new java.awt.Color(1, 74, 173));
        dateEntrada.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateEntrada.setForeground(new java.awt.Color(51, 51, 51));
        dateEntrada.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(dateEntrada, gridBagConstraints);

        dateSalida.setBackground(new java.awt.Color(1, 74, 173));
        dateSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateSalida.setForeground(new java.awt.Color(51, 51, 51));
        dateSalida.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(dateSalida, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("STXihei", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("PLAZO DE BUSQUEDA:");
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(jLabel6, gridBagConstraints);

        checkBox.setBackground(new java.awt.Color(255, 204, 0));
        checkBox.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        checkBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        checkBox.setContentAreaFilled(false);
        checkBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkBox.setPreferredSize(new java.awt.Dimension(40, 40));
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(checkBox, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("STXihei", 1, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AL");
        jLabel7.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        Body.add(jLabel7, gridBagConstraints);

        jLayeredPane1.setLayer(Body, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(Body);
        Body.setBounds(200, 0, 610, 600);

        getContentPane().add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        Header.setBackground(new java.awt.Color(1, 74, 173));
        Header.setPreferredSize(new java.awt.Dimension(1000, 100));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Filtros.png"))); // NOI18N
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 96));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/TAP3 (1).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        getContentPane().add(Header, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        try {
            int costo = precios.getValue();

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

            filtros.put("costo", costo);
            filtros.put("fechaE", fechaEntrada);
            filtros.put("fechaS", fechaSalida);
            filtros.put("favoritos", filtroFavoritos);
            

            notifyObservers();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void preciosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_preciosStateChanged
        int valor = precios.getValue();
        lblCosto.setText("$" + valor);
    }//GEN-LAST:event_preciosStateChanged

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        filtroFavoritos = !filtroFavoritos;        
    }//GEN-LAST:event_checkBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JCheckBox checkBox;
    private componentes.DateSelector dateEntrada;
    private componentes.DateSelector dateSalida;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JSlider precios;
    // End of variables declaration//GEN-END:variables

}
