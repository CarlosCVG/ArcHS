/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Puesto;
import repositorio.RepPuestos;

/**
 *
 * @author edwin
 */
public class DAOPuesto {
    RepPuestos repPuesto = new RepPuestos();

    public Puesto daobuscarPorId(int id) {
        return repPuesto.search(id);
    }

    public List<Puesto> daoBuscarPuesto(String idEmpleado, String nombre, String sueldo, String turno) {
        return repPuesto.search(idEmpleado, nombre, sueldo, turno);
    }

}
