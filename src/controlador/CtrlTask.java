package controlador;

import java.util.List;
import modelo.logica.LogicTask;
import modelo.vo.Tarea;

public class CtrlTask {

    LogicTask logicatask = new LogicTask();

    public List<Tarea> searchByRegistro(String selectedbp, int id_empleado) {
        return logicatask.searchByRegistro(selectedbp, id_empleado);
    }

    public String findAdminById(int id_administrador) {
        return logicatask.findAdminById(id_administrador);
    }

    public boolean updateLectura(Tarea selectedtsk) {
        return logicatask.updateLectura(selectedtsk);
    }

    
}
