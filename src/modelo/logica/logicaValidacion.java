/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import excepciones.ExValidacion;
import java.time.LocalDate;
import java.time.Period;
import modelo.vo.Empleado;

/**
 *
 * @author edwin
 */
public class logicaValidacion {

    // ------------------------
    // VALIDACIONES DE EMPLEADOS
    // ------------------------
    public boolean logicaValidacionEmpleado(Empleado empleado) throws ExValidacion {
        validarNss("" + empleado.getNss());
        validarCurp(empleado.getCurp());
        validarTelefono(empleado.getTelefono());
        validarRfc(empleado.getRfc());
        validarSueldo(empleado.getSueldo());
        validarFechaNacimiento(empleado.getFecha_nac());
        return true;
    }

    public boolean validarNss(String nss) throws ExValidacion {
        if (!nss.matches("\\d{11}")) {
            throw new ExValidacion("NSS invalido. Debe tener exactamente 11 dígitos.");
        }
        return true;
    }

    public boolean validarCurp(String curp) throws ExValidacion {
        if (curp == null || curp.length() != 18) {
            throw new ExValidacion("CURP invalida. Debe tener 18 caracteres.");
        }
        return true;
    }

    public boolean validarTelefono(String telefono) throws ExValidacion {
        if (!telefono.matches("\\d{10}")) {
            throw new ExValidacion("Telefono invalido. Debe tener exactamente 10 dígitos.");
        }
        return true;
    }

    public boolean validarRfc(String rfc) throws ExValidacion {
        if (rfc == null || rfc.length() != 13) {
            throw new ExValidacion("RFC invalido. Debe tener 13 caracteres.");
        }
        return true;
    }

    public boolean validarSueldo(String sueldoStr) throws ExValidacion {
        try {
            double sueldo = Double.parseDouble(sueldoStr);
            if (sueldo < 0) {
                throw new ExValidacion("Sueldo invalido. No puede ser negativo.");
            }
        } catch (NumberFormatException e) {
            throw new ExValidacion("Sueldo invalido. Debe ser un número válido.");
        }
        return true;
    }

    public boolean validarFechaNacimiento(LocalDate fechaNac) throws ExValidacion {
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNac, hoy);
        if (edad.getYears() < 18) {
            throw new ExValidacion("Fecha de nacimiento invalida. El empleado debe tener al menos 18 años.");
        }
        return true;
    }

    // -----------------------------
    // VALIDACIONES DE RESERVACIONES
    // -----------------------------
    public boolean logicaValidacionReservacion(LocalDate f_entrada, LocalDate f_salida) throws ExValidacion {
        validarFechaEntrada(f_entrada);
        validarFechaSalida(f_salida);
        return true;
    }

    public boolean validarFechaEntrada(LocalDate f_entrada) throws ExValidacion {
        LocalDate hoy = LocalDate.now();
        if (f_entrada.isBefore(hoy)) {
            throw new ExValidacion("La fecha de entrada no puede ser anterior al día actual.");
        }
        return true;
    }

    public boolean validarFechaSalida(LocalDate f_salida) throws ExValidacion {
        LocalDate hoy = LocalDate.now();
        if (f_salida.isBefore(hoy)) {
            throw new ExValidacion("La fecha de salida no puede ser anterior al día actual.");
        }
        return true;
    }

}
