package controlador;

import excepciones.ExRegistroHab;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import modelo.logica.LogicRegistroHab;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

public class CtrlRegistroHab {

    LogicRegistroHab logicarh = new LogicRegistroHab();

    public void styleTable(JTable tblRegistroFisico) {
        JTableHeader header = tblRegistroFisico.getTableHeader();
        header.setBackground(Color.decode("#014AAD"));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblRegistroFisico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblRegistroFisico.setRowHeight(25);
        tblRegistroFisico.setGridColor(Color.LIGHT_GRAY);
        tblRegistroFisico.setSelectionBackground(new Color(0, 120, 215));
        tblRegistroFisico.setSelectionForeground(Color.WHITE);
        tblRegistroFisico.setShowHorizontalLines(true);
        tblRegistroFisico.setShowVerticalLines(false);
        tblRegistroFisico.setIntercellSpacing(new Dimension(0, 0));
        tblRegistroFisico.setFillsViewportHeight(true);
        tblRegistroFisico.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblRegistroFisico.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblRegistroFisico.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblRegistroFisico.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblRegistroFisico.getColumnModel().getColumn(4).setPreferredWidth(200);

    }

    public List<Habitacion> getListaHabitaciones() {
        return logicarh.getListaHabitaciones();
    }

    public List<Reservacion> getListaReservaciones() {
        return logicarh.getListaReservaciones();
    }

    public boolean revisarDisponible(int HabToR, List<Habitacion> habitaciones) {
        return logicarh.revisarDisponible(HabToR, habitaciones);
    }

    public int getCountHuespedes() {
        return logicarh.getCountHuespedes();
    }

    public int getCountReservaciones() {
        return logicarh.getCountReservaciones();
    }

    public List<Habitacion> filtrarListaHabitaciones(List<Reservacion> reservaciones, List<Habitacion> habitacionesNF, int tmSelector) {
        return logicarh.filtrarListaHabitaciones(reservaciones, habitacionesNF, tmSelector);
    }

    public boolean addHuesped(String usuario, String pass, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) throws ExRegistroHab {
        return logicarh.addHuesped(usuario, pass, nombre, ap1, ap2, num_tarjeta, idioma, correo);
    }

    public Huesped findClient(String usuario, String pass) {
        return logicarh.findClient(usuario, pass);
    }
}
