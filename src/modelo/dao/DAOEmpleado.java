/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;

/**
 *
 * @author edwin
 */
public class DAOEmpleado {
    RepositorioEmpleado repEmpleado = new RepositorioEmpleado();

    public Alumno buscarPorId(int numControl) {
        return repAlumno.buscarPorId(numControl);
    }

    public List<Alumno> daoBuscarAlumno(String numControl, String nombre, String ap1, String ap2, String carrera, String telefono, String semestre, String correo) {
        return RepositorioAlumnos.buscarAlumno(numControl, nombre, ap1, ap2, carrera, telefono, semestre, correo);
    }

    public boolean daoEliminarAlumno(Alumno alumno){
        return repAlumno.eliminarAlumno(alumno);
    }
    
    public Alumno daoAgregarAlumno(Alumno alumno){
        return RepositorioAlumnos.agregarAlumno(alumno);
    }
    
    public Alumno daoModificarAlumno(Alumno alumno){
        return RepositorioAlumnos.modificarAlumno(alumno);
    }
}
