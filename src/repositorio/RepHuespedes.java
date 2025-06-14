package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.vo.Huesped;

public class RepHuespedes {

    private final static List<Huesped> listaHuespedes = new ArrayList<>();

    public static boolean insert(Huesped huesped) {
        return listaHuespedes.add(huesped);
    }

    public static boolean update(Huesped nhuesped) {
        int posicion = listaHuespedes.indexOf(nhuesped);
        if (posicion >= 0) {
            listaHuespedes.set(posicion, nhuesped);
            return true;
        }
        return false;
    }

    public static boolean delete(Huesped huesped) {
        return listaHuespedes.remove(huesped);
    }

    public static Huesped search(int id) {
        for (Huesped h : listaHuespedes) {
            if (h.getId_huesped()== id) {
                return h;
            }
        }
        return null;
    }

    public static List<Huesped> search(String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) {
        List<Huesped> coincidencias = new ArrayList<>();

        for (Huesped a : listaHuespedes) {
            boolean coincide = true;

            if (!nombre.isEmpty() && a.getNombre().equalsIgnoreCase(nombre)) {
                coincide = false;
            }
            if (!ap1.isEmpty() && a.getAp1().equalsIgnoreCase(ap1)) {
                coincide = false;
            }
            if (!ap2.isEmpty() && !a.getAp2().equalsIgnoreCase(ap2)) {
                coincide = false;
            }
            if (!num_tarjeta.isEmpty() && !a.getNum_tarjeta().equalsIgnoreCase(num_tarjeta)) {
                coincide = false;
            }
            if (!idioma.isEmpty() && !a.getIdioma().equalsIgnoreCase(idioma)) {
                coincide = false;
            }
            if (!correo.isEmpty() && !a.getCorreo().equalsIgnoreCase(correo)) {
                coincide = false;
            }

            if (coincide) {
                coincidencias.add(a);
            }
        }

        return coincidencias;
    }
    
    public static List<Huesped> getHuespedes() {
        return listaHuespedes;
    }

    public static List<Huesped> cargarDatosInicialesHuespedes() {
        listaHuespedes.add(new Huesped("h", "admin",1, "Carlos", "Ramírez", "López", "1234-5678-9012-3456", "Español", "carlos.ramirez@mail.com"));
        listaHuespedes.add(new Huesped("h1", "admin",2, "María", "Gómez", "Hernández", "9876-5432-1098-7654", "Inglés", "maria.gomez@mail.com"));
        listaHuespedes.add(new Huesped("h2", "admin",3, "Juan", "Pérez", "Martínez", "4567-8901-2345-6789", "Francés", "juan.perez@mail.com"));
        listaHuespedes.add(new Huesped("h3", "admin",4, "Laura", "Sánchez", "Díaz", "3210-6543-9876-5432", "Alemán", "laura.sanchez@mail.com"));
        listaHuespedes.add(new Huesped("h4", "admin",5, "Andrés", "Gutiérrez", "Torres", "6789-0123-4567-8901", "Italiano", "andres.gutierrez@mail.com"));
        listaHuespedes.add(new Huesped("h5", "admin",6, "Fernanda", "Vargas", "Morales", "1357-2468-1357-2468", "Portugués", "fernanda.vargas@mail.com"));
        listaHuespedes.add(new Huesped("h6", "admin",7, "Miguel", "Cruz", "Navarro", "2468-1357-2468-1357", "Español", "miguel.cruz@mail.com"));
        listaHuespedes.add(new Huesped("h7", "admin",8, "Sofía", "Ríos", "Ortega", "5678-9012-3456-7890", "Ruso", "sofia.rios@mail.com"));
        listaHuespedes.add(new Huesped("h8", "admin",9, "Jorge", "Flores", "Acosta", "6789-0123-4567-8901", "Chino", "jorge.flores@mail.com"));
        listaHuespedes.add(new Huesped("h9", "admin",10, "Valeria", "Mendoza", "Salinas", "9012-3456-7890-1234", "Japonés", "valeria.mendoza@mail.com"));
        return listaHuespedes;
    }
}
