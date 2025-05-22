package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Reservacion;

public class RepReservaciones {
    private final static List<Reservacion> listaReservaciones = new ArrayList<>();
    private static int contadorId = 1;
    
    //Si van a hacer reservaciones, creen un objeto de tipo reservacion con idReservacion 0, en este metodo insert, ya se le asigna el id de autoincremento, por lo que nunca se repitira
    public static boolean insert(Reservacion reservacion) {
        return listaReservaciones.add(new Reservacion(contadorId++, reservacion.getId_habitacion(), reservacion.getId_huesped(), "", reservacion.getF_entrada(), reservacion.getF_salida()));
    }
    
    static {
        cargarDatosInicialesReservaciones();
    }

    public static boolean update(Reservacion nreservacion) {
        int posicion = listaReservaciones.indexOf(nreservacion);
        if (posicion >= 0) {
            listaReservaciones.set(posicion, nreservacion);
            return true;
        }
        return false;
    }

    public static Reservacion search(int idHabitacion){
        for (Reservacion e : listaReservaciones) {
            if (e.getId_habitacion() == idHabitacion) {
                return e;
            }
        }
        return null;
    }
    
    public static Reservacion searchByID(int idReservacion){
        for (Reservacion e : listaReservaciones) {
            if (e.getId_reservacion() == idReservacion) {
                return e;
            }
        }
        return null;
    }
    
    public static List<Reservacion> searchByMounth(int mounth){
        List<Reservacion> reservacion = new ArrayList<>();
        
        for (Reservacion e : listaReservaciones) {
            if (e.getF_entrada().getMonthValue() == mounth || e.getF_salida().getMonthValue() == mounth) {
                reservacion.add(e);
            }
        }
        return reservacion;
    }
    
    public static boolean delete(Reservacion reservacion) {
        return listaReservaciones.remove(reservacion);
    }

    public static List<Reservacion> getListaReservaciones() {
        return listaReservaciones;
    }

    //int id_reservacion, int id_habitacion, int id_huesped, LocalDate f_entrada, LocalDate f_salida
    public static List<Reservacion> cargarDatosInicialesReservaciones() {
        listaReservaciones.add(new Reservacion(contadorId++, 1, 1, "Hola", LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 15)));
        listaReservaciones.add(new Reservacion(contadorId++, 2, 2, "Hola", LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 5)));
        listaReservaciones.add(new Reservacion(contadorId++, 3, 3, "Hola", LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 25)));
        listaReservaciones.add(new Reservacion(contadorId++, 4, 4, "Hola", LocalDate.of(2025, 6, 10), LocalDate.of(2025, 6, 12)));
        listaReservaciones.add(new Reservacion(contadorId++, 5, 5, "Hola", LocalDate.of(2025, 4, 18), LocalDate.of(2025, 4, 22)));
        return listaReservaciones;
    }
}
