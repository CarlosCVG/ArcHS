/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import repositorio.RepEmpleados;

/**
 *
 * @author edwin
 */
public class DAOEmpleado {
    RepEmpleados repEmpleado = new RepEmpleados();

    public Alumno buscarPorId(int numControl) {
        return repEmpleado.buscarPorId(numControl);
    }

    public List<Alumno> daoBuscarAlumno(String numControl, String nombre, String ap1, String ap2, String carrera, String telefono, String semestre, String correo) {
        return repEmpleado.buscarAlumno(numControl, nombre, ap1, ap2, carrera, telefono, semestre, correo);
    }

    public boolean daoEliminarAlumno(Alumno alumno){
        return repEmpleado.eliminarAlumno(alumno);
    }
    
    public Alumno daoAgregarAlumno(Alumno alumno){
        return repEmpleado.agregarAlumno(alumno);
    }
    
    public Alumno daoModificarAlumno(Alumno alumno){
        return repEmpleado.modificarAlumno(alumno);
    }
}
