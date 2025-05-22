package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConexion {
    private static Connection conexion = null;
    
    public static Connection getConexionBD(){
        try{
            String url = "jdbc:mysql://localhost/hotel";
            String usuario = "hotelarc";
            String password = "hotelaccess1";
            conexion = (Connection) DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }
        return conexion;
    }
}
