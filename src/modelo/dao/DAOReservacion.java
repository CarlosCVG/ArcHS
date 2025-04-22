/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Reservacion;
import repositorio.RepReservaciones;

/**
 *
 * @author edwin
 */
public class DAOReservacion {
    RepReservaciones repReservacion = new RepReservaciones();

    public Reservacion daobuscarPorId(int id) {
        return repReservacion.search(id);
    }

    public List<Reservacion> daoBuscarEmpleado(String id_reservacion, String id_habitacion, String id_huesped, String f_entrada, String f_salida) {
        
        return repReservacion.search(id_reservacion, id_habitacion, id_huesped, f_entrada, f_salida);
    }

    public boolean daoEliminarEmpleado(Reservacion reservacion){
        return repReservacion.delete(reservacion);
    }
    
    public boolean daoAgregarEmpleado(Reservacion reservacion){
        return repReservacion.insert(reservacion);
    }
    
    public boolean daoModificarEmpleado(Reservacion reservacion){
        return repReservacion.update(reservacion);
    }
}
