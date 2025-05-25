/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.logica.LogicReservacion;
import modelo.vo.Habitacion;
import modelo.vo.Reservacion;

/**
 *
 * @author edwin
 */
public class CtrlSelectorHabitacion {
    LogicReservacion logicaReservacion = new LogicReservacion();
    
    public List<Reservacion> ctrBuscarReservacion(Habitacion habitacion){
        return logicaReservacion.logicaBuscarPorHabitacion(habitacion.getId_habitacion());
    }
    
    public List<Reservacion> ctrBuscarReservaciones(){
        return logicaReservacion.logicaBuscarReservaciones();
    }
    
    
}
