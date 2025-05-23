package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Reservacion;
import repositorio.RepReservaciones;

public class DAOReservacion {

    RepReservaciones repReserva = new RepReservaciones();

    private Connection conexion;

    public DAOReservacion() {
        conexion = new DBConexion().getConexionBD();
    }

    public List<Reservacion> daoGetReservacion() {
        List<Reservacion> reservaciones = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(MapData.mapearReserva(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservaciones;

    }

    public boolean daoEliminarReservacion(Reservacion reservacion) {
        String sql = "DELETE FROM reservaciones WHERE id_reservacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, reservacion.getId_reservacion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean daoAgregarReservacion(Reservacion reservacion) {
        String sql = "INSERT INTO reservaciones (id_reservacion, id_habitacion, id_cliente, f_entrada, f_salida, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, reservacion.getId_reservacion());
            stmt.setInt(2, reservacion.getId_habitacion());
            stmt.setInt(3, reservacion.getId_huesped());
            stmt.setDate(4, Date.valueOf(reservacion.getF_entrada()));
            stmt.setDate(5, Date.valueOf(reservacion.getF_salida()));
            stmt.setString(6, reservacion.getEstado());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Reservacion> daoBuscarPorHabitacion(int idHabitacion) {
        List<Reservacion> reservaciones = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones WHERE id_habitacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idHabitacion);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(MapData.mapearReserva(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservaciones;

    }

    public List<Reservacion> daoBuscarPorHuesped(int idHuesped) {
        List<Reservacion> reservaciones = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones WHERE id_cliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idHuesped);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(MapData.mapearReserva(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservaciones;

    }

    public Reservacion daoBuscarPorID(int idReservacion) {
        String sql = "SELECT * FROM reservaciones WHERE id_reservacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idReservacion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return MapData.mapearReserva(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public List<Reservacion> daoBuscarPorMes(int year, int mes) {
        List<Reservacion> reservaciones = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones WHERE"
                + " (MONTH(f_entrada) = ? AND YEAR(f_entrada) = ?)"
                + " OR (MONTH(f_salida) = ? AND YEAR(f_salida) = ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, mes);
            stmt.setInt(2, year);
            stmt.setInt(3, mes);
            stmt.setInt(4, year);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(MapData.mapearReserva(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservaciones;
    }

    public List<Reservacion> daoBuscarPorHabitacionYMes(int idHabitacion, int year, int mes) {
        List<Reservacion> reservaciones = new ArrayList<>();
        String sql = "SELECT * FROM reservaciones WHERE"
                + " ((MONTH(f_entrada) = ? AND YEAR(f_entrada) = ?)"
                + " OR (MONTH(f_salida) = ? AND YEAR(f_salida) = ?))"
                + " AND id_habitacion = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, mes);
            stmt.setInt(2, year);
            stmt.setInt(3, mes);
            stmt.setInt(4, year);
            stmt.setInt(5, idHabitacion);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservaciones.add(MapData.mapearReserva(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reservaciones;
    }
}
