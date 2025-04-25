/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.logica.LogicaHabitacion;
import modelo.vo.Habitacion;

/**
 *
 * @author edwin
 */
public class CtrReservaUI {
    LogicaHabitacion logicaHabitacion = new LogicaHabitacion();
    
    public List<Habitacion> ctrHabitacionesDisponibles(){
        return logicaHabitacion.logicaHabitacionesDisponibles();
    }
}
