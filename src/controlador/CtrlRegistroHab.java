
package controlador;

import java.util.List;
import modelo.logica.LogicRegistroHab;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;

public class CtrlRegistroHab {
    LogicRegistroHab logicarh = new LogicRegistroHab();
    
    public List<Habitacion> getListaHabitaciones(){
        return logicarh.getListaHabitaciones();
    }
    public List<Reservacion> getListaReservaciones(){
        return logicarh.getListaReservaciones();
    }
    
    public boolean revisarDisponible(int HabToR, List<Habitacion> habitaciones){
        return logicarh.revisarDisponible(HabToR, habitaciones);
    }
    
    public List<Habitacion> filtrarListaHabitaciones(List<Reservacion> reservaciones, List<Habitacion> habitacionesNF, int tmSelector){
        return logicarh.filtrarListaHabitaciones(reservaciones, habitacionesNF, tmSelector);
    }
    
    
}
