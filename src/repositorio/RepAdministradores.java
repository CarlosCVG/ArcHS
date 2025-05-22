package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.Administrador;

public class RepAdministradores {

    private static List<Administrador> administradores = new ArrayList<>();
    private static int contadorId = 1;

    static {
        initAdministradores();
    }

    public static Administrador insert(String nombre, String ap1, String ap2, String correo, String telefono, String rfc, String nss, String curp, LocalDate fnac, String direccion) {

        Administrador nuevo = new Administrador(""+contadorId++, ""+contadorId++, contadorId++, nombre, ap1, ap2, correo, telefono, rfc, nss, curp, fnac, direccion);

        if (administradores.add(nuevo)) {
            return nuevo;
        }
        return null;
    }

    public static boolean delete(Administrador admin) {
        return administradores.remove(admin);
    }

    public static boolean update(Administrador admin) {
        int posicion = administradores.indexOf(admin);
        if (posicion >= 0) {
            administradores.set(posicion, admin);
            return true;
        }
        return false;
    }

    public static Administrador search(int id) {
        for (Administrador a : administradores) {
            if (a.getId_admin() == id) {
                return a;
            }
        }
        return null;
    }

    public static List<Administrador> getAdministradores() {
        return administradores;
    }

    public static void initAdministradores() {
//        LocalDate hoy = LocalDate.now();
//        administradores.add(new Administrador("admin", "admin", contadorId++, "Ana", "Soto", "López", "ana@correo.com", "6148887777", "RFCANA123", "NSSANA456", "CURPANA789", hoy, "Av. Siempre Viva 123"));
//        administradores.add(new Administrador("admin1", "admin", contadorId++, "Pedro", "Gómez", "Núñez", "pedro@correo.com", "6141112233", "RFCPED123", "NSSPED456", "CURPPED789", hoy, "Col. Reforma"));
//        administradores.add(new Administrador("admin2", "admin", contadorId++, "Laura", "Martínez", "Santos", "laura@correo.com", "6142223344", "RFCLAU123", "NSSLAU456", "CURPLAU789", hoy, "Av. Universidad"));
//        administradores.add(new Administrador("admin3", "admin", contadorId++, "Hugo", "Delgado", "Reyes", "hugo@correo.com", "6143334455", "RFCHUG123", "NSSHUG456", "CURPHUG789", hoy, "Blvd. Ortiz Mena"));
//        administradores.add(new Administrador("admin4", "admin", contadorId++, "Carmen", "Treviño", "García", "carmen@correo.com", "6144445566", "RFCCAR123", "NSSCAR456", "CURPCAR789", hoy, "Av. Tecnológico"));
//        administradores.add(new Administrador("admin5", "admin", contadorId++, "Ernesto", "Vargas", "Solís", "ernesto@correo.com", "6145556677", "RFCERN123", "NSSERN456", "CURPERN789", hoy, "Col. Centro"));
//        administradores.add(new Administrador("admin6", "admin",contadorId++, "Paola", "Ríos", "Torres", "paola@correo.com", "6146667788", "RFCPAO123", "NSSPAO456", "CURPPAO789", hoy, "Zona Dorada"));
//        administradores.add(new Administrador("admin7", "admin", contadorId++, "Alfredo", "Navarro", "Meza", "alfredo@correo.com", "6147778899", "RFCALF123", "NSSALF456", "CURPALF789", hoy, "Lomas del Valle"));
//        administradores.add(new Administrador("admin8", "admin", contadorId++, "Sofía", "Campos", "León", "sofia@correo.com", "6148889900", "RFCSOF123", "NSSSOF456", "CURPSOF789", hoy, "Fracc. Campestre"));
//        administradores.add(new Administrador("admin9", "admin", contadorId++, "Bruno", "Cisneros", "Moreno", "bruno@correo.com", "6149990011", "RFCBRU123", "NSSBRU456", "CURPBRU789", hoy, "Col. Roma"));
    }

    
}
