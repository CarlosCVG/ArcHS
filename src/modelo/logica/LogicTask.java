package modelo.logica;

import java.util.List;
import modelo.dao.DAOTask;
import modelo.vo.Tarea;

public class LogicTask {
    DAOTask daotask = new DAOTask();

    public List<Tarea> searchByRegistro(String selectedbp, int id_empleado) {
        return daotask.searchByRegistro(selectedbp, id_empleado);
    }

    public String findAdminById(int id_administrador) {
        return daotask.findAdminById(id_administrador);
    }

    public boolean updateLectura(Tarea selectedtsk) {
        return daotask.updateLectura(selectedtsk);
    }
}
