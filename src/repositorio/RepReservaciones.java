package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Reservacion;

public class RepReservaciones {
    private final static List<Reservacion> listaReservaciones = new ArrayList<>();

    public static boolean insert(Reservacion reservacion) {
        return listaReservaciones.add(reservacion);
    }

    public static boolean update(Reservacion nreservacion) {
        int posicion = listaReservaciones.indexOf(nreservacion);
        if (posicion >= 0) {
            listaReservaciones.set(posicion, nreservacion);
            return true;
        }
        return false;
    }

    public static boolean delete(Reservacion reservacion) {
        return listaReservaciones.remove(reservacion);
    }

    public static Reservacion search(int id) {
        for (Reservacion r : listaReservaciones) {
            if (r.getId_reservacion() == id) {
                return r;
            }
        }
        return null;
    }

    public static List<Reservacion> search(String id_reservacion, String id_habitacion, String id_huesped, String f_entrada, String f_salida) {
        List<Reservacion> coincidencias = new ArrayList<>();

        for (Reservacion r : listaReservaciones) {
            boolean coincide = true;

            if (!id_reservacion.isEmpty() && r.getId_reservacion()!= Integer.parseInt(id_reservacion)) {
                coincide = false;
            }
            if (!id_habitacion.isEmpty() && r.getId_habitacion()!= Integer.parseInt(id_habitacion)) {
                coincide = false;
            }
            if (!id_huesped.isEmpty() && r.getId_huesped()!= Integer.parseInt(id_huesped)) {
                coincide = false;
            }
            if (!f_entrada.isEmpty() && !r.getF_entrada().toString().equals(f_entrada)) {
                coincide = false;
            }
            if (!f_salida.isEmpty() && !r.getF_salida().toString().equals(f_salida)) {
                coincide = false;
            }
            

            if (coincide) {
                coincidencias.add(r);
            }
        }

        return coincidencias;
    }
    
    public static List<Reservacion> getListaReservaciones() {
        return listaReservaciones;
    }

    public static List<Reservacion> cargarDatosInicialesReservaciones() {
        listaReservaciones.add(new Reservacion(1, 1, 1, LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 15)));
        listaReservaciones.add(new Reservacion(2, 2, 2, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 5)));
        listaReservaciones.add(new Reservacion(3, 3, 3, LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 25)));
        listaReservaciones.add(new Reservacion(4, 4, 4, LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 12)));
        listaReservaciones.add(new Reservacion(5, 5, 5, LocalDate.of(2025, 4, 18), LocalDate.of(2025, 4, 22)));
        return listaReservaciones;
    }
}
