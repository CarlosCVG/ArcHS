
package modelo.dao;

import java.util.List;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;
import repositorio.RepAdministradores;
import repositorio.RepEmpleados;
import repositorio.RepHuespedes;

public class DAOLogin {
    public void initAdministradores(){
        RepAdministradores ra = new RepAdministradores();
    }
    public void initEmpleados(){
        RepEmpleados re = new RepEmpleados();
    }
    public void initHuespedes(){
        
        repositorio.RepHuespedes.cargarDatosInicialesHuespedes();
        
    }
    
    public List<Administrador> getListaAdministradores(){
        return RepAdministradores.getAdministradores();
    }
    public List<Empleado> getListaEmpleados(){
        return RepEmpleados.getEmpleados();
    }
    public List<Huesped> getListaHuespedes(){
        return RepHuespedes.getListaHuespedes();
    }
}
