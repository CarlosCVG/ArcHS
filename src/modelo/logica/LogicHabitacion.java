package modelo.logica;

import excepciones.ExConsulta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.dao.DAOHabitacion;
import modelo.dao.DAOReservacion;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;

public class LogicHabitacion {

    DAOHabitacion daoHabitacion = new DAOHabitacion();
    DAOReservacion daoReservacion = new DAOReservacion();

    public List<Habitacion> logicaBuscarHabitacionesDisponibles() {
        List<Habitacion> todasLasHabitaciones = daoHabitacion.daoGetHabitaciones();
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();

        for (Habitacion habitacion : todasLasHabitaciones) {
            // Si no hay reservaciones para esta habitación, se considera disponible
            if (daoReservacion.daoBuscarPorHabitacion(habitacion.getId_habitacion()) == null) {
                habitacionesDisponibles.add(habitacion);
            }
        }

        return habitacionesDisponibles;
    }

    public List<Habitacion> logicaHabitacionesFiltradas(Map<String, Object> filtros, Huesped huesped) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        List<Habitacion> habitaciones;

        if (filtros.containsKey("favorito")){
            habitaciones = daoHabitacion.daoGetHabitacionesFavoritas(huesped);
        } else{
            habitaciones = daoHabitacion.daoGetHabitaciones();
        }
        
        int filtroCosto = 3000;
        LocalDate filtroFechaE = LocalDate.now();
        LocalDate filtroFechaS = LocalDate.now();

        // Recuperar valores del mapa de filtros
        if (filtros.containsKey("costo")) {
            filtroCosto = (int) filtros.get("costo");
        }
        if (filtros.containsKey("fechaE")) {
            filtroFechaE = (LocalDate) filtros.get("fechaE");
        }
        if (filtros.containsKey("fechaS")) {
            filtroFechaS = (LocalDate) filtros.get("fechaS");
        }
        

        for (Habitacion habitacion : habitaciones) {
            // Filtrar por precio
            if (habitacion.getPrecio() > filtroCosto) {
                continue;
            }

            // Verificar si la habitación está reservada
            Reservacion reserva = daoReservacion.daoBuscarPorHabitacion(habitacion.getId_habitacion());

            if (reserva != null) {
                LocalDate fechaInicioReserva = reserva.getF_entrada();
                LocalDate fechaFinReserva = reserva.getF_salida();

                // Si las fechas se solapan, la habitación no está disponible
                boolean fechasSeSolapan = !(filtroFechaS.isBefore(fechaInicioReserva) || filtroFechaE.isAfter(fechaFinReserva));
                if (fechasSeSolapan) {
                    continue;
                }
            }

            habitacionesFiltradas.add(habitacion);
        }

        return habitacionesFiltradas;
    }

    public List<Habitacion> logicaBuscarHabitaciones() {
        return daoHabitacion.daoGetHabitaciones();
    }
}
