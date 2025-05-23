package modelo.logica;

import excepciones.ExAgregar;
import java.time.LocalDate;
import java.util.List;
import modelo.dao.DAOReservacion;
import modelo.vo.Reservacion;

public class LogicReservacion {

    DAOReservacion daoReservacion = new DAOReservacion();

    public boolean logicaAgregarReservacion(Reservacion reservacion) throws ExAgregar {
        LocalDate hoy = LocalDate.now();
        LocalDate entrada = reservacion.getF_entrada();
        LocalDate salida = reservacion.getF_salida();

        if (entrada.isBefore(hoy)) {
            throw new ExAgregar("La fecha de entrada no puede ser en el pasado");
        }

        if (salida.isBefore(entrada)) {
            throw new ExAgregar("La fecha de salida no puede ser anterior a la fecha de entrada");
        }

        return daoReservacion.daoAgregarReservacion(reservacion);
    }

    public List<Reservacion> logicaBuscarPorHabitacion(int numHabitacion) {
        return daoReservacion.daoBuscarPorHabitacion(numHabitacion);
    }
    
    public List<Reservacion> logicaBuscarPorHuesped(int idHuesped) {
        return daoReservacion.daoBuscarPorHuesped(idHuesped);
    }

    public List<Reservacion> logicaBuscarReservaciones() {
        return daoReservacion.daoGetReservacion();
    }

    public List<Reservacion> logicaBuscarPorMes(int year, int mes) {
        return daoReservacion.daoBuscarPorMes(year, mes);
    }

    public List<Reservacion> logicaBuscarPorHabitacionYMes(int idHabitacion, int year, int mes) {
        return daoReservacion.daoBuscarPorHabitacionYMes(idHabitacion, year, mes);
    }
}
