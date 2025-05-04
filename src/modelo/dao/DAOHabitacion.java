
package modelo.dao;

import java.util.List;
import modelo.vo.Habitacion;
import repositorio.RepHabitaciones;

public class DAOHabitacion {
    RepHabitaciones repHabitacion;
    
    public List<Habitacion> daoGetHabitaciones(){
        return repHabitacion.getListaHabitaciones();
    }
}
