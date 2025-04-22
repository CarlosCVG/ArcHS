package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.vo.Empleado;

public class RepEmpleados {

    private static List<Empleado> empleados = new ArrayList<>();
    private static int contadorId = 1;

    static {
        initEmpleados();
    }

    public static Empleado insert(int idAdmin, int nss, String curp, String telefono, String email, String rfc, int idPuesto, String sueldo, LocalDate fechaNac, String direccion, LocalDate fechaContrat, String nombre, String ap1, String ap2) {

        Empleado nuevo = new Empleado(""+contadorId++, ""+contadorId++,contadorId++, idAdmin, nss, curp, telefono, email, rfc, idPuesto, sueldo, fechaNac, direccion, fechaContrat, nombre, ap1, ap2);
        if (empleados.add(nuevo)) {
            return nuevo;
        }
        return null;
    }

    public static boolean delete(Empleado emp) {
        return empleados.remove(emp);
    }

    public static boolean update(Empleado e) {
        int posicion = empleados.indexOf(e);
        if (posicion >= 0) {
            empleados.set(posicion, e);
            return true;
        }
        return false;
    }

    public static Empleado search(int id) {
        for (Empleado e : empleados) {
            if (e.getId_empleado() == id) {
                return e;
            }
        }
        return null;
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void initEmpleados() {
        LocalDate hoy = LocalDate.now();

        empleados.add(new Empleado("e", "admin",contadorId++, 1, 123456, "CURP123456", "6141234567", "empleado1@correo.com", "RFC123", 1, "15000", hoy, "Calle Uno", hoy, "Luis", "Garcia", "Perez"));
        empleados.add(new Empleado("e1", "admin",contadorId++, 2, 234567, "CURP234567", "6142345678", "empleado2@correo.com", "RFC234", 2, "14000", hoy, "Calle Dos", hoy, "María", "López", "Ramírez"));
        empleados.add(new Empleado("e2", "admin",contadorId++, 3, 345678, "CURP345678", "6143456789", "empleado3@correo.com", "RFC345", 3, "13000", hoy, "Calle Tres", hoy, "José", "Martínez", "Gómez"));
        empleados.add(new Empleado("e3", "admin",contadorId++, 4, 456789, "CURP456789", "6144567890", "empleado4@correo.com", "RFC456", 4, "12000", hoy, "Calle Cuatro", hoy, "Lucía", "Fernández", "Hernández"));
        empleados.add(new Empleado("e4", "admin",contadorId++, 5, 567890, "CURP567890", "6145678901", "empleado5@correo.com", "RFC567", 5, "11000", hoy, "Calle Cinco", hoy, "Carlos", "Ruiz", "Mendoza"));
        empleados.add(new Empleado("e5", "admin",contadorId++, 6, 678901, "CURP678901", "6146789012", "empleado6@correo.com", "RFC678", 1, "10500", hoy, "Calle Seis", hoy, "Elena", "Soto", "Delgado"));
        empleados.add(new Empleado("e6", "admin",contadorId++, 7, 789012, "CURP789012", "6147890123", "empleado7@correo.com", "RFC789", 2, "9500", hoy, "Calle Siete", hoy, "Miguel", "Aguilar", "Vargas"));
        empleados.add(new Empleado("e7", "admin",contadorId++, 8, 890123, "CURP890123", "6148901234", "empleado8@correo.com", "RFC890", 3, "8800", hoy, "Calle Ocho", hoy, "Rosa", "Silva", "Carrillo"));
        empleados.add(new Empleado("e8", "admin",contadorId++, 9, 901234, "CURP901234", "6149012345", "empleado9@correo.com", "RFC901", 4, "8700", hoy, "Calle Nueve", hoy, "Diego", "Castillo", "Cano"));
        empleados.add(new Empleado("9", "admin",contadorId++, 10, 123457, "CURP123457", "6141122334", "empleado10@correo.com", "RFC000", 5, "8600", hoy, "Calle Diez", hoy, "Valeria", "Ortiz", "Reyes"));
    }

}
