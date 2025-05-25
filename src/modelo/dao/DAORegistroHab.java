package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import modelo.vo.Reservacion;
import repositorio.RepHabitaciones;
import repositorio.RepHuespedes;
import repositorio.RepReservaciones;

public class DAORegistroHab {

    private Connection conexion;

    public DAORegistroHab() {
        conexion = new DBConexion().getConexionBD();
    }

    public Huesped getClienteByIdReservacion(int idReservacion) {
        String sql = "SELECT *  FROM clientes JOIN reservaciones ON "
                + "clientes.id_cliente = reservaciones.id_cliente "
                + "WHERE reservaciones.id_reservacion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idReservacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return MapData.mapearHuesped(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteReservation(Reservacion rselected) {
        try {
            String qryDelete = "DELETE FROM reservaciones WHERE id_reservacion = ?";
            PreparedStatement ps = conexion.prepareStatement(qryDelete);
            ps.setInt(1, rselected.getId_reservacion());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Reservacion> searchLikeReservacion(String txtToSearch) {
        List<Reservacion> listaReservacionesXCliente = new ArrayList<>();
        String sql = "SELECT reservaciones.id_reservacion, reservaciones.id_habitacion, reservaciones.id_cliente, reservaciones.f_salida, reservaciones.f_entrada, reservaciones.estado "
                + "FROM reservaciones "
                + "JOIN clientes ON reservaciones.id_cliente = clientes.id_cliente "
                + "WHERE clientes.nombre LIKE ? OR clientes.ap1 LIKE ? OR clientes.ap2 LIKE ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            String txtLikes = "%" + txtToSearch + "%";
            ps.setString(1, txtLikes);
            ps.setString(2, txtLikes);
            ps.setString(3, txtLikes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaReservacionesXCliente.add(MapData.mapearReserva(rs));
            }
            return listaReservacionesXCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Habitacion> getListaHabitaciones() {
        List<Habitacion> listaHabitaciones = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaHabitaciones.add(MapData.mapearHabitacion(rs));
            }
            return listaHabitaciones;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Reservacion> getListaReservaciones() {
        List<Reservacion> listaReserva = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaReserva.add(MapData.mapearReserva(rs));
            }
            return listaReserva;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Habitacion> filterHabHoy() {

        List<Habitacion> listToShow = new ArrayList<>();
        String sql = "SELECT DISTINCT habitaciones.id_habitacion, habitaciones.num_camas, "
                + "habitaciones.size, habitaciones.precio, habitaciones.descripcion FROM habitaciones "
                + "LEFT JOIN reservaciones ON reservaciones.id_habitacion = habitaciones.id_habitacion "
                + "WHERE reservaciones.f_entrada <> CURDATE() OR reservaciones.f_entrada IS NULL";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listToShow.add(MapData.mapearHabitacion(rs));
            }
            return listToShow;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Object[]> filtrarListaReservaciones() {

        List<Object[]> listToShow = new ArrayList<>();
        String sql = "SELECT r.id_reservacion, r.id_habitacion, CONCAT(c.nombre, ' ', c.ap1, ' ', c.ap2) "
                + "AS nombrecc, r.f_entrada, r.f_salida, h.precio, h.num_camas FROM reservaciones r "
                + "JOIN habitaciones h ON r.id_habitacion = h.id_habitacion "
                + "JOIN clientes c ON r.id_cliente = c.id_cliente";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] reservaObject = new Object[7];
                reservaObject[0] = rs.getInt("id_reservacion");
                reservaObject[1] = rs.getInt("id_habitacion");
                reservaObject[2] = rs.getString("nombrecc");
                reservaObject[3] = rs.getDate("f_entrada");
                reservaObject[4] = rs.getDate("f_salida");
                reservaObject[5] = rs.getDouble("precio");
                reservaObject[6] = rs.getInt("num_camas");
                listToShow.add(reservaObject);
            }
            return listToShow;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getCountHuespedes() {
        return RepHuespedes.getListaHuespedes().size();
    }

    public int getCountReservaciones() {
        return RepReservaciones.getListaReservaciones().size();
    }

    public boolean addHuesped(String usuario, String pass, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) {
        try {
            String qryInsert;
            PreparedStatement ps;
            qryInsert = "INSERT INTO clientes (usuario, password, nombre, ap1, ap2, num_tarjeta, correo, idioma) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conexion.prepareStatement(qryInsert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ps.setString(3, nombre);
            ps.setString(4, ap1);
            ps.setString(5, ap2);
            ps.setString(6, num_tarjeta);
            ps.setString(7, idioma);
            ps.setString(8, correo);

            int numRegistrosIns = ps.executeUpdate();

            if (numRegistrosIns == 0) {
                throw new SQLException("Ocurrio un error durante la Operacion de Insertar");
            }
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en codigo: " + ex.getMessage());
            return false;
        }
    }

    public Huesped findClient(String usuario, String pass) {
        String sql = "SELECT * FROM clientes WHERE usuario = ? AND password = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return MapData.mapearHuesped(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
