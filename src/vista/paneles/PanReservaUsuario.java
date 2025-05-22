/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

import modelo.util.Observer;
import componentes.SelectorMes;
import controlador.CtrlReservaUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import vista.ventanas.WinReservacion;
import javax.swing.JPanel;
import modelo.vo.Favorito;
import modelo.vo.Reservacion;
import vista.paneles.PanHabitacion;
import vista.ventanas.WinFiltros;
import vista.ventanas.WinCalendario;

/**
 *
 * @author karlo
 */
public class PanReservaUsuario extends JPanel implements Observer {

    private CtrlReservaUI controladorReserva = new CtrlReservaUI();

    private List<Habitacion> habitaciones;
    private List<Favorito> favoritos;
    private Huesped huespedActual;
    private WinFiltros panelFiltros;

    public PanReservaUsuario(Huesped huesped) {
        initComponents();
        this.huespedActual = huesped;
        this.habitaciones = controladorReserva.ctrHabitaciones();
        configurarComponentesUI();
    }

    private void configurarComponentesUI() {
        // Configuración del carrusel de habitaciones, busco las habitaciones con reservacion para colocar el mensaje
        // ""
        for (Habitacion habitacion : habitaciones) {

            List<Favorito> favoritos = controladorReserva.ctrBuscarFavoritos(huespedActual);
            boolean esFavorito = false;
            for (Favorito favorito : favoritos) {
                if (habitacion.getId_habitacion() == favorito.getId_habitacion()) {
                    esFavorito = true;
                    break;
                }
            }

            Reservacion reserva = controladorReserva.ctrBuscarReservacion(habitacion);

            if (reserva != null) {
                carrusel.agregarPanel(new PanHabitacion(habitacion, reserva.getF_entrada().getMonthValue(), esFavorito));
            } else {
                carrusel.agregarPanel(new PanHabitacion(habitacion, esFavorito));
            }

            configurarEstilosCarrusel();
            configurarBotones();
        }

    }

    private void configurarEstilosCarrusel() {
        Color colorPrincipal = new Color(1, 74, 173);
        carrusel.setColorVelo(colorPrincipal);
        carrusel.setBtnColor(colorPrincipal);
        carrusel.setBtnColorForMouseEntered(new Color(1, 106, 249));
        carrusel.setBtnColorForMouseExit(colorPrincipal);
        carrusel.setBtnColorForMousePressed(colorPrincipal);
        carrusel.setBtnColorForMouseReleased(colorPrincipal);

        ImageIcon iconLeft = new ImageIcon("src/vista/images/btnLeft.png");
        ImageIcon iconRight = new ImageIcon("src/vista/images/btnRight.png");

        carrusel.setBtnImage(iconRight, iconLeft);
    }

    private void configurarBotones() {
        configurarBoton(btnReservar, "src/vista/images/btnReservar.png", new Dimension(240, 40));
        configurarBoton(btnFiltrar, "src/vista/images/btnFiltros.png", new Dimension(240, 40));
        configurarBoton(btnFavoritos, "src/vista/images/btnFavoritos.png", new Dimension(40, 40));
        configurarBoton(btnCalendario, "src/vista/images/btnCalendario.png", new Dimension(40, 40));
    }

    private void configurarBoton(JButton boton, String rutaIcono, Dimension dimension) {
        boton.setPreferredSize(dimension);
        ImageIcon icono = new ImageIcon(rutaIcono);
        Image imagenEscalada = icono.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(imagenEscalada));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        carrusel = new componentes.PanelCarrusel();
        footer = new javax.swing.JPanel();
        btnCalendario = new componentes.RoundedButton();
        btnReservar = new componentes.RoundedButton();
        btnFiltrar = new componentes.RoundedButton();
        btnFavoritos = new componentes.RoundedButton();

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

        btnCalendario.setBackground(new java.awt.Color(1, 74, 173));
        btnCalendario.setText("");
        btnCalendario.setOpaque(true);
        btnCalendario.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCalendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCalendarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCalendarioMouseExited(evt);
            }
        });
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        footer.add(btnCalendario, new java.awt.GridBagConstraints());

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
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        footer.add(btnFiltrar, new java.awt.GridBagConstraints());

        btnFavoritos.setBackground(new java.awt.Color(1, 74, 173));
        btnFavoritos.setText("");
        btnFavoritos.setOpaque(true);
        btnFavoritos.setPreferredSize(new java.awt.Dimension(40, 40));
        btnFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFavoritosActionPerformed(evt);
            }
        });
        footer.add(btnFavoritos, new java.awt.GridBagConstraints());

        add(footer, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // Cambiarlo despues.

        List<JPanel> a = carrusel.getPanelList();
        List<PanHabitacion> b = new ArrayList<>();

        for (JPanel jPanel : a) {
            b.add((PanHabitacion) jPanel);
        }

        carrusel.detenerAutoScroll();
        PanHabitacion panelSeleccionado = (PanHabitacion) carrusel.getCurrentPanel();
        new WinReservacion(b, huespedActual).setVisible(true);
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnReservarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseEntered
        btnReservar.setBackground(new Color(1, 90, 211));
    }//GEN-LAST:event_btnReservarMouseEntered

    private void btnReservarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservarMouseExited
        btnReservar.setBackground(new Color(1, 74, 174));
    }//GEN-LAST:event_btnReservarMouseExited

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        btnFiltrar.setBackground(new Color(1, 90, 211));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        btnFiltrar.setBackground(new Color(1, 74, 174));
    }//GEN-LAST:event_btnFiltrarMouseExited

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        panelFiltros = new WinFiltros();
        panelFiltros.addObserver(this);
        panelFiltros.setVisible(true);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        // Selector de mes
        carrusel.detenerAutoScroll();
        PanHabitacion panelSeleccionado = (PanHabitacion) carrusel.getCurrentPanel();

        SelectorMes selectorMesDialog = new SelectorMes(this);
        selectorMesDialog.setMes(panelSeleccionado.getMesReserva());
        selectorMesDialog.setVisible(true);
        String mesSeleccionado = selectorMesDialog.getMesIngresado();

        int mes;
        try {
            LocalDate hoy = LocalDate.now();

            mes = Integer.valueOf(mesSeleccionado);
            if (mes < 1 || mes > 12) {
                mostrarMensaje("Por favor, ingrese un mes válido (1-12).");
                return; // Mes invalido fuera menor que 1 y mayor que 12
            }
            if (mes < hoy.getMonthValue()) {
                mostrarMensaje("Por favor ingrese un mes igual o posterior al actual");
                return; // Mes antes que hoy
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("Por favor, ingrese un numero valido para el mes.");
            return; // Salir si no es un numero
        }

        List<Reservacion> reservacionesDelMes = controladorReserva.ctrBuscarReservacionPorMes(mes);
        WinCalendario calendario = new WinCalendario(mes, panelSeleccionado, huespedActual);

        calendario.setReservaList(reservacionesDelMes);
        calendario.setVisible(true);
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnCalendarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalendarioMouseExited
        btnCalendario.setBackground(new Color(1, 74, 174));
    }//GEN-LAST:event_btnCalendarioMouseExited

    private void btnCalendarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalendarioMouseEntered
        btnCalendario.setBackground(new Color(1, 90, 211));
    }//GEN-LAST:event_btnCalendarioMouseEntered

    private void btnFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFavoritosActionPerformed
        PanHabitacion currentHabitacion = (PanHabitacion) carrusel.getCurrentPanel();
        currentHabitacion.alternarFavorito();
    }//GEN-LAST:event_btnFavoritosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private componentes.RoundedButton btnCalendario;
    private componentes.RoundedButton btnFavoritos;
    private componentes.RoundedButton btnFiltrar;
    private componentes.RoundedButton btnReservar;
    private componentes.PanelCarrusel carrusel;
    private javax.swing.JPanel footer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {

        // Lógica para actualizar las habitaciones con los filtros aplicados
        habitaciones = controladorReserva.ctrHabitacionesConFiltros(panelFiltros.getFiltros(), huespedActual);
        System.out.println(habitaciones.size());

        carrusel.removePanels();

        for (Habitacion habitacion : habitaciones) {
            Reservacion reserva = controladorReserva.ctrBuscarReservacion(habitacion);

            if (reserva == null) {
                carrusel.agregarPanel(new PanHabitacion(habitacion));
            } else {
                carrusel.agregarPanel(new PanHabitacion(habitacion, reserva.getF_entrada().getMonthValue(), true));
            }
        }

    }

    private void mostrarMensaje(String mensaje) {
        ImageIcon originalIcon = new ImageIcon("src/vista/images/LOGO.png");  // Cambia esta ruta por la de tu imagen

        // Redimensionar la imagen
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(75, 90, Image.SCALE_SMOOTH); // Ajusta el tamaño (ancho y alto)

        // Crear el nuevo ImageIcon con la imagen redimensionada
        ImageIcon customIcon = new ImageIcon(resizedImage);
        JOptionPane optionPane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, customIcon);
        JDialog dialog = optionPane.createDialog(this, "Advertencia");
        dialog.setLocationRelativeTo(this);

        dialog.setVisible(true);
    }

}
