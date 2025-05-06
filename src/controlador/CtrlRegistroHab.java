
package controlador;

import excepciones.ExRegistroHab;
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
    
    public int getCountHuespedes(){
        return logicarh.getCountHuespedes();
    }
    
    public int getCountReservaciones(){
        return logicarh.getCountReservaciones();
    }
    public List<Habitacion> filtrarListaHabitaciones(List<Reservacion> reservaciones, List<Habitacion> habitacionesNF, int tmSelector){
        return logicarh.filtrarListaHabitaciones(reservaciones, habitacionesNF, tmSelector);
    }
    
    public boolean addHuesped(String usuario, String pass, int id_huesped, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) throws ExRegistroHab{
        return logicarh.addHuesped(usuario, pass, id_huesped, nombre, ap1, ap2, num_tarjeta, idioma, correo);
    }
    
    
}
