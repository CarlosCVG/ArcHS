package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.vo.Habitacion;

public class RepHabitaciones {

    private final static List<Habitacion> listaHabitaciones = new ArrayList<>();

    public static boolean insert(Habitacion habitacion) {
        return listaHabitaciones.add(habitacion);
    }

    public static boolean update(Habitacion nhabitacion) {
        int posicion = listaHabitaciones.indexOf(nhabitacion);
        if (posicion >= 0) {
            listaHabitaciones.set(posicion, nhabitacion);
            return true;
        }
        return false;
    }

    public static boolean delete(Habitacion habitacion) {
        return listaHabitaciones.remove(habitacion);
    }

    public static Habitacion search(int id) {
        for (Habitacion h : listaHabitaciones) {
            if (h.getId_habitacion()== id) {
                return h;
            }
        }
        return null;
    }

    public static List<Habitacion> search(String precio, String tamano, String num_camas, String descripcion) {
        List<Habitacion> coincidencias = new ArrayList<>();

        for (Habitacion a : listaHabitaciones) {
            boolean coincide = true;

            if (!precio.isEmpty() && a.getPrecio() != Double.parseDouble(precio)) {
                coincide = false;
            }
            if (!tamano.isEmpty() && a.getTamaño() != Double.parseDouble(tamano)) {
                coincide = false;
            }
            if (!num_camas.isEmpty() && a.getNum_camas() != Integer.parseInt(num_camas)) {
                coincide = false;
            }
            if (!descripcion.isEmpty() && !a.getDescripcion().equalsIgnoreCase(descripcion)) {
                coincide = false;
            }
            
            if (coincide) {
                coincidencias.add(a);
            }
        }

        return coincidencias;
    }
    
    public static List<Habitacion> getHabitaciones() {
        return listaHabitaciones;
    }

    public static List<Habitacion> cargarDatosInicialesAlumnos() {
        listaHabitaciones.add(new Habitacion(1, 1200.50, 23.4, 2, "Habitacion tamaño promedio con 2 camas y vista al mar"));
        listaHabitaciones.add(new Habitacion(2, 950.00, 18.0, 1, "Habitacion sencilla con cama individual y baño privado"));
        listaHabitaciones.add(new Habitacion(3, 1500.75, 30.0, 2, "Suite con sala de estar, minibar y balcón"));
        listaHabitaciones.add(new Habitacion(4, 1800.00, 35.0, 3, "Habitacion familiar con 3 camas y cocina equipada"));
        listaHabitaciones.add(new Habitacion(5, 800.00, 16.5, 1, "Habitacion económica con cama matrimonial"));
        listaHabitaciones.add(new Habitacion(6, 2200.00, 40.0, 2, "Penthouse con terraza privada y jacuzzi"));
        listaHabitaciones.add(new Habitacion(7, 1300.00, 24.0, 2, "Habitacion doble con escritorio y vista a la piscina"));
        listaHabitaciones.add(new Habitacion(8, 1100.00, 20.0, 1, "Habitacion con cama queen y decoración moderna"));
        listaHabitaciones.add(new Habitacion(9, 1400.00, 28.0, 2, "Habitacion premium con 2 camas queen y balcón"));
        listaHabitaciones.add(new Habitacion(10, 1600.00, 32.0, 2, "Suite ejecutiva con zona de trabajo y vista panorámica"));
        return listaHabitaciones;
    }
}
