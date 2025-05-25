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

    public void styleTable(JTable tblToStyle) {
        JTableHeader header = tblToStyle.getTableHeader();
        header.setBackground(Color.decode("#014AAD"));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblToStyle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblToStyle.setRowHeight(25);
        tblToStyle.setGridColor(Color.LIGHT_GRAY);
        tblToStyle.setSelectionBackground(new Color(0, 120, 215));
        tblToStyle.setSelectionForeground(Color.WHITE);
        tblToStyle.setShowHorizontalLines(true);
        tblToStyle.setShowVerticalLines(false);
        tblToStyle.setIntercellSpacing(new Dimension(0, 0));
        tblToStyle.setFillsViewportHeight(true);
        tblToStyle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tblToStyle.getColumnModel().getColumn(0).setPreferredWidth(110);
        tblToStyle.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblToStyle.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblToStyle.getColumnModel().getColumn(3).setPreferredWidth(110);
        tblToStyle.getColumnModel().getColumn(4).setPreferredWidth(340);

    }
    public void styleTableReservaciones(JTable tblToStyle) {
        JTableHeader header = tblToStyle.getTableHeader();
        header.setBackground(Color.decode("#014AAD"));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblToStyle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblToStyle.setRowHeight(25);
        tblToStyle.setGridColor(Color.LIGHT_GRAY);
        tblToStyle.setSelectionBackground(new Color(0, 120, 215));
        tblToStyle.setSelectionForeground(Color.WHITE);
        tblToStyle.setShowHorizontalLines(true);
        tblToStyle.setShowVerticalLines(false);
        tblToStyle.setIntercellSpacing(new Dimension(0, 0));
        tblToStyle.setFillsViewportHeight(true);
        tblToStyle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tblToStyle.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblToStyle.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblToStyle.getColumnModel().getColumn(2).setPreferredWidth(160);
        tblToStyle.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblToStyle.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblToStyle.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblToStyle.getColumnModel().getColumn(6).setPreferredWidth(95);

    }

    
    public List<Reservacion> searchLikeReservacion(String txtToSearch){
        return logicarh.searchLikeReservacion(txtToSearch);
    }
    
    public Huesped getClienteByIdReservacion(int idReservacion){
        return logicarh.getClienteByIdReservacion(idReservacion);
    }
    
    public boolean deleteReservation(Reservacion rselected){
        return logicarh.deleteReservation(rselected);
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

    public List<Habitacion> filtrarListaHabitaciones() {
        return logicarh.filtrarListaHabitaciones();
    }
    public List<Object[]> filtrarListaReservaciones() {
        return logicarh.filtrarListaReservaciones();
    }

    public boolean addHuesped(String usuario, String pass, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) throws ExRegistroHab {
        return logicarh.addHuesped(usuario, pass, nombre, ap1, ap2, num_tarjeta, idioma, correo);
    }

    public Huesped findClient(String usuario, String pass) {
        return logicarh.findClient(usuario, pass);
    }
}
