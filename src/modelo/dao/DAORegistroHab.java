package modelo.dao;

import java.util.List;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;
import repositorio.RepHabitaciones;
import repositorio.RepHuespedes;
import repositorio.RepReservaciones;

public class DAORegistroHab {
    public List<Habitacion> getListaHabitaciones(){
        return RepHabitaciones.getListaHabitaciones();
    }
    public List<Reservacion> getListaReservaciones(){
        return RepReservaciones.getListaReservaciones();
    }
    public int getCountHuespedes(){
        return RepHuespedes.getListaHuespedes().size();
    }
    public int getCountReservaciones(){
        return RepReservaciones.getListaReservaciones().size();
    }
}
