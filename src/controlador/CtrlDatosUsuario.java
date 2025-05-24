
package controlador;

import java.util.List;
import modelo.logica.LogicHabitacion;
import modelo.logica.LogicReservacion;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

/**
 *
 * @author edwin
 */
public class CtrlDatosUsuario {
    LogicReservacion logicaReservacion = new LogicReservacion();
    LogicHabitacion logicaHabitacion = new LogicHabitacion();

    public List<Reservacion> ctrBuscarReservaciones(Huesped huesped){
        return logicaReservacion.logicaBuscarPorHuesped(huesped.getId_huesped());
    }
    
    public List<Habitacion> ctrBuscarHabitaciones(){
        return logicaHabitacion.logicaBuscarHabitaciones();
    }
}
