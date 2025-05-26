package controlador;

import excepciones.ExRegistroHab;
import java.util.List;
import java.util.Map;
import modelo.logica.LogicAdmin;
import modelo.vo.Administrador;
import modelo.vo.Empleado;

public class CtrlAdmin {
    LogicAdmin ladmin = new LogicAdmin();
    
    public List<Object[]> obtenerListaEmpleados() {
        return ladmin.obtenerListaEmpleados();
    }

    public List<Empleado> searchLikeNombre(String txtToSearch) {
        return ladmin.searchLikeNombre(txtToSearch);
    }

    public boolean sendTask(Administrador admin, Empleado empleado, String asunto, String task) {
        return ladmin.sendTask(admin, empleado, asunto, task);
    }

    public Map<Integer, Integer> cantRxM(int numMes) {
        return ladmin.cantReservacionesPorMes(numMes);
    }

    public boolean deleteEmpleado(Empleado empleadoSelected) {
        return ladmin.deleteEmpleado(empleadoSelected);
    }

    public boolean addEmpleado(String usuario, String pass, String nombre, String ap1, String ap2, String curp, String telefono, String email, String puesto) throws ExRegistroHab {
        return ladmin.addEmpleado(usuario, pass, nombre, ap1, ap2, curp, telefono, email, puesto);
    }
    public boolean modEmpleado(int id_empleado, String usuario, String pass, String nombre, String ap1, String ap2, String curp, String telefono, String email, String puesto) throws ExRegistroHab {
        return ladmin.modEmpleado(id_empleado, usuario, pass, nombre, ap1, ap2, curp, telefono, email, puesto);
    }
    
    
    
}
