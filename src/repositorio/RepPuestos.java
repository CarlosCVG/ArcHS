package repositorio;

import java.util.List;
import java.util.ArrayList;
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

    public static List<Puesto> getPuestos() {
        return puestos;
    }

    public static void initPuestos() {
        puestos.add(new Puesto(contadorId++, 1, "Recepcionista", 15000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 2, "Limpieza", 9000.0, "Vespertino"));
        puestos.add(new Puesto(contadorId++, 3, "Camarero", 8000.0, "Mixto"));
        puestos.add(new Puesto(contadorId++, 4, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 5, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 6, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 7, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 8, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 9, "Recepcionista", 12000.0, "Matutino"));
        puestos.add(new Puesto(contadorId++, 10, "Recepcionista", 12000.0, "Matutino"));
    }

}
