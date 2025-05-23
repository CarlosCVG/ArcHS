/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.DBConexion;
import modelo.util.MapData;
import modelo.vo.Favorito;
import modelo.vo.Habitacion;

/**
 *
 * @author edwin
 */
public class DAOFavorito {

    private Connection conexion;

    public DAOFavorito() {
        conexion = new DBConexion().getConexionBD();
    }

    public List<Favorito> daoGetFavoritos() {
        List<Favorito> favoritos = new ArrayList<>();
        String sql = "SELECT * FROM favoritos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                favoritos.add(MapData.mapearFavorito(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return favoritos;

    }

    public boolean daoEliminarFavoritos(Favorito favorito) {
        String sql = "DELETE FROM favoritos WHERE id_favorito = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, favorito.getId_favorito());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean daoAgregarFavoritos(Favorito favorito) {
        String sql = "INSERT INTO favoritos (id_cliente, id_habitacion) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, favorito.getId_cliente());
            stmt.setInt(2, favorito.getId_habitacion());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Favorito> daoBuscarFavoritosCliente(int idCliente) {
        List<Favorito> favoritos = new ArrayList<>();
        String sql = "SELECT * FROM favoritos WHERE id_cliente = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                favoritos.add(MapData.mapearFavorito(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return favoritos;
    }

    public Favorito daoBuscarFavorito(int idCliente, int idHabitacion) {
        Favorito favorito = new Favorito();
        String sql = "SELECT * FROM favoritos WHERE id_cliente = ? AND id_habitacion = ? ";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idHabitacion);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return MapData.mapearFavorito(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
