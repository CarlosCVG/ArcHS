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
import modelo.vo.Tarea;
import repositorio.RepHabitaciones;
import repositorio.RepHuespedes;
import repositorio.RepReservaciones;

public class DAOTask {

    private Connection conexion;

    public DAOTask() {
        conexion = new DBConexion().getConexionBD();
    }

    public List<Tarea> searchByRegistro(String selectedbp, int id_empleado) {
        List<Tarea> listaTareas = new ArrayList<>();

        String sql = "select * from tareas where lectura = ? and id_empleado = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, selectedbp);
            ps.setInt(2, id_empleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId_tarea(rs.getInt("id_tarea"));
                tarea.setId_administrador(rs.getInt("id_administrador"));
                tarea.setId_empleado(rs.getInt("id_empleado"));
                tarea.setAsunto(rs.getString("asunto"));
                tarea.setMensaje(rs.getString("mensaje"));
                tarea.setLectura(rs.getString("lectura"));
                listaTareas.add(tarea);
            }
            return listaTareas;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public String findAdminById(int id_administrador) {
        String sql = "SELECT concat(nombre, ' ', ap1, ' ', ap2) AS nombreadmin FROM administradores where id_administrador = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id_administrador);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombreadmin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean updateLectura(Tarea selectedtsk) {
        try {
            String qryUpdate = "update tareas set lectura = 'buzon' where id_tarea = ?";

            PreparedStatement ps = conexion.prepareStatement(qryUpdate);

            ps.setInt(1, selectedtsk.getId_tarea());
            

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos al modificar: " + ex.getMessage());
            return false;
        }
    }
}
