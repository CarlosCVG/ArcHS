package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Administrador;
import modelo.vo.Empleado;

public class DAOAdmin {

    private Connection conexion;

    public DAOAdmin() {
        conexion = new DBConexion().getConexionBD();
    }

    public List<Object[]> obtenerListaEmpleados() {
        List<Object[]> listaEmpleados = new ArrayList<>();
        String sql = "SELECT e.id_empleado, e.nombre, e.ap1, e.ap2, e.email, e.fcontrat, p.nom_puesto "
                + "FROM empleados e INNER JOIN puestos p ON e.id_puesto = p.id_puesto";
        try (PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id_empleado");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("ap1");
                fila[3] = rs.getString("ap2");
                fila[4] = rs.getString("email");
                fila[5] = rs.getDate("fcontrat");
                fila[6] = rs.getString("nom_puesto");
                listaEmpleados.add(fila);
            }
            return listaEmpleados;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Empleado> searchLikeNombre(String txtToSearch) {
        List<Empleado> listaempleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados "
                + "WHERE nombre LIKE ? OR ap1 LIKE ? OR ap2 LIKE ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            String txtLikes = "%" + txtToSearch + "%";
            ps.setString(1, txtLikes);
            ps.setString(2, txtLikes);
            ps.setString(3, txtLikes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaempleados.add(MapData.mapearEmpleado(rs));
            }
            return listaempleados;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean sendTask(Administrador admin, Empleado empleado, String asunto, String task) {
        try {
            String qryInsert;
            PreparedStatement ps;
            qryInsert = "INSERT INTO tareas (id_administrador, id_empleado, asunto, mensaje, lectura) "
                    + "VALUES (?, ?, ?, ?, 'pendiente')";

            ps = conexion.prepareStatement(qryInsert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, admin.getId_admin());
            ps.setInt(2, empleado.getId_empleado());
            ps.setString(3, asunto);
            ps.setString(4, task);

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

}
