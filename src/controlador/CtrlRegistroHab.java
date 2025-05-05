
package controlador;

import java.util.List;
import modelo.logica.LogicRegistroHab;
import modelo.vo.Habitacion;

public class CtrlRegistroHab {
    LogicRegistroHab logicarh = new LogicRegistroHab();
    
    public List<Habitacion> getListaHabitaciones(){
        return logicarh.getListaHabitaciones();
    }
}
