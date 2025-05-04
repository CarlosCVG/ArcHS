
package modelo.logica;

import java.time.LocalDate;
import java.util.List;
import modelo.vo.Empleado;
import repositorio.RepEmpleados;
import excepciones.ExBusiness;

public class LogicEmpleado {

    public LogicEmpleado() {
    }

    // Agregar empleado
    public Empleado agregarEmpleado(Empleado nuevoEmpleado) throws ExBusiness {
        validarEmpleado(nuevoEmpleado);

        // Verificar que el NSS no este duplicado
        if (RepEmpleados.getEmpleados().stream().anyMatch(e -> e.getNss() == nuevoEmpleado.getNss())) {
            throw new ExBusiness("El NSS ya esta registrado");
        }

        // Verificar que el RFC no este duplicado
        if (RepEmpleados.getEmpleados().stream().anyMatch(e -> e.getRfc().equalsIgnoreCase(nuevoEmpleado.getRfc()))) {
            throw new ExBusiness("El RFC ya esta registrado");
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
            throw new ExBusiness("Error al agregar empleado");
        }

        return empleadoCreado;
    }

    //  Eliminar empleado
    public boolean eliminarEmpleado(int idEmpleado) throws ExBusiness {
        Empleado empleado = RepEmpleados.search(idEmpleado);

        if (empleado == null) {
            throw new ExBusiness("Empleado no encontrado");
        }

        // Validar que el empleado no tenga registros asociados 
        return RepEmpleados.delete(empleado);
    }

    public void modificarSoloPuesto(Empleado empleado) throws ExBusiness {
        // Validación específica para cambio de puesto
        if (empleado.getId_puesto() <= 0) {
            throw new ExBusiness("El ID de puesto debe ser positivo");
        }

        Empleado existente = RepEmpleados.search(empleado.getId_empleado());
        if (existente == null) {
            throw new ExBusiness("Empleado no encontrado");
        }

        // Solo actualiza el puesto, manteniendo los demás valores
        existente.setId_puesto(empleado.getId_puesto());

        if (!RepEmpleados.update(existente)) {
            throw new ExBusiness("Error al actualizar el puesto");
        }
    }

    // Modificar datos de empleados
    public Empleado modificarEmpleado(Empleado empleadoActualizado) throws ExBusiness {
        // Validar campos obligatorios
        validarEmpleado(empleadoActualizado);

        // Obtener empleado actual antes de los cambios
        Empleado empleadoOriginal = RepEmpleados.search(empleadoActualizado.getId_empleado());
        if (empleadoOriginal == null) {
            throw new ExBusiness("Empleado no encontrado");
        }

        // Validar NSS solo si ha cambiado
        if (empleadoActualizado.getNss() != empleadoOriginal.getNss()) {
            validarNSSUnico(empleadoActualizado.getNss(), empleadoActualizado.getId_empleado());
        }

        // Validar CURP solo si ha cambiado
        if (!empleadoActualizado.getCurp().equals(empleadoOriginal.getCurp())) {
            validarCURPUnica(empleadoActualizado.getCurp(), empleadoActualizado.getId_empleado());
        }

        // Validar RFC solo si ha cambiado
        if (!empleadoActualizado.getRfc().equals(empleadoOriginal.getRfc())) {
            validarRFCUnico(empleadoActualizado.getRfc(), empleadoActualizado.getId_empleado());
        }

        // Realizar la actualización
        if (!RepEmpleados.update(empleadoActualizado)) {
            throw new ExBusiness("Error al guardar los cambios");
        }

        return empleadoActualizado;
    }

// Métodos de validación específicos
    private void validarNSSUnico(int nss, int idEmpleadoActual) throws ExBusiness {
        boolean existe = RepEmpleados.getEmpleados().stream()
                .filter(e -> e.getId_empleado() != idEmpleadoActual)
                .anyMatch(e -> e.getNss() == nss);

        if (existe) {
            throw new ExBusiness("El NSS " + nss + " ya pertenece a otro empleado");
        }
    }

    private void validarCURPUnica(String curp, int idEmpleadoActual) throws ExBusiness {
        boolean existe = RepEmpleados.getEmpleados().stream()
                .filter(e -> e.getId_empleado() != idEmpleadoActual)
                .anyMatch(e -> e.getCurp().equalsIgnoreCase(curp));

        if (existe) {
            throw new ExBusiness("La CURP " + curp + " ya pertenece a otro empleado");
        }
    }

    private void validarRFCUnico(String rfc, int idEmpleadoActual) throws ExBusiness {
        boolean existe = RepEmpleados.getEmpleados().stream()
                .filter(e -> e.getId_empleado() != idEmpleadoActual)
                .anyMatch(e -> e.getRfc().equalsIgnoreCase(rfc));

        if (existe) {
            throw new ExBusiness("El RFC " + rfc + " ya pertenece a otro empleado");
        }
    }

    // Consultar lista de empleados
    public List<Empleado> consultarEmpleados() {
        return RepEmpleados.getEmpleados();
    }

    // Consultar empleado por ID
    public Empleado consultarEmpleado(int idEmpleado) throws ExBusiness {
        Empleado empleado = RepEmpleados.search(idEmpleado);

        if (empleado == null) {
            throw new ExBusiness("Empleado no encontrado");
        }

        return empleado;
    }

    // Metodo de validacion 
    public void validarEmpleado(Empleado empleado) throws ExBusiness {
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            throw new ExBusiness("El nombre es requerido");
        }

        if (empleado.getAp1() == null || empleado.getAp1().trim().isEmpty()) {
            throw new ExBusiness("El primer apellido es requerido");
        }

        if (empleado.getNss() <= 0) {
            throw new ExBusiness("NSS no valido");
        }

        if (empleado.getRfc() == null || empleado.getRfc().trim().isEmpty()) {
            throw new ExBusiness("RFC es requerido");
        }

//        if (empleado.getFecha_nac() == null || empleado.getFecha_nac().isAfter(LocalDate.now().minusYears(18))) {
//            throw new BusinessException("Fecha de nacimiento no valida");
//        }
        if (empleado.getFecha_nac() == null) {
            throw new ExBusiness("Fecha de nacimiento es requerida");
        }

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMinima = fechaActual.minusYears(18);

        if (empleado.getFecha_nac().isAfter(fechaMinima)) {
            throw new ExBusiness("El empleado debe ser mayor de edad (18+ años)");
        }

        if (empleado.getFecha_contrat() == null || empleado.getFecha_contrat().isAfter(LocalDate.now())) {
            throw new ExBusiness("Fecha de contratacion no valida");
        }

        // Validar formato de email
        if (empleado.getEmail() == null) {
            throw new ExBusiness("Email no vacio");
        }

        // Validar telefono 
        if (empleado.getTelefono() == null) {
            throw new ExBusiness("Telefono es inaceptable ");
        }
    }
}
