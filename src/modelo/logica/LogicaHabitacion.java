/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import excepciones.ExConsulta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.dao.DAOHabitacion;
import modelo.dao.DAOReservacion;
import modelo.vo.Habitacion;

/**
 *
 * @author edwin
 */
public class LogicaHabitacion {

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

    public List<Habitacion> logicaHabitacionesFiltradas(Map<String, Integer> filtros) {
        List<Habitacion> habitacionesFiltradas = new ArrayList<>();
        List<Habitacion> habitacionesDisponibles = logicaBuscarHabitacionesDisponibles();

        int filtroId = -1;
        int filtroCosto = 3000;

        if (filtros.containsKey("id")) {
            filtroId = filtros.get("id");
        }

        if (filtros.containsKey("costo")) {
            filtroCosto = filtros.get("costo");
        }

        for (Habitacion habitacion : habitacionesDisponibles) {
            if (filtroId != -1 && habitacion.getId_habitacion() != filtroId) {
                continue;
            }

            if (habitacion.getPrecio() > filtroCosto) {
                continue;
            }

            habitacionesFiltradas.add(habitacion);
        }

        return habitacionesFiltradas;
    }
    
    public List<Habitacion> logicaBuscarHabitaciones(){
        return daoHabitacion.daoGetHabitaciones();
    }
}
