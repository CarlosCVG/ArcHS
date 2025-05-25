package controlador;

import java.util.List;
import modelo.logica.LogicAdmin;
import modelo.vo.Empleado;

public class CtrlAdmin {
    LogicAdmin ladmin = new LogicAdmin();
    
    public List<Object[]> obtenerListaEmpleados() {
        return ladmin.obtenerListaEmpleados();
    }

    public List<Empleado> searchLikeNombre(String txtToSearch) {
        return ladmin.searchLikeNombre(txtToSearch);
    }
}
