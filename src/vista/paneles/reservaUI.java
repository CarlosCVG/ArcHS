/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

import controlador.CtrReservaUI;
import java.awt.Color;
import java.awt.Dimension;
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

        btnReservar.setPreferredSize(new Dimension(240, 40));
        ImageIcon iconReservar = new ImageIcon("src/vista/images/btnReservar.png");
        Image scaledReservar = iconReservar.getImage().getScaledInstance(240, 40, Image.SCALE_SMOOTH);
        btnReservar.setIcon(new ImageIcon(scaledReservar));

        btnFiltrar.setPreferredSize(new Dimension(240, 40));
        ImageIcon iconFiltros = new ImageIcon("src/vista/images/btnFiltros.png");
        Image scaledFiltros = iconFiltros.getImage().getScaledInstance(240, 40, Image.SCALE_SMOOTH);
        btnFiltrar.setIcon(new ImageIcon(scaledFiltros));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        carrusel = new componentes.PanelCarrusel();
        footer = new javax.swing.JPanel();
        btnReservar = new componentes.RoundedButton();
        btnFiltrar = new componentes.RoundedButton();

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

        btnReservar.setBackground(new java.awt.Color(1, 74, 173));
        btnReservar.setText("");
        btnReservar.setOpaque(true);
        btnReservar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnReservar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReservarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReservarMouseExited(evt);
            }
        });
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        footer.add(btnReservar, new java.awt.GridBagConstraints());

        btnFiltrar.setBackground(new java.awt.Color(1, 74, 173));
        btnFiltrar.setText("");
        btnFiltrar.setOpaque(true);
        btnFiltrar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        footer.add(btnFiltrar, new java.awt.GridBagConstraints());

        add(footer, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed


    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnReservarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseEntered
        btnReservar.setBackground(new Color(1,90,211));
    }//GEN-LAST:event_btnReservarMouseEntered

    private void btnReservarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseExited
        btnReservar.setBackground(new Color(1, 74, 174));
    }//GEN-LAST:event_btnReservarMouseExited

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        btnFiltrar.setBackground(new Color(1,90,211));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        btnFiltrar.setBackground(new Color(1, 74, 174));
    }//GEN-LAST:event_btnFiltrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.RoundedButton btnFiltrar;
    private componentes.RoundedButton btnReservar;
    private componentes.PanelCarrusel carrusel;
    private javax.swing.JPanel footer;
    // End of variables declaration//GEN-END:variables
}
