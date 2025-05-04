
package controlador;

import java.util.List;
import java.util.Map;
import modelo.logica.LogicHabitacion;
import modelo.vo.Habitacion;

public class CtrlReservaUI {
    LogicHabitacion logicaHabitacion = new LogicHabitacion();
    
    public List<Habitacion> ctrHabitacionesDisponibles(){
        return logicaHabitacion.logicaBuscarHabitacionesDisponibles();
    }
    
    public List<Habitacion> ctrHabitacionesConFiltros(Map<String, Integer> filtros){
        return logicaHabitacion.logicaHabitacionesFiltradas(filtros);
    }
    
}
