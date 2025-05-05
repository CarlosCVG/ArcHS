package modelo.logica;

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
        for (Habitacion hab: habitaciones){
            if(hab.getId_habitacion() == HabToR){
                return true;
            }
        }
        return false;
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
