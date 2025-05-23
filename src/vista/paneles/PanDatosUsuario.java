/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.paneles;

import controlador.CtrlDatosUsuario;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

/**
 *
 * @author edwin
 */
public class PanDatosUsuario extends javax.swing.JPanel {

    private CtrlDatosUsuario controlador;

    public PanDatosUsuario(Huesped huesped) {
        initComponents();
        controlador = new CtrlDatosUsuario();
        recuperarDatos(huesped, body);
    }

    public void recuperarDatos(Huesped huesped, JLabel etiqueta) {
        List<Reservacion> reservaciones = controlador.ctrBuscarReservaciones(huesped);
        List<Habitacion> habitaciones = controlador.ctrBuscarHabitaciones();

        // Mapa para acceder a las habitaciones más rápido
        Map<Integer, Habitacion> mapaHabitaciones = new HashMap<>();
        for (Habitacion h : habitaciones) {
            mapaHabitaciones.put(h.getId_habitacion(), h);
        }

        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<div style='"
                + "font-family: monospace;"
                + "font-size: 16px;"
                + "color: white;"
                + "background-color: rgb(1,74,173);"
                + "padding: 15px;"
                + "border-radius: 10px;"
                + "width: 400px;'>");

        html.append("<div style='font-size: 18px; font-weight: bold; margin-bottom: 10px;'>Reservaciones:</div>");

        double costoTotalAcumulado = 0;  // Acumulador de costos

        for (Reservacion reservacion : reservaciones) {
            Habitacion habitacion = mapaHabitaciones.get(reservacion.getId_habitacion());

            long dias = ChronoUnit.DAYS.between(reservacion.getF_entrada(), reservacion.getF_salida());

            if (habitacion != null) {
                double costoBase = habitacion.getPrecio();
                double costoTotal = costoBase + (costoBase * dias / 3.0);

                costoTotalAcumulado += costoTotal;  // Sumar al total acumulado

                html.append(String.format(
                        "<div style='margin-bottom: 8px;'>"
                        + "<span style='color: #7289da;'>%s</span> - "
                        + "<span style='color: #7289da;'>%s</span> - "
                        + "Habitación <b>#%d</b> - "
                        + "Días: <b>%d</b> - "
                        + "Costo: <span style='color: #43b581;'>$%.2f</span>"
                        + "</div>",
                        reservacion.getF_entrada(),
                        reservacion.getF_salida(),
                        habitacion.getId_habitacion(),
                        dias,
                        costoTotal));
            } else {
                html.append(String.format(
                        "<div style='color: #f04747;'>Habitación no encontrada para la reservación del %s</div>",
                        reservacion.getF_entrada()));
            }
        }

        // Añadir renglón con el costo total acumulado
        html.append(String.format(
                "<div style='margin-top: 15px; font-weight: bold; font-size: 17px;'>"
                + "Costo Total: <span style='color: #faa61a;'>$%.2f</span>"
                + "</div>",
                 costoTotalAcumulado));

        html.append("</div></html>");
        etiqueta.setText(html.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JLabel();

        setBackground(new java.awt.Color(1, 74, 173));
        setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(1, 74, 173));
        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    // End of variables declaration//GEN-END:variables
}
