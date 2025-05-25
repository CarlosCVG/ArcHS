package controlador;

import java.util.List;
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

    public String cantRxM(int numMes) {
        return ladmin.cantRxM(numMes);
    }
    
}
