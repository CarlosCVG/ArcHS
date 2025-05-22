
package modelo.util;

import modelo.vo.Habitacion;
import modelo.vo.Favorito;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Puesto;

/**
 *
 * @author edwin
 */
public class MapData {

    public static Huesped mapearHuesped(ResultSet rs) throws SQLException {
        Huesped h = new Huesped();

        h.setUsuario(rs.getString("usuario"));
        h.setPass(rs.getString("password"));
        h.setNum_tarjeta(rs.getString("num_tarjeta"));
        h.setNombre(rs.getString("nombre"));
        h.setIdioma(rs.getString("idioma"));
        h.setId_huesped(rs.getInt("id_cliente"));
        h.setCorreo(rs.getString("correo"));
        h.setAp1(rs.getString("ap1"));
        h.setAp2(rs.getString("ap2"));

        return h;
    }

    public static Reservacion mapearReserva(ResultSet rs) throws SQLException {
        Reservacion r = new Reservacion();

        r.setId_reservacion(rs.getInt("id_reservacion"));
        r.setId_habitacion(rs.getInt("id_habitacion"));
        r.setId_huesped(rs.getInt("id_cliente"));
        r.setF_salida(rs.getDate("f_salida").toLocalDate());
        r.setF_entrada(rs.getDate("f_entrada").toLocalDate());
        r.setEstado(rs.getString("estado"));

        return r;
    }

    public static Favorito mapearFavorito(ResultSet rs) throws SQLException {
        Favorito f = new Favorito();

        f.setId_cliente(rs.getInt("id_cliente"));
        f.setId_favorito(rs.getInt("id_favorito"));
        f.setId_habitacion(rs.getInt("id_habitacion"));

        return f;
    }

    public static Habitacion mapearHabitacion(ResultSet rs) throws SQLException {
        Habitacion h = new Habitacion();

        h.setDescripcion(rs.getString("descripcion"));
        h.setId_habitacion(rs.getInt("id_habitacion"));
        h.setNum_camas(rs.getInt("num_camas"));
        h.setPrecio(rs.getDouble("precio"));
        h.setSize(rs.getDouble("size"));

        return h;
    }

    public static Administrador mapearAdministrador(ResultSet rs) throws SQLException {
        Administrador a = new Administrador();

        a.setUsuario(rs.getString("usuario"));
        a.setTelefono(rs.getString("telefono"));
        a.setPass(rs.getString("password"));
        a.setNombre(rs.getString("nombre"));
        a.setId_admin(rs.getInt("id_administrador"));
        a.setCorreo(rs.getString("correo"));
        a.setAp1(rs.getString("ap1"));
        a.setAp2(rs.getString("ap2"));

        return a;
    }

    public static Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        Empleado e = new Empleado();

        e.setUsuario(rs.getString("usuario"));
        e.setTelefono(rs.getString("telefono"));
        e.setPass(rs.getString("password"));
        e.setNombre(rs.getString("nombre"));
        e.setId_puesto(rs.getInt("id_puesto"));
        e.setId_empleado(rs.getInt("id_empleado"));
        e.setFecha_contrat(rs.getDate("fcontrat").toLocalDate());
        e.setEmail(rs.getString("email"));
        e.setCurp(rs.getString("curp"));
        e.setAp1(rs.getString("ap1"));
        e.setAp2(rs.getString("ap2"));

        return e;
    }

    public static Puesto mapearPuesto(ResultSet rs) throws SQLException {
        Puesto p = new Puesto();

        p.setId_puesto(rs.getInt("id_puesto"));
        p.setNombre_puesto(rs.getString("nom_puesto"));
        p.setSueldo(rs.getInt("sueldo"));

        return p;
    }

}
