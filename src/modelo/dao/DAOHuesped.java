/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Huesped;
import repositorio.RepHuespedes;

/**
 *
 * @author edwin
 */
public class DAOHuesped {

    RepHuespedes repHuesped = new RepHuespedes();

    public Huesped daobuscarPorId(int id) {
        return repHuesped.search(id);
    }

    public List<Huesped> daoBuscarHuesped(String nombre, String ap1, String ap2, String num_tarjeta, String idioma, String correo) {
        return repHuesped.search(nombre, ap1, ap2, num_tarjeta, idioma, correo);
    }

    public boolean daoEliminarHuesped(Huesped huesped) {
        return repHuesped.delete(huesped);
    }

    public boolean daoAgregarEmpleado(Huesped huesped) {
        return repHuesped.insert(huesped);
    }

    public boolean daoModificarEmpleado(Huesped huesped) {
        return repHuesped.update(huesped);
    }
}
