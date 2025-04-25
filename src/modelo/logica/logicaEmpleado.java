/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import java.time.LocalDate;
import java.util.List;
import modelo.vo.Empleado;
import repositorio.RepEmpleados;
import excepciones.BusinessException;

public class logicaEmpleado {

    public logicaEmpleado() {
    }

    // Agregar empleado
    public Empleado agregarEmpleado(Empleado nuevoEmpleado) throws BusinessException {
        validarEmpleado(nuevoEmpleado);

        // Verificar que el NSS no este duplicado
        if (RepEmpleados.getEmpleados().stream().anyMatch(e -> e.getNss() == nuevoEmpleado.getNss())) {
            throw new BusinessException("El NSS ya esta registrado");
        }

        // Verificar que el RFC no este duplicado
        if (RepEmpleados.getEmpleados().stream().anyMatch(e -> e.getRfc().equalsIgnoreCase(nuevoEmpleado.getRfc()))) {
            throw new BusinessException("El RFC ya esta registrado");
        }

        Empleado empleadoCreado = RepEmpleados.insert(
                nuevoEmpleado.getId_admin(),
                nuevoEmpleado.getNss(),
                nuevoEmpleado.getCurp(),
                nuevoEmpleado.getTelefono(),
                nuevoEmpleado.getEmail(),
                nuevoEmpleado.getRfc(),
                nuevoEmpleado.getId_puesto(),
                nuevoEmpleado.getSueldo(),
                nuevoEmpleado.getFecha_nac(),
                nuevoEmpleado.getDireccion(),
                nuevoEmpleado.getFecha_contrat(),
                nuevoEmpleado.getNombre(),
                nuevoEmpleado.getAp1(),
                nuevoEmpleado.getAp2()
        );

        if (empleadoCreado == null) {
            throw new BusinessException("Error al agregar empleado");
        }

        return empleadoCreado;
    }

    //  Eliminar empleado
    public boolean eliminarEmpleado(int idEmpleado) throws BusinessException {
        Empleado empleado = RepEmpleados.search(idEmpleado);

        if (empleado == null) {
            throw new BusinessException("Empleado no encontrado");
        }

        // Validar que el empleado no tenga registros asociados 
        return RepEmpleados.delete(empleado);
    }

    // Modificar datos de empleados
    public Empleado modificarEmpleado(Empleado empleadoActualizado) throws BusinessException {
        validarEmpleado(empleadoActualizado);

        Empleado empleadoExistente = RepEmpleados.search(empleadoActualizado.getId_empleado());
        if (empleadoExistente == null) {
            throw new BusinessException("Empleado no encontrado");
        }

        // Validar que NSS y RFC no cambien 
        if (empleadoExistente.getNss() != empleadoActualizado.getNss()) {
            throw new BusinessException("No se puede modificar el NSS");
        }

        if (!empleadoExistente.getRfc().equals(empleadoActualizado.getRfc())) {
            throw new BusinessException("No se puede modificar el RFC");
        }

        // Actualizar en el repositorio
        if (!RepEmpleados.update(empleadoActualizado)) {
            throw new BusinessException("Error al actualizar empleado");
        }

        return empleadoActualizado;
    }

    // Consultar lista de empleados
    public List<Empleado> consultarEmpleados() {
        return RepEmpleados.getEmpleados();
    }

    // Consultar empleado por ID
    public Empleado consultarEmpleado(int idEmpleado) throws BusinessException {
        Empleado empleado = RepEmpleados.search(idEmpleado);

        if (empleado == null) {
            throw new BusinessException("Empleado no encontrado");
        }

        return empleado;
    }

    // Metodo de validacion 
    private void validarEmpleado(Empleado empleado) throws BusinessException {
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            throw new BusinessException("El nombre es requerido");
        }

        if (empleado.getAp1() == null || empleado.getAp1().trim().isEmpty()) {
            throw new BusinessException("El primer apellido es requerido");
        }

        if (empleado.getNss() <= 0) {
            throw new BusinessException("NSS no valido");
        }

        if (empleado.getRfc() == null || empleado.getRfc().trim().isEmpty()) {
            throw new BusinessException("RFC es requerido");
        }

        if (empleado.getFecha_nac() == null || empleado.getFecha_nac().isAfter(LocalDate.now().minusYears(18))) {
            throw new BusinessException("Fecha de nacimiento no valida");
        }

        if (empleado.getFecha_contrat() == null || empleado.getFecha_contrat().isAfter(LocalDate.now())) {
            throw new BusinessException("Fecha de contratacion no valida");
        }

        // Validar formato de email
        if (empleado.getEmail() == null ) {
            throw new BusinessException("Email no vacio");
        }

        // Validar telefono 
        if (empleado.getTelefono() == null ) {
            throw new BusinessException("Telefono es inaceptable ");
        }
    }
}
