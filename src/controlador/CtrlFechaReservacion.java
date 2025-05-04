
package controlador;

import excepciones.ExAgregar;
import modelo.logica.LogicReservacion;
import modelo.vo.Reservacion;

public class CtrlFechaReservacion {
    LogicReservacion logicaReservacion = new LogicReservacion();
    
    public boolean ctrAgregarReservacion(Reservacion reservacion) throws ExAgregar{
        return logicaReservacion.logicaAgregarReservacion(reservacion);
    }
}
