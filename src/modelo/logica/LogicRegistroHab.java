
package modelo.logica;

import java.util.List;
import modelo.dao.DAORegistroHab;
import modelo.vo.Habitacion;

public class LogicRegistroHab {
    DAORegistroHab daorh = new DAORegistroHab();
    List<Habitacion> listahabitaciones = daorh.getListaHabitaciones();
    public List<Habitacion> getListaHabitaciones() {
        return daorh.getListaHabitaciones();
    }
}
