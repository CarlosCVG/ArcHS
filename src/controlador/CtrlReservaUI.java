
package controlador;

import java.util.List;
import java.util.Map;
import modelo.logica.LogicHabitacion;
import modelo.logica.LogicReservacion;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;

public class CtrlReservaUI {
    LogicHabitacion logicaHabitacion = new LogicHabitacion();
    LogicReservacion logicaReservacion = new LogicReservacion();
    
    public List<Habitacion> ctrHabitacionesDisponibles(){
        return logicaHabitacion.logicaBuscarHabitacionesDisponibles();
    }
    
    public List<Habitacion> ctrHabitacionesConFiltros(Map<String, Object> filtros){
        return logicaHabitacion.logicaHabitacionesFiltradas(filtros);
    }
    
    public List<Habitacion> ctrHabitaciones(){
        return logicaHabitacion.logicaBuscarHabitaciones();
    }

    public Reservacion ctrBuscarReservacion(Habitacion habitacion){
        return logicaReservacion.logicaBuscarPorHabitacion(habitacion.getId_habitacion());
    }
    
    public List<Reservacion> ctrBuscarReservacionPorMes(int mes){
        return logicaReservacion.logicaBuscarPorMes(mes);
    }
    
}
