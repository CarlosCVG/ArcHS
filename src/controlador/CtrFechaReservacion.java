/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepciones.ExAgregar;
import modelo.logica.LogicaReservacion;
import modelo.vo.Reservacion;

/**
 *
 * @author edwin
 */
public class CtrFechaReservacion {
    LogicaReservacion logicaReservacion = new LogicaReservacion();
    
    public boolean ctrAgregarReservacion(Reservacion reservacion) throws ExAgregar{
        return logicaReservacion.logicaAgregarReservacion(reservacion);
    }
}
