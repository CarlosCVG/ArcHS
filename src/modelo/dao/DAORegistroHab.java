package modelo.dao;

import java.util.List;
import modelo.vo.Habitacion;
import repositorio.RepHabitaciones;

public class DAORegistroHab {
    public List<Habitacion> getListaHabitaciones(){
        return RepHabitaciones.getListaHabitaciones();
    }
}
