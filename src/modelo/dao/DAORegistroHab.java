package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
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
    
    public List<Habitacion> getListaHabitaciones() {
        return RepHabitaciones.getListaHabitaciones();
    }

    public List<Reservacion> getListaReservaciones() {
        return RepReservaciones.getListaReservaciones();
    }

    public int getCountHuespedes() {
        return RepHuespedes.getListaHuespedes().size();
    }

    public int getCountReservaciones() {
        return RepReservaciones.getListaReservaciones().size();
    }

    public boolean addHuesped(String usuario, String pass, String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo){
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
    
    public Huesped findClient(String usuario, String pass){
        String sql = "SELECT * FROM clientes WHERE usuario = ? AND password = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return MapData.mapearHuesped(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch( Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
