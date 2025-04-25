/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.vo.Reservacion;
import repositorio.RepReservaciones;

/**
 *
 * @author edwin
 */
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
}
