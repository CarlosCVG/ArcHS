/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Habitacion;
import repositorio.RepHabitaciones;

/**
 *
 * @author edwin
 */
public class DAOHabitacion {

    RepHabitaciones repHabitacion = new RepHabitaciones();

    public Habitacion daobuscarPorId(int id) {
        return repHabitacion.search(id);
    }

    public List<Habitacion> daoBuscarHabitacion(String precio, String tamano, String num_camas, String descripcion) {
        return repHabitacion.search(precio, tamano, num_camas, descripcion);
    }

    public boolean daoEliminarHabitacion(Habitacion habitacion) {
        return repHabitacion.delete(habitacion);
    }

    public boolean daoAgregarHabitacion(Habitacion habitacion) {
        return repHabitacion.insert(habitacion);
    }

    public boolean daoModificarHabitacion(Habitacion habitacion) {
        return repHabitacion.update(habitacion);
    }
}
