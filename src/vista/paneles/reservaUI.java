/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

import controlador.CtrReservaUI;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import modelo.vo.Habitacion;

/**
 *
 * @author karlo
 */
public class reservaUI extends javax.swing.JPanel {

    /**
     * Creates new form registroUI
     */
    CtrReservaUI ctrReservaUI = new CtrReservaUI();
    List<Habitacion> habitaciones;

    public reservaUI() {
        initComponents();
        habitaciones = ctrReservaUI.ctrHabitacionesDisponibles();
        System.out.println(habitaciones.size());
        configurarComponentes();
    }

    private void configurarComponentes() {
        for (Habitacion habitacion : habitaciones) {
            carrusel.agregarPanel(new PanelHabitacion(habitacion));
        }

        carrusel.setColorVelo(new Color(1, 74, 173));
        carrusel.setBtnColor(new Color(1, 74, 173));
        carrusel.setBtnColorForMouseEntered(new Color(1, 106, 249));
        carrusel.setBtnColorForMouseExit(new Color(1, 74, 173));
        carrusel.setBtnColorForMousePressed(new Color(1, 74, 173));
        carrusel.setBtnColorForMouseReleased(new Color(1, 74, 173));

        ImageIcon iconR = new ImageIcon("src/vista/images/btnRight.png");
        Image scaledR = iconR.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        ImageIcon iconL = new ImageIcon("src/vista/images/btnLeft.png");
        Image scaledL = iconL.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        carrusel.setBtnImage(new ImageIcon(scaledR), new ImageIcon(scaledL));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        carrusel = new componentes.PanelCarrusel();
        footer = new javax.swing.JPanel();
        roundedButton1 = new componentes.RoundedButton();
        roundedButton2 = new componentes.RoundedButton();

        setPreferredSize(new java.awt.Dimension(760, 580));
        setLayout(new java.awt.BorderLayout());

        body.setLayout(new java.awt.BorderLayout());

        carrusel.setBackground(new java.awt.Color(1, 74, 173));
        carrusel.setAutoScrollInterval(6000);
        carrusel.setMinimumSize(new java.awt.Dimension(62, 450));
        carrusel.setPreferredSize(new java.awt.Dimension(800, 530));
        body.add(carrusel, java.awt.BorderLayout.CENTER);

        add(body, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(1, 74, 173));
        footer.setMaximumSize(new java.awt.Dimension(32767, 22));
        footer.setMinimumSize(new java.awt.Dimension(310, 22));
        footer.setPreferredSize(new java.awt.Dimension(310, 50));
        footer.setLayout(new java.awt.GridBagLayout());
        footer.add(roundedButton1, new java.awt.GridBagConstraints());
        footer.add(roundedButton2, new java.awt.GridBagConstraints());

        add(footer, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.PanelCarrusel carrusel;
    private javax.swing.JPanel footer;
    private componentes.RoundedButton roundedButton1;
    private componentes.RoundedButton roundedButton2;
    // End of variables declaration//GEN-END:variables
}
