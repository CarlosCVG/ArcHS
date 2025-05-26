
package modelo.logica;

import excepciones.ExRegistroHab;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import modelo.dao.DAOAdmin;
import modelo.vo.Administrador;
import modelo.vo.Empleado;

public class LogicAdmin {
    DAOAdmin daoadmin = new DAOAdmin();
    public List<Object[]> obtenerListaEmpleados() {
        return daoadmin.obtenerListaEmpleados();
    }
    public List<Empleado> searchLikeNombre(String txtToSearch) {
        return daoadmin.searchLikeNombre(txtToSearch);
    }
    public boolean sendTask(Administrador admin, Empleado empleado, String asunto, String task) {
        return daoadmin.sendTask(admin, empleado, asunto, task);
    }
    
    public Map<Integer, Integer> cantReservacionesPorMes(int numMes) {
        return daoadmin.cantReservacionesPorMes(numMes);
    }
    
    public boolean deleteEmpleado(Empleado empleadoSelected) {
        return daoadmin.deleteEmpleado(empleadoSelected);
    }

    public boolean addEmpleado(String usuario, String pass, String nombre, String ap1, String ap2, String curp, String telefono, String email, String puesto) throws ExRegistroHab{
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        if (pass == null || pass.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        
        if (ap1 == null || ap1.trim().isEmpty()) {
            throw new ExRegistroHab("El apellido es requerido");
        }
        
        if (email == null) {
            throw new ExRegistroHab("Email no vacio");
        }
        
        if (curp == null) {
            throw new ExRegistroHab("Email no vacio");
        }

        if (telefono == null) {
            throw new ExRegistroHab("Telefono es inaceptable ");
        }
        int numPuesto;
        numPuesto = switch (puesto) {
            case "Recepcionista" -> 1;
            case "Limpieza" -> 2;
            default -> 3;
        };
        return daoadmin.addEmpleado(usuario, pass, nombre, ap1, ap2, curp, telefono, email, numPuesto);
    }
    public boolean modEmpleado(int id_empleado, String usuario, String pass, String nombre, String ap1, String ap2, String curp, String telefono, String email, String puesto) throws ExRegistroHab{
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        if (pass == null || pass.trim().isEmpty()) {
            throw new ExRegistroHab("El nombre es requerido");
        }
        
        if (ap1 == null || ap1.trim().isEmpty()) {
            throw new ExRegistroHab("El apellido es requerido");
        }
        
        if (email == null) {
            throw new ExRegistroHab("Email no vacio");
        }
        
        if (curp == null) {
            throw new ExRegistroHab("Email no vacio");
        }

        if (telefono == null) {
            throw new ExRegistroHab("Telefono es inaceptable ");
        }
        int numPuesto;
        numPuesto = switch (puesto) {
            case "Recepcionista" -> 1;
            case "Limpieza" -> 2;
            default -> 3;
        };
        return daoadmin.modEmpleado(id_empleado, usuario, pass, nombre, ap1, ap2, curp, telefono, email, numPuesto);
    }
}
