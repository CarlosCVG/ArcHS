package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Habitacion;
import modelo.vo.Huesped;
import repositorio.RepHabitaciones;

public class DAOHabitacion {

    RepHabitaciones repHabitacion;

    private Connection conexion;

    public DAOHabitacion() {
        conexion = new DBConexion().getConexionBD();
    }

    public List<Habitacion> daoGetHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habitaciones.add(MapData.mapearHabitacion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return habitaciones;

    }

    public List<Habitacion> daoGetHabitacionesFavoritas(Huesped huesped) {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT H.* FROM habitaciones H"
                + " JOIN favoritos F ON H.id_habitacion = F.id_habitacion"
                + " WHERE  F.id_cliente = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, huesped.getId_huesped());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habitaciones.add(MapData.mapearHabitacion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return habitaciones;
    }

}
