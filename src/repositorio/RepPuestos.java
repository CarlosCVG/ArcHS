package repositorio;

import java.util.List;
import java.util.ArrayList;
import modelo.vo.Habitacion;
import modelo.vo.Puesto;

public class RepPuestos {

    private static List<Puesto> puestos = new ArrayList<>();
    private static int contadorId = 1;

    static {
        initPuestos();
    }

    public static Puesto insert(int idEmpleado, String nombre, double sueldo, String turno) {
        Puesto nuevo = new Puesto(contadorId++, idEmpleado, nombre, sueldo, turno);
        if (puestos.add(nuevo)) {
            return nuevo;
        }
        return null;
    }

    public static boolean delete(Puesto puesto) {
        return puestos.remove(puesto);
    }

    public static boolean update(Puesto puesto){
         int posicion = puestos.indexOf(puesto);
        if (posicion >= 0) {
            puestos.set(posicion, puesto);
            return true;
        }
        return false;
    }

    public static Puesto search(int idPuesto) {
        for (Puesto p : puestos) {
            if (p.getId_puesto() == idPuesto) {
                return p;
            }
        }
        return null;
    }
    
    public static List<Puesto> search(String idEmpleado, String nombre, String sueldo, String turno) {
        List<Puesto> coincidencias = new ArrayList<>();

        for (Puesto p : puestos) {
            boolean coincide = true;

            if (!idEmpleado.isEmpty() && p.getId_empleado() != Integer.parseInt(idEmpleado)) {
                coincide = false;
            }
            if (!nombre.isEmpty() && p.getNombre_puesto().equalsIgnoreCase(nombre)) {
                coincide = false;
            }
            if (!sueldo.isEmpty() && p.getSueldo() != Double.parseDouble(sueldo)) {
                coincide = false;
            }
            if (!turno.isEmpty() && !p.getTurno().equalsIgnoreCase(turno)) {
                coincide = false;
            }
            
            if (coincide) {
                coincidencias.add(p);
            }
        }

        return coincidencias;
    }

    public static List<Puesto> getPuestos() {
        return puestos;
    }

    public static void initPuestos() {
        puestos.add(new Puesto(contadorId++, 1, "Gerente", 15000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 2, "Asistente", 9000.0, "Vespertino"));
        puestos.add(new Puesto(contadorId++, 3, "Recepcionista", 8000.0, "Mixto"));
        puestos.add(new Puesto(contadorId++, 4, "Contador", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 5, "Soporte Técnico", 10000.0, "Vespertino"));
    }

}
