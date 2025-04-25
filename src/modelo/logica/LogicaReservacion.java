/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import excepciones.ExAgregar;
import java.time.LocalDate;
import modelo.dao.DAOReservacion;
import modelo.vo.Reservacion;

/**
 *
 * @author edwin
 */
public class LogicaReservacion {
    DAOReservacion daoReservacion = new DAOReservacion();

    public boolean logicaAgregarReservacion(Reservacion reservacion) throws ExAgregar {
        LocalDate hoy = LocalDate.now();
        LocalDate entrada = reservacion.getF_entrada();
        LocalDate salida = reservacion.getF_salida();

        //Validar fechas
        if (!entrada.isAfter(hoy)) {
            throw new ExAgregar("La fecha de entrada debe ser posterior a hoy");
        }

        if (!salida.isAfter(hoy)) {
            throw new ExAgregar("La fecha de salida debe ser posterior a hoy");
        }

        if (!salida.isAfter(entrada)) {
            throw new ExAgregar("La fecha de salida debe ser posterior a la fecha de entrada");
        }

        return daoReservacion.daoAgregarReservacion(reservacion);
    }
}

