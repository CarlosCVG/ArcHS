package modelo.logica;

import excepciones.ExRegistroHab;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.DAORegistroHab;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;

public class LogicRegistroHab {

    DAORegistroHab daorh = new DAORegistroHab();
    List<Habitacion> listahabitaciones = daorh.getListaHabitaciones();

    public List<Habitacion> getListaHabitaciones() {
        return daorh.getListaHabitaciones();
    }

    public List<Reservacion> getListaReservaciones() {
        return daorh.getListaReservaciones();
    }

    public boolean revisarDisponible(int HabToR, List<Habitacion> habitaciones) {
        for (Habitacion hab : habitaciones) {
            if (hab.getId_habitacion() == HabToR) {
                return true;
            }
        }
        return false;
    }

    public int getCountHuespedes() {
        return daorh.getCountHuespedes();
    }
    public int getCountReservaciones() {
        return daorh.getCountReservaciones();
    }

    public boolean addHuesped(String usuario, String pass, int id_huesped, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) throws ExRegistroHab {
        if (nombre.isBlank() || ap1.isBlank() || ap2.isBlank() || num_tarjeta.isBlank() || idioma.isBlank() || correo.isBlank()) {
            throw new ExRegistroHab("Rellena todos los campos");
        }
        if (esNumero(nombre) || esNumero(ap1) || esNumero(ap2)) {
            throw new ExRegistroHab("El nombre no puede contener numeros");
        }
        if (num_tarjeta.length() != 19){
            throw new ExRegistroHab("Longitud de tarjeta incorrecta");
        }
        return true;
    }

    public boolean esNumero(String str) {
        boolean esNumero = false;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                esNumero = true;
                break;
            }
        }
        return esNumero;
    }

    public List<Habitacion> filtrarListaHabitaciones(List<Reservacion> reservaciones, List<Habitacion> habitacionesNF, int tmSelector) {
        List<Habitacion> habitaciones = new ArrayList<>();

        if (tmSelector == 1) {
            for (Habitacion habi : habitacionesNF) {
                boolean estaReservada = false;
                for (Reservacion reserv : reservaciones) {
                    if (habi.getId_habitacion() == reserv.getId_habitacion()) {
                        estaReservada = true;
                        break;
                    }
                }
                if (!estaReservada) {
                    habitaciones.add(habi);
                }
            }
        } else if (tmSelector == 2) {
            for (Habitacion habi : habitacionesNF) {
                for (Reservacion reserv : reservaciones) {
                    if (habi.getId_habitacion() == reserv.getId_habitacion()) {
                        habitaciones.add(habi);
                        break;
                    }
                }
            }
        }

        return habitaciones;
    }

}
