package modelo.logica;

import java.util.List;
import modelo.dao.DAOLogin;
import modelo.vo.Administrador;
import modelo.vo.Empleado;
import modelo.vo.Huesped;

public class LogicLogin {
    DAOLogin daologin = new DAOLogin();
    public void initAdministradores(){
        daologin.initAdministradores();
    }
    public void initEmpleados(){
        daologin.initEmpleados();
    }
    public void initHuespedes(){
        daologin.initHuespedes();
    }
    
    public List<Administrador> getListaAdministradores() {
        return daologin.getListaAdministradores();
    }
    public List<Empleado> getListaEmpleados() {
        return daologin.getListaEmpleados();
    }
    public List<Huesped> getListaHuespedes() {
        return daologin.getListaHuespedes();
    }
}
