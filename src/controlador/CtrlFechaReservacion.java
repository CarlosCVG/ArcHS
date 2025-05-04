
package controlador;

import excepciones.ExAgregar;
import modelo.logica.LogicaReservacion;
import modelo.vo.Reservacion;

public class CtrlFechaReservacion {
    LogicaReservacion logicaReservacion = new LogicaReservacion();
    
    public boolean ctrAgregarReservacion(Reservacion reservacion) throws ExAgregar{
        return logicaReservacion.logicaAgregarReservacion(reservacion);
    }
}
