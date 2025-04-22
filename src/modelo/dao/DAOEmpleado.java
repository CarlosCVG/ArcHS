/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.time.LocalDate;
import java.util.List;
import repositorio.RepEmpleados;
import modelo.vo.Empleado;

/**
 *
 * @author edwin
 */
public class DAOEmpleado {
    RepEmpleados repEmpleado = new RepEmpleados();

    public Empleado daobuscarPorId(int id) {
        return repEmpleado.search(id);
    }

    public List<Empleado> daoBuscarEmpleado(String idAdmin, String nss, String curp, String telefono, String email, String rfc,
            String idPuesto, String sueldo, String fechaNac, String direccion, String fechaContrat,
            String nombre, String ap1, String ap2) {
        
        return repEmpleado.search(idAdmin, nss, curp, telefono, email, rfc, idPuesto, sueldo, fechaNac, direccion, fechaContrat, nombre, ap1, ap2);
    }

    public boolean daoEliminarEmpleado(Empleado empleado){
        return repEmpleado.delete(empleado);
    }
    
    public Empleado daoAgregarEmpleado(int idAdmin, int nss, String curp, String telefono, String email, String rfc, int idPuesto, String sueldo, LocalDate fechaNac, String direccion, LocalDate fechaContrat, String nombre, String ap1, String ap2){
        return repEmpleado.insert(idAdmin, nss, curp, telefono, email, rfc, idPuesto, sueldo, fechaNac, direccion, fechaContrat, nombre, ap1, ap2);
    }
    
    public boolean daoModificarEmpleado(Empleado empleado){
        return repEmpleado.update(empleado);
    }
}
