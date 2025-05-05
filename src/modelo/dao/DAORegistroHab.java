package modelo.dao;

import java.util.List;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;
import repositorio.RepHabitaciones;
import repositorio.RepReservaciones;

public class DAORegistroHab {
    public List<Habitacion> getListaHabitaciones(){
        return RepHabitaciones.getListaHabitaciones();
    }
    public List<Reservacion> getListaReservaciones(){
        return RepReservaciones.getListaReservaciones();
    }
}
