/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import excepciones.ExConsulta;
import java.util.ArrayList;
import java.util.List;
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

    public List<Habitacion> logicaHabitacionesDisponibles() {
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
}
