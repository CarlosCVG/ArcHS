
package modelo.dao;

import java.util.List;
import modelo.vo.Reservacion;
import repositorio.RepReservaciones;

public class DAOReservacion {
    RepReservaciones repReserva = new RepReservaciones();
    
    public Reservacion daoBuscarPorHabitacion(int numHabitacion){
        return repReserva.search(numHabitacion);
    }
    
    public Reservacion daoBuscarPorID(int idReservacion){
        return repReserva.searchByID(idReservacion);
    }
    
    public boolean daoAgregarReservacion(Reservacion reservacion){
        return repReserva.insert(reservacion);
    }
    
    public List<Reservacion> daoBuscarPorMes(int mes){
        return repReserva.searchByMounth(mes);
    }
}
