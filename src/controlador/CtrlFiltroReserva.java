
package controlador;

import java.util.List;
import modelo.logica.LogicHabitacion;
import modelo.vo.Habitacion;

public class CtrlFiltroReserva {
    LogicHabitacion logicaHabitacion = new LogicHabitacion();
    
    public List<Habitacion> ctrHabitaciones(){
        return logicaHabitacion.logicaBuscarHabitaciones();
    }
}
