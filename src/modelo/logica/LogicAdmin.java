
package modelo.logica;

import java.util.List;
import modelo.dao.DAOAdmin;
import modelo.vo.Empleado;

public class LogicAdmin {
    DAOAdmin daoadmin = new DAOAdmin();
    public List<Object[]> obtenerListaEmpleados() {
        return daoadmin.obtenerListaEmpleados();
    }
    public List<Empleado> searchLikeNombre(String txtToSearch) {
        return daoadmin.searchLikeNombre(txtToSearch);
    }
}
