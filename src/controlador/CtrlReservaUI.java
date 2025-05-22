
package controlador;

import java.util.List;
import java.util.Map;
import modelo.logica.LogicFavorito;
import modelo.logica.LogicHabitacion;
import modelo.logica.LogicReservacion;
import modelo.vo.Favorito;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

public class CtrlReservaUI {
    LogicHabitacion logicaHabitacion = new LogicHabitacion();
    LogicReservacion logicaReservacion = new LogicReservacion();
    LogicFavorito logicaFavorito = new LogicFavorito();
    
    public List<Habitacion> ctrHabitacionesDisponibles(){
        return logicaHabitacion.logicaBuscarHabitacionesDisponibles();
    }
    
    public List<Habitacion> ctrHabitacionesConFiltros(Map<String, Object> filtros, Huesped huesped){
        return logicaHabitacion.logicaHabitacionesFiltradas(filtros, huesped);
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
    
    public List<Favorito> ctrBuscarFavoritos(Huesped huesped){
        return logicaFavorito.logicaBuscarFavoritos(huesped.getId_huesped());
    }
    
    public boolean ctrAgregarFavorito(Favorito favorito){
        return logicaFavorito.logicaEliminarFavorito(favorito);
    }
    
    public boolean ctrEliminarFavorito(Favorito favorito){
        return logicaFavorito.logicaEliminarFavorito(favorito);
    }
    
    
}
