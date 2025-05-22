package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;
import modelo.vo.Puesto;
import repositorio.RepAdministradores;
import repositorio.RepEmpleados;
import repositorio.RepHuespedes;
import repositorio.RepPuestos;

public class DAOLogin {

    private Connection conexion;

    public DAOLogin() {
        conexion = new DBConexion().getConexionBD();
    }

    public void initAdministradores() {
        RepAdministradores ra = new RepAdministradores();
    }

    public void initEmpleados() {
        RepEmpleados re = new RepEmpleados();
    }

    public void initHuespedes() {
        repositorio.RepHuespedes.cargarDatosInicialesHuespedes();
    }

    public void initPuestos() {
        RepPuestos rp = new RepPuestos();
    }

    public List<Administrador> getListaAdministradores() {
        List<Administrador> administradores = new ArrayList<>();
        String sql = "SELECT * FROM administradores";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                administradores.add(MapData.mapearAdministrador(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return administradores;

    }
    
    public List<Huesped> getListaHuespedes() {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                huespedes.add(MapData.mapearHuesped(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return huespedes;

    }
    
    public List<Empleado> getListaEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                empleados.add(MapData.mapearEmpleado(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return empleados;

    }
    
    public List<Puesto> getListaPuestos() {
        List<Puesto> puestos = new ArrayList<>();
        String sql = "SELECT * FROM puestos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                puestos.add(MapData.mapearPuesto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return puestos;

    }
}
