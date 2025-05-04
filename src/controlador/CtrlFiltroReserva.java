
package controlador;

import java.util.List;
import modelo.logica.LogicaHabitacion;
import modelo.vo.Habitacion;

public class CtrlFiltroReserva {
    LogicaHabitacion logicaHabitacion = new LogicaHabitacion();
    
    public List<Habitacion> ctrHabitaciones(){
        return logicaHabitacion.logicaBuscarHabitaciones();
    }
}
